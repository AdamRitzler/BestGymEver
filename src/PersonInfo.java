import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PersonInfo {

    //metod checkForPerson() för att stämma överäns namn eller person nummer med input
    //persenalinfo = pers.get(i).split(",");

    public ArrayList<String> personInfo(String filNames){
        ArrayList<String> pers = new ArrayList<String>();
        String tempFirstLine, LastYearlyPayment, pName, securityNum;
        String[] persenalinfo;
        try (BufferedReader buffe = new BufferedReader(new FileReader(filNames))) {
            while ((tempFirstLine = buffe.readLine()) != null) {
                LastYearlyPayment = buffe.readLine();
                pers.add(tempFirstLine);
                //System.out.println(pers);
            }


        } catch (FileNotFoundException e) {
            System.out.println("Kunde inte hitta någon fil!");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("något gick fel");
            throw new RuntimeException(e);
        }
        return pers;
    }
}
