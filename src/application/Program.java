package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a source file path: ");
        String strPath = sc.nextLine();

         System.out.println("Enter a destiny file path: ");
         String strPathd = sc.nextLine();

        File path = new File(strPath);
        File pathd = new File(strPathd);
        try (BufferedReader br = new BufferedReader(new FileReader(path))) { // cria um bloco try instanciando br a
                                                                             // partir de um fr de path
            String line = br.readLine();
            

            while (line != null) {
                String [] productInfo=line.split(",");
                Double price = Double.parseDouble(productInfo[1]);
                Integer qnt = Integer.parseInt(productInfo[2]);
                try(BufferedWriter bw = new BufferedWriter(new FileWriter(pathd,true))) {
                         bw.write(productInfo[0] +" "+ (price*qnt));
                         bw.newLine();
                }
                catch(IOException e){
                    e.getStackTrace();
                }
        
                line = br.readLine();

            }
        } 
        catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        sc.close();
    }

}
