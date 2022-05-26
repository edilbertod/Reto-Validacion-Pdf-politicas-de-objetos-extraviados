package co.com.choucair.objperdidos.abilities;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import net.serenitybdd.screenplay.Ability;
import net.serenitybdd.screenplay.Actor;

import java.io.IOException;

public class LeerPdf implements Ability {

    private String pdfText;
    private final String filePath;
    PdfReader pdfReader;

    public LeerPdf(String filePath) throws IOException {
        this.filePath = filePath;
        this.pdfReader = new PdfReader(filePath);
    }

    public static LeerPdf downloadedInPath(String filePath) throws IOException {
        return new LeerPdf(filePath);
    }

    public static LeerPdf as(Actor actor) {
        return actor.abilityTo(LeerPdf.class);
    }

    public String getText() throws IOException {

        int pagesNumber = pdfReader.getNumberOfPages();

        StringBuilder pdfText = new StringBuilder();

        for (int i = 1; i <= pagesNumber; i++) {

            pdfText.append(PdfTextExtractor.getTextFromPage(pdfReader, i));

        }
        return pdfText.toString();
    }


}
