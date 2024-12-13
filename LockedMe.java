import java.io.File;
import java.util.*;

public class LockedMe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String directoryPath = "C:\\Users\\jayde\\Desktop\\Simplilearn\\Simplilearn-Projects";
        
        // Welcome Screen
        System.out.println("Welcome to LockedMe.com");
        System.out.println("Developer: [Jaydeep Patil]");
        boolean exit = false;

        while (!exit) {
            // Display Main Menu
            System.out.println("\nMain Menu:");
            System.out.println("1. Display files in ascending order");
            System.out.println("2. Business-level operations");
            System.out.println("3. Exit application");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayFiles(directoryPath);
                    break;
                case 2:
                    businessOperations(directoryPath, scanner);
                    break;
                case 3:
                    System.out.println("Exiting application. Thank you!");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    private static void displayFiles(String directoryPath) {
        File folder = new File(directoryPath);
        File[] files = folder.listFiles();
        if (files != null && files.length > 0) {
            List<String> fileNames = new ArrayList<>();
            for (File file : files) {
                if (file.isFile()) fileNames.add(file.getName());
            }
            Collections.sort(fileNames); // Ascending order
            System.out.println("Files in ascending order:");
            for (String fileName : fileNames) {
                System.out.println(fileName);
            }
        } else {
            System.out.println("The directory is empty.");
        }
    }

    private static void businessOperations(String directoryPath, Scanner scanner) {
        System.out.println("\nBusiness Operations:");
        System.out.println("1. Add a file");
        System.out.println("2. Delete a file");
        System.out.println("3. Search for a file");
        System.out.println("4. Back to Main Menu");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                System.out.print("Enter file name to add: ");
                String fileNameToAdd = scanner.nextLine();
                addFile(directoryPath, fileNameToAdd);
                break;
            case 2:
                System.out.print("Enter file name to delete: ");
                String fileNameToDelete = scanner.nextLine();
                deleteFile(directoryPath, fileNameToDelete);
                break;
            case 3:
                System.out.print("Enter file name to search: ");
                String fileNameToSearch = scanner.nextLine();
                searchFile(directoryPath, fileNameToSearch);
                break;
            case 4:
                System.out.println("Returning to Main Menu.");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private static void addFile(String directoryPath, String fileName) {
        File file = new File(directoryPath + File.separator + fileName);
        try {
            if (file.createNewFile()) {
                System.out.println("File created successfully: " + fileName);
            } else {
                System.out.println("File already exists.");
            }
        } catch (Exception e) {
            System.out.println("Error occurred while creating the file: " + e.getMessage());
        }
    }

    private static void deleteFile(String directoryPath, String fileName) {
        File file = new File(directoryPath + File.separator + fileName);
        if (file.delete()) {
            System.out.println("File deleted successfully: " + fileName);
        } else {
            System.out.println("File not found or couldn't be deleted.");
        }
    }

    private static void searchFile(String directoryPath, String fileName) {
        File folder = new File(directoryPath);
        File[] files = folder.listFiles();
        boolean found = false;
        if (files != null) {
            for (File file : files) {
                if (file.getName().equals(fileName)) {
                    found = true;
                    break;
                }
            }
        }
        if (found) {
            System.out.println("File found: " + fileName);
        } else {
            System.out.println("File not found.");
        }
    }
}
