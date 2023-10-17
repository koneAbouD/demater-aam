package africa.box.dm.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 *
 */
@ConfigurationProperties(prefix = "onboarding")
@Component
public class ExternalEndPointConfig {

    //    @Value("${onboarding.server}")
    private String server_url;
    private String get_all_file_url;
    private String get_file_uploaded_url;
    private String update_businesskey_url;
    private String get_docs_url;
    private String update_state_file_url;
    private String add_doc_url;
    private String default_agence;
    private String default_user;

    private String add_doc_for_sign;
    private String get_sign_doc;

//    public ExternalEndPointConfig(String add_doc_for_sign, String get_sign_doc) {
//        this.add_doc_for_sign = add_doc_for_sign;
//        this.get_sign_doc = get_sign_doc;
//    }

    public void setAdd_doc_for_sign(String add_doc_for_sign) {
        this.add_doc_for_sign = add_doc_for_sign;
    }

    public String getAdd_doc_for_sign() {
        return add_doc_for_sign;
    }

    public String getGet_sign_doc() {
        return get_sign_doc;
    }

    public void setGet_sign_doc(String get_sign_doc) {
        this.get_sign_doc = get_sign_doc;
    }

    public String getServer_url() {
        return server_url;
    }


    public void setServer_url(String server_url) {
        this.server_url = server_url;
    }

    public String getGet_all_file_url() {
        return get_all_file_url;
    }

    public void setGet_all_file_url(String get_all_file_url) {
        this.get_all_file_url = get_all_file_url;
    }

    public String getGet_file_uploaded_url() {
        return get_file_uploaded_url;
    }

    public void setGet_file_uploaded_url(String get_file_uploaded_url) {
        this.get_file_uploaded_url = get_file_uploaded_url;
    }

    public String getUpdate_businesskey_url() {
        return update_businesskey_url;
    }

    public void setUpdate_businesskey_url(String update_businesskey_url) {
        this.update_businesskey_url = update_businesskey_url;
    }

    public String getGet_docs_url() {
        return get_docs_url;
    }

    public void setGet_docs_url(String get_docs_url) {
        this.get_docs_url = get_docs_url;
    }

    public String getUpdate_state_file_url() {
        return update_state_file_url;
    }

    public void setUpdate_state_file_url(String update_state_file_url) {
        this.update_state_file_url = update_state_file_url;
    }

    public String getAdd_doc_url() {
        return add_doc_url;
    }

    public void setAdd_doc_url(String add_doc_url) {
        this.add_doc_url = add_doc_url;
    }

    public String getDefault_agence() {
        return default_agence;
    }

    public void setDefault_agence(String default_agence) {
        this.default_agence = default_agence;
    }

    public String getDefault_user() {
        return default_user;
    }

    public void setDefault_user(String default_user) {
        this.default_user = default_user;
    }

    //    public String getServer() {
//        return server;
//    }
//
//    public void setServer(String server) {
//        this.server = server;
//    }
//
////    public   String BASE_URL = "http://172.16.1.146:8080";
//
//    /* +++++++++++ query to take all loans +++++++++++
//        POST
//        body: {
//                "date": null
//            }
//     */
//    public String URL_GET_ALL_LOAN = getServer() +"/api/loan/getter";
//
//    // Ex: http://172.16.1.136:8000/streamfile/e31be22b-6a1a-11eb-9b64-1cbfc05f736c/ATRED
////    public   String URL_GET_FILE_UPLOADED = this.server+"/streamfile";// +id+docCode
//    public String URL_GET_FILE_UPLOADED =getServer()+"/loan/docs/streaming";// +id+docCode
//
////    public   String TEST = "http://172.16.1.107:8083/document/test";
//
//    /* +++++++++++ query to update businesskey +++++++++++
//        PUT
//        body: {
//                "businesskey_old": "dolore ad",
//                "businesskey_new": "dolore"
//            }
//     */
//    public String URL_UPDATE_BUSINESSKEY =getServer()+"/api/loan/businesskey/update";
//
//
//    /* +++++++++++ query to update businesskey +++++++++++
//        POST
//        body: {
//                "businesskey": "1d814bf0-6097-11eb-be21-1cbfc05f736c"
//            }
//     */
//    public String URL_GET_DOCS =getServer()+"/api/docs/getter";
//
//
//    /* +++++++++++ query to update state of loan apply +++++++++++
//        PUTDirectory created successfully
//        body: {
//                "state": "d",
//                "businesskey": "occaecat enim dolore ipsum vo"
//            }
//     */
//    public String URL_UPDATE_LOAN_STATE =getServer()+"/api/loan/state/update";
//
//
//    /* +++++++++++ query to add new docs into list +++++++++++
//        add new doc PUT
//        *"/api/docs/create"*
//        body: {
//                "business_key": "labore consequa",
//                "description": "mollit exercitation",
//                "doccode": "adipisicing eiusmod",
//                "documentstatus": "est nostrud labore",
//                "facultatif": "mollit dolor",
//                "name": "ut et nulla aliqua",
//                "numberofcopies": "elit qui esse",
//                "fromclient": "sint cupidatat in",
//                "id": "fugiat ea",
//                "docmetadacanevas": "sed est"
//            }
//     */
//    public String URL_ADD_NEW_DOC =getServer()+"/api/docs/create";
//
//    public String DEFAULT_EXTERNAL_AGENCE = "/EXTERNE";
//    public String DEFAULT_EXTERNAL_USER = "serverTask";

}
