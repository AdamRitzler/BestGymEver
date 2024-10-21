import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class PersonInfo {
    private String fullName, securityNum, lastPaymentDate;


    public ArrayList<String> personInfo(String input) {

        ArrayList<String> pers = new ArrayList<>();//skapar en lista för alla personer
        String tempFirstLine, lastYearlyPayment;

        try (BufferedReader buffern = new BufferedReader(new FileReader(input))) {
            while ((tempFirstLine = buffern.readLine()) != null) {
                lastYearlyPayment = buffern.readLine();
                //lägger in namn, personnummer och senast betalningsdatum för varje person i listan
                pers.add(tempFirstLine + ", " + lastYearlyPayment);


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
        //tar in listan med personer
        personer = pers.personInfo("src/data_inlamningsuppg2.txt");

        //går igenom listan med personer
        int n = 0;
        while (n <= personer.size()) {
            try {
                //Delar upp varje person uppgifter så att dem går att skilja
                pName = personer.get(n).split(",");
                if (indataMedlem == null) {
                    return false;

                } else if (pName[1].trim().equalsIgnoreCase(indataMedlem) || pName[0].trim().equalsIgnoreCase(indataMedlem)) {
                    /*
                    kollar ifall inputen är en person som finns i listan
                    När Person är hittad i listan så sparar namn, personnummer, och betalningsdatum
                    Sem returnerar jag att person finns i listan
                     */
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

    public String getTimeDate() {
        //returnerar dagens datum och tid.
        LocalDateTime todayDateTime = LocalDateTime.now();
        return todayDateTime.format(DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss"));
    }

    public void printToPTFile(String input) {
        PersonInfo personen = new PersonInfo();

        //skapar em printWriter som skriver in personerna som tränar i en fil
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(input, true))) {

            printWriter.println("Kundens namn och personnummer: " + this.fullName + ", " + this.securityNum + ", Tid: " + personen.getTimeDate());

        } catch (IOException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }
}
