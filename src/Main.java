import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
/*
skapa en fil reader som läser av en fil och sedan tar från en input och jämför inputen med filen.
 */
        Scanner scan = new Scanner(System.in);
        String text;
        System.out.println("skriv något:");
        while (scan.hasNextLine()) {
            text = scan.nextLine();


            System.out.println("Du skrev: " + text);
            System.out.println("skriv något:");
        }

    }
}