import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;


class PersonInfoTest {
    PersonInfo p = new PersonInfo();

    @Test
    public void personInfoTest() {
        List<String> wants = Arrays.asList("7703021234, Alhambra Aromes, 2024-07-01",
                "8204021234, Bear Belle, 2019-12-02",
                "8512021234, Chamade Coriola, 2018-03-12");


        ArrayList<String> b = p.personInfo("test/data_inlamningsuppg2.txt");

        assertIterableEquals(wants, b);

    }

    @Test
    public void getTimeDateTest(){
        String todayDateTimeTest = p.getTimeDate();
        LocalDateTime todayDateTime = LocalDateTime.now();

        assertEquals( todayDateTime.format(DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss")), todayDateTimeTest);

    }

}