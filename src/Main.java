import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
/*
skapa en fil reader som läser av en fil och sedan tar från en input och jämför inputen med filen.
 */
        Scanner scan = new Scanner(System.in);
        String[] memberInfo;
        String readFil = "src/data_inlamningsuppg2.txt";
        String indata, memberName;
        boolean member;
        while (true) {
            System.out.println("Vem är det som ska träna? \nSkriv \"exit\" för att avsluta");
            indata = scan.nextLine();
            if (indata.equalsIgnoreCase("exit")) {
                System.exit(0);
            }

            PersonInfo p = new PersonInfo();

            member = p.getMember(indata);
            memberName = p.getName();
            if (!member) {
                System.out.println("kunden har aldrig varit medlem ");
                continue;
            }
            LocalDate t = LocalDate.now();
            LocalDate paymentDate = LocalDate.parse(p.getDate());
            Period d = Period.between(paymentDate, t);


            if (member) {
                if (d.getYears() < 1) {
                    System.out.println(memberName + " är medlem");
                } else if (d.getYears() >= 1) {
                    System.out.println(p.getName() + " är en före detta medlem");
                }
            }


        }
    }
}
