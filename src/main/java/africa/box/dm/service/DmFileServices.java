package africa.box.dm.service;

import africa.box.dm.db.CompteDao;
import africa.box.dm.db.entities.Compte;
import africa.box.dm.dto.ReportDto;
import com.vladmihalcea.hibernate.type.json.JsonNodeBinaryType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


@Component
public class DmFileServices {
    private static final Logger logger = LoggerFactory.getLogger(DmFileServices.class);
    @Autowired
    CompteDao compteDao;


    @PersistenceContext(unitName = "dmPu")
    EntityManager accountPuEm;

//    public List<Compte> getComptebyStatusAndAgence(LoanFileStatus status){
//        LoanInitiationServices services=new LoanInitiationServices();
//        User user=  services.getUser();
//        return compteDao.findByStatusAndAgence(status, user.getAgence());
//    }
//    public List<Compte> getComptebyStatusAndUser(LoanFileStatus status){
//        LoanInitiationServices services=new LoanInitiationServices();
//        User user=  services.getUser();
//        return compteDao.findByStatusAndCreatedBy(status, user.getEmail());
//    }
//
//    public List<Compte> getAllComptebyUserAndAgence(){
//        LoanInitiationServices services=new LoanInitiationServices();
//        User user=  services.getUser();
////        System.out.println("user.getEmail() -"+user.getEmail()+" - user.getAgence() -"+user.getAgence());
//        return compteDao.findByCreatedByAndAgence(
//                "BROUILLON",user.getEmail(),
//                "EFFACE", user.getAgence());
//    }
//
//    public List<String> getAllBusinessKeybyUserRoleAndStatus(String status){
//        LoanInitiationServices services=new LoanInitiationServices();
//        User user=  services.getUser();
//        List<String> roles = user.getRoles();
//        List<Compte> dossierList = getAllComptebyUserRole();
//
//        LoanFileStatus fileStatus = null;
//        try{
//            if (status.equals("all")) fileStatus = null;
//            else fileStatus = LoanFileStatus.valueOf(status);
//        }catch (Exception e){
//            e.printStackTrace();
//            fileStatus = null;
//        }
//
//        List<String> businessKeys = new ArrayList<>();
//        if (dossierList != null) {
//            // Si aucun status n'est passé en paramètre, on ramène tous les businesskeys
//            if (fileStatus!=null) {
//                for (Compte dossier : dossierList) {
//                    if (dossier.getStatus().equals(fileStatus))
//                        businessKeys.add(dossier.getBussinessKey());
//                }
//            }else {
//                for (Compte dossier : dossierList) {
//                    if (!dossier.getStatus().equals(LoanFileStatus.BROUILLON))businessKeys.add(dossier.getBussinessKey());
//                }
//            }
//        }
//        return businessKeys;
//    }

    //public List<Compte> getAllComptebyUserRole(){
//        LoanInitiationServices services=new LoanInitiationServices();
//        return compteDao.findAll();

//        User user=  services.getUser();
//        List<String> roles = user.getRoles();
//
//        if (roles.contains(RolesConfig.Role_administrateur)){
//            // Tous les dossiers
//            return compteDao.findAll();
//        }else if(roles.contains(RolesConfig.Role_decision)){
//            // Tous les dossiers de toutes les agences sauf:
//            // les dossiers en brouillons, les dossiers en attente et les dossiers en traitement
//            List<LoanFileStatus> status = new ArrayList<>();
//            status.add(LoanFileStatus.BROUILLON);
//            status.add(LoanFileStatus.EN_ATTENTE);
//            status.add(LoanFileStatus.EN_TRAITEMENT);
//            status.add(LoanFileStatus.EFFACE);
//            return compteDao.findByStatusNotIn(status);
//
//        }else if(roles.contains(RolesConfig.Role_chef_reseau)){
//            // Tous les dossiers de toutes les agences sauf:
//            // les dossiers en brouillons, les dossiers en attente et les dossiers en traitement
//            List<LoanFileStatus> status = new ArrayList<>();
//            status.add(LoanFileStatus.BROUILLON);
//            status.add(LoanFileStatus.EN_ATTENTE);
//            status.add(LoanFileStatus.EN_TRAITEMENT);
//            status.add(LoanFileStatus.EFFACE);
//            return compteDao.findByStatusNotIn(status);
//
//        }else if(roles.contains(RolesConfig.Role_chef_agence)){
//            // Tous les dossiers de son agences sauf:
//            // les dossiers en brouillons des autres
//            return compteDao.findByAgence(user.getAgence());
//
//        }else if(roles.contains(RolesConfig.Role_charge_clientele)){
//            // Tous les dossiers de son agences sauf:
//            // les dossiers en brouillons des autres
//            return compteDao.findByAgence(user.getAgence());
//
//        }else {
//            return null;
//        }
    //}

    public List<ReportDto> getNombreDossierParStatusParMoisDeLagence(Date startDate, Date finishDate) {
        String nativeQuery = "SELECT status, json_object_agg(date,total ORDER BY date) report " +
                "FROM ( SELECT status, to_char(created_at, 'DD/MM/YYYY') as date, " +
                "count(businesskey) AS total " +
                "FROM public.compte where created_at between ?1 and ?2 " +
                "GROUP BY to_char(created_at, 'DD/MM/YYYY'),status) s " +
                "group by status";
        return getReportDtoByQuery(nativeQuery,startDate,finishDate);
    }

    public List<ReportDto> getNombreDossierParAgence(Date startDate, Date finishDate) {
        String nativeQuery = "SELECT agence, json_object_agg(date,total ORDER BY date) report " +
                "FROM ( SELECT agence, to_char(created_at, 'DD/MM/YYYY') as date, " +
                "count(businesskey) AS total " +
                "FROM public.compte where created_at between ?1 and ?2 " +
                "GROUP BY to_char(created_at, 'DD/MM/YYYY'),agence) s " +
                "group by agence";
        return getReportDtoByQuery(nativeQuery,startDate,finishDate);
    }

    public List<ReportDto>  getReportDtoByQuery(String nativeQuery, Date startDate, Date finishDate){
        if(finishDate==null) finishDate=new Date();
        Calendar c= Calendar.getInstance(); c.set(Calendar.DAY_OF_MONTH,1);
        if(startDate==null) startDate=c.getTime();
        List<ReportDto> listReport=new ArrayList<>();
        List<Object[]> result= accountPuEm.createNativeQuery(nativeQuery)
                .setParameter(1, startDate)
                .setParameter(2,finishDate)
                .unwrap(org.hibernate.query.NativeQuery.class)
                .addScalar("agence")
                .addScalar("report", new JsonNodeBinaryType())
                .getResultList();
        for (Object[] obj : result)  {
            String status = (String) obj[0];
            String report=  obj[1].toString();
            listReport.add(new ReportDto(status,report));
        }
        return listReport;
    }

}
