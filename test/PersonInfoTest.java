import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;


class PersonInfoTest {
    PersonInfo p = new PersonInfo();

    @Test
    public void personInfoTest() {
        List<String> wants = Arrays.asList( "7703021234, Alhambra Aromes, 2024-07-01",
                "8204021234, Bear Belle, 2019-12-02",
                "8512021234, Chamade Coriola, 2018-03-12");


        ArrayList<String> b = p.personInfo("test/data_inlamningsuppg2.txt");

        assertIterableEquals(wants, b);

    }

}