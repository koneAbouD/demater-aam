//package africa.box.dm.service.sumsub.model;
//
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import com.fasterxml.jackson.annotation.JsonInclude;
//import net.minidev.json.JSONObject;
//
//import java.util.HashMap;
//
//@JsonInclude(JsonInclude.Include.NON_NULL)
//@JsonIgnoreProperties(ignoreUnknown = true)
//public class Applicant {
//    // https://developers.sumsub.com/api-reference/#request-body
//    private String id;
//    private String externalUserId;
//    private String email;
//    private JSONObject info;
//    private RequiredIdDocs requiredIdDocs;
//
//    public Applicant() {
//    }
//
//    public Applicant(String externalUserId, RequiredIdDocs requiredIdDocs, String email, JSONObject info) {
//        this.externalUserId = externalUserId;
//        this.requiredIdDocs = requiredIdDocs;
//        this.email = email;
//        this.info = info;
//    }
//
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public String getExternalUserId() {
//        return externalUserId;
//    }
//
//    public void setExternalUserId(String externalUserId) {
//        this.externalUserId = externalUserId;
//    }
//
//    public RequiredIdDocs getRequiredIdDocs() {
//        return requiredIdDocs;
//    }
//
//    public void setRequiredIdDocs(RequiredIdDocs requiredIdDocs) {
//        this.requiredIdDocs = requiredIdDocs;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public JSONObject getInfo() {
//        return info;
//    }
//
//    public void setInfo(JSONObject info) {
//        this.info = info;
//    }
//}
