package africa.box.dm.service;

import africa.box.dm.config.RolesConfig;
import africa.box.dm.db.CompteDao;
import africa.box.dm.dto.*;
import com.vladmihalcea.hibernate.type.json.JsonNodeBinaryType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


@Component
public class KpiServices {
    private static final Logger logger = LoggerFactory.getLogger(KpiServices.class);
    @Autowired
    CompteDao compteDao;

    @PersistenceContext(unitName = "dmPu")
    EntityManager accountPuEm;

    //  Nombre de dossier par type de prêt
    public List<ReportDto>  getNombreDossierParTypeDePret(Date startDate, Date finishDate){
        String nativeQuery = "SELECT souscategorietypepret as element, json_object_agg(date,total ORDER BY date) report " +
                "FROM ( SELECT souscategorietypepret, to_char(created_at, 'DD/MM/YYYY') as date, " +
                "count(businesskey) AS total " +
                "FROM public.compte where created_at between ?1 and ?2 " +
                "GROUP BY to_char(created_at, 'DD/MM/YYYY'),souscategorietypepret) s " +
                "group by souscategorietypepret";
        return getReportDtoByQuery(nativeQuery,startDate,finishDate);
    }

    public List<ReportDto> getReportDtoByQuery(String nativeQuery, Date startDate, Date finishDate){
        if(finishDate==null) finishDate=new Date();
        Calendar c= Calendar.getInstance(); c.set(Calendar.DAY_OF_MONTH,1);
        if(startDate==null) startDate=c.getTime();
        List<ReportDto> listReport=new ArrayList<>();
        List<Object[]> result= accountPuEm.createNativeQuery(nativeQuery)
                .setParameter(1, startDate)
                .setParameter(2,finishDate)
                .unwrap(org.hibernate.query.NativeQuery.class)
                .addScalar("element")
                .addScalar("report", new JsonNodeBinaryType())
                .getResultList();
        for (Object[] obj : result)  {
            String status = (String) obj[0];
            String report=  obj[1].toString();
            listReport.add(new ReportDto(status,report));
        }
        return listReport;
    }

//  Dossier par statut => getKpiDossierByVariable()
//  Temps moyen de traitement => getKpiTempsTraitementDto()
//  Taux d'approbation => getKpiTauxByStatusDto(STATUS=APPROUVE)
//  Taux d'incomplet' => getKpiTauxByStatusDto(STATUS=ABONDONNE)

