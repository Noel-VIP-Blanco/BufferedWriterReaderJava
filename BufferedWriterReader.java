import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Scanner;
public class BufferedWriterReader
{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
        String format = "%1$-20s %2$-20s %3$-20s %4$-20s%n";
        String firstName,lastName, id, contact;
        System.out.println("Enter a choice");
        System.out.println("1. Add Record");
        System.out.println("2. Search Record");
        System.out.println("3. Display all Record");
        System.out.println("0. Exit");
        int choiceInt = sc1.nextInt();
        while(choiceInt != 0){
            if(choiceInt == 1){
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
                System.out.println();
            }
            else if(choiceInt == 2){
                System.out.println("Search id: ");
                int searchID = sc1.nextInt();
                try{
                    FileReader file = new FileReader("Student.txt");
                    BufferedReader input = new BufferedReader(file);
                    String line;
                    boolean find = false;
                    String[] findId;
                    while((line = input.readLine()) != null){
                        findId = line.split(" ");
                        if(Integer.parseInt(findId[0]) == searchID){
                            System.out.printf(format, "ID", "LASTNAME", "FIRSTNAME", "CONTACT");
                            System.out.printf(format, findId[0], findId[1], findId[2], findId[3]);
                            find = true;
                            System.out.println();
                            break;
                        }
                        
                    }
                    if(find == false){
                        System.out.println("Id not found");
                    }  
                    input.close();
                }
                catch(Exception e){
                    e.getStackTrace();
                }
            }
            else if(choiceInt == 3){
                try{
                        FileReader file = new FileReader("Student.txt");
                        BufferedReader input = new BufferedReader(file);
                        String line;
                        String[] lineWord;
                        System.out.printf(format, "ID", "LASTNAME", "FIRSTNAME", "CONTACT");
                        while((line = input.readLine()) != null){
                            lineWord = line.split(" ");
                            System.out.printf(format, lineWord[0], lineWord[1], lineWord[2], lineWord[3]);
                        }
                        input.close();    
                    }
                    catch(Exception e){
                        e.getStackTrace();
                    }
            }
            else{
                System.out.println("Invalid input");
                System.out.println();
            }
            System.out.println("Enter a choice");
            System.out.println("1. Add Record");
            System.out.println("2. Search Record");
            System.out.println("3. Display all Record");
            System.out.println("0. Exit");
            choiceInt = sc1.nextInt();
            
        }
    }
}
