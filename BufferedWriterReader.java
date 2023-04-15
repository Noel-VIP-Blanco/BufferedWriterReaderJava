import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Scanner;
public class BufferedWriterReader
{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String firstName,lastName, id, contact;
        
        System.out.println("Enter id number: ");
        id = sc.nextLine();
        System.out.println("Enter last name: ");
        lastName = sc.nextLine();
        System.out.println("Enter first name: ");
        firstName = sc.nextLine();
        System.out.println("Enter contact: ");
        contact = sc.nextLine();
        
        try{
            FileWriter file = new FileWriter("Student.txt", true);
            BufferedWriter output = new BufferedWriter(file);
            output.write(id + " ");
            output.write(lastName + " ");
            output.write(firstName + " "); 
            output.write(contact + " ");
            output.newLine();
            output.close();
            
        }
        catch(Exception e){
            e.getStackTrace();
        }
        
        try{
            FileReader file = new FileReader("Student.txt");
            BufferedReader input = new BufferedReader(file);
            String line;
            System.out.println("ID LASTNAME FIRSTNAME CONTACT");
            while((line = input.readLine()) != null){
                System.out.println(line);
            }
            
            input.close();    
        }
        catch(Exception e){
            e.getStackTrace();
        }
    }
}
