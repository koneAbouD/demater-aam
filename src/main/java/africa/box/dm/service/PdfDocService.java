package africa.box.dm.service;

import africa.box.dm.config.LogInfoConstante;
import africa.box.dm.config.MyAppConfig;
import africa.box.dm.config.PdfContratTemplate;
import africa.box.dm.config.PdfVoloTemplate;
import africa.box.dm.db.CompteDocumentDao;
import africa.box.dm.db.entities.*;
import africa.box.dm.dto.DocumentDto;
//import com.lowagie.text.*;
//import com.lowagie.text.pdf.PdfWriter;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import okhttp3.*;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.tools.imageio.ImageIOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.*;

//import static com.itextpdf.text.Paragraph.

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


@Service
public class PdfDocService {

    @Autowired(required=true)
    CompteService compteService;

    @Autowired
    ExternalEndPointService externalEndPointService;

    @Autowired
    CompteDocumentDao compteDocumentDao;

    @Autowired
    PdfContratTemplate pdfcontratTemplate;

    @Autowired
    PdfVoloTemplate pdfVoloTemplate;

    @Autowired
    LogInfoService logInfoService;

    @Autowired
    private Environment env;

//    @Autowired
//    CompteDocumentDao documentDao;

    private final StorageService storageService;

    final
    MyAppConfig appConfig;

    final CompteDocumentDao dao;

    public PdfDocService(StorageService storageService,CompteDocumentDao dao, MyAppConfig appConfig) {
        this.storageService = storageService;
        this.appConfig = appConfig;
        this.dao = dao;
    }

    //
//    public String createCni(){
//
//
//        return null;
//    }

    public String createComptePDF( String businessKey) {

        String upBasePath = appConfig.getUploadBasePath();
        if(StringUtils.isEmpty(upBasePath)){
            upBasePath = System.getProperty("java.io.tmpdir");
        }

        LocalDate localDate = LocalDate.now() ;
        String filename ="Contrat_ouverture_compte.pdf";
        String  path=upBasePath + File.separator + localDate.getYear() +
                File.separator + localDate.getMonth()+
                File.separator + businessKey+ File.separator;

        File dir = new File(path);
        dir.mkdirs();


        try {
            Optional<Compte> compte = compteService.getCompte(businessKey);
            List<CompteDocument> compteDocuments = new ArrayList<>();

            Compte cmpt=null;
            cmpt=compte.get();
            CompteDocument doc_1 = new CompteDocument();

            if(compte.isPresent()) {

                cmpt = compte.get();
//                creation de nouveau document

//                ouverture de compte
                doc_1.setIdentifiant(String.valueOf(UUID.randomUUID()));
                doc_1.setBusinessKey(cmpt.getBusinessKey());
                doc_1.setNumberOfCopies(1);
                doc_1.setCreatedAt(new Date());
                doc_1.setStatut("confirmation");
                doc_1.setDocumentstatus(DocumentStatus.MANQUANT);
                doc_1.setFacultatif(false);
                doc_1.setName("Contrat ouverture de compte");
                doc_1.setDocCode("CONFIRMATION");
                doc_1.setDescription("Contrat d'ouverture de compte");
//                doc_1.setContentType(MediaType.APPLICATION_PDF);
                compteDocuments.add(doc_1);

                System.out.println("fin  if compte.isPresent()");

                compteDocumentDao.saveAll(compteDocuments);

            } else {

            }

            if(doc_1.getDocCode()!=null) {
                Document document = new Document(PageSize.A4, 50, 50, 50, 50);

                //create a PDF writer instance and pass output stream
                PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(path+filename));
                pdfcontratTemplate.contratTemplate(document,cmpt.getBusinessKey());
//                document.open();
//                document.addAuthor("kkouakou");
//                document.addCreationDate();
//
//                document.addTitle("CONTRAT D'OUVERTURE DE COMPTE");
//
//                document.close();
//                writer.close();

                // conversion du pdf en image
                if (document != null) {
                    compteOuvertureContratPDFtoImage(businessKey,path+filename);
                }
                System.out.println("fin  if doc_1.getDocCode()");

            } else {

            }
            Optional<CompteDocument> doc=compteDocumentDao.findById(doc_1.getIdentifiant());
            DocumentDto documentDto ;
            if (doc.isPresent()) {

                documentDto = ModelMapper.convertCompteDocumentToDocumentDto(doc.get());
                File fle_1 = new File(String.valueOf(Paths.get(path+filename)));

//                FileOutputStream fichier=new FileOutputStream(fle);

                FileItem fileItem = new DiskFileItem("mainFile1", "MediaType.APPLICATION_PDF", false, fle_1.getName(), (int) fle_1.length(), fle_1.getParentFile());

                try {
                    InputStream input = new FileInputStream(fle_1);
                    OutputStream os = fileItem.getOutputStream();
                    IOUtils.copy(input, os);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                MultipartFile multipartFile = new CommonsMultipartFile(fileItem);
                // sauvegarde du document
                storageService.store(businessKey, multipartFile, doc_1.getIdentifiant(), documentDto);

                System.out.println("fin  if  multipartFile doc.isPresent()");

                if (cmpt.getFromOnboarding() && storageService.store(businessKey, multipartFile, doc_1.getIdentifiant(), documentDto)!=null) {
                    System.out.println("cmpt.getFromOnboarding() ouverture compte");
                    contratPdfConverter(businessKey,doc_1.getIdentifiant());
                }
            }


        }
        catch(Exception exp) {
            System.out.println(exp.getMessage());
        }
        return "fait -------";
    }


