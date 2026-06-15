package activities;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.FileUtils;

public class Activity14 {

    public static void main(String[] args) {

        try {
            // Step 1: Create file
            File file = new File("myfile.txt");

            if (file.createNewFile()) {
                System.out.println("File created successfully.");

                // Step 2: Write data to file
                FileUtils.writeStringToFile(file, "Hello! This is sample file content.", StandardCharsets.UTF_8);
            } else {
                System.out.println("File already exists.");
            }

            // Step 3: Read data from file
            String content = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
            System.out.println("Original File Content: " + content);

            // Step 4: Create directory
            File directory = new File("backupDir");
            if (!directory.exists()) {
                directory.mkdir();
                System.out.println("Directory created.");
            }

            // Step 5: Copy file to directory
            FileUtils.copyFileToDirectory(file, directory);

            // Step 6: Access copied file
            File copiedFile = FileUtils.getFile(directory, "myfile.txt");

            // Step 7: Read copied file
            String copiedContent = FileUtils.readFileToString(copiedFile, StandardCharsets.UTF_8);
            System.out.println("Copied File Content: " + copiedContent);

        } catch (IOException e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}