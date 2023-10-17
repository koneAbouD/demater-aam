//package africa.box.dm.controllers;
//
////import africa.box.dm.service.sumsub.AppTokenJavaService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//import java.io.IOException;
//import java.security.InvalidKeyException;
//import java.security.NoSuchAlgorithmException;
//
//@Controller
//@RequestMapping("/sumsub")
//@CrossOrigin(value = "*", origins = "*")
//public class SumsubController {
//
//    @Autowired(required=true)
//    AppTokenJavaService appTokenJavaService;
//
//
//
//    @GetMapping("/token/{externalUserId}")
//    @ResponseBody
//    public String getToken(@PathVariable(name = "externalUserId") String externalUserId) throws NoSuchAlgorithmException, InvalidKeyException, IOException {
//        if(externalUserId==null || externalUserId.equals("undefined")) {
//            System.out.println("externalUserId is null");
//            return "";
//        }
//        System.out.println(">"+externalUserId+"<");
//        return appTokenJavaService.getAccessToken(externalUserId);
//    }
//
//
//    @GetMapping("/statut/{applicantId}")
//    @ResponseBody
//    public String getSumsubStatut(@PathVariable(name = "applicantId") String applicantId) throws NoSuchAlgorithmException, InvalidKeyException, IOException {return appTokenJavaService.getApplicantStatus(applicantId); }
//
//    @GetMapping("/applicant/{applicantId}")
//    @ResponseBody
//    public String getSumsubApplicant(@PathVariable(name = "applicantId") String applicantId) throws NoSuchAlgorithmException, InvalidKeyException, IOException {return appTokenJavaService.getApplicant(applicantId); }
//
//
//}