    public String createContratDemandeCardPDF( String businessKey) {

        String upBasePath = appConfig.getUploadBasePath();
        if(StringUtils.isEmpty(upBasePath)){
            upBasePath = System.getProperty("java.io.tmpdir");
        }

        LocalDate localDate = LocalDate.now() ;
        String filename ="Contrat_carte_credit.pdf";
        String  path=upBasePath + File.separator + localDate.getYear() +
                File.separator + localDate.getMonth()+
                File.separator + businessKey+ File.separator;

        File dir = new File(path);
        dir.mkdirs();


        try {
            Optional<Compte> compte = compteService.getCompte(businessKey);
            List<CompteDocument> compteDocuments = new ArrayList<>();

            Compte cmpt=null;
            cmpt=compte.get();
            CompteDocument doc_1 = new CompteDocument();

            if(compte.isPresent()) {

                cmpt = compte.get();
//                creation de nouveau document

//                ouverture de compte
                doc_1.setIdentifiant(String.valueOf(UUID.randomUUID()));
                doc_1.setBusinessKey(cmpt.getBusinessKey());
                doc_1.setNumberOfCopies(1);
                doc_1.setCreatedAt(new Date());
                doc_1.setStatut("confirmation");
                doc_1.setDocumentstatus(DocumentStatus.MANQUANT);
                doc_1.setFacultatif(false);
                doc_1.setName("Contrat Carte de Credit");
                doc_1.setDocCode("CONFIRMATION");
                doc_1.setDescription("Contrat carte de credit");
//                doc_1.setContentType(MediaType.APPLICATION_PDF);
                compteDocuments.add(doc_1);


                compteDocumentDao.saveAll(compteDocuments);

            } else {

            }

            if(doc_1.getDocCode()!=null) {
                Document document = new Document(PageSize.A4, 50, 50, 50, 50);

                //create a PDF writer instance and pass output stream
                PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(path+filename));
                pdfcontratTemplate.contratTemplate(document,cmpt.getBusinessKey());
//                document.open();
//                document.addAuthor("kkouakou");
//                document.addCreationDate();
//
//                document.addTitle("CONTRAT D'OUVERTURE DE COMPTE");
//
//                document.close();
//                writer.close();

                // conversion du pdf en image
                if (document != null) {
                    compteOuvertureContratPDFtoImage(businessKey,path+filename);
                }
                System.out.println("fin  if doc_1.getDocCode()");

            } else {

            }
            Optional<CompteDocument> doc=compteDocumentDao.findById(doc_1.getIdentifiant());
            DocumentDto documentDto ;
            if (doc.isPresent()) {

                documentDto = ModelMapper.convertCompteDocumentToDocumentDto(doc.get());
                File fle_1 = new File(String.valueOf(Paths.get(path+filename)));

//                FileOutputStream fichier=new FileOutputStream(fle);

                FileItem fileItem = new DiskFileItem("mainFile1", "MediaType.APPLICATION_PDF", false, fle_1.getName(), (int) fle_1.length(), fle_1.getParentFile());

                try {
                    InputStream input = new FileInputStream(fle_1);
                    OutputStream os = fileItem.getOutputStream();
                    IOUtils.copy(input, os);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                MultipartFile multipartFile = new CommonsMultipartFile(fileItem);
                // sauvegarde du document
                storageService.store(businessKey, multipartFile, doc_1.getIdentifiant(), documentDto);

                System.out.println("fin  if  multipartFile doc.isPresent()");

                if (cmpt.getFromOnboarding() && storageService.store(businessKey, multipartFile, doc_1.getIdentifiant(), documentDto)!=null) {
                    System.out.println("cmpt.getFromOnboarding() ouverture compte");
                    contratPdfConverter(businessKey,doc_1.getIdentifiant());
                }
            }


        }
        catch(Exception exp) {
            System.out.println(exp.getMessage());
        }
        return "fait -------";
    }


