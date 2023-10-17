//package africa.box.dm.service.sumsub;
//
//import africa.box.dm.db.entities.DocumentType;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import africa.box.dm.service.sumsub.model.Applicant;
//import africa.box.dm.service.sumsub.model.DocSet;
//import africa.box.dm.service.sumsub.model.DocType;
//import africa.box.dm.service.sumsub.model.HttpMethod;
//import africa.box.dm.service.sumsub.model.IdDocSetType;
//import africa.box.dm.service.sumsub.model.Metadata;
//import africa.box.dm.service.sumsub.model.RequiredIdDocs;
//import net.minidev.json.JSONObject;
//import okhttp3.*;
//import okhttp3.RequestBody;
//import okhttp3.ResponseBody;
//import okio.Buffer;
////import okhttp3.MediaType;
////import okhttp3.MultipartBody;
////import okhttp3.OkHttpClient;
////import okhttp3.Request;
////import okhttp3.RequestBody;
////import okhttp3.Response;
////import okhttp3.ResponseBody;
////import okio.Buffer;
//import org.apache.commons.codec.binary.Hex;
//import org.springframework.web.bind.annotation.*;
//
//import javax.crypto.Mac;
//import javax.crypto.spec.SecretKeySpec;
//import java.io.File;
//import java.io.IOException;
//import java.nio.charset.StandardCharsets;
//import java.security.InvalidKeyException;
//import java.security.NoSuchAlgorithmException;
//import java.time.Instant;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//import java.util.UUID;
//
//
//
//
//public class AppTokenJavaExample {
//    // The description of the authorization method is available here: https://developers.sumsub.com/api-reference/#app-tokens
//    private static final String SUMSUB_SECRET_KEY = "Wk0iNjOw0Z0JnGmmRqf3H8alBG8tGoVK"; // Example: Hej2ch71kG2kTd1iIUDZFNsO5C1lh5Gq
//    private static final String SUMSUB_APP_TOKEN = "tst:SsuBIqjenAYjc7JLttErPpFc.RfYVqJYx7yBSDFuzF5b1b2twyfjn9KlZ"; // Example: tst:uY0CgwELmgUAEyl4hNWxLngb.0WSeQeiYny4WEqmAALEAiK2qTC96fBad
//    private static final String SUMSUB_TEST_BASE_URL = "https://test-api.sumsub.com"; // Please don't forget to change when switching to production
//
//    private static final ObjectMapper objectMapper = new ObjectMapper();
//
////    public static void main(String[] args) throws IOException, InvalidKeyException, NoSuchAlgorithmException {
////        // The description of the flow can be found here: https://developers.sumsub.com/api-flow/#api-integration-phases
////
////        //https://test-api.sumsub.com/resources/applicants/6047376a0aa6c400091c808c/one
////        String applicantStr = getApplicant("6064bf660aa6c4000bb50f39");
////        System.out.println("Applicant (json string): " + applicantStr);
////
////        // Such actions are presented below:
////        // 1) Creating an applicant
////        // 2) Adding a document to the applicant
////        // 3) Getting applicant status
////        // 4) Getting access token
////
////        File file = new File("C:\\Users\\Kevin KOUAKOU\\Documents\\LAM\\BACK\\dm\\fausse-cni.png");
////
////        if (!file.exists()){
////            System.out.println("File n'existe pas !!!");
////        }
//////        JSONObject info = new JSONObject();
//////        info.put("firstName","TONTON2");
//////        info.put("lastName","ADJOUMANI2");
//////        info.put("middleName","TEST2");
//////        info.put("gender","M");
//////        info.put("dob","2001-09-25");
//////        info.put("placeOfBirth","Yakro");
//////        info.put("countryOfBirth","CI");
//////        info.put("stateOfBirth","BELIER");
//////        info.put("phone","+2250707001122");
////
//////        Applicant applicant = new Applicant(
//////                null,
//////                null,
//////                "kkouakou@box.africa",
//////                info
//////        );
//////        String applicantId = createApplicant(applicant);
//////        System.out.println("The applicant was successfully created: " + applicantId);
//////        System.out.println("The verification de lapplicant et id: " + applicantId);
//////
//////        System.out.println(" =======> "+file.getAbsolutePath());
//////        String imageId = addDocument(applicantId, file);
//////        System.out.println("Identifier of the added document: " + imageId);
//////
//////        String applicantStatusStr = getApplicantStatus(applicantId);
//////        System.out.println("Applicant status (json string): " + applicantStatusStr);
////        String accessTokenStr = getAccessToken("6064bf660aa6c4000bb50f39");
////        System.out.println("Access token tonton (json string): " + accessTokenStr);
////
////
////
////    }
//
//
//
//    public static String createApplicant(Applicant applicant) throws IOException, NoSuchAlgorithmException, InvalidKeyException {
//        // https://developers.sumsub.com/api-reference/#creating-an-applicant
//
//        DocSet identityDocSet = new DocSet(
//                IdDocSetType.IDENTITY,
//                Arrays.asList(DocType.ID_CARD)
//        );
//
//        DocSet selfieDocSet = new DocSet(
//                IdDocSetType.SELFIE,
//                Collections.singletonList(DocType.SELFIE)
//        );
//
//        applicant.setExternalUserId(UUID.randomUUID().toString());
//        applicant.setRequiredIdDocs(new RequiredIdDocs(Arrays.asList(identityDocSet, selfieDocSet)));
//
//        Response response = sendPost(
//                "/resources/applicants?levelName=API%20INTEGRATION",
//                RequestBody.create(
//                        MediaType.parse("application/json; charset=utf-8"),
//                        objectMapper.writeValueAsString(applicant)));
//
//        ResponseBody responseBody = response.body();
//
//        return responseBody != null ? objectMapper.readValue(responseBody.string(), Applicant.class).getId() : null;
//
//    }
//
//    public static String addDocument(String applicantId, File doc) throws NoSuchAlgorithmException, InvalidKeyException, IOException {
//        // https://developers.sumsub.com/api-reference/#adding-an-id-document
//
//        RequestBody requestBody = new MultipartBody.Builder()
//                .setType(MultipartBody.FORM)
//                .addFormDataPart("metadata", objectMapper.writeValueAsString(new Metadata(DocType.PASSPORT, "DEU")))
//                .addFormDataPart("content", doc.getName(), RequestBody.create(MediaType.parse("image/*"), doc))
//                .build();
//
//        Response response = sendPost("/resources/applicants/" + applicantId + "/info/idDoc", requestBody);
//        return response.headers().get("X-Image-Id");
//    }
//
//    public static String getApplicantStatus(String applicantId) throws NoSuchAlgorithmException, InvalidKeyException, IOException {
//        // https://developers.sumsub.com/api-reference/#getting-applicant-status-api
//
//        Response response = sendGet("/resources/applicants/" + applicantId + "/requiredIdDocsStatus");
//
//        ResponseBody responseBody = response.body();
//        return responseBody != null ? responseBody.string() : null;
//    }
//
//    public static String getApplicant(String applicantId) throws NoSuchAlgorithmException, InvalidKeyException, IOException {
//        // https://developers.sumsub.com/api-reference/#getting-applicant-status-api
//
//        Response response = sendGet("/resources/applicants/" + applicantId + "/one");
//
//        ResponseBody responseBody = response.body();
//        return responseBody != null ? responseBody.string() : null;
//    }
//
//    public static String getAccessToken(String applicantId) throws NoSuchAlgorithmException, InvalidKeyException, IOException {
//        // https://developers.sumsub.com/api-reference/#access-tokens-for-sdks
//
//        Response response = sendPost(
//                "/resources/accessTokens?userId=" + applicantId,
//                RequestBody.create(null,new byte[0]));
//
//        ResponseBody responseBody = response.body();
//        return responseBody != null ? responseBody.string() : null;
//    }
//
//    @GetMapping(path = "/geToken/{applicantId}")
//    @org.springframework.web.bind.annotation.ResponseBody
//    public static String getToken(@PathVariable("applicantId") String applicantId) throws NoSuchAlgorithmException, InvalidKeyException, IOException {
//        // https://developers.sumsub.com/api-reference/#access-tokens-for-sdks
//
//        Response response = sendPost(
//                "/resources/accessTokens?userId=" + applicantId,
//                RequestBody.create(null,new byte[0]));
//
//        ResponseBody responseBody = response.body();
//        return responseBody != null ? responseBody.string() : null;
//    }
//
//    public static Response sendPost(String url, RequestBody requestBody) throws IOException, InvalidKeyException, NoSuchAlgorithmException {
//        long ts = Instant.now().getEpochSecond();
//
//        Request request = new Request.Builder()
//                .url(SUMSUB_TEST_BASE_URL + url)
//                .header("X-App-Token", SUMSUB_APP_TOKEN)
//                .header("X-App-Access-Sig", createSignature(ts, HttpMethod.POST, url, requestBodyToBytes(requestBody)))
//                .header("X-App-Access-Ts", String.valueOf(ts))
//                .post(requestBody)
//                .build();
//
//        Response response = new OkHttpClient().newCall(request).execute();
//
//        if (response.code() != 200 && response.code() != 201) {
//            // https://developers.sumsub.com/api-reference/#errors
//            // If an unsuccessful answer is received, please log the value of the "correlationId" parameter.
//            // Then perhaps you should throw the exception. (depends on the logic of your code)
//        }
//        return response;
//    }
//
//    private static Response sendGet(String url) throws IOException, InvalidKeyException, NoSuchAlgorithmException {
//        long ts = Instant.now().getEpochSecond();
//
//        Request request = new Request.Builder()
//                .url(SUMSUB_TEST_BASE_URL + url)
//                .header("X-App-Token", SUMSUB_APP_TOKEN)
//                .header("X-App-Access-Sig", createSignature(ts, HttpMethod.GET, url, null))
//                .header("X-App-Access-Ts", String.valueOf(ts))
//                .get()
//                .build();
//
//        Response response = new OkHttpClient().newCall(request).execute();
//
//        if (response.code() != 200 && response.code() != 201) {
//            // https://developers.sumsub.com/api-reference/#errors
//            // If an unsuccessful answer is received, please log the value of the "correlationId" parameter.
//            // Then perhaps you should throw the exception. (depends on the logic of your code)
//        }
//        return response;
//    }
//
//    private static String createSignature(long ts, HttpMethod httpMethod, String path, byte[] body) throws NoSuchAlgorithmException, InvalidKeyException {
//        Mac hmacSha256 = Mac.getInstance("HmacSHA256");
//        hmacSha256.init(new SecretKeySpec(SUMSUB_SECRET_KEY.getBytes(StandardCharsets.UTF_8), "HmacSHA256"));
//        hmacSha256.update((ts + httpMethod.name() + path).getBytes(StandardCharsets.UTF_8));
//        byte[] bytes = body == null ? hmacSha256.doFinal() : hmacSha256.doFinal(body);
//        return Hex.encodeHexString(bytes);
//    }
//
//    public static byte[] requestBodyToBytes(RequestBody requestBody) throws IOException {
//        Buffer buffer = new Buffer();
//        requestBody.writeTo(buffer);
//        return buffer.readByteArray();
//    }
//
//}
//
//
//
