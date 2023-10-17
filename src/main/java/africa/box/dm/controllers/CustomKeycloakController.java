package africa.box.dm.controllers;
import africa.box.dm.service.CustomKeycloakService;
import org.keycloak.representations.account.UserRepresentation;
import org.keycloak.representations.idm.GroupRepresentation;
import org.keycloak.representations.idm.RoleRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController()
@RequestMapping("/keycloak")
@CrossOrigin(value = "*", origins = "*")
public class CustomKeycloakController {

    @Autowired
    CustomKeycloakService customKeycloakService;

    @GetMapping("/users")
    public List<UserRepresentation> getUsers(){
//		KeycloakSecurityContext context = (KeycloakSecurityContext) request.getAttribute(KeycloakSecurityContext.class.getName());
//
//		Keycloak keycloak = KeycloakBuilder.builder()
//				.serverUrl("http://localhost:8080/auth")
//				.realm("example")
//				.authorization(context.getTokenString())
//				.resteasyClient(new ResteasyClientBuilder().connectionPoolSize(20).build())
//				.build();
        List<Map<String,String>> list = new ArrayList<>();

        List<UserRepresentation> listUserRepresentation = customKeycloakService.getUsers();
        for (UserRepresentation u:listUserRepresentation){
            Map<String,String> user = new HashMap<>();
            user.put("firstName",u.getFirstName());
            user.put("lasttName",u.getLastName());
            user.put("email",u.getEmail());
            System.out.println(user);
        }

        return listUserRepresentation;
    }

    @GetMapping("/groups")
    public List<GroupRepresentation> getGroups(){
        List<Map<String,String>> list = new ArrayList<>();

        //List<GroupRepresentation> listGroupRepresentation = customKeycloakService.getGroups();
        List<GroupRepresentation> listGroupRepresentation = customKeycloakService.getGroupsKeycloak();
        for (GroupRepresentation g:listGroupRepresentation){
            Map<String,String> group = new HashMap<>();
            group.put("name",g.getName());
            group.put("path",g.getPath());
            group.put("id",g.getId());
            System.out.println("group "+group);
        }

        return listGroupRepresentation;
    }
    @GetMapping("/membersofgroups/{idGroup}")
    public List<UserRepresentation> getMembersOfGroups(@PathVariable("idGroup")String idGroup){
        return customKeycloakService.getUsersOfGroup(idGroup);
    }

    @GetMapping("/users/all")
    public List<UserRepresentation> getKeycloakUsers(){
        return customKeycloakService.getUsersKeycloak();
    }

    @GetMapping("/roles/all")
    public List<RoleRepresentation> getKeycloakRoles(){
        return customKeycloakService.getRolesKeycloak();
    }

    @GetMapping("/groups/all")
    public List<GroupRepresentation> getKeycloakGroups(){
        return customKeycloakService.getGroupsKeycloak();
    }

//    @GetMapping("/groups")
//    public List<GroupRepresentation> getGroups(){
//        List<Map<String,String>> list = new ArrayList<>();
//
//        List<GroupRepresentation> listGroupRepresentation = customKeycloakService.getGroups();
//        for (GroupRepresentation g:listGroupRepresentation){
//            Map<String,String> group = new HashMap<>();
//            group.put("name",g.getName());
//            group.put("path",g.getPath());
//            group.put("id",g.getId());
//        }
//        return listGroupRepresentation;
//    }

//    @GetMapping("/membersofgroups/{idGroup}")
//    public List<UserRepresentation> getMembersOfGroups(@PathVariable("idGroup")String idGroup){
//        List<UserRepresentation> listUserRepresentation = customKeycloakService.getUsersOfGroup(idGroup);
//        return listUserRepresentation;
//    }
//
//    @PostMapping("/membersofgroups")
//    @ResponseBody
//    public List<Map<String,String>> getMembersOfMultipleGroups(@RequestBody Map<String,List<String>> idGroups){
//        List<Map<String,String>> list = new ArrayList<>();
//
//        List<String>listIdGroup = new ArrayList<>();
//        listIdGroup = idGroups.get("listGroups");
//        for (String idGroup:listIdGroup){
//            List<UserRepresentation> listUserRepresentation = customKeycloakService.getUsersOfGroup(idGroup);
//            for (UserRepresentation u:listUserRepresentation){
//                Map<String,String> user = new HashMap<>();
//                user.put("firstName",u.getFirstName());
//                user.put("lasttName",u.getLastName());
//                user.put("email",u.getEmail());
//            }
//        }
//
//        return list;
//    }
//
//    @GetMapping("/users/all")
//    public List<UserRepresentation> getKeycloakUsers(){
//        List<UserRepresentation> listUserRepresentation = customKeycloakService.getUsersKeycloak();
//        return listUserRepresentation;
//    }
//
//    @GetMapping("/roles/all")
//    public List<RoleRepresentation> getKeycloakRoles(){
//        List<RoleRepresentation> roleRepresentations = customKeycloakService.getRolesKeycloak();
//        return roleRepresentations;
//    }
//
//    @GetMapping("/groups/all")
//    public List<GroupRepresentation> getKeycloakGroups(){
//        List<GroupRepresentation> groupRepresentationList = customKeycloakService.getGroupsKeycloak();
//        return groupRepresentationList;
//    }

}
