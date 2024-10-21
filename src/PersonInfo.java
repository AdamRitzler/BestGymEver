import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.IllegalFormatException;

public class PersonInfo {
    private String fullName, securityNum, lastPaymentDate;


    //metod checkForPerson() för att stämma överäns namn eller person nummer med input
    //persenalinfo = pers.get(i).split(",");

    /*
    gör en getName(), getSecurityNum(), getDate() metod
     */

    public ArrayList<String> personInfo() {
        ArrayList<String> pers = new ArrayList<>();
        String tempFirstLine, lastYearlyPayment;
        String[] persenalinfo;
        try (BufferedReader buffern = new BufferedReader(new FileReader("src/data_inlamningsuppg2.txt"))) {
            while ((tempFirstLine = buffern.readLine()) != null) {
                lastYearlyPayment = buffern.readLine();

                pers.add(tempFirstLine + ", " + lastYearlyPayment);
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

    public boolean getMember(String indataMedlem) {
        String[] pName;
        ArrayList<String> personer;
        PersonInfo pers = new PersonInfo();
        personer = pers.personInfo();
        int n = 0;
        while (n <= personer.size()) {
            try {
                pName = personer.get(n).split(",");
                if(indataMedlem == null){
                    return false;
                } else if (pName[1].trim().equalsIgnoreCase(indataMedlem) || pName[0].trim().equalsIgnoreCase(indataMedlem)) {
                    this.fullName = pName[1].trim();
                    this.securityNum = pName[0].trim();
                    this.lastPaymentDate = pName[2].trim();
                    return true;
                }
                n++;


            }catch (Exception e){
                return false;
            }
        }


        return false;
    }

    public String getName() {
        return this.fullName;

    }

    public String getDate() {
        return this.lastPaymentDate;

    }

    public String getSecurityNum() {
        return this.securityNum;
    }
}
