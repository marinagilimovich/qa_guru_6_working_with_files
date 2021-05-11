package tests;

import com.codeborne.pdftest.PDF;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static utils.Files.getPdf;

public class PdfFileTests {
    @Test
    void pdfTest() throws IOException {
        String pdfFilePath = "src/test/resources/files/2.pdf";
        String expectedData = "How can I download some file in my test?";

        PDF pdf = getPdf(pdfFilePath);
        assertThat(pdf, PDF.containsText(expectedData));
    }
}