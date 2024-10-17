import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
/*
skapa en fil reader som läser av en fil och sedan tar från en input och jämför inputen med filen.
 */

                String tempLine, heigth, lineheight;
                int tempIndex;
                boolean tallPersonTrue = false;
                try (BufferedReader buffe = new BufferedReader(new FileReader("src/Personuppgifter.txt"))) {
                    while ((tempLine = buffe.readLine()) != null) {
                        lineheight = buffe.readLine();
                        tempIndex = lineheight.lastIndexOf(",");
                        heigth = lineheight.substring(tempIndex + 1);


                        if(Integer.parseInt(heigth.trim()) >= 200 ){
                            System.out.println(tallPersonTrue);
                            System.out.println(tempLine.substring(0, tempLine.indexOf(',')) + " " +  heigth.trim());
                        }

                    }

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }

        }
