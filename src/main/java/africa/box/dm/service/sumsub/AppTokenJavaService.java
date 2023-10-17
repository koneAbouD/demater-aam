//package africa.box.dm.service.sumsub;
//
//import africa.box.dm.db.entities.Compte;
//import africa.box.dm.service.CompteService;
//import africa.box.dm.service.sumsub.model.*;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import net.minidev.json.JSONObject;
//import okhttp3.*;
//import okio.Buffer;
//import org.apache.commons.codec.binary.Hex;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import javax.crypto.Mac;
//import javax.crypto.spec.SecretKeySpec;
//import java.io.File;
//import java.io.IOException;
//import java.nio.charset.StandardCharsets;
//import java.security.InvalidKeyException;
//import java.security.NoSuchAlgorithmException;
//import java.time.Instant;
//import java.util.*;
//
//@Service
//public class AppTokenJavaService {
//    // The description of the authorization method is available here: https://developers.sumsub.com/api-reference/#app-tokens
//    private  final String SUMSUB_SECRET_KEY = "TiMvpZWG0wjeM2n1FtBxF9EJt2956hFA"; // Example: Hej2ch71kG2kTd1iIUDZFNsO5C1lh5Gq
//    private  final String SUMSUB_APP_TOKEN = "prd:GEJggppGzQG7bDv5ElX9wGYe.0pw6ssfcGqZIAx4Dc3KnAl9F16nP5nLS"; // Example: tst:uY0CgwELmgUAEyl4hNWxLngb.0WSeQeiYny4WEqmAALEAiK2qTC96fBad
//    private  final String SUMSUB_TEST_BASE_URL = "https://api.sumsub.com"; // Please don't forget to change when switching to production
//
//    private  final ObjectMapper objectMapper = new ObjectMapper();
//
//    public  String createApplicant(Applicant applicant) throws IOException, NoSuchAlgorithmException, InvalidKeyException {
//        // https://developers.sumsub.com/api-reference/#creating-an-applicant
//
//        DocSet identityDocSet = new DocSet(
//                IdDocSetType.IDENTITY,
//                Arrays.asList(DocType.ID_CARD)
//        );
//
////        DocSet selfieDocSet = new DocSet(
////                IdDocSetType.SELFIE,
////                Collections.singletonList(DocType.SELFIE)
////        );
////        applicant.setRequiredIdDocs(new RequiredIdDocs(Arrays.asList(identityDocSet, selfieDocSet)));
//
////        applicant.setExternalUserId(UUID.randomUUID().toString());
//        applicant.setRequiredIdDocs(new RequiredIdDocs(Arrays.asList(identityDocSet)));
//
//        Response response = sendPost(
//                "/resources/applicants?levelName=web-kyc-level", //?levelName=API%20INTEGRATION
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
//    public  String addDocument(String applicantId, File doc) throws NoSuchAlgorithmException, InvalidKeyException, IOException {
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
//    public  String getApplicantStatus(String applicantId) throws NoSuchAlgorithmException, InvalidKeyException, IOException {
//        // https://developers.sumsub.com/api-reference/#getting-applicant-status-api
//
//        Response response = sendGet("/resources/applicants/" + applicantId + "/requiredIdDocsStatus");
//
//        ResponseBody responseBody = response.body();
//        return responseBody != null ? responseBody.string() : null;
//    }
//
//    public  String getApplicant(String applicantId) throws NoSuchAlgorithmException, InvalidKeyException, IOException {
//        // https://developers.sumsub.com/api-reference/#getting-applicant-status-api
//
//        Response response = sendGet("/resources/applicants/" + applicantId + "/one");
//
//        ResponseBody responseBody = response.body();
//        return responseBody != null ? responseBody.string() : null;
//    }
//
//    public  String getAccessToken(String externalUserId) throws NoSuchAlgorithmException, InvalidKeyException, IOException {
//        // https://developers.sumsub.com/api-reference/#access-tokens-for-sdks
//
//        Response response = sendPost(
//                "/resources/accessTokens?userId=" + externalUserId,
//                RequestBody.create(null,new byte[0]));
//
//        ResponseBody responseBody = response.body();
//        return responseBody != null ? responseBody.string() : null;
//    }
//
////    @GetMapping(path = "/geToken/{applicantId}")
////    @org.springframework.web.bind.annotation.ResponseBody
////    public  String getToken(@PathVariable("applicantId") String applicantId) throws NoSuchAlgorithmException, InvalidKeyException, IOException {
////        // https://developers.sumsub.com/api-reference/#access-tokens-for-sdks
////
////        Response response = sendPost(
////                "/resources/accessTokens?userId=" + applicantId,
////                RequestBody.create(null,new byte[0]));
////
////        ResponseBody responseBody = response.body();
////        return responseBody != null ? responseBody.string() : null;
////    }
//
//    public  Response sendPost(String url, RequestBody requestBody) throws IOException, InvalidKeyException, NoSuchAlgorithmException {
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
//    private  Response sendGet(String url) throws IOException, InvalidKeyException, NoSuchAlgorithmException {
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
//    private  String createSignature(long ts, HttpMethod httpMethod, String path, byte[] body) throws NoSuchAlgorithmException, InvalidKeyException {
//        Mac hmacSha256 = Mac.getInstance("HmacSHA256");
//        hmacSha256.init(new SecretKeySpec(SUMSUB_SECRET_KEY.getBytes(StandardCharsets.UTF_8), "HmacSHA256"));
//        hmacSha256.update((ts + httpMethod.name() + path).getBytes(StandardCharsets.UTF_8));
//        byte[] bytes = body == null ? hmacSha256.doFinal() : hmacSha256.doFinal(body);
//        return Hex.encodeHexString(bytes);
//    }
//
//    public  byte[] requestBodyToBytes(RequestBody requestBody) throws IOException {
//        Buffer buffer = new Buffer();
//        requestBody.writeTo(buffer);
//        return buffer.readByteArray();
//    }
//
//}
//
//
//
