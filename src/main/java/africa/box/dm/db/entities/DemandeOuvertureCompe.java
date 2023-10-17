package africa.box.dm.db.entities;

import com.itextpdf.forms.PdfAcroForm;
import com.itextpdf.forms.fields.PdfFormField;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.Map;

public class DemandeOuvertureCompe {
    private final static long serialVersinUID = 1L;
    private final static Logger logger = LoggerFactory.getLogger(DemandeOuvertureCompe.class);

    private static final String SRC = "C:\\Users\\VAS 6\\Box-arica\\Demance_Ouverture_Compte_Template.pdf";
    private static final String DEST = "C:\\Users\\VAS 6\\Box-arica\\Demance_Ouverture_Compte.pdf";


    public DemandeOuvertureCompe(){

    }

   public void generate(Compte compte){
       try{
           PdfDocument pdfDocument = new PdfDocument(
                   new PdfReader(SRC), new PdfWriter(DEST)
           );

           PdfCanvas canvas = new PdfCanvas(pdfDocument.getFirstPage());

           PdfAcroForm form = PdfAcroForm.getAcroForm(pdfDocument, true);

           final Map<String, PdfFormField> fields = form.getFormFields();

           fields.entrySet().forEach(entry->{
               System.out.println(entry.getKey());
           });

           fields.get("fullName").setValue(compte.getNomDemandeur() + " "+ compte.getPrenomDemandeur());
           fields.get("dateOfBirth").setValue(compte.getDateDeNaissance().toString());
           fields.get("placeOfBirth").setValue(compte.getLieuDeNaissance().toString());

           fields.get("profession").setValue(compte.getPoste());
           fields.get("adress").setValue(compte.getAdresse() + " - "+ compte.getVille());
           fields.get("postalCode").setValue(compte.getBoitePostal());
           fields.get("nationality").setValue(compte.getNationalite().getNationalite());
           fields.get("registerIdentifierNumber").setValue(compte.getNumeroDePiece());


           fields.get("signaturePlace").setValue(LocalDate.now().toString());
           pdfDocument.close();
       }catch (Exception ex){
           logger.warn("An error occured with message {}", ex.getMessage());
           ex.printStackTrace();
       }

   }

}
