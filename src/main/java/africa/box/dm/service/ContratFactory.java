package africa.box.dm.service;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import java.io.FileOutputStream;
import java.nio.file.Path;

public abstract class ContratFactory {
    private String firstName;
    private String lastName;
    private Path path;
    private   String title;
    private final static  String AUTHOR = "BOX AFRICA";
    private final static  String CREATOR = "BOX AFRICA";

    public ContratFactory(String firstName, String lastName,
                          String title, Path path){
        this.firstName = firstName;
        this.lastName = lastName;
        this.path = path;
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName(){
        return firstName + " " + lastName;
    }
    public  void addMetaData(Document document){
        document.addAuthor("Box AFRICA BANK");
        document.addCreator("Box AFRICA BANK");
        document.addKeywords("Contrat ouverture de compte");
        document.addCreationDate();
    }
    public  void addTitlePage(Document document) throws Exception{
        addEmptyLine(document, 2);
        Paragraph p = new Paragraph(title.toUpperCase(),
                new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.BOLD));
        Font font = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.BOLD);

        p.setAlignment(Element.ALIGN_CENTER);
        document.add(p);
        //document.newPage();
    }
    public  void addEmptyLine(Document document, int numberOfLine) throws Exception{
        for (int count = 0; count < numberOfLine; count++){
            document.add(new Paragraph(""));
        }

    }
    public Resource generateContrat() throws  Exception{
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
        addContent(document);
        document.setMargins(10, 10, 20, 20);
        document.close();

        return new UrlResource(path.toUri());
    }
    public abstract void addContent(Document document) throws Exception;

}
