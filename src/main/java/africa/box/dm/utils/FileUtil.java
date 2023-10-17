package africa.box.dm.utils;

import africa.box.dm.config.MyAppConfig;
import camundajar.impl.scala.ValueOf;
import com.itextpdf.forms.PdfAcroForm;
import com.itextpdf.forms.fields.PdfFormField;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfString;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.annot.PdfAnnotation;
import com.itextpdf.kernel.pdf.annot.PdfTextAnnotation;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Map;

@Component
public class FileUtil {
    private static Logger LOG = LoggerFactory.getLogger(FileUtil.class.getName());

    //private static final String UPLOAD_BASE_PATH= "C:\\Users\\VAS 6\\Box-arica\\AccountFiles";
    private static final String UPLOAD_BASE_PATH= "C:\\DEMATER\\AppDM";
    //private static final String UPLOAD_BASE_PATH= "/home/AdminLocal/UploadedFiles/AccountFiles";
    @Autowired
    private  MyAppConfig appConfig;

    public  byte[] getCompteFile(String businessKey,String docName, Date date){
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Path path = Paths.get(appConfig.getUploadBasePath(),
                String.valueOf(localDate.getYear()),
                String.valueOf(localDate.getMonth()),
                businessKey, docName);

        if(!path.toFile().exists()){
            throw new  CompteFileNotFoundException();
        }
       try {
           return Files.readAllBytes(path);
       }catch (Exception e){
           LOG.warn("[ERROR] : {}", e.getMessage());
            throw new RuntimeException(e.getMessage());
       }
    }

//    public static void main(String... args){
//        final String SRC = "C:\\Users\\VAS 6\\Box-arica\\Contrat_Templates\\Conventio_BDU.pdf";
//        final String DEST = "C:\\Users\\VAS 6\\Box-arica\\Contrat_Templates\\Convention_BDU_text_1.pdf";
//       try{
//           PdfReader reader = new PdfReader(SRC);
//           PdfWriter writer = new PdfWriter(DEST);
//
//           PdfDocument pdfDocument = new PdfDocument(
//                   reader, writer
//           );
//
//           PdfAnnotation pdfAnon = new PdfTextAnnotation(new Rectangle(400,200))
//                   .setOpen(true)
//                   .setTitle(new PdfString("BDU"))
//                   .setContents("Life is an amazing given by god");
//
//           pdfDocument.getFirstPage().addAnnotation(pdfAnon);
//
//           PdfCanvas canvas = new PdfCanvas(pdfDocument.getFirstPage());
//
//           PdfAcroForm form = PdfAcroForm.getAcroForm(pdfDocument, true);
//
//           final Map<String, PdfFormField> fields = form.getFormFields();
//           fields.get("fullName").setValue("Kouakou David");
//
//
//           pdfDocument.close();
//       }catch (Exception ex){
//           ex.printStackTrace();
//       }
//    }

}