    public List<KpiDossierDto> getKpiDossierByVariable(String variable, Date startDate, Date finishDate, List<String>agences, List<String>users) {
        DmInitiationServices services=new DmInitiationServices();
        User user=  services.getUser();
        List<String> roles = user.getRoles();
        String whereCreatedByIn="";

        if (roles.contains(RolesConfig.Role_administrateur)){
//            whereCreatedByIn="";
        }else if(roles.contains(RolesConfig.Role_decision)){
//            whereCreatedByIn="";
        }else if(roles.contains(RolesConfig.Role_chef_reseau)){
//            whereCreatedByIn="";
        }else if(roles.contains(RolesConfig.Role_chef_agence)){
//            whereCreatedByIn="";
        }else if(roles.contains(RolesConfig.Role_charge_clientele)){
            users.add(user.getFullName());
        }

        if (users!=null){
            whereCreatedByIn=" AND created_by IN (";
            for (int i=0;i<users.size();i++){
                whereCreatedByIn+="'"+users.get(i)+"'";
                if (i<(users.size()-1))whereCreatedByIn+=",";
            }
            whereCreatedByIn+=") ";
            if ((users.size()<1))whereCreatedByIn=" ";
        }

        String whereAgenceIn="";
        if (agences!=null){
            whereAgenceIn=" AND agence IN (";
            for (int i=0;i<agences.size();i++){
                whereAgenceIn+="'"+agences.get(i)+"'";
                if (i<(agences.size()-1))whereAgenceIn+=",";
            }
            whereAgenceIn+=") ";
            if ((agences.size()<1))whereAgenceIn=" ";// " AND agence IN ('NULL') "
        }
        String nativeQuery ="";
        switch (variable){
            case "agence":
                nativeQuery = " SELECT agence as element,  count(businesskey) AS nombre_total " +
                        "FROM public.compte where created_at between ?1 and ?2 " +whereCreatedByIn+
                        "AND status NOT IN ('BROUILLON','EFFACE') GROUP BY agence";
                break;
//            sum(montantdupret) AS montant_total,
            case "created_by":
                nativeQuery = " SELECT created_by as element,  count(businesskey) AS nombre_total " +
                        "FROM public.compte where created_at between ?1 and ?2 " +whereCreatedByIn+
                        "AND status NOT IN ('BROUILLON','EFFACE') GROUP BY created_by";
                break;
//            sum(montantdupret) AS montant_total,
            case "status":
                nativeQuery = " SELECT status as element,  count(businesskey) AS nombre_total " +
                        "FROM public.compte where created_at between ?1 and ?2 " +whereAgenceIn+whereCreatedByIn+
                        "AND status NOT IN ('BROUILLON','EFFACE') GROUP BY status";
                break;
//            sum(montantdupret) AS montant_total,
            default:
                nativeQuery = " SELECT status as element,  count(businesskey) AS nombre_total " +
                        "FROM public.compte where created_at between ?1 and ?2 " +whereCreatedByIn+
                        "AND status NOT IN ('BROUILLON','EFFACE') GROUP BY status";
                break;
//            sum(montantdupret) AS montant_total,
        }

        return getKpiDossier(nativeQuery,startDate,finishDate);
    }

//    public KpiDossierDto getKpiDossierByAgence(Date startDate, Date finishDate) {
//        String nativeQuery = " SELECT agence as element, sum(montantdupret) AS montant_total, count(businesskey) AS nombre_total " +
//                "FROM public.compte where created_at between ?1 and ?2 GROUP BY agence";
//        return getKpiDossier(nativeQuery,startDate,finishDate);
//    }
//
//    public KpiDossierDto  getKpiDossierByUser(Date startDate, Date finishDate) {
//        String nativeQuery = " SELECT created_by as element, sum(montantdupret) AS montant_total, count(businesskey) AS nombre_total " +
//                "FROM public.compte where created_at between ?1 and ?2 GROUP BY created_by";
//        return getKpiDossier(nativeQuery,startDate,finishDate);
//    }
//
//    public KpiDossierDto  getKpiDossierByStatus(Date startDate, Date finishDate) {
//        String nativeQuery = " SELECT status as element, sum(montantdupret) AS montant_total, count(businesskey) AS nombre_total " +
//                "FROM public.compte where created_at between ?1 and ?2 GROUP BY status";
//        return getKpiDossier(nativeQuery,startDate,finishDate);
//    }

    public List<KpiDossierDto>  getKpiDossier(String nativeQuery, Date startDate, Date finishDate){
        List<KpiDossierDto> listKpiDossierDto = new ArrayList<>();
        if(finishDate==null) finishDate=new Date();
        Calendar c= Calendar.getInstance(); c.set(Calendar.DAY_OF_MONTH,1);
        if(startDate==null) startDate=c.getTime();
        List<Object[]> result= accountPuEm.createNativeQuery(nativeQuery)
                .setParameter(1, startDate)
                .setParameter(2,finishDate)
                .unwrap(org.hibernate.query.NativeQuery.class)
                .addScalar("element")
                .addScalar("nombre_total")
                .getResultList();
        for (Object[] obj : result)  {
            String element = (String) obj[0];
//            double montant_total= (double) obj[1];
            int nombre_total= obj[1] instanceof BigInteger ? ((BigInteger)obj[1]).intValue():(int) obj[1];
            KpiDossierDto kpiDossierDto = new KpiDossierDto(element, nombre_total);
            listKpiDossierDto.add(kpiDossierDto);
        }

        return listKpiDossierDto;
    }

