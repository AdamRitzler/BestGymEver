import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
/*
skapa en fil reader som läser av en fil och sedan tar från en input och jämför inputen med filen.
 */
        String readFil = "src/data_inlamningsuppg2.txt";
        ArrayList<String> pers = new ArrayList<String>();
        PersonInfo p = new PersonInfo();
        pers = p.personInfo(readFil);
        System.out.println(pers.get(0));

    }
}
