package emailapp;
import java.util.*;
public class emailApp {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        //user info
        System.out.println("Enter First Name:");
        String first_name = s.next();
        System.out.println("Enter Last Name:");
        String last_name = s.next();
        //creating object for email class
        email em1 = new email(first_name,last_name);
        int choice = -1;
        do {
            System.out.println("\n*****\nEnter Your Choice\n1.Show Info\n2.Change password\n3.Change mailbox capacity\n4.Set alternative mail\n5." +
                    "Store data in file\n6.Display data from file\n7.Exit");
            choice = s.nextInt();
            switch (choice){
                case 1:
                    em1.getInfo();
                    break;
                case 2:
                    em1.set_password();
                    break;
                case 3:
                    em1.set_mailcapacity();
                    break;
                case 4:
                    em1.altenate_email();
                    break;
                case 5:
                    em1.storefile();
                      break;
                case 6:
                    em1.read_file();
                    break;
                case 7:
                    System.out.println("Thank you for using application");
                    break;
                default:
                    System.out.println("Invalid Choice!! \n Enter Proper Choice");
            }
        }while(choice!=7);


    }
}
