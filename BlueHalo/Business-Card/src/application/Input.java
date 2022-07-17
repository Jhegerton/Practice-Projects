package application;

import java.io.*;
import java.nio.file.Path;
import java.util.Scanner;

public class Input {

    private Input(){
        super();
    }

    /**
     * This method takes the input from the ocr text from a text file
     * and coverts it to a string with a new line delimiter. The data is
     * then passed to the card data parser.
     * @param arg
     * @return Contact
     * @throws Exception
     */
    public static Contact getInput(String arg) throws Exception {
        Path path = Path.of(arg);
        File file = new File(path.toString());
        StringBuilder build = new StringBuilder();
        try (Scanner scan = new Scanner(file)) {
            while (scan.hasNext()) {
                build.append(scan.nextLine()).append("&");
            }
        }
        CardParser parser = new CardParser();
        Contact contact = parser.getContactInfo(build.toString());
        System.out.println(contact);

        return contact;
    }
}
