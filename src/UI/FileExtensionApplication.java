package UI;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;

public class FileExtensionApplication {
    private UserInterface UI = new UserInterface();
    private HashMap<String, String> fileExtensions;

    /**
     * A switch case that displays the menu options and gets the user's choice.
     * It runs until 'q' is entered where the program calls quit() and exits.
     */
    public void run(){
        char option;
        do{
            option = UI.displayMenu();
            switch(option){
                case '1' : addNew(); break;
                case '2' : displayAll();break;
                case '3' : displayExtension();break;
                case '4' : deleteExtension();break;
                case '5' : deleteAll();break;
                case 'q' : quit();break;
            }
        } while (option != 'q');
    }

    //
    // Options
    //

    /**
     * Option 1
     * Adds a new entry to the fileExtensions HashMap.
     * If the file extension already exists, prints an error message.
     */
    private void addNew() {
        String extension = UI.getFileExtension();

        if (findExtension(extension)) {
            System.out.println("\n" + extension + " already exists");
            return;
        }

        String application = UI.getApplication();
        fileExtensions.put(extension, application);

        System.out.println("\nAdded new extension: " + extension + " opens with " + application);
    }


    /**
     * Option 2
     * Displays all entries in the fileExtensions HashMap.
     * If the HashMap is empty, it prints an error message.
     */
    private void displayAll() {
        if (fileExtensions.isEmpty()) {
            System.out.println("\nNo file extensions found");
            return;
        }

        System.out.println();

        for (String extension : fileExtensions.keySet()) {
            System.out.println("File extension: " + extension + " opens with " + fileExtensions.get(extension));
        }
    }


    /**
     * Option 3
     * Displays the application associated with the given file extension.
     * If the file extension does not exist, it prints an error message.
     */
    private void displayExtension() {
        String extension = UI.getFileExtension();

        if (findExtension(extension)) {
            System.out.println("\nFile extension: " + extension + " opens with " + fileExtensions.get(extension));
        } else {
            System.out.println("\nNo file extension with the name " + extension + " found");
        }
    }


    /**
     * Option 4
     * Deletes an entry from the fileExtensions HashMap.
     * Prompts the user to confirm the deletion.
     */
    private void deleteExtension() {
        String extension = UI.getFileExtension();

        if (!findExtension(extension)) {
            System.out.println("\nNo file extension with the name " + extension + " found");
            return;
        }

        if (UI.areYouSure("delete file extension " + extension) == 'y') {
            fileExtensions.remove(extension);
            System.out.println("\nFile extension " + extension + " successfully deleted");
        }
    }


    /**
     * Option 5
     * Deletes all entries from the fileExtensions HashMap.
     * Prompts the user to confirm the deletion.
     */
    private void deleteAll() {
        if (fileExtensions.isEmpty()) {
            System.out.println("\nNo file extensions found");
            return;
        }

        if (UI.areYouSure("delete all file extensions") == 'y') {
            fileExtensions.clear();
            System.out.println("\nAll files extensions successfully deleted");
        }
    }


    /**
     * Option Q
     * Saves the fileExtensions HashMap to a JSON file.
     * Prints either a success message or an error message.
     */
    private void quit() {
        try (FileWriter writer = new FileWriter("fileExtensions.json")) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(fileExtensions, writer);

            System.out.println("\nData saved successfully. Exiting application");
        } catch (IOException e) {
            System.out.println("\nError saving data " + e.getMessage());
        }
    }


    //
    // Helper methods
    //

    /**
     * Helper 1
     * Returns true if the fileExtensions HashMap contains an entry with the given key.
     * Otherwise, returns false.
     */
    private boolean findExtension(String extension) {
        return fileExtensions.containsKey(extension);
    }


    /**
     * Helper 2
     * Constructor that reads the fileExtensions HashMap from a JSON file.
     * If the file does not exist, it creates a new HashMap.
     */
    public FileExtensionApplication() {
        File file = new File("fileExtensions.json");

        if (file.exists()) {
            try (FileReader reader = new FileReader(file)) {
                Gson gson = new Gson();
                Type type = new TypeToken<HashMap<String, String>>() {}.getType();
                fileExtensions = gson.fromJson(reader, type);

                if (fileExtensions == null) {
                    fileExtensions = new HashMap<>();
                }
            } catch (IOException e) {
                System.out.println("Error reading from file: " + e.getMessage());
                fileExtensions = new HashMap<>();
            }
        } else {
            fileExtensions = new HashMap<>();

            try {
                if (file.createNewFile()) {
                    System.out.println("File created: " + file.getName());
                }
            } catch (IOException e) {
                System.out.println("An error occurred while creating the file");
                e.printStackTrace();
            }
        }
    }
}
