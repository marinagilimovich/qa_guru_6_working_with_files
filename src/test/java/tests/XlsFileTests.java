package tests;

import com.codeborne.xlstest.XLS;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static utils.Files.getXls;
import static utils.Files.readXlsxFromPath;

public class XlsFileTests {
    @Test
    void xlsSimpleTest() throws IOException {
        String xlsFilePath = "./src/test/resources/files/1.xls";
        String expectedData = "Hello, you are reading the excel file";

        XLS xls = getXls(xlsFilePath);
        assertThat(xls, XLS.containsText(expectedData));
    }

    @Test
    void xlsCellTest() throws IOException {
        String xlsFilePath = "./src/test/resources/files/1.xls";
        String expectedData = "It's a test excel file";

        XLS xls = getXls(xlsFilePath);
        String actualData = xls.excel.getSheetAt(0).getRow(1).getCell(0).toString();
        assertThat(actualData, containsString(expectedData));
    }

    @Test
    void xlsxTest() {
        String xlsFilePath = "./src/test/resources/files/1.xlsx";
        String expectedData = "It's a test excel file";

        String actualData = readXlsxFromPath(xlsFilePath);
        assertThat(actualData, containsString(expectedData));
    }

}