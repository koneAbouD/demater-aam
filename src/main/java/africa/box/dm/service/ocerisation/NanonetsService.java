package africa.box.dm.service.ocerisation;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class NanonetsService {


    public  String postDocForServer(String url,String businesskey) throws UnirestException {

        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = Unirest.post("https://boxbanking-mobile.westeurope.cloudapp.azure.com/index.php/api/upload/sign/files")
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .field("file", new File(url))
                .field("businesskey", businesskey)
                .asString();

        return response.getBody();
    }




       public String oceriserDoc(File pathName) throws UnirestException {

           System.out.println("pathName======= "+pathName);

           Unirest.setTimeouts(0, 0);
           HttpResponse<String> response = Unirest.post("https://app.nanonets.com/api/v2/OCR/Model/14498730-f049-4a55-b2a0-b892550eea83/LabelFile/")
                   .header("accept", "multipart/form-data")
                   .header("Authorization", "Basic VnpCbUQ2c0hTZmtVRWhWZGltb2ZMNUtwMW1WTFlST0I6")
                   .header("Cookie", "flash=MTYyNjEwNzM5NXxEdi1CQkFFQ180SUFBUkFCRUFBQUJQLUNBQUE9fH5W_Y4USQpvwu-cLoUdtpYAoxgtkiwtMXwpqhCV3gd-")
                   .field("file", pathName)
                   .asString();

//           pathName ="/C:/Users/Kevin KOUAKOU/Documents/BOX_AFRICA_APP/HPSCANS/numérisation - Copie.jpg";
//        Gson g = new Gson();

            return response.getBody();
       }

}
