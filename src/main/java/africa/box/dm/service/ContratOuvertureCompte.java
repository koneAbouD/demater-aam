package africa.box.dm.service;

import com.itextpdf.text.*;

import java.nio.file.Path;
import java.time.LocalDate;

public class ContratOuvertureCompte extends ContratFactory {
    private final static String TITLE = "Contrat ouverture de compte";

    private String typeCompte;
    public ContratOuvertureCompte(String firstName, String lastName,
                       Path path, String typeCompte){
        super(firstName, lastName, TITLE, path);
        this.typeCompte = typeCompte;
    }
    @Override
    public void addContent(Document document) throws Exception {
        addEmptyLine(document, 5);
        StringBuffer text = new StringBuffer();
        text.append("    ");
        text.append("Monsieur/Madame ");
        text.append(getFullName() );
        text.append(" s'engagae à ouvrir un compte "+typeCompte.toUpperCase() +".");

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
        text4.append("Fait à Abidjan le ..............." );
        Paragraph p4 = new Paragraph(text4.toString(),
                new Font(Font.FontFamily.TIMES_ROMAN, 7));
        p4.setAlignment(Element.ALIGN_RIGHT);
        document.add(p4);
    }
}
