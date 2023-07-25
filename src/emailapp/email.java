package emailapp;
import java.util.*;
import java.io.*;

public class email {

    public Scanner s = new Scanner(System.in); //Class Scanner Global
    //Setting Variables as Private
    private String first_name;
    private String last_name;
    private String dept;
    private String email;
    private String password;
    private int mail_capacity = 500;
    private String alter_email;

    public email(String first_name,String last_name){

        this.first_name = first_name;
        this.last_name = last_name;
        System.out.println("New Employee:"+this.first_name+" "+this.last_name);
        //Calling Methods
        this.dept = this.setDept();
        this.password = this.generate_password(8);
        this.email = this.generate_email();
    }
    //Generate mail
    private String generate_email(){
        return this.first_name.toLowerCase()+"."+this.last_name.toLowerCase()+"@"+this.dept.toLowerCase()+".company.com";
    }
    //asking for dept.
    private String setDept(){
        System.out.println("Department codes \n1 for Sales \n2 for Development \n3 for Accounting \n0 for None");
        boolean flag = false;
        do {
            System.out.println("Enter Department Code");
            int choice = s.nextInt();
            switch (choice){
                case 1:
                    return "Sales";
                case 2:
                    return "Development";
                case 3:
                    return "Accounting";
                case 0:
                    return "None";
                default:
                    System.out.println("Invalid! Please Choose Again");

            }
        }while(!flag);
        return null;
    }
    //generate random password method
    private String generate_password(int length){
        Random r = new Random();
        String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String Small_chars = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String symbol = "!@#$%&?";
        String values = Capital_chars+Small_chars+numbers+symbol;
        String password = "";
        for (int i=0; i<length; i++){
            password=password+values.charAt(r.nextInt(values.length()));

        }
        return password;
    }
    //change password method
    public void set_password(){
        boolean flag = false;
        do {
            System.out.println("do you want to change your password!(Y/N)");
            char choice = s.next().charAt(0);
            if (choice=='Y'||choice=='y') {
                flag = true;
                System.out.println("Enter Current Password:");
                String temp = s.next();
                if (temp.equals(this.password)) {
                    System.out.println("Enter New Password:");
                    this.password = s.next();
                    System.out.println("Password Changed Successfully");
                } else {
                    System.out.println("Incorrect Password");
                }
            } else if (choice=='N'||choice=='n') {
                flag = true;
                System.out.println("Password Changed Option Cancelled");
            }
            else {
                System.out.println("Enter Valid Choice");
            }

        }while(!flag);
    }
    // Set Mailbox capacity method
    public void set_mailcapacity(){
        System.out.println("Current Capacity="+this.mail_capacity+"mb");
        System.out.println("Enter New Mailbox Capacity:");
        this.mail_capacity = s.nextInt();
        System.out.println("Mailbox capacity is successfully changed");
    }
    //set alternate email
    public void altenate_email(){
        System.out.println("Enter New Alternate mail:");
        this.alter_email = s.next();
        System.out.println("Alternate Mail is Set");

    }
    //Display user Information method
    public void getInfo(){
        System.out.print("New Member:"+this.first_name+" "+this.last_name);
        System.out.println("\nDepartment:"+this.dept);
        System.out.println("Email:"+this.email);
        System.out.println("Password:"+this.password);
        System.out.println("Mailbox Capacity:"+this.mail_capacity+"mb");
        System.out.println("Alternate Mail:"+this.alter_email);

    }
    //store information in text file
    public void storefile(){
            try {
                FileWriter in = new FileWriter("C:\\Users\\D I V U L G E R\\Downloads\\info new member.txt");
                in.write("First Name:"+this.first_name);
                in.append("\nLast Name:"+this.last_name);
                in.append("\nEmail:"+this.email);
                in.append("\npassword:"+this.password);
                in.append("\nCapacity:"+this.mail_capacity);
                in.append("\nAlternate mail:"+this.alter_email);
                in.close();
                System.out.println("Data Stored..");
            }catch (Exception e){System.out.println(e);}
    }
    //reading file method
    public void read_file(){
        try{
            FileReader fr = new FileReader("C:\\Users\\D I V U L G E R\\Downloads\\info new member.txt");
            int i;
            while ((i= fr.read())!=-1){
                System.out.print((char)i);
            }

            fr.close();

        }catch (Exception e){System.out.println(e);}
    }
}