    public List<KpiTempsTraitementDto>  getKpiTempsTraitementDto(Date startDate, Date finishDate, List<String>agences, List<String>users){
        DmInitiationServices services=new DmInitiationServices();
        User user=  services.getUser();
        List<String> roles = user.getRoles();
        String whereCreatedByIn="";

        if (roles.contains(RolesConfig.Role_administrateur)){
//            whereCreatedByIn="";
        }else if(roles.contains(RolesConfig.Role_decision)){
//            whereCreatedByIn="";
        }else if(roles.contains(RolesConfig.Role_chef_reseau)){
//            whereCreatedByIn="";
        }else if(roles.contains(RolesConfig.Role_chef_agence)){
//            whereCreatedByIn="";
        }else if(roles.contains(RolesConfig.Role_charge_clientele)){
              users.add(user.getFullName());
        }

        if (users!=null){
            whereCreatedByIn=" AND created_by IN (";
            for (int i=0;i<users.size();i++){
                whereCreatedByIn+="'"+users.get(i)+"'";
                if (i<(users.size()-1))whereCreatedByIn+=",";
            }
            whereCreatedByIn+=") ";
            if ((users.size()<1))whereCreatedByIn=" ";
        }

//        String whereCreatedByIn="";
//
//        if (roles.contains(RolesConfig.Role_administrateur)){
//            whereCreatedByIn="";
//        }else if(roles.contains(RolesConfig.Role_decision)){
//            whereCreatedByIn="";
//        }else if(roles.contains(RolesConfig.Role_chef_reseau)){
//            whereCreatedByIn="";
//        }else if(roles.contains(RolesConfig.Role_chef_agence)){
//            whereCreatedByIn="";
//        }else if(roles.contains(RolesConfig.Role_charge_clientele)){
//            whereCreatedByIn=" AND created_by IN ('"+user.getEmail()+"')";
//        }
        String whereAgenceIn="";
        if (agences!=null){
            whereAgenceIn=" AND agence IN (";
            for (int i=0;i<agences.size();i++){
                whereAgenceIn+="'"+agences.get(i)+"'";
                if (i<(agences.size()-1))whereAgenceIn+=",";
            }
            whereAgenceIn+=") ";
            if ((agences.size()<1))whereAgenceIn=" ";// " AND agence IN ('NULL') "
        }
        String nativeQuery = "SELECT d.agence, d.created_by, d.businesskey, d.created_at , N.enddate , " +
                "((DATE_PART('day', N.enddate - d.created_at) * 24) + " +
                "(DATE_PART('hour', N.enddate - d.created_at) * 60) + " +
                "DATE_PART('minute', N.enddate - d.created_at) ) as delai_en_minute " +
                "FROM public.compte d , (SELECT businesskey,  max(date) as enddate " +
                "FROM public.notes WHERE sla='END' GROUP BY businesskey ) as N " +
                "WHERE d.businesskey = N.businesskey " +
                "AND d.created_at between ?1 and ?2 "+whereAgenceIn+whereCreatedByIn;
        List<KpiTempsTraitementDto> listKpiTempsTraitementDto = new ArrayList<>();
        if(finishDate==null) finishDate=new Date();
        Calendar c= Calendar.getInstance(); c.set(Calendar.DAY_OF_MONTH,1);
        if(startDate==null) startDate=c.getTime();
        List<Object[]> result= accountPuEm.createNativeQuery(nativeQuery)
                .setParameter(1, startDate)
                .setParameter(2,finishDate)
                .unwrap(org.hibernate.query.NativeQuery.class)
                .addScalar("businesskey")
                .addScalar("created_at")
                .addScalar("enddate")
                .addScalar("delai_en_minute")
                .getResultList();
        for (Object[] obj : result)  {
            String businesskey = (String) obj[0];
            Date created_at= (Date) obj[1];
            Date ended_at= (Date) obj[2];
            double nb_minute= (double) obj[3];
            KpiTempsTraitementDto kpiTempsTraitementDto = new KpiTempsTraitementDto(businesskey,created_at,ended_at,nb_minute);
            listKpiTempsTraitementDto.add(kpiTempsTraitementDto);
        }
        return listKpiTempsTraitementDto;
    }

