import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class PersonInfo {
    private String fullName, securityNum, lastPaymentDate;

    public ArrayList<String> personInfo(String input) {
        ArrayList<String> pers = new ArrayList<>();
        String tempFirstLine, lastYearlyPayment;

        try (BufferedReader buffern = new BufferedReader(new FileReader(input))) {
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
        personer = pers.personInfo("src/data_inlamningsuppg2.txt");
        int n = 0;
        while (n <= personer.size()) {
            try {
                pName = personer.get(n).split(",");
                if (indataMedlem == null) {
                    return false;
                } else if (pName[1].trim().equalsIgnoreCase(indataMedlem) || pName[0].trim().equalsIgnoreCase(indataMedlem)) {
                    this.fullName = pName[1].trim();
                    this.securityNum = pName[0].trim();
                    this.lastPaymentDate = pName[2].trim();
                    return true;
                }
                n++;


            } catch (Exception e) {
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

    public String getTimeDate() {

        LocalDateTime todayDateTime = LocalDateTime.now();
        return todayDateTime.format(DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss"));
    }

    public void printToPTFile() {
        PersonInfo p = new PersonInfo();

        try (PrintWriter printWriter = new PrintWriter(new FileWriter("personlig tränare",true))) {

            printWriter.println("Kundens namn och personnummer: " + this.fullName + ", " + this.securityNum + ", Tid: " + p.getTimeDate());

        } catch (IOException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }
}