    public String createVoloPDF( String businessKey) {

        String upBasePath = appConfig.getUploadBasePath();
        if(StringUtils.isEmpty(upBasePath)){
            upBasePath = System.getProperty("java.io.tmpdir");
        }

        LocalDate localDate = LocalDate.now() ;
        String filename ="Contrat_volo.pdf";
        String  path=upBasePath + File.separator + localDate.getYear() +
                File.separator + localDate.getMonth()+
                File.separator + businessKey+ File.separator;

        String inputImagePath = path+filename;


        File dir = new File(path);
        dir.mkdirs();


        try {
            Optional<Compte> compte = compteService.getCompte(businessKey);
            List<CompteDocument> compteDocuments = new ArrayList<>();

            Compte cmpt=null;
            cmpt=compte.get();
            CompteDocument doc_2 = new CompteDocument();

            if(compte.isPresent()) {

                cmpt = compte.get();
//                creation de nouveau document

//                ouverture de compte volo
                doc_2.setIdentifiant(String.valueOf(UUID.randomUUID()));
                doc_2.setBusinessKey(cmpt.getBusinessKey());
                doc_2.setNumberOfCopies(1);
                doc_2.setCreatedAt(new Date());
                doc_2.setStatut("confirmation");
                doc_2.setDocumentstatus(DocumentStatus.MANQUANT);
                doc_2.setFacultatif(false);
                doc_2.setName("Contrat VOLO");
                doc_2.setDocCode("CONFIRMATION");
                doc_2.setDescription("Contrat de consentement BIC");
//                doc_1.setContentType(MediaType.APPLICATION_PDF);
                compteDocuments.add(doc_2);

                System.out.println("fin  if compte.isPresent()");

                compteDocumentDao.saveAll(compteDocuments);

            } else {

            }

            if(doc_2.getDocCode()!=null) {
                Document document = new Document(PageSize.A4, 50, 50, 50, 50);

                //create a PDF writer instance and pass output stream
                PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(path+filename));
                pdfVoloTemplate.voloTemplate(document,cmpt.getBusinessKey());

//                writer.close();

                System.out.println("fin  if doc_2.getDocCode()");
                // conversion du pdf en image
                if (document != null) {
                    voloContratPDFtoImage(cmpt.getBusinessKey(),inputImagePath);
                }

            } else {

            }
            Optional<CompteDocument> doc=compteDocumentDao.findById(doc_2.getIdentifiant());
            DocumentDto documentDto ;
            if (doc.isPresent()) {

                documentDto = ModelMapper.convertCompteDocumentToDocumentDto(doc.get());
                File fle = new File(String.valueOf(Paths.get(path+filename)));
//                FileOutputStream fichier=new FileOutputStream(fle);
                FileItem fileItem = new DiskFileItem("mainFile2", "MediaType.APPLICATION_PDF", false, fle.getName(), (int) fle.length(), fle.getParentFile());

                try {
                    InputStream input = new FileInputStream(fle);
                    OutputStream os = fileItem.getOutputStream();
                    IOUtils.copy(input, os);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                MultipartFile multipartFile = new CommonsMultipartFile(fileItem);

                storageService.store(businessKey, multipartFile, doc_2.getIdentifiant(), documentDto);

                System.out.println("fin  if  multipartFile volo doc.isPresent()");

                if (cmpt.getFromOnboarding() && storageService.store(businessKey, multipartFile, doc_2.getIdentifiant(), documentDto)!=null) {
                    System.out.println("cmpt.getFromOnboarding() volo");
                    contratPdfConverter(businessKey,doc_2.getIdentifiant());
                }
            }


        }
        catch(Exception exp) {
            System.out.println(exp.getMessage());
        }
        return "fait -------";
    }

    // solution 2
    public void voloContratPDFtoImage(String businessKey,String inputPath) throws Exception {
        String upBasePath = appConfig.getUploadBasePath();
        if(StringUtils.isEmpty(upBasePath)){
            upBasePath = System.getProperty("java.io.tmpdir");
        }



        String contratImagefilename ="contrat_volo";
        String  path=upBasePath + File.separator+"contrat_for_pad"+ File.separator+businessKey+File.separator;



        File dir = new File(path);
        dir.mkdirs();

        String outputPath = path+contratImagefilename;
//        ---------------------------------------------------------------------
        if (!path.isEmpty()) {
            PDDocument document = PDDocument.load(new File(inputPath));
            PDFRenderer pdfRenderer = new PDFRenderer(document);
            for (int page = 0; page < document.getNumberOfPages(); ++page)
            {
                BufferedImage bim = pdfRenderer.renderImageWithDPI(page, 300, ImageType.RGB);
                // suffix in filename will be used as the file format
                ImageIOUtil.writeImage(bim, outputPath + "_" + (page+1) + ".png", 300);
            }
            document.close();

        }


    }


