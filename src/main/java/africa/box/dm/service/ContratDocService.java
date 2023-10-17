package africa.box.dm.service;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.pdf.codec.Base64;
import fr.opensagres.poi.xwpf.converter.pdf.PdfConverter;
import fr.opensagres.poi.xwpf.converter.pdf.PdfOptions;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.util.ZipSecureFile;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.*;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.io.*;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class ContratDocService {
    public String CreateDocumentSimple(String fileName) {
//        String fileName = "c:\\test\\hello.docx";
        XWPFDocument doc = new XWPFDocument();
        // create a paragraph
        XWPFParagraph p1 = doc.createParagraph();
        p1.setAlignment(ParagraphAlignment.CENTER);

        // set font
        XWPFRun r1 = p1.createRun();
        r1.setBold(true);
        r1.setItalic(true);
        r1.setFontSize(22);
        r1.setFontFamily("New Roman");
        r1.setText("I am first paragraph.");

        // save it to .docx file
        try {
            FileOutputStream out = new FileOutputStream(fileName);
            doc.write(out);
        }  catch (IOException e) {
            e.printStackTrace();
        }
        return "word fait";


    }

    public String addImage(String path) {
        String imgFile = "C:\\DEMATER\\signature_clientAA043.png";
//        String path = "C:\\DEMATER" + File.separator + "signature.docx";
        try {
//            XWPFDocument doc = new XWPFDocument();
            XWPFDocument doc = new XWPFDocument(Files.newInputStream(Paths.get(path)));
            XWPFParagraph p = doc.createParagraph();
            XWPFRun r = p.createRun();
            r.setText(imgFile);
            r.addBreak();

            // add png image
            try (FileInputStream is = new FileInputStream(imgFile)) {
                r.addPicture(is,
                        Document.PICTURE_TYPE_PNG,    // png file
                        imgFile,
                        Units.toEMU(400),
                        Units.toEMU(200));            // 400x200 pixels
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InvalidFormatException e) {
                e.printStackTrace();
            }

            try (FileOutputStream out = new FileOutputStream(path)) {
                doc.write(out);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "word fait";


    }

    public String convertToPDF(String inputFile,String outputFile) throws Exception {

//        String inputFile="D:/TEST.docx";
//        String outputFile="D:/TEST.pdf";


        try {
            ZipSecureFile.setMinInflateRatio(0);

            System.out.println("inputFile:" + inputFile + ",outputFile:"+ outputFile);
            File inFile=new File(inputFile);
            FileInputStream in=new FileInputStream(inFile);

            XWPFDocument doc=new XWPFDocument(in);

            PdfOptions options= PdfOptions.create();

            File outFile=new File(outputFile);
            OutputStream out=new FileOutputStream(outFile);

            doc.createNumbering();
            PdfConverter.getInstance().convert(doc,out,options);
            doc.createStyles();
            doc.close();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "converti";
    }
//
//    public String convertToPDF3(String inputFile) throws IOException {
//
//        String k=null;   ,String outputFile
//        OutputStream fileForPdf =null;
//        try {
//
//            String fileName="/document/test2.doc";
//            //Below Code is for .doc file
//            if(fileName.endsWith(".doc"))
//            {
//                HWPFDocument doc = new HWPFDocument(new FileInputStream(
//                        fileName));
//                WordExtractor we=new WordExtractor(doc);
//                k = we.getText();
//
//                fileForPdf = new FileOutputStream(new File(
//                        "/document/DocToPdf.pdf"));
//                we.close();
//            }
//
//            //Below Code for
//
//            else if(fileName.endsWith(".docx"))
//            {
//                XWPFDocument docx = new XWPFDocument(new FileInputStream(
//                        fileName));
//                // using XWPFWordExtractor Class
//                XWPFWordExtractor we = new XWPFWordExtractor(docx);
//                k = we.getText();
//
//                fileForPdf = new FileOutputStream(new File(
//                        "/document/DocxToPdf.pdf"));
//                we.close();
//            }
//
//
//
//            Document document = new Document();
//            PdfWriter.getInstance(document, fileForPdf);
//
//            document.open();
//
//            document.add(new Paragraph(k));
//
//            document.close();
//            fileForPdf.close();
//
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//
////        InputStream doc = new URL(inputFile).openStream();
////        ByteArrayOutputStream baos = new ByteArrayOutputStream();
////
////        XWPFDocument document = new XWPFDocument(doc);
////        PdfOptions options = PdfOptions.create();
////        PdfConverter.getInstance().convert(document, baos, options);
////        String base64_encoded = Base64.encodeBytes(baos.toByteArray());
//
////        return base64_encoded;
//return "fait";
//
//    }

//     Files.newInputStream(Paths.get(path));

}
