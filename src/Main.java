import java.time.LocalDate;
import java.time.Period;

import java.util.Scanner;

public class Main {
    public Main() {
        PersonInfo p = new PersonInfo();
        Scanner scan = new Scanner(System.in);
        String indata, ptFileName = "src/personlig tränare";
        boolean member;

        while (true) {
            System.out.println("Vem är det som ska träna? \nSkriv \"exit\" för att avsluta");
            indata = scan.nextLine();//tar in det som användaren skriver.
            if (indata.equalsIgnoreCase("exit")) {//kollar om användaren vill avsluta programmet.
                System.out.println("Avslutar programmet");
                System.exit(0);

            }
            //anropar metoden getMember() för att kolla om kunden är medlem eller inte
            member = p.getMember(indata);

            if (!member) {//Ifall kunden aldrig har varit medlem så skriver den ut det och börjar får början av while loopen
                System.out.println("kunden har aldrig varit medlem \n");
                continue;
            }
            /*
            hämtar dagen datum och datumet när kunden senast betalade avgiften
            och tar reda på hur lång tid det har gått från att man betalade senast.
             */
            LocalDate todayDate = LocalDate.now();
            LocalDate paymentDate = LocalDate.parse(p.getDate());
            Period d = Period.between(paymentDate, todayDate);

            //kollar om kunden har betalat inom ett år och då ör fortfarande medlem
            if (d.getYears() < 1) {
                System.out.println(p.getName() + " är medlem\n");
                p.printToPTFile(ptFileName);//anropar metoden för att skriva in i tränarens fil när kunden va och tränade
            } else {
                //ifall kunden inte har betalat på mer än ett år och är då inte medlem.
                System.out.println(p.getName() + " är en före detta medlem\n");
            }
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
    }


}
