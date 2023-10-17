package africa.box.dm.service;

import africa.box.dm.config.DecisionConfig;
import africa.box.dm.config.RolesConfig;
import africa.box.dm.db.*;
import africa.box.dm.db.entities.*;
import africa.box.dm.dto.DecisionDto;
import africa.box.dm.dto.StatusDto;
import africa.box.dm.dto.User;
import org.keycloak.representations.account.UserRepresentation;
import org.keycloak.representations.idm.GroupRepresentation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class DmDecisionService {
    private final static Logger log = LoggerFactory.getLogger(DmDecisionService.class.getName());

    @Autowired
    LevelDecisionDao levelDecisionDao;

    @Autowired
    DecideurOfLevelDao decideurOfLevelDao;

    @Autowired
    CompteDao dossierDao;

    @Autowired
    NotesDao notesDao;

    @Autowired
    DecideurTemplateDao decideurTemplateDao;

    @Autowired
    CustomKeycloakService customKeycloakService;


    public DecisionDto getMaxDecisionByBussinessKeyAndLevel (String bussinesskey){
        DecisionDto decisionDto = new DecisionDto();
        try{
            List<LevelDecision> levelDecisions = levelDecisionDao.findByBusinessKey( bussinesskey);

            if(levelDecisions.isEmpty()) return decisionDto;

            LevelDecision maxlevelOfBusinessKey = Collections.max(levelDecisions, Comparator.comparing(l -> l.getId()));
            decisionDto.setLeveDecision(maxlevelOfBusinessKey);
            decisionDto.setDecideurOfLevels(
                decideurOfLevelDao.findByIdlevel(maxlevelOfBusinessKey.getId())
            );
        }catch (Exception e){
            e.printStackTrace();
        }

        return decisionDto;
    }

    public Map<String,DecisionDto> getFinalsDecisionsByBusinessKey (String businesskey){
        Map<String,DecisionDto> itemFinalsDecision = new HashMap<>();
        try{
            List<LevelDecision> levelDecisions = levelDecisionDao.findByBusinessKey(businesskey);
            int NB_OF_IMPORTANTE_DECISION_LEVEL=3;
            for (int i=1;i<=NB_OF_IMPORTANTE_DECISION_LEVEL;i++){
                DecisionDto decisionDto = new DecisionDto();
                LevelDecision maxlevelOfBusinessKey = Collections.max(levelDecisions, Comparator.comparing(l -> l.getId()));
                decisionDto.setLeveDecision(maxlevelOfBusinessKey);
                decisionDto.setDecideurOfLevels(
                    decideurOfLevelDao.findByIdlevel(maxlevelOfBusinessKey.getId())
                );
                if (i==1)itemFinalsDecision.put("DG",decisionDto);
                if (i==2)itemFinalsDecision.put("AVIS",decisionDto);
                if (i==3)itemFinalsDecision.put("CHEF_AGENCE",decisionDto);
                levelDecisions.removeIf(d -> d.getId().equals(maxlevelOfBusinessKey.getId()));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return itemFinalsDecision;
    }

    public List<DecisionDto> getDecisionByBussinessKeyAndLevel (String bussinesskey){
        List<DecisionDto> decisionDtos = new ArrayList<>();
        List<LevelDecision> levelDecisions = levelDecisionDao.findByBusinessKey(bussinesskey);
        for (LevelDecision l: levelDecisions){
            DecisionDto decisionDto = new DecisionDto();
            decisionDto.setLeveDecision(l);
            decisionDto.setDecideurOfLevels(
                decideurOfLevelDao.findByIdlevel(l.getId())
            );
            decisionDtos.add(decisionDto);
        }
        return decisionDtos;
    }

    public LevelDecision addLevelDecision (LevelDecision d){
        return levelDecisionDao.save(d);
    }

    public int nextLevelOfLevelDecision (LevelDecision d){
        return levelDecisionDao.findMaxLevel(d.getBusinessKey());
    }

    public boolean deleteLevelDecision (LevelDecision d){
        try{
            levelDecisionDao.delete(d);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public DecideurOfLevel addDecideur (DecideurOfLevel d){
        return decideurOfLevelDao.save(d);
    }

    public boolean deleteDecideur (DecideurOfLevel d) {
        try {
            decideurOfLevelDao.delete(d);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<DecideurOfLevel> addListOfDecideur (List<DecideurOfLevel> list){
        return (List<DecideurOfLevel>) decideurOfLevelDao.saveAll(list);
    }

    public StatusDto createLevelByActionAndCondition(String businessKey, String action, String condition){
        Optional<Compte> accountDB=  dossierDao.findByBusinessKey(businessKey);
        if(accountDB.isPresent()) {
            try {
                Compte cmpt = accountDB.get();
//                List<DecideurTemplate> decideurTemplates = new ArrayList<>();
                List<DecideurTemplate> decideurInKeycloak = new ArrayList<>();
                String roleName="";
                List<UserRepresentation> userRepresentationList = new ArrayList<>();
                switch (action){
                    case DecisionConfig.action_soumettre:
                        DmInitiationServices services=new DmInitiationServices();
                        User user=  services.getUser();

                        /*List<GroupRepresentation> listGroupRepresentation = customKeycloakService.getGroups();

                        for (GroupRepresentation g:listGroupRepresentation){
                            Map<String,String> group = new HashMap<>();
                            group.put("name",g.getName());
                            group.put("path",g.getPath());
                            group.put("id",g.getId());
                            System.out.println("group__________ "+group);
                        }*/

//Test interne box
                        /*List<UserRepresentation> usersInGroup = customKeycloakService.getGroups().stream()
                                .filter(grp->{return grp.getName().equalsIgnoreCase(UserService.getConnectedUser().getAgence().trim().replace("/", ""));})
                                .findFirst()
                                .map(grp->{return customKeycloakService.getUsersOfGroup(grp.getId());})
                                .orElse(new ArrayList<>());*/
//  Preprod dbu
                        List<UserRepresentation> usersInGroup = customKeycloakService.getGroupsKeycloak().stream()
                                .filter(grp->{return grp.getName().equalsIgnoreCase(UserService.getConnectedUser().getAgence().trim().replace("/", ""));})
                                .findFirst()
                                .map(grp->{return customKeycloakService.getUsersFromGroup(grp.getId());})
                                .orElse(new ArrayList<>());
                        System.out.println("usersInGroup _______________ "+usersInGroup.size());
//  Test interne box
                        //List<UserRepresentation> usersInrole = customKeycloakService.getUsersOfRole(RolesConfig.Role_chef_agence);
//  Preprod dbu
                        List<UserRepresentation> usersInrole = customKeycloakService.getUsersOfRoleKeycloak(RolesConfig.Role_chef_agence);
                        System.out.println("usersInrole _______________ "+usersInrole.size());
                        List<UserRepresentation> userRepresentations = usersInrole.stream()
                                .filter(userRepresentation->{
                                    boolean found = false;
                                    for(UserRepresentation u:usersInGroup){
                                        if (u.getId().equals(userRepresentation.getId())) {
                                            found = true;
                                        }
                                    }
                                    return found;
                                })
                                .collect(Collectors.toList());
                        log.info("decideures _________ "+userRepresentations.stream().map(x->x.getEmail()).collect(Collectors.toList()));

                        //userRepresentations.addAll(customKeycloakService.getUsersOfRoleKeycloak(RolesConfig.Role_chef_reseau));

                        // New function => decideur comes from keycloak now
//                        roleName = RolesConfig.Role_chef_agence+"_"+(user.getAgence().startsWith("/")?user.getAgence().substring(1):user.getAgence());
//                        userRepresentationList = customKeycloakService.getUsersOfRoleKeycloak(roleName);
//                        if (userRepresentationList.isEmpty()){
//                            userRepresentationList = customKeycloakService.getUsersOfRoleKeycloak(RolesConfig.Role_administrateur);
//                        }
                        decideurInKeycloak =  ModelMapper.convertListUserRepresentationToListDecideurTemplate(
                                userRepresentations,
                                RolesConfig.Type_Role_Avis,
                                RolesConfig.Priorite_chef_agence,
                                RolesConfig.Role_Default_Status,
                                DecisionConfig.LEVEL_1_CHEF_AGENCE,
                                user.getAgence());
                        createLevelAndDecideur(cmpt,"Décision du chef d'agence",decideurInKeycloak);
                    case DecisionConfig.action_approuver_par_chef_agence :
//                        if (cmpt.getMontantDuPret()>DecisionConfig.MONTANT_COMITE_SUP){
//                            decideurTemplates = decideurTemplateDao.findByTypeLevel(DecisionConfig.LEVEL_2_PLUS_10M);
//                            createLevelAndDecideur(cmpt,"Avis des membres du comité",decideurTemplates);
//                        }else{
//                            decideurTemplates = decideurTemplateDao.findByTypeLevel(DecisionConfig.LEVEL_2_MOINS_10M);
//                            createLevelAndDecideur(cmpt,"Avis des membres du comité",decideurTemplates);
//                        }
                        break;
                    case DecisionConfig.action_approuver_par_membre_du_comite :
                        /*
                        SI Montant est > à 10 Million, On Vérifie si au moins 2 personnes on donné leur avis
                            + Si oui, on vérifie si les avis sont REFUS,
                                - Si oui, on change le statut du dossier en REFUS
                                - Si non, on crée le niveau final
                            + Si non on attend qu'il y ai 2 avis
                        SI Montant est < à 10 Million, On Vérifie si une personne on donné son avis
                            + Si oui, on vérifie si l'avis est REFUS/COMPLEMENT,
                                - Si oui, on change le statut du dossier en REFUS/COMPLEMENT
                                - Si non, on crée le niveau final
                            + Si non on attend qu'il y ai 1 avis
                         */
//                        if (cmpt.getMontantDuPret()>DecisionConfig.MONTANT_COMITE_SUP) {
//
//                            createLevelAndDecideur(cmpt,"Décision",
//                                    decideurTemplateDao.findByTypeLevel(DecisionConfig.DECISION_FINAL));
//                        }else{
//                            createLevelAndDecideur(cmpt,"Décision",
//                                    decideurTemplateDao.findByTypeLevel(DecisionConfig.DECISION_FINAL));
//                        }
                        break;
                    default:
                        break;
                }
                return StatusDto.ofSuccess("Modification avec success de l'état du dossier");

            } catch (Exception e) {
                e.printStackTrace();
                throw new MyAppException("Impossible de Mettre à jour le dossier");
            }
        }else{
            throw new MyAppException("Le dossier n'existe pas");
        }

    }
    public Boolean createLevelAndDecideur (Compte cmpt, String descriptionLevel, List<DecideurTemplate> decideurs){
        try{
            LevelDecision levelDecision = new LevelDecision();
            int level = levelDecisionDao.findMaxLevel(cmpt.getBusinessKey());
            levelDecision.setBusinessKey(cmpt.getBusinessKey());
            levelDecision.setLevel(level);
            levelDecision.setDescription(descriptionLevel);
            levelDecision.setWaitingforlevel(level - 1);

            levelDecision = levelDecisionDao.save(levelDecision);
            System.out.println("levelDecision ====== >>>>>>>> " + levelDecision.toString());

            for (DecideurTemplate decideur: decideurs){
                DecideurOfLevel decideurOfLevel = new DecideurOfLevel();
                decideurOfLevel.setIdlevel(levelDecision.getId());
                decideurOfLevel.setDecideur(decideur.getEmail());
                decideurOfLevel.setDecideurFullName(decideur.getPrenom()+" "+decideur.getNom());
                decideurOfLevel.setRole(decideur.getRole());
                decideurOfLevel.setPriorite(decideur.getPriorite());
                decideurOfLevel.setBusinessKey(cmpt.getBusinessKey());
                decideurOfLevelDao.save(decideurOfLevel);
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public NoteTypes analyseAllDecision(String businessKey){
        // Selectionne tous les decideurs du dernier level
        List<LevelDecision> levelDecisions = levelDecisionDao.findByBusinessKey(businessKey);
        LevelDecision maxlevelOfBusinessKey = Collections.max(levelDecisions, Comparator.comparing(l -> l.getId()));

        List<DecideurOfLevel> decideurOfLevels = decideurOfLevelDao.findByBusinessKeyAndRoleAndIdlevel(businessKey,
                DecisionConfig.role_decideur,maxlevelOfBusinessKey.getId());

        Boolean valider=true,refuser=true, completer=true, mixed=true;

        for (DecideurOfLevel decideurOfLevel: decideurOfLevels) {
            System.out.println(decideurOfLevel);

            if (decideurOfLevel.getDecision() == null) {
                System.out.println("decideurOfLevel ===== null");
                valider = false;
                refuser = false;
                completer = false;
                mixed = false;
                return null;
            }

            if (!(decideurOfLevel.getDecision().equals(NoteTypes.ABSENCE) ||
                    decideurOfLevel.getDecision().equals(NoteTypes.VALIDATION)))
                valider= false;

            if (!(decideurOfLevel.getDecision().equals(NoteTypes.ABSENCE) ||
                    decideurOfLevel.getDecision().equals(NoteTypes.REFUSE)))
                refuser= false;

            if (!(decideurOfLevel.getDecision().equals(NoteTypes.ABSENCE) ||
                    decideurOfLevel.getDecision().equals(NoteTypes.COMPLEMENT)))
                completer= false;

        }

        if (valider) return NoteTypes.VALIDATION;
        if (refuser) return NoteTypes.REFUSE;
        if (completer) return NoteTypes.COMPLEMENT;
        if (mixed) {
            DecideurOfLevel decideurOfLevel = Collections.min(decideurOfLevels, Comparator.comparing(l -> l.getPriorite()));
            return decideurOfLevel.getDecision();
        }

        return null;
    }

    public NoteTypes analyseDecisionsOfComite(int idlevel,int avisMinimum){
        // Selectionne tous les decideurs du level
        List<DecideurOfLevel> decideurOfLevels = decideurOfLevelDao.findByIdlevel(idlevel);

        int valider=0,refuser=0, completer=0, mixed=0;

        for (DecideurOfLevel decideurOfLevel: decideurOfLevels) {
//            System.out.println(decideurOfLevel);

//            if (decideurOfLevel.getDecision() == null) {
//                System.out.println("decideurOfLevel ===== null");
//                valider = false;
//                refuser = false;
//                completer = false;
//                mixed = false;
//                return null;
//            }

            if (decideurOfLevel.getDecision()!= null && !decideurOfLevel.getDecision().equals(NoteTypes.ABSENCE) &&
                    decideurOfLevel.getDecision().equals(NoteTypes.VALIDATION))
                valider++;

            if (decideurOfLevel.getDecision()!= null && !decideurOfLevel.getDecision().equals(NoteTypes.ABSENCE) &&
                    decideurOfLevel.getDecision().equals(NoteTypes.REFUSE))
                refuser++;

            if (decideurOfLevel.getDecision()!= null && !decideurOfLevel.getDecision().equals(NoteTypes.ABSENCE) &&
                    decideurOfLevel.getDecision().equals(NoteTypes.COMPLEMENT))
                completer++;

        }

        if (valider>=avisMinimum) return NoteTypes.VALIDATION;
        if (refuser>=avisMinimum) return NoteTypes.REFUSE;
        if (completer>=avisMinimum) return NoteTypes.COMPLEMENT;

        if ((valider+refuser+completer>=avisMinimum))return NoteTypes.COMPLEMENT; // Faire passer le dossier en décision

        return null;
    }

    public StatusDto decisionFinal(String businessKey){
        // Si tous les decideurs ont validé/refusé on approuve/refuse le dossier
        // Si les decideurs ont des avis différent on prend la decision de celui qui est prioritaire.

        Optional<Compte> accountDB=  dossierDao.findByBusinessKey(businessKey);
        if(accountDB.isPresent()) {
            Compte cmpt=accountDB.get();
            NoteTypes statusDossier = analyseAllDecision(businessKey);

            if(statusDossier !=null && statusDossier.equals(NoteTypes.REFUSE)){
                cmpt.setStatus(DmStatus.REFUSE);
                cmpt=dossierDao.save(cmpt);

                Notes notes = new Notes();
                notes.setDate(new Date());
                notes.setBusinessKey(businessKey);
                notes.setType(NoteTypes.REFUSE);
                notes.setDecision("decision");
                notes.setSla("END");
                notes.setNote("Refusé par les decideurs");
                notesDao.save(notes);

                return StatusDto.ofSuccess("Mise à jour bien effectué");
            }
            if(statusDossier !=null && statusDossier.equals(NoteTypes.COMPLEMENT)){
                cmpt.setStatus(DmStatus.EN_TRAITEMENT);
                cmpt=dossierDao.save(cmpt);

                Notes notes = new Notes();
                notes.setDate(new Date());
                notes.setBusinessKey(businessKey);
                notes.setType(NoteTypes.COMPLEMENT);
                notes.setDecision("decision");
                notes.setSla("END");
                notes.setNote("Demande de complement par les decideurs");
                notesDao.save(notes);

                return StatusDto.ofSuccess("Mise à jour bien effectué");
            }
            if(statusDossier !=null && statusDossier.equals(NoteTypes.VALIDATION)){
                cmpt.setStatus(DmStatus.APPROUVE);
                cmpt=dossierDao.save(cmpt);

                Notes notes = new Notes();
                notes.setDate(new Date());
                notes.setBusinessKey(businessKey);
                notes.setType(NoteTypes.APPROUVE);
                notes.setDecision("decision");
                notes.setSla("END");
                notes.setNote("Approuvé par les decideurs");
                notesDao.save(notes);

                return StatusDto.ofSuccess("Mise à jour bien effectué");
            }

        } else{
            throw new MyAppException("Le Loan n'existe pas");
        }

        return null;
    }


}
