package UI;

import java.util.Scanner;

public class UserInterface {
    private Scanner input;

    public UserInterface(){
        input = new Scanner(System.in);
    }


    /**
     * This method displays the main menu and gets the user's choice
     * @return the user's choice
     */
    public char displayMenu(){
        System.out.println("\nMain Menu");
        System.out.println("*".repeat(9));
        System.out.println("1. Add new file extension");
        System.out.println("2. Display all file extensions");
        System.out.println("3. Find a file extension");
        System.out.println("4. Delete a file extension");
        System.out.println("5. Delete all file extensions");
        System.out.println("Q. Quit");
        System.out.print("\nPlease enter an option: ");

        return getOption("[12345Qq]");
    }


    /**
     * This method gets a user's choice from the menu
     * @return the option chosen by the user
     */
    private char getOption(String acceptableValues){
        while(!input.hasNext(acceptableValues)){
            System.out.println("Error - please try again!");
            input.next();
        }

        return input.next().toLowerCase().charAt(0);
    }


    /**
     * This method gets the file extension from the user
     * @return the file extension
     */
    public char areYouSure(String message){
        // this method is used to get yes no responses - the message parameter
        // will change depending on what the user wants to do i.e. delete all

        System.out.print("Are you sure you want to " + message + "? (Y/N): ");

        return getOption("[yYnN]");
    }


    /**
     * This method gets the file extension from the user
     * @return the file extension
     */
    public String getFileExtension(){
        System.out.print("Please enter a file extension: ");

        while(!input.hasNext()){
            input.next();
        }

        return input.next().toLowerCase(); //make the file extension lower case
    }


    /**
     * This method gets the application from the user
     * @return the application
     */
    public String getApplication(){
        System.out.print("Please enter an application: ");

        while(!input.hasNext()){
            input.next();
        }

        return input.next();
    }
}
