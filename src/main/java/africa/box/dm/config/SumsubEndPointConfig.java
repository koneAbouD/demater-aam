package africa.box.dm.config;

public class SumsubEndPointConfig {
    public static final String BASE_URL = "https://test-api.sumsub.com/";

    /* +++++++++++ query to take all loans +++++++++++
        POST
        body: {
                "date": null
            }
     */
    public static final String URL_GET_ALL_ACCOUNT = BASE_URL+"/api/account/getter";

    // Ex: http://172.16.1.136:8000/streamfile/e31be22b-6a1a-11eb-9b64-1cbfc05f736c/ATRED
    public static final String URL_GET_FILE_UPLOADED = BASE_URL+"/streamfile";// +id+docCode

    public static final String TEST = "http://172.16.1.107:8083/document/test";

    /* +++++++++++ query to update businesskey +++++++++++
        PUT
        body: {
                "businesskey_old": "dolore ad",
                "businesskey_new": "dolore"
            }
     */
    public static final String URL_UPDATE_BUSINESSKEY = BASE_URL+"/api/account/businesskey/update";


    /* +++++++++++ query to update businesskey +++++++++++
        POST
        body: {
                "businesskey": "1d814bf0-6097-11eb-be21-1cbfc05f736c"
            }
     */
    public static final String URL_GET_DOCS = BASE_URL+"/api/docs/getter";


    /* +++++++++++ query to update state of loan apply +++++++++++
        PUT
        body: {
                "state": "d",
                "businesskey": "occaecat enim dolore ipsum vo"
            }
     */
    public static final String URL_UPDATE_ACCOUNT_STATE = BASE_URL+"/api/account/state/update";


    /* +++++++++++ query to add new docs into list +++++++++++
        PUT
        body: {
                "business_key": "labore consequa",
                "description": "mollit exercitation",
                "doccode": "adipisicing eiusmod",
                "documentstatus": "est nostrud labore",
                "facultatif": "mollit dolor",
                "name": "ut et nulla aliqua",
                "numberofcopies": "elit qui esse",
                "fromclient": "sint cupidatat in",
                "id": "fugiat ea",
                "docmetadacanevas": "sed est"
            }
     */
    public static final String URL_ADD_NEW_DOC = BASE_URL+"/api/docs/create";

    public static final String DEFAULT_EXTERNAL_AGENCE = "/EXTERNE";
    public static final String DEFAULT_EXTERNAL_USER = "serverTask";

}
