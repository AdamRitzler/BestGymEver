import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class PersonInfoTest {
    PersonInfo p = new PersonInfo();

    @Test
    public void personInfoTest() {
        List<String> förväntan = Arrays.asList("7703021234, Alhambra Aromes, 2024-07-01",
                "8204021234, Bear Belle, 2019-12-02",
                "8512021234, Chamade Coriola, 2018-03-12");

        ArrayList<String> personLista = p.personInfo("test/data_inlamningsuppg2.txt");

        assertIterableEquals(förväntan, personLista);

    }

    @Test
    public void getTimeDateTest() {
        String todayDateTimeTest = p.getTimeDate();
        LocalDateTime TimeDateNow = LocalDateTime.now();

        assertEquals(TimeDateNow.format(DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss")), todayDateTimeTest);
        assertNotEquals("2024-10-21", todayDateTimeTest);
    }

    @Test
    public void printToPTFileTest() {
        LocalDateTime timeDateNow = LocalDateTime.now();
        String lastLineInFile, fileName = "src/personlig tränare";
        lastLineInFile = printToPTFile("Alhambra Aromes", fileName);
        assertEquals("Kundens namn och personnummer: Alhambra Aromes, 7703021234, Tid: " + timeDateNow.format(DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss")), lastLineInFile);

        lastLineInFile = printToPTFile("Diamanda Djedi", fileName);
        assertEquals("Kundens namn och personnummer: Diamanda Djedi, 7608021234, Tid: " + timeDateNow.format(DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss")), lastLineInFile);
    }

    public String printToPTFile(String fName, String fileName) {

        p.getMember(fName);
        p.printToPTFile(fileName);
        String lastLine = null;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String currentLine;
            while ((currentLine = br.readLine()) != null) {
                lastLine = currentLine;
            }


        } catch (FileNotFoundException e) {
            System.out.println("Gick inte att göra testet för att filen kunde inte hittas");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Gick inte att köra testet för att filen gick inte att läsa");
            e.printStackTrace();
        }
        return lastLine;
    }


}