    public void compteOuvertureContratPDFtoImage(String businessKey,String inputPath) throws Exception {
        String upBasePath = appConfig.getUploadBasePath();
        if(StringUtils.isEmpty(upBasePath)){
            upBasePath = System.getProperty("java.io.tmpdir");
        }

        LocalDate localDate = LocalDate.now() ;

        String contratImagefilename ="contrat_ouverture_compte";
        String  path=upBasePath + File.separator+"contrat_for_pad"+ File.separator+businessKey+File.separator;


        File dir = new File(path);
        dir.mkdirs();

        String outputPath = path+contratImagefilename;

//        Optional<Compte> compte = compteService.getCompte(businessKey);
//
//        Compte cmpt=null;
//        cmpt=compte.get();
//        ---------------------------------------------------------------------
        if (!path.isEmpty()) {
            PDDocument document = PDDocument.load(new File(inputPath));
            PDFRenderer pdfRenderer = new PDFRenderer(document);
            for (int page = 0; page < document.getNumberOfPages(); ++page)
            {
                BufferedImage bim = pdfRenderer.renderImageWithDPI(page, 300, ImageType.RGB);
                // suffix in filename will be used as the file format
                ImageIOUtil.writeImage(bim, outputPath + "_" + (page+1) + ".png", 300);
            }
            document.close();
        }


    }

//
//    public void contratPdfConverterForOnbording(String businessKey, String fileId) {
//
//        System.out.println("fileId==="+fileId);
//
//        Optional<CompteDocument> compteDocumentOptional = this.dao.findById(fileId);
//
//        if(!compteDocumentOptional.isPresent()){
//            throw new MyAppException("Cannot find file id.");
//        }
//
//        CompteDocument doc= compteDocumentOptional.get();
//        Date d = doc.getCreatedAt();
//
//        // Convert java.util.Date to java.time.LocalDate
//        LocalDate localDate = d.toInstant()
//                .atZone(ZoneId.systemDefault())
//                .toLocalDate();
//
//        String upBasePath = appConfig.getUploadBasePath();
//
//        if(StringUtils.isEmpty(upBasePath)){
//            upBasePath = System.getProperty("java.io.tmpdir");
//        }
//
//
//
//        String path =appConfig.getUploadBasePath() + File.separator + localDate.getYear() +
//                File.separator + localDate.getMonth()+
//                File.separator + businessKey + File.separator + doc.getDocPath();
//
//        //nouveau nom apres signature
//        String newFileNameFormat = path.substring(0,path.length()-4)+"_signatureClient"+".pdf";
//
////        File dir = new File(path);
////        dir.mkdirs();
//
//        try {
//            Optional<Compte> compte = compteService.getCompte(businessKey);
//            Compte cmpt=null;
//            cmpt=compte.get();
//
//
//            //Create PdfReader instance.
//            PdfReader pdfReader =
//                    new PdfReader(path);
//
//            //Create PdfStamper instance.
//            PdfStamper pdfStamper = new PdfStamper(pdfReader,
//                    new FileOutputStream(newFileNameFormat));
//
//            //Create BaseFont instance.
//            BaseFont baseFont = BaseFont.createFont(
//                    BaseFont.TIMES_ROMAN,
//                    BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
//
////            C:\DEMATER\AppDM\2021\JULY\AA053\signature_clientAA053.png
//
//            String imagePath = upBasePath + File.separator + localDate.getYear() +
//                    File.separator + localDate.getMonth()+
//                    File.separator + businessKey+ File.separator;
//            String fileName=null;
//
//            //si le compte vient du onBording
//                List<CompteDocument> cmptDoc = compteDocumentDao.findByBusinessKeyAndName(businessKey,"signature");
//                if (!cmptDoc.isEmpty()) {
//                    CompteDocument signature =cmptDoc.get(0);
//                    fileName=signature.getDocPath();
//                    System.out.println("signature.getDocPath()==================>"+signature.getDocPath());
//                }
//
//
//            //Get the number of pages in pdf.
//            int pages = pdfReader.getNumberOfPages();
//
////            System.out.println("pages"+(pages));
////            System.out.println("pages-1 "+(pages-1));
//
//            //Iterate the pdf through pages.
//            for(int i=1; i<=pages; i++) {
//
//                com.itextpdf.text.Image image = com.itextpdf.text.Image.getInstance(imagePath+fileName);
//                image.scaleAbsolute(200, 100);
//                image.setAbsolutePosition(0, 0);
//                //Contain the pdf data.
//                PdfContentByte pageContentByte =
//                        pdfStamper.getOverContent(pages);
//
//                pageContentByte.beginText();
//                //Set text font and size.
//                pageContentByte.setFontAndSize(baseFont, 14);
//
//                pageContentByte.setTextMatrix(50, 50);
//                pageContentByte.addImage(image);
//
//                //Write text
////                pageContentByte.showText("w3spoint.com nouveau------------------");
//                pageContentByte.endText();
//            }
//
//            //Close the pdfStamper.
//            pdfStamper.close();
//
//
//
//            // stockage du nouveau document
//            //info du compte
////            Optional<Compte> compte = compteService.getCompte(businessKey);
////            Compte cmpt=null;
////            cmpt=compte.get();
//
//            DocumentDto documentDto ;
//            documentDto = ModelMapper.convertCompteDocumentToDocumentDto(doc);
//
//
//            File newFileApresSignature = new File(String.valueOf(Paths.get(newFileNameFormat)));
//            FileItem fileItem = new DiskFileItem("mainFile2", "MediaType.APPLICATION_PDF", false, newFileApresSignature.getName(), (int) newFileApresSignature.length(), newFileApresSignature.getParentFile());
//
//            try {
//                InputStream input = new FileInputStream(newFileApresSignature);
//                OutputStream os = fileItem.getOutputStream();
//                IOUtils.copy(input, os);
//            } catch (IOException ex) {
//                ex.printStackTrace();
//            }
//
//            MultipartFile multipartFile = new CommonsMultipartFile(fileItem);
//
//            storageService.store(businessKey, multipartFile, doc.getIdentifiant(), documentDto);
//            String docName="Contrat VOLO";
//            String docName_compte="Contrat ouverture de compte";
//            System.out.println("doc.getName()========="+doc.getName());
//
//            if (doc.getName().equals(docName.toLowerCase()) || doc.getName().equals(docName) || doc.getName().equals("Contrat Volo")) {
//                System.out.println("entré volo=========");
//
//                logInfoService.addLog(
//                        LogInfoConstante.TRAITEMENT_DU_DOSSIER.ETAPE_SIGNATURE_CONTRAT.SIGNER_CONTRAT_VOLO,
//                        businessKey,
//                        LogInfoConstante.TRAITEMENT_DU_DOSSIER.ETAPE_SIGNATURE_CONTRAT.ETAPE_VERIFICATION_SIGNATURE);
//
//                Notes notes = new Notes();
//                notes.setBusinessKey(businessKey);
//                notes.setDate(new Date());
//                notes.setType(NoteTypes.INFORMATION);
//                notes.setNote("Contrat volo signé avec succès");
//                cmpt.setSignatureVoloEffectue(true);
//                compteService.updateCompte(cmpt,notes);
//
//            }
//            if (doc.getName().equals(docName_compte.toLowerCase()) || doc.getName().equals(docName_compte)) {
//
//                logInfoService.addLog(
//                        LogInfoConstante.TRAITEMENT_DU_DOSSIER.ETAPE_SIGNATURE_CONTRAT.SIGNER_CONTRAT_COMPTE,
//                        businessKey,
//                        LogInfoConstante.TRAITEMENT_DU_DOSSIER.ETAPE_SIGNATURE_CONTRAT.ETAPE_VERIFICATION_SIGNATURE);
//
//                System.out.println("entré ouverture compte=========");
//                Notes notes = new Notes();
//                notes.setBusinessKey(businessKey);
//                notes.setDate(new Date());
//                notes.setType(NoteTypes.INFORMATION);
//                notes.setNote("Contrat  d'ouverture de compte signé avec succès");
//                cmpt.setSignatureCompteEffectue(true);
//
//                compteService.updateCompte(cmpt,notes);
//            }
//
////
//            // ENVOI VERS LE SERVER
////            if (newFileApresSignature != null) {
////                System.out.println("newFileNameFormat=========="+newFileNameFormat);
////                System.out.println("String.valueOf(Paths.get(newFileNameFormat))=========="+String.valueOf(Paths.get(newFileNameFormat)));
////                 postDocForServer(newFileNameFormat,businessKey);
////            }
//
//            System.out.println("fin  if  multipartFile volo doc.isPresent()");
//
//            System.out.println("PDF modified successfully.");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//