    public KpiTauxByStatusDto getKpiTauxByStatusDto(String status, Date startDate, Date finishDate, List<String>agences, List<String>users){
        DmInitiationServices services=new DmInitiationServices();
        User user=  services.getUser();
        List<String> roles = user.getRoles();

        String whereCreatedByIn="";

        if (roles.contains(RolesConfig.Role_administrateur)){
//            whereCreatedByIn="";
        }else if(roles.contains(RolesConfig.Role_decision)){
//            whereCreatedByIn="";
        }else if(roles.contains(RolesConfig.Role_chef_reseau)){
//            whereCreatedByIn="";
        }else if(roles.contains(RolesConfig.Role_chef_agence)){
//            whereCreatedByIn="";
        }else if(roles.contains(RolesConfig.Role_charge_clientele)){
            users.add(user.getFullName());
        }

        if (users!=null){
            whereCreatedByIn=" AND created_by IN (";
            for (int i=0;i<users.size();i++){
                whereCreatedByIn+="'"+users.get(i)+"'";
                if (i<(users.size()-1))whereCreatedByIn+=",";
            }
            whereCreatedByIn+=") ";
            if ((users.size()<1))whereCreatedByIn=" ";
        }
//
//        String whereCreatedByIn="";
//
//        if (roles.contains(RolesConfig.Role_administrateur)){
//            whereCreatedByIn="";
//        }else if(roles.contains(RolesConfig.Role_decision)){
//            whereCreatedByIn="";
//        }else if(roles.contains(RolesConfig.Role_chef_reseau)){
//            whereCreatedByIn="";
//        }else if(roles.contains(RolesConfig.Role_chef_agence)){
//            whereCreatedByIn="";
//        }else if(roles.contains(RolesConfig.Role_charge_clientele)){
//            whereCreatedByIn=" AND created_by IN ('"+user.getEmail()+"')";
//        }
        String whereAgenceIn="";
        if (agences!=null){
            whereAgenceIn=" AND agence IN (";
            for (int i=0;i<agences.size();i++){
                whereAgenceIn+="'"+agences.get(i)+"'";
                if (i<(agences.size()-1))whereAgenceIn+=",";
            }
            whereAgenceIn+=") ";
            if ((agences.size()<1))whereAgenceIn=" ";// " AND agence IN ('NULL') "
        }
        String nativeQuery = "SELECT count(*) as nb_element, " +
                "(SELECT count(*) as nb_dossier " +
                "FROM public.compte WHERE created_at between ?1 and ?2 " +whereAgenceIn+whereCreatedByIn+
                " AND status NOT IN ('BROUILLON','EFFACE') ) " +
                "FROM public.compte WHERE status='"+status+"' " +
                "AND  created_at between ?1 and ?2 " +whereAgenceIn+whereCreatedByIn+
                " AND status NOT IN ('BROUILLON','EFFACE')";
        KpiTauxByStatusDto kpiTauxByStatusDto = new KpiTauxByStatusDto();
        if(finishDate==null) finishDate=new Date();
        Calendar c= Calendar.getInstance(); c.set(Calendar.DAY_OF_MONTH,1);
        if(startDate==null) startDate=c.getTime();
        List<Object[]> result= accountPuEm.createNativeQuery(nativeQuery)
                .setParameter(1, startDate)
                .setParameter(2,finishDate)
                .unwrap(org.hibernate.query.NativeQuery.class)
                .addScalar("nb_element")
                .addScalar("nb_dossier")
                .getResultList();
        for (Object[] obj : result)  {
            int nb_element = (obj[0]) instanceof BigInteger ?((BigInteger) obj[0]).intValue():((int) obj[0]);
            int nb_dossier= (obj[0]) instanceof BigInteger ?((BigInteger) obj[1]).intValue():((int) obj[1]);
            double taux= (double)nb_element*100/(double)nb_dossier;
            kpiTauxByStatusDto = new KpiTauxByStatusDto(nb_element,nb_dossier,taux);
        }
        return kpiTauxByStatusDto;
    }

}
