package africa.box.dm.utils;

import africa.box.dm.db.entities.*;
import com.itextpdf.forms.PdfAcroForm;
import com.itextpdf.forms.fields.PdfFormField;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;

import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import java.io.FileOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class ContratPdfBDU {
    private final static long serialVersinUID = 1L;
    private final static Logger logger = LoggerFactory.getLogger(ContratPdfBDU.class);
    //private final static String FILE_TEMPLATE_BASE_PATH = "/home/admin/BDU_PROJECT/AAM/BACK/Contrat_Templates/";
    //private final static String FILE_TEMPLATE_BASE_PATH = "C:\\DEMATER\\AppDM\\Contrat_Templates\\";
    //private final static String FILE_TEMPLATE_BASE_PATH = "C:\\DEMATER\\AppDM\\PRE-PROD\\BACK\\Contrat_Templates\\";
    //private final static String FILE_TEMPLATE_BASE_PATH = "C:\\Users\\dkone\\Documents\\DEMATER\\AppDM\\Contrat_Templates\\";

    @Value("${app.file-storage.template-base-path}")
    private static String FILE_TEMPLATE_BASE_PATH;
    private final static String end = UUID.randomUUID().toString().split("-")[2];
    private ContratPdfBDU(){

    }
    public static Resource createConventBDUPdf(Compte compte) throws Exception{
        final String SRC = FILE_TEMPLATE_BASE_PATH+"Convention_BDU_Template.pdf";
        final Path DEST = Paths.get(System.getProperty("java.io.tmpdir"),
                randomFileName("Convention_BDU", compte.getBusinessKey()));
        final Path TEMP = Paths.get(System.getProperty("java.io.tmpdir"),
                randomFileName("Convention_BDU_TEMP", compte.getBusinessKey()));

        if (!DEST.toFile().exists()){
            DEST.toFile().createNewFile();
        }

        PdfDocument pdfDocument = null;
        try{
//            PdfReader reader = new PdfReader(SRC);
//            PdfWriter writer = new PdfWriter(TEMP.toString());
             pdfDocument = new PdfDocument(
                     new PdfReader(SRC), new PdfWriter(TEMP.toString())
            );

            PdfCanvas canvas = new PdfCanvas(pdfDocument.getFirstPage());

            PdfAcroForm form = PdfAcroForm.getAcroForm(pdfDocument, true);

            final Map<String, PdfFormField> fields = form.getFormFields();
            fields.entrySet().forEach(entry->{
                System.out.println("Convention_BDU_Template_______ "+entry.getKey());
            });
            fields.get("fullName").setValue(compte.getNomDemandeur() != null ? compte.getNomDemandeur() : "" + " "+ compte.getPrenomDemandeur() != null ? compte.getPrenomDemandeur() :"");
            fields.get("birthDate").setValue(compte.getDateDeNaissance() != null ? compte.getDateDeNaissance().toString() : "");
            fields.get("birthPlace").setValue(compte.getLieuDeNaissance() != null ? compte.getLieuDeNaissance() : "");

            RegisteredID registeredID = compte.getRegisteredID();

            if (registeredID != null){
                if (registeredID.getAuthority().equalsIgnoreCase(IDCardType.CNI.name())){
                    fields.get("CNI").setValue("OK");
                }else if (registeredID.getAuthority().equalsIgnoreCase("ATTESTATION")){
                    fields.get("ATTESTATION").setValue("OK");
                }
                fields.get("identityNumber").setValue(registeredID.getNumber() != null? registeredID.getNumber():"");
            }

            fields.get("profession").setValue(compte.getPoste() != null? compte.getPoste():"");
            fields.get("adress1").setValue(compte.getVille() !=null? compte.getVille():"");
            fields.get("adress2").setValue(compte.getAdresse() !=null? compte.getAdresse():"");
            fields.get("bp").setValue(compte.getBoitePostal() != null? compte.getBoitePostal():"");
            fields.get("nationality").setValue(compte.getNationalite() !=null ? compte.getNationalite().getNationalite() : "");

            fields.get("signatureDate").setValue(DateFormatter.localDate());
            fields.get("signaturePlace").setValue(compte.getAgence().replace("/",""));


//            writer.close();
//            reader.close();

        }catch (Exception ex){
            logger.warn("An error occured with message {}", ex.getMessage());
            ex.printStackTrace();
        }finally {
            if (pdfDocument !=null){
                pdfDocument.close();
            }
        }

        if (compte.getSignature() != null){
            com.itextpdf.text.pdf.PdfReader  reader = null;
            PdfStamper stamper = null;
            try{
                reader = new com.itextpdf.text.pdf.PdfReader(TEMP.toString());
                 stamper = new PdfStamper(reader, new FileOutputStream(DEST.toString()));
                Image img = Image.getInstance(compte.getSignature());
                float x = 450;
                float y = 25;
                float w = 100;
                float h = 50;
                img.setAbsolutePosition(x, y);
                img.scaleToFit(w, h);
                stamper.getOverContent(reader.getNumberOfPages()).addImage(img);
                //reader.close();
                //stamper.close();
            }catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Problème de chargement du document");
            }finally {
                if (stamper != null)
                    stamper.close();
                if (reader != null)
                    reader.close();

            }

            return new UrlResource(DEST.toUri());
            // pdfDocument.add(signature);
        }


        return new UrlResource(TEMP.toUri());
    }

    /**
     * Créer le contrat PDF de l'ouverture de compte
     * @param compte
     * @return Le document {@link Resource}
     * @throws Exception
     */
    public static Resource createOuvertureDeComptePdf(Compte compte) throws  Exception{

        final String SRC = FILE_TEMPLATE_BASE_PATH+"Demande_Ouverture_De_Compte_Template.pdf";
        final Path DEST = Paths.get(System.getProperty("java.io.tmpdir"),
                randomFileName("Demande_Ouverture_De_Compte", compte.getBusinessKey()));

        final Path TEMP = Paths.get(System.getProperty("java.io.tmpdir"),
                randomFileName("Demande_Ouverture_De_Compte_TEMP", compte.getBusinessKey()));

        if (!DEST.toFile().exists()){
            DEST.toFile().createNewFile();
        }
        PdfDocument pdfDocument = null;
        try{
            pdfDocument = new PdfDocument(
                    new PdfReader(SRC), new PdfWriter(TEMP.toString())
            );

            PdfCanvas canvas = new PdfCanvas(pdfDocument.getFirstPage());

            PdfAcroForm form = PdfAcroForm.getAcroForm(pdfDocument, true);

            final Map<String, PdfFormField> fields = form.getFormFields();

            fields.entrySet().forEach(entry -> System.out.println("Demande_Ouverture_De_Compte_Template fieldsKey_________"+entry.getKey()));

            fields.get("firstName").setValue(compte.getNomDemandeur() != null ? compte.getNomDemandeur() : "");
            fields.get("lastName").setValue(compte.getPrenomDemandeur() != null ? compte.getPrenomDemandeur() : "");
            String fullName ="";
            if (compte.getNomDemandeur() != null){
                fullName = compte.getNomDemandeur();
                if (compte.getPrenomDemandeur() != null){
                    fullName = fullName+" "+compte.getPrenomDemandeur();
                }
            }else if (compte.getPrenomDemandeur() != null){
                fullName = compte.getPrenomDemandeur();
            }
            fields.get("fullName").setValue(fullName);
            fields.get("signataire").setValue(fullName);
            fields.get("raisonSociale").setValue(compte.getTypeDemandeur() == "Personne Physique".trim() ? "" : "");
            fields.get("agence").setValue(compte.getAgence().replace("/", "") );
            fields.get("placeOfSignature").setValue(compte.getAgence().replace("/", ""));
            fields.get("DateOfSignature").setValue(DateFormatter.localDate());
            fields.get("address").setValue(compte.getAdresse()+", "+compte.getAdresse2());

           // pdfDocument.close();
        }catch (Exception ex){
            logger.warn("An error occured with message {}", ex.getMessage());
            ex.printStackTrace();
        }finally {
            if (pdfDocument !=null) {
                pdfDocument.close();
            }
        }


        if (compte.getSignature() != null){
            com.itextpdf.text.pdf.PdfReader  reader = null;
            PdfStamper stamper = null;
            try {
                reader = new com.itextpdf.text.pdf.PdfReader(TEMP.toString());
                 stamper = new PdfStamper(reader, new FileOutputStream(DEST.toFile()));
                Image img = Image.getInstance(compte.getSignature());
                float x = 430;
                float y = 5;
                float w = 100;
                float h = 50;
                img.setAbsolutePosition(x, y);
                img.scaleToFit(w, h);
                stamper.getOverContent(reader.getNumberOfPages()).addImage(img);
                //stamper.close();
            }catch (Exception e) {
                throw new RuntimeException("Problème de chargement du document");
            }finally {
                if (stamper != null)
                    stamper.close();
                if (reader != null)
                    reader.close();

            }

            return new UrlResource(DEST.toUri());
            // pdfDocument.add(signature);
        }

        return new UrlResource(TEMP.toUri());
    }
    public static Resource createRibPdf(Compte compte) throws  Exception{

        final String SRC = FILE_TEMPLATE_BASE_PATH+"Releve_Identite_Bancaire.pdf";
        final Path DEST = Paths.get(System.getProperty("java.io.tmpdir"),
                randomFileName("Releve_Identite_Bancaire", compte.getBusinessKey()));

        final Path TEMP = Paths.get(System.getProperty("java.io.tmpdir"),
                randomFileName("Releve_Identite_Bancaire_TEMP", compte.getBusinessKey()));

        if (!DEST.toFile().exists()){
            DEST.toFile().createNewFile();
        }
        PdfDocument pdfDocument = null;
        ReleveIdentiteBancaire rib = compte.getRib();

        try{
            pdfDocument = new PdfDocument(
                    new PdfReader(SRC), new PdfWriter(TEMP.toString())
            );
            PdfCanvas canvas = new PdfCanvas(pdfDocument.getFirstPage());

            PdfAcroForm form = PdfAcroForm.getAcroForm(pdfDocument, true);

            final Map<String, PdfFormField> fields = form.getFormFields();
/*
           fields.entrySet().forEach(entry->{
               System.out.println("fieldsKey_________"+entry.getKey());
           });
*/
            fields.get("demandeur").setValue(rib.getDemandeur() != null ? rib.getDemandeur() : "null");
            fields.get("adresse1").setValue(rib.getAdresse1() != null ? rib.getAdresse1() : "null");
            fields.get("adresse2").setValue(rib.getAdresse2() != null ? rib.getAdresse2() : "null");
            fields.get("iban").setValue(rib.getIban() != null ? rib.getIban() : "null");
            fields.get("bic").setValue(rib.getBic() != null ? rib.getBic() : "null");
            fields.get("nom_agence").setValue(rib.getBranch() != null ? rib.getBranch() : "null");
            fields.get("code_banque").setValue(rib.getCodeBank() != null ? rib.getCodeBank() : "null");
            fields.get("code_agence").setValue(rib.getBranchCode() != null ? rib.getBranchCode() : "null");
            fields.get("num_compte").setValue(rib.getAccountCode() != null ? rib.getAccountCode() : "null");
            fields.get("cle_rib").setValue(rib.getCleRib() != null ? rib.getCleRib() : "null");

            // pdfDocument.close();
        }catch (Exception ex){
            logger.warn("An error occured with message {}", ex.getMessage());
            ex.printStackTrace();
        }finally {
            if (pdfDocument != null) {
                pdfDocument.close();
            }
        }

        if (compte.getSignature() != null){
            com.itextpdf.text.pdf.PdfReader  reader = null;
            PdfStamper stamper = null;
            try {
                reader = new com.itextpdf.text.pdf.PdfReader(TEMP.toString());
                stamper = new PdfStamper(reader, new FileOutputStream(DEST.toFile()));
                Image img = Image.getInstance(compte.getSignature());
                float x = 430;
                float y = 5;
                float w = 100;
                float h = 50;
                img.setAbsolutePosition(x, y);
                img.scaleToFit(w, h);
                stamper.getOverContent(reader.getNumberOfPages()).addImage(img);
                //stamper.close();
            }catch (Exception e) {
                throw new RuntimeException("Problème de chargement du document");
            }finally {
                if (stamper != null)
                    stamper.close();
                if (reader != null)
                    reader.close();
            }

            return new UrlResource(DEST.toUri());
            // pdfDocument.add(signature);
        }

        return new UrlResource(TEMP.toUri());
    }

    /**
     * Crée  Le PDF Carton de sinature
     * @param compte
     * @return
     * @throws Exception
     */
    public static Resource createCartonSignaturePdf(Compte compte) throws  Exception{
        final String SRC = FILE_TEMPLATE_BASE_PATH+"Carton_De_Signature_Template.pdf";
        final Path DEST = Paths.get(System.getProperty("java.io.tmpdir"),
                randomFileName("Carton_De_Signature", compte.getBusinessKey()));

        final Path TEMP = Paths.get(System.getProperty("java.io.tmpdir"),
                randomFileName("Carton_De_Signature_TEMP", compte.getBusinessKey()));



        if (!DEST.toFile().exists()){
            DEST.toFile().createNewFile();
        }
        PdfDocument pdfDocument =null;
        try{
             pdfDocument = new PdfDocument(
                    new PdfReader(SRC), new PdfWriter(TEMP.toString())
            );

            PdfCanvas canvas = new PdfCanvas(pdfDocument.getFirstPage());

            PdfAcroForm form = PdfAcroForm.getAcroForm(pdfDocument, true);

            final Map<String, PdfFormField> fields = form.getFormFields();

            fields.entrySet().forEach(entry -> System.out.println("createCartonSignaturePdf fieldsKey_________"+entry.getKey()));

            fields.get("firstName").setValue(compte.getNomDemandeur() != null ? compte.getNomDemandeur() : "");
            fields.get("lastName").setValue(compte.getPrenomDemandeur() != null ? compte.getPrenomDemandeur() :"");
            fields.get("Nationality").setValue(compte.getNationalite() != null ? compte.getNationalite().getNationalite() :"");
            fields.get("bp").setValue(compte.getBoitePostal() != null ? compte.getBoitePostal() :"");
            fields.get("profession").setValue(compte.getPoste() != null ? compte.getPoste() :"");

            String dateLieuNaissance = compte.getDateDeNaissance() !=null? compte.getDateDeNaissance().toString():"";
            if (compte.getLieuDeNaissance() != null && !compte.getLieuDeNaissance().isEmpty()){
                dateLieuNaissance = dateLieuNaissance +" à "+ compte.getLieuDeNaissance();
            }

            fields.get("DateAndPlaceOfBirth").setValue(dateLieuNaissance);
            fields.get("agence").setValue(compte.getAgence().replace("/", ""));
            fields.get("geographicalAddress").setValue(compte.getSituationGeographique() != null ? compte.getSituationGeographique(): "" + " " + compte.getAdresse());
            fields.get("phoneNumber").setValue(compte.getMobile());
            RegisteredID registeredID = compte.getRegisteredID();
            if (registeredID != null) {

                fields.get("IDCardNumber").setValue(registeredID.getNumber() != null? registeredID.getNumber():"");
                fields.get("IDCardIssuedPlace").setValue(registeredID.getLocale() !=null? registeredID.getLocale():"");
                fields.get("IDCardIssuedDate").setValue(registeredID.getValidFrom() !=null? registeredID.getValidFrom().toString():"");
            }
            if(compte.getListAutreActionnaire() != null && !compte.getListAutreActionnaire().isEmpty()){
                System.out.println("list signataire not empty__________");
                int i =0;
                for(Actionnaire actionnaire: compte.getListAutreActionnaire()){
                    System.out.println("Nom signataire __________"+actionnaire.getNomActionnaire());
                    fields.get("nom_sgnataire"+i++).setValue(actionnaire.getNomActionnaire() != null? actionnaire.getNomActionnaire() +" "+actionnaire.getPrenomActionnaire():"");
                }
            }

            fields.get("bp").setValue(compte.getBoitePostal() != null ? compte.getBoitePostal() : "");
            fields.get("agence").setValue(compte.getAgence().replace("/", ""));

           // pdfDocument.close();
        }catch (Exception ex){
            logger.warn("An error occured with message {}", ex.getMessage());
            ex.printStackTrace();
        }finally {
            if (pdfDocument !=null)
                pdfDocument.close();
        }

        if (compte.getSignature() != null){
            com.itextpdf.text.pdf.PdfReader  reader = null;
            PdfStamper stamper = null;
            try {
                  reader = new com.itextpdf.text.pdf.PdfReader(TEMP.toString());
                  stamper = new PdfStamper(reader, new FileOutputStream(DEST.toString()));
                Image img = Image.getInstance(compte.getSignature());
                float x = 320;
                float y = 250;
                float w = 100;
                float h = 50;
                img.setAbsolutePosition(x, y);
                img.scaleToFit(w, h);
                stamper.getOverContent(reader.getNumberOfPages()).addImage(img);
                //stamper.close();
            }catch (Exception e){
                throw new RuntimeException("Problème de chargement du document");
            }finally {
                if (stamper != null)
                    stamper.close();
                if (reader != null)
                    reader.close();

            }
            return new UrlResource(DEST.toUri());

            // pdfDocument.add(signature);
        }
        return new UrlResource(TEMP.toUri());
    }

    public static Resource createKYCPersonnePhysiqueBDUPdf(Compte compte)  throws  Exception{
        final String SRC = FILE_TEMPLATE_BASE_PATH+"Formulaire_Ouverture_De_Compte_Personne_Physique.pdf";
        final Path DEST = Paths.get(System.getProperty("java.io.tmpdir"),
                randomFileName("Formulaire_Ouverture_De_Compte_Personne_Physique_TEMP", compte.getBusinessKey()));

        if (!DEST.toFile().exists()){
            DEST.toFile().createNewFile();
        }
        PdfDocument pdfDocument =null;
        try{
             pdfDocument = new PdfDocument(
                    new PdfReader(SRC), new PdfWriter(DEST.toString())
            );

            PdfCanvas canvas = new PdfCanvas(pdfDocument.getFirstPage());

            PdfAcroForm form = PdfAcroForm.getAcroForm(pdfDocument, true);

            final Map<String, PdfFormField> fields = form.getFormFields();

            fields.entrySet().forEach(entry -> System.out.println("KYC_Personne_Physique_Template fieldsKey_________"+entry.getKey()));
            String typeCompte ="";
            if (compte.getTypeCompte() != null && !compte.getTypeCompte().isEmpty()){
                if (compte.getTypeCompte().equalsIgnoreCase("Compte courant")){
                    fields.get("courant").setValue("OK");
                }
                if (compte.getTypeCompte().equalsIgnoreCase("Compte epargne")){
                    fields.get("epargne").setValue("OK");
                }

            }
            fields.get("xof").setValue("OK");

            fields.get("agence").setValue(compte.getAgence().replace("/", ""));
            fields.get("full_name").setValue(compte.getNomDemandeur() + " " + compte.getPrenomDemandeur());
            fields.get("type_compte").setValue(compte.getTypeCompte() != null ? compte.getTypeCompte() : "");
            fields.get("nom").setValue(compte.getNomDemandeur() != null ? compte.getNomDemandeur() : "");
            fields.get("prenom").setValue(compte.getPrenomDemandeur() != null ? compte.getPrenomDemandeur() : "");
            if (compte.getGenre() != null && !compte.getGenre().isEmpty()){
                if (compte.getGenre().equalsIgnoreCase("Homme")){
                    fields.get("sexe").setValue("M");
                }
                else if (compte.getGenre().equalsIgnoreCase("Femme")){
                    fields.get("sexe").setValue("F");
                }else {
                    fields.get("sexe").setValue("");
                }
            }
            //fields.get("date_naissance").setValue(compte.getDateDeNaissance() != null ? compte.getDateDeNaissance().toString() : "");

            fields.get("lieu_naissance").setValue(compte.getLieuDeNaissance() != null ? compte.getLieuDeNaissance() : "");
            fields.get("nationalite").setValue(compte.getNationalite() != null ? compte.getNationalite().getNationalite() : "");
            fields.get("profession").setValue(compte.getPoste() != null ? compte.getPoste() : "");
            fields.get("employeur").setValue(compte.getNomEmployeur() != null ? compte.getNomEmployeur() : "");
            fields.get("nom_mere").setValue(compte.getNomEmployeur() != null ? compte.getNomEmployeur() : "");

        }catch (Exception ex){
            logger.warn("An error occured with message {}", ex.getMessage());
            ex.printStackTrace();
        }finally {
            if (pdfDocument !=null){
                pdfDocument.close();
            }
        }



        return new UrlResource(DEST.toUri());
    }

    public static Resource createDemandeChequierPdf(Compte compte) throws  Exception {
        final String SRC = FILE_TEMPLATE_BASE_PATH+"Demande_De_Chequier_Template.pdf";
        final Path DEST = Paths.get(System.getProperty("java.io.tmpdir"),
                randomFileName("Demande_De_Chequier", compte.getBusinessKey()));

        final Path TEMP = Paths.get(System.getProperty("java.io.tmpdir"),
                randomFileName("Demande_De_Dhequier_TEMP", compte.getBusinessKey()));

        if (!DEST.toFile().exists()){
            DEST.toFile().createNewFile();
        }
        PdfDocument pdfDocument =  null;
        try{
            pdfDocument = new PdfDocument(
                    new PdfReader(SRC), new PdfWriter(TEMP.toString())
            );

            PdfCanvas canvas = new PdfCanvas(pdfDocument.getFirstPage());

            PdfAcroForm form = PdfAcroForm.getAcroForm(pdfDocument, true);

            final Map<String, PdfFormField> fields = form.getFormFields();
            //fields.entrySet().forEach(entry -> System.out.println("KYC_Personne_Physique_Template fieldsKey_________"+entry.getKey()));
            fields.get("adresse").setValue(compte.getAdresse());

            fields.get("nomPrenom").setValue(compte.getNomDemandeur() + " " +
                    compte.getPrenomDemandeur());
            fields.get("type").setValue(compte.getChequier().getType() != null ? compte.getChequier().getType():"");
            fields.get("pageCount").setValue(Integer.toString(compte.getChequier().getNumberOfPapers()));
            fields.get("location").setValue(compte.getAgence() != null ? compte.getAgence().replace("/", "") : "");
            fields.get("date").setValue(DateFormatter.localDate());


            pdfDocument.close();
        }catch (Exception ex){
            logger.warn("An error occured with message {}", ex.getMessage());
            ex.printStackTrace();
        }finally {
            if (pdfDocument != null)
                pdfDocument.close();
        }

        if (compte.getSignature()!= null){
            //stampSignature(compte.getSignature(),TEMP.toString(), DEST.toString());
            com.itextpdf.text.pdf.PdfReader  reader = null;
            PdfStamper stamper = null;
            try {
                reader = new com.itextpdf.text.pdf.PdfReader(TEMP.toString());
                stamper = new PdfStamper(reader, new FileOutputStream(DEST.toFile()));
                Image img = Image.getInstance(compte.getSignature());
                float x = 450;
                float y = 5;
                float w = 100;
                float h = 50;
                img.setAbsolutePosition(x, y);
                img.scaleToFit(w, h);
                stamper.getOverContent(reader.getNumberOfPages()).addImage(img);
                stamper.close();
            }catch (Exception e){
                throw new RuntimeException("Problème de chargement du document");
                //e.printStackTrace();
            }finally {
                if (stamper != null)
                    stamper.close();
                if (reader != null)
                    reader.close();

            }

            return new UrlResource(DEST.toUri());
            // pdfDocument.add(signature);
        }

        return new UrlResource(TEMP.toUri());
    }

    public static Resource createFormulaireSmsEBankingPdf(Compte compte) throws  Exception {
        final String SRC = FILE_TEMPLATE_BASE_PATH+"Formulaire_Sms_EBanking_Template.pdf";
        final Path DEST = Paths.get(System.getProperty("java.io.tmpdir"),
                randomFileName("Formulaire_Sms_EBanking", compte.getBusinessKey()));

        final Path TEMP = Paths.get(System.getProperty("java.io.tmpdir"),
                randomFileName("Formulaire_Sms_EBanking_TEMP", compte.getBusinessKey()));

        if (!DEST.toFile().exists()){
            DEST.toFile().createNewFile();
        }
        PdfDocument pdfDocument = null;
        try{
            pdfDocument = new PdfDocument(
                    new PdfReader(SRC), new PdfWriter(TEMP.toString())
            );

            PdfCanvas canvas = new PdfCanvas(pdfDocument.getFirstPage());

            PdfAcroForm form = PdfAcroForm.getAcroForm(pdfDocument, true);

            final Map<String, PdfFormField> fields = form.getFormFields();

            fields.entrySet().forEach(entry->{System.out.println("Formulaire_Sms_EBanking_Template_______ "+entry.getKey());});

            fields.get("addresses").setValue(compte.getAdresse() != null ? compte.getAdresse() : "" );

            fields.get("firstName").setValue(compte.getNomDemandeur() != null ? compte.getNomDemandeur() : "" );
            fields.get("lastNamz").setValue(compte.getPrenomDemandeur() != null ? compte.getPrenomDemandeur() : "" );
            fields.get("nationality").setValue(compte.getNationalite() != null ? compte.getNationalite().getNationalite() : "" );
            fields.get("dateOfBirth").setValue(compte.getDateDeNaissance() != null? compte.getDateDeNaissance().toString():"");
            fields.get("bp").setValue(compte.getBoitePostal() != null ? compte.getBoitePostal() : "" );
            fields.get("city").setValue(compte.getVille() != null ? compte.getVille() : "" );
            fields.get("country").setValue(compte.getPaysResidence().getName() != null ? compte.getAdresse() : "" );
            fields.get("phoneNumber").setValue(compte.getMobile() != null ? compte.getMobile() : "" );
            fields.get("email").setValue(compte.getEmail() != null ? compte.getEmail() : "" );
            fields.get("fixe").setValue(compte.getFixe() != null ? compte.getFixe() : "" );
            fields.get("agence").setValue(compte.getAgence() != null ? compte.getAgence().replace("/", "") : "");

            if (compte.getTypeDemandeur().equalsIgnoreCase("Personne Physique")) {
                fields.get("comptePhysique").setValue("OK");
            }else {
                fields.get("compteMorale").setValue("OK");
            }

            RegisteredID registeredID = compte.getRegisteredID();

            if (registeredID != null) {
                if (registeredID.getAuthority().equalsIgnoreCase(IDCardType.CNI.name())){
                    fields.get("cni").setValue("OK");
                }else if (registeredID.getAuthority().equalsIgnoreCase(IDCardType.PASSEPORT.name())){
                    fields.get("passeport").setValue("OK");
                } else if (registeredID.getAuthority().equalsIgnoreCase(IDCardType.PERMIS_CONDUIRE.name())){
                    fields.get("permisConduire").setValue("OK");
                }else if (registeredID.getAuthority().equalsIgnoreCase(IDCardType.CARTE_CONSULAIRE.name())) {
                    fields.get("carteResidence").setValue("OK");
                }
            }

            //pdfDocument.close();
        }catch (Exception ex){
            logger.warn("An error occured with message {}", ex.getMessage());
            ex.printStackTrace();
        }finally {
            if (pdfDocument !=null)
                pdfDocument.close();
        }

        if (compte.getSignature() != null){
            com.itextpdf.text.pdf.PdfReader  reader = null;
            PdfStamper stamper = null;
           try{
                 reader = new com.itextpdf.text.pdf.PdfReader(TEMP.toString());
                stamper = new PdfStamper(reader, new FileOutputStream(DEST.toFile()));
               Image img = Image.getInstance(compte.getSignature());
               float x = 100;
               float y = 50;
               float w = 100;
               float h = 50;
               img.setAbsolutePosition(x, y);
               img.scaleToFit(w, h);
               stamper.getOverContent(reader.getNumberOfPages()).addImage(img);
               stamper.close();
           }catch (Exception e){
               e.printStackTrace();
               throw new RuntimeException("Problème de chargement du document");
           }finally {
               if (stamper != null)
                   stamper.close();
               if (reader != null)
                   reader.close();

           }
            return new UrlResource(DEST.toUri());
            // pdfDocument.add(signature);
        }

        return new UrlResource(TEMP.toUri());
    }

    public static Resource createFormulaireAdhesionServiceMonetiquePdf(Compte compte) throws  Exception {
        final String SRC = FILE_TEMPLATE_BASE_PATH+"Adhesion_Service_Monetique_Template.pdf";
        final Path DEST = Paths.get(System.getProperty("java.io.tmpdir"),
                randomFileName("Adhesion_Service_Monetique", compte.getBusinessKey()));

        final Path TEMP = Paths.get(System.getProperty("java.io.tmpdir"),
                randomFileName("Adhesion_Service_Monetique_TEMP", compte.getBusinessKey()));

        if (!DEST.toFile().exists()){
            DEST.toFile().createNewFile();
        }
        PdfDocument pdfDocument = null;
        try{
             pdfDocument = new PdfDocument(
                    new PdfReader(SRC), new PdfWriter(TEMP.toString())
            );

            PdfCanvas canvas = new PdfCanvas(pdfDocument.getFirstPage());

            PdfAcroForm form = PdfAcroForm.getAcroForm(pdfDocument, true);


            final Map<String, PdfFormField> fields = form.getFormFields();

            fields.entrySet().forEach(entry->{System.out.println("Adhesion_Service_Monetique_Template_______ "+entry.getKey());});

            fields.get("agency").setValue( compte.getAgence() != null ? compte.getAgence().replace("/", "") : "");
            fields.get("nomPrenom").setValue(compte.getNomDemandeur() + " "+
                    compte.getPrenomDemandeur());

            String dateLieuNaissance = compte.getDateDeNaissance() !=null? compte.getDateDeNaissance().toString():"";
            if (compte.getLieuDeNaissance() != null || !compte.getLieuDeNaissance().isEmpty()){
                dateLieuNaissance = dateLieuNaissance +" à "+ compte.getLieuDeNaissance();
            }
            fields.get("birthDatePlace").setValue(dateLieuNaissance);

            //fields.get("profession").setValue(compte.get);
            fields.get("ville").setValue(compte.getVille() != null ? compte.getAgence(): "");
            fields.get("place").setValue( compte.getAgence() != null ? compte.getAgence().replace("/", "") : "");
            fields.get("postalAdress").setValue(compte.getBoitePostal() != null ? compte.getBoitePostal(): "");
            fields.get("telephone").setValue(compte.getMobile() != null ? compte.getMobile(): "");
            fields.get("email").setValue(compte.getEmail() != null ? compte.getEmail(): "");
            fields.get("date").setValue(DateFormatter.localDate());
            fields.get("profession").setValue(compte.getPoste() != null ? compte.getPoste():"");
            fields.get("creation").setValue("OK");

            if (compte.getGenre().equals("Homme")) {
                fields.get("Mr").setValue("OK");
            }else if (compte.getGenre().equals("Femme")) {
                fields.get("Mme").setValue("OK");
            }

            final RegisteredID registeredID = compte.getRegisteredID();
            if (registeredID != null) {
                if (registeredID.getAuthority().equals(IDCardType.CNI.name())) {
                    fields.get("cin").setValue("OK");
                } else if (registeredID.getAuthority().equals(IDCardType.PASSEPORT.name())) {
                    fields.get("passeport").setValue("OK");
                }
                fields.get("nPiece").setValue(registeredID.getNumber() != null? registeredID.getNumber():"");
            }


            for (CarteBancaire cb: compte.getCarteBancaires()) {
                if (cb.getType().equals(CreditCardType.GIM_UEMOA)) {
                    fields.get("carteGim").setValue("OK");
                }else if (cb.getType().equals(CreditCardType.VISA_GOLD)) {
                    fields.get("carteGold").setValue("OK");
                } else if (cb.getType().equals(CreditCardType.VISA_CLASSIC)) {
                    fields.get("carteGold").setValue("OK");
                }
            }
            for (CarteBancaire cb: compte.getCarteBancaires()) {
                if (cb.getInsuranceOption().equals(CreditCardOption.Option_1)) {
                    fields.get("assuranceOption1").setValue("OK");
                }else if (cb.getInsuranceOption().equals(CreditCardOption.Option_2)) {
                    fields.get("assuranceOption2").setValue("OK");
                } else if (cb.getInsuranceOption().equals(CreditCardOption.Option_3)) {
                    fields.get("assuranceOption3").setValue("OK");
                }
            }

            //pdfDocument.close();
        }catch (Exception ex){
            logger.warn("An error occured with message {}", ex.getMessage());
            ex.printStackTrace();
        }finally {
            if (pdfDocument != null)
                pdfDocument.close();
        }

        if (compte.getSignature() != null){
            com.itextpdf.text.pdf.PdfReader  reader = null;
            PdfStamper stamper = null;
            try {
                reader = new com.itextpdf.text.pdf.PdfReader(TEMP.toString());
                stamper = new PdfStamper(reader, new FileOutputStream(DEST.toFile()));
                Image img = Image.getInstance(compte.getSignature());
                float x = 420;
                float y = 10;
                float w = 100;
                float h = 50;
                img.setAbsolutePosition(x, y);
                img.scaleToFit(w, h);
                stamper.getOverContent(reader.getNumberOfPages()).addImage(img);
                //stamper.close();
            }catch (Exception e) {
                throw new RuntimeException("Problème de chargement du document");
            }finally {
                if (stamper != null)
                    stamper.close();
                if (reader != null)
                    reader.close();

            }
            return new UrlResource(DEST.toUri());
            // pdfDocument.add(signature);
        }

        return new UrlResource(TEMP.toUri());
    }
    public static Resource createFormulaireObtentionConsentementPdf(Compte compte) throws Exception{
        final String SRC = FILE_TEMPLATE_BASE_PATH+"Formulaire_Obtention_De_Consentement.pdf";
        final Path DEST = Paths.get(System.getProperty("java.io.tmpdir"),
                randomFileName("Formulaire_Obtention_De_Consentement", compte.getBusinessKey()));

        final Path TEMP = Paths.get(System.getProperty("java.io.tmpdir"),
                randomFileName("Formulaire_Obtention_De_Consentement_TEMP", compte.getBusinessKey()));
        if (!DEST.toFile().exists()){
            DEST.toFile().createNewFile();
        }
        PdfDocument pdfDocument = null;
        try{
            pdfDocument = new PdfDocument(
                    new PdfReader(SRC), new PdfWriter(TEMP.toString())
            );

            PdfCanvas canvas = new PdfCanvas(pdfDocument.getFirstPage());

            PdfAcroForm form = PdfAcroForm.getAcroForm(pdfDocument, true);

            final Map<String, PdfFormField> fields = form.getFormFields();

            fields.entrySet().forEach(entry->{
                System.out.println("Formulaire_Obtention_De_Consentement fieldsKey_________"+entry.getKey());
            });

            fields.get("nom").setValue(compte.getNomDemandeur() != null ? compte.getNomDemandeur(): "");
            fields.get("prenom").setValue(compte.getPrenomDemandeur() != null ? compte.getPrenomDemandeur(): "");
            fields.get("adresse").setValue(compte.getVille() != null ? compte.getVille(): "");

            //pdfDocument.close();
        }catch (Exception ex){
            logger.warn("An error occured with message {}", ex.getMessage());
            ex.printStackTrace();
        }finally {
            if (pdfDocument != null)
                pdfDocument.close();
        }

        if (compte.getSignature() != null){
            com.itextpdf.text.pdf.PdfReader  reader = null;
            PdfStamper stamper = null;
            try {
                reader = new com.itextpdf.text.pdf.PdfReader(TEMP.toString());
                stamper = new PdfStamper(reader, new FileOutputStream(DEST.toFile()));
                Image img = Image.getInstance(compte.getSignature());
                float x = 420;
                float y = 10;
                float w = 100;
                float h = 50;
                img.setAbsolutePosition(x, y);
                img.scaleToFit(w, h);
                stamper.getOverContent(reader.getNumberOfPages()).addImage(img);
                //stamper.close();
            }catch (Exception e) {
                throw new RuntimeException("Problème de chargement du document");
            }finally {
                if (stamper != null)
                    stamper.close();
                if (reader != null)
                    reader.close();

            }
            return new UrlResource(DEST.toUri());
            // pdfDocument.add(signature);
        }
        return new UrlResource(TEMP.toUri());
    }

    private static String randomFileName(String prefix, String end) {
        return prefix + "_" + end + ".pdf";
    }

    private static void stampSignature(byte[] bytes, String src, String dest) throws Exception {
        com.itextpdf.text.pdf.PdfReader  reader = new com.itextpdf.text.pdf.PdfReader(src);
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
        Image img = Image.getInstance(bytes);
        float x = 420;
        float y = 25;
        float w = 100;
        float h = 50;
        img.setAbsolutePosition(x, y);
        img.scaleToFit(w, h);
        stamper.close();
    }
}