    public void contratPdfConverter(String businessKey, String fileId) {

        System.out.println("fileId==="+fileId);

        Optional<CompteDocument> compteDocumentOptional = this.dao.findById(fileId);

        if(!compteDocumentOptional.isPresent()){
            throw new MyAppException("Cannot find file id.");
        }

        CompteDocument doc= compteDocumentOptional.get();
        Date d = doc.getCreatedAt();

        // Convert java.util.Date to java.time.LocalDate
        LocalDate localDate = d.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

        String upBasePath = appConfig.getUploadBasePath();

        if(StringUtils.isEmpty(upBasePath)){
            upBasePath = System.getProperty("java.io.tmpdir");
        }



        String path =appConfig.getUploadBasePath() + File.separator + localDate.getYear() +
                File.separator + localDate.getMonth()+
                File.separator + businessKey + File.separator + doc.getDocPath();

        //nouveau nom apres signature
        String newFileNameFormat = path.substring(0,path.length()-4)+"_signatureClient"+".pdf";

//        File dir = new File(path);
//        dir.mkdirs();

        try {
            Optional<Compte> compte = compteService.getCompte(businessKey);
            Compte cmpt=null;
            cmpt=compte.get();


            //Create PdfReader instance.
            PdfReader pdfReader =
                    new PdfReader(path);

            //Create PdfStamper instance.
            PdfStamper pdfStamper = new PdfStamper(pdfReader,
                    new FileOutputStream(newFileNameFormat));

            //Create BaseFont instance.
            BaseFont baseFont = BaseFont.createFont(
                    BaseFont.TIMES_ROMAN,
                    BaseFont.CP1252, BaseFont.NOT_EMBEDDED);

//            C:\DEMATER\AppDM\2021\JULY\AA053\signature_clientAA053.png

            String imagePath = upBasePath + File.separator + localDate.getYear() +
                    File.separator + localDate.getMonth()+
                    File.separator + businessKey+ File.separator;
            String fileName=null;

            //si le compte vient du Onboarding
            if (cmpt.getFromOnboarding()) {
                System.out.println("cmpt.getFromOnboarding()========"+cmpt.getFromOnboarding());
                List<CompteDocument> cmptDoc = compteDocumentDao.findByBusinessKeyAndName(businessKey,"signature");
                if (!cmptDoc.isEmpty()) {
                    CompteDocument signature =cmptDoc.get(0);
                    fileName=signature.getDocPath();
                    System.out.println("signature.getDocPath()==================>"+signature.getDocPath());
                }
            } else {

                fileName="signature_client"+businessKey+".png";
                System.out.println("if !onboarding fileName==================>"+fileName);

            }

            //Get the number of pages in pdf.
            int pages = pdfReader.getNumberOfPages();

//            System.out.println("pages"+(pages));
//            System.out.println("pages-1 "+(pages-1));

            //Iterate the pdf through pages.
            for(int i=1; i<=pages; i++) {
                System.out.println("for image fileName 22==================>"+fileName);

                com.itextpdf.text.Image image = com.itextpdf.text.Image.getInstance(imagePath+fileName);
                image.scaleAbsolute(200, 100);
                image.setAbsolutePosition(0, 0);
                //Contain the pdf data.
                PdfContentByte pageContentByte =
                        pdfStamper.getOverContent(pages);

                pageContentByte.beginText();
                //Set text font and size.
                pageContentByte.setFontAndSize(baseFont, 14);

                pageContentByte.setTextMatrix(50, 50);
                pageContentByte.addImage(image);

                //Write text
//                pageContentByte.showText("w3spoint.com nouveau------------------");
                pageContentByte.endText();
            }

            //Close the pdfStamper.
            pdfStamper.close();



            // stockage du nouveau document
            //info du compte
//            Optional<Compte> compte = compteService.getCompte(businessKey);
//            Compte cmpt=null;
//            cmpt=compte.get();

            DocumentDto documentDto ;
            documentDto = ModelMapper.convertCompteDocumentToDocumentDto(doc);


            File newFileApresSignature = new File(String.valueOf(Paths.get(newFileNameFormat)));
            FileItem fileItem = new DiskFileItem("mainFile2", "MediaType.APPLICATION_PDF", false, newFileApresSignature.getName(), (int) newFileApresSignature.length(), newFileApresSignature.getParentFile());

            try {
                InputStream input = new FileInputStream(newFileApresSignature);
                OutputStream os = fileItem.getOutputStream();
                IOUtils.copy(input, os);
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            MultipartFile multipartFile = new CommonsMultipartFile(fileItem);

            storageService.store(businessKey, multipartFile, doc.getIdentifiant(), documentDto);
            String docName="Contrat VOLO";
            String docName_compte="Contrat ouverture de compte";
            System.out.println("doc.getName()========="+doc.getName());

            if (doc.getName().equals(docName.toLowerCase()) || doc.getName().equals(docName) || doc.getName().equals("Contrat Volo")) {
                System.out.println("entré volo=========");

                logInfoService.addLog(
                        LogInfoConstante.TRAITEMENT_DU_DOSSIER.ETAPE_SIGNATURE_CONTRAT.SIGNER_CONTRAT_VOLO,
                        businessKey,
                        LogInfoConstante.TRAITEMENT_DU_DOSSIER.ETAPE_SIGNATURE_CONTRAT.ETAPE_VERIFICATION_SIGNATURE);

                Notes notes = new Notes();
                notes.setBusinessKey(businessKey);
                notes.setDate(new Date());
                notes.setType(NoteTypes.INFORMATION);
                notes.setNote("Contrat volo signé avec succès");
                cmpt.setSignatureVoloEffectue(true);
                compteService.updateCompte(cmpt,notes);

            }
            if (doc.getName().equals(docName_compte.toLowerCase()) || doc.getName().equals(docName_compte)) {

                logInfoService.addLog(
                        LogInfoConstante.TRAITEMENT_DU_DOSSIER.ETAPE_SIGNATURE_CONTRAT.SIGNER_CONTRAT_COMPTE,
                        businessKey,
                        LogInfoConstante.TRAITEMENT_DU_DOSSIER.ETAPE_SIGNATURE_CONTRAT.ETAPE_VERIFICATION_SIGNATURE);

                System.out.println("entré ouverture compte=========");
                Notes notes = new Notes();
                notes.setBusinessKey(businessKey);
                notes.setDate(new Date());
                notes.setType(NoteTypes.INFORMATION);
                notes.setNote("Contrat  d'ouverture de compte signé avec succès");
                cmpt.setSignatureCompteEffectue(true);

                compteService.updateCompte(cmpt,notes);
            }

//
            // ENVOI VERS LE SERVER
//            if (newFileApresSignature != null) {
//                System.out.println("newFileNameFormat=========="+newFileNameFormat);
//                System.out.println("String.valueOf(Paths.get(newFileNameFormat))=========="+String.valueOf(Paths.get(newFileNameFormat)));
//                 postDocForServer(newFileNameFormat,businessKey);
//            }

            System.out.println("fin  if  multipartFile volo doc.isPresent()");

            System.out.println("PDF modified successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public  String postDocForServer() throws UnirestException,IOException {
        System.out.println("debut postDocForServer");
        //JSONObject params = new JSONObject();
        //  params.put("pdf",url);
        //  params.put("businesskey",businesskey);



//        Unirest.setTimeouts(0, 0);
//        HttpResponse<String> response = Unirest.post("http://52.166.206.235/index.php/api/upload/sign/files")
//                .field("pdf", new File(url))
//                .field("businesskey", businesskey)
//                .asString();
//
//
//        System.out.println("fin  postDocForServer  "+response.getBody());

//        return   externalEndPointService.addDocFile(url, businesskey);
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
//        MediaType mediaType = MediaType.APPLICATION_PDF;
        RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("pdf", String.valueOf(new File("C:/Users/Kevin KOUAKOU/Documents/Fiche_mandataire.pdf")))
                .addFormDataPart("businesskey","AA002")
                .build();
        Request request = new Request.Builder()
                .url("https://boxbanking-mobile.westeurope.cloudapp.azure.com/index.php/api/upload/sign/files")
                .method("POST", body)
                .build();


        Response response = client.newCall(request).execute();

        System.out.println("fin postDocForServer"+response);
        return null;
    }


//    public  Object postDocForServer(String url,String businesskey) throws UnirestException {
//        System.out.println("debut postDocForServer");
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
//        Unirest.setTimeouts(0, 0);
//        HttpResponse<InputStream> response = Unirest.post("http://52.166.206.235/index.php/api/upload/sign/files")
//                .field("pdf", new File(url))
//                .field("businesskey", businesskey)
//                .asBinary();
//
//
//        System.out.println("fin  postDocForServer  "+response.getBody());
//
//        return response.getBody();
//    }


    //
//    public String getAccountDocumentFileUploaded (String externalBusinessKey, DossierDocument d){
//        String urlFileUploaded = externalEndPointConfig.getGet_file_uploaded_url()+"/"+externalBusinessKey+"/"+d.getDocCode();
//        MultipartFile file = restTemplate3().execute(urlFileUploaded, HttpMethod.GET, null, clientHttpResponse -> {
//            File ret = File.createTempFile("download", "tmp");
//            FileOutputStream fichier=new FileOutputStream(ret);
//            StreamUtils.copy(clientHttpResponse.getBody(), fichier);
//            System.out.println(clientHttpResponse.getHeaders().getContentType());
//
//            FileItem fileItem = new DiskFileItem("mainFile", ""+clientHttpResponse.getHeaders().getContentType(), false, ret.getName(), (int) ret.length(), ret.getParentFile());
//
//            try {
//                InputStream input = new FileInputStream(ret);
//                OutputStream os = fileItem.getOutputStream();
//                IOUtils.copy(input, os);
//                // Or faster..
//                // IOUtils.copy(new FileInputStream(file), fileItem.getOutputStream());
//            } catch (IOException ex) {
//                // do something.
//            }
//
//            MultipartFile multipartFile = new CommonsMultipartFile(fileItem);
//            // CommonsMultipartFile multipartFile = new CommonsMultipartFile(fileItem);
//
//            fichier.close();
//            return multipartFile;
//        });
//
//        DossierDocumentDto dto = storageService.store(
//                d.getBusinessKey(),
//                file,
//                d.getIdentifiant(),
//                ModelMapper.convertDossierDocumentToDossierDocumentDto(d)
//        );
//
//        return dto.getDocPath();
//    }
//
//

    public synchronized Resource generateContratOC(String firstName, String lastName, String typeCompte) throws Exception{
        String fileName = "contrat-ouvertue-de-compte.pdf";
        Path path = Paths.get(System.getProperty("java.io.tmpdir"), fileName);

        if (!path.toFile().exists()){
            path.toFile().createNewFile();
        }
        ContratOuvertureCompte coc = new ContratOuvertureCompte(
                firstName, lastName,path, typeCompte
        );

        return coc.generateContrat();
    }


    public synchronized Resource generateContratVOLO(String firstName, String lastName) throws Exception{
        String fileName = "contrat-volo.pdf";
        Path path = Paths.get(System.getProperty("java.io.tmpdir"), fileName);

        if (!path.toFile().exists()){
            path.toFile().createNewFile();
        }
        ContratVOLO cVolo = new ContratVOLO(
                firstName, lastName,path
        );

        return cVolo.generateContrat();
    }

    public synchronized Resource generateContratDemandeCartCredit(String firstName, String lastName) throws Exception{
        String fileName = "contrat-carte-credit.pdf";
        Path path = Paths.get(System.getProperty("java.io.tmpdir"), fileName);

        if (!path.toFile().exists()){
            path.toFile().createNewFile();
        }
        ContratDemandeCardCredit cVolo = new ContratDemandeCardCredit(
                firstName, lastName,path
        );

        return cVolo.generateContrat();
    }

    public  synchronized Resource createContrat(String fullName, String typeCompte) throws  Exception{
        String fileName = "contrat-ouvertue-de-compte.pdf";
        Path path = Paths.get(System.getProperty("user.home"), fileName);

        if (!path.toFile().exists()){
            path.toFile().createNewFile();
        }

        Document document = new Document();
        document.setPageSize(PageSize.A4);
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(path.toFile()));

       // writer.setPageEvent(new MarkPageEvent());
        document.open();
        addMetaData(document);
        addTitlePage(document);
        document.add(Chunk.NEWLINE);
        document.add(Chunk.NEWLINE);
        document.add(Chunk.NEWLINE);
        addContent(document, fullName);
        document.setMargins(10, 10, 20, 20);
        document.close();

        return new UrlResource(path.toUri());

    }


    private  void addMetaData(Document document){
        document.addAuthor("Box AFRICA BANK");
        document.addCreator("Box AFRICA BANK");
        document.addKeywords("Contrat ouverture de compte");
        document.addCreationDate();
    }

    private  void addTitlePage(Document document) throws Exception{
        addEmptyLine(document, 2);
        Paragraph p = new Paragraph("CONTRAT D'OUVERTURE DE COMPTE",
                new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.BOLD));
        Font font = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.BOLD);

        p.setAlignment(Element.ALIGN_CENTER);
        document.add(p);
        //document.newPage();
    }

    private   void addContent(Document document, String fullName) throws Exception{
        addEmptyLine(document, 5);
        StringBuffer text = new StringBuffer();
        text.append("    ");
        text.append("Monsieur/Madame ");
        text.append(fullName );
        text.append(" s'engagae à ouvrir un compte .");

        Paragraph p = new Paragraph(text.toString(),
                new Font(  Font.FontFamily.TIMES_ROMAN, 8));
        p.setIndentationRight(4);
        document.add(p);

        StringBuffer text2 = new StringBuffer("\t");
        text2.append("The journey commenced with a single tutorial on HTML in 2006 and elated by the response it generated, we worked");
        text2.append("our way to adding fresh tutorials to our repository which now proudly ");

        Paragraph p2 = new Paragraph(text2.toString(),
                new Font(  Font.FontFamily.TIMES_ROMAN, 8));
        p2.setIndentationRight(4);
        document.add(p2);

        StringBuffer text3 = new StringBuffer();
        text3.append("flaunts a wealth of tutorials and allied articles on topics");
        text3.append("ranging from programming languages to web designing to academics and much more.");

        Paragraph p3 = new Paragraph(text2.toString(),
                new Font(  Font.FontFamily.TIMES_ROMAN, 8));
        p3.setIndentationRight(4);
        document.add(p3);

        document.add(Chunk.NEWLINE);
        document.add(Chunk.NEWLINE);
        document.add(Chunk.NEWLINE);
        document.add(Chunk.NEWLINE);
        document.add(Chunk.NEWLINE);
        StringBuffer text4 = new StringBuffer();
        text4.append("Fait à Abidjan le " + LocalDate.now().toString());
        Paragraph p4 = new Paragraph(text4.toString(),
                        new Font(Font.FontFamily.TIMES_ROMAN, 7));
        p4.setAlignment(Element.ALIGN_RIGHT);
        document.add(p4);

    }

    private  void addEmptyLine(Document document, int numberOfLine) throws Exception{
        for (int count = 0; count < numberOfLine; count++){
            document.add(new Paragraph(""));
        }

    }



    public  class MarkPageEvent extends PdfPageEventHelper{
        @Override
        public void onStartPage(PdfWriter writer, Document document) {
//            ColumnText.showTextAligned(writer.getDirectContent(),
//                    Element.ALIGN_CENTER, new Phrase("BOX AFRICA BANK"),
//                    297.5f, 421, writer.getPageNumber() % 2 == 1 ? 45 : -45);
        }

        @Override
        public void onEndPage(PdfWriter writer, Document document) {
            ColumnText.showTextAligned(writer.getDirectContentUnder(),
                    Element.ALIGN_CENTER, new Phrase("BOX AFRICA BANK"),
                    297.5f, 421, writer.getPageNumber() % 2 == 1 ? 45 : -45);
        }
    }

}
