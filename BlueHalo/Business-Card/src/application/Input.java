package application;

import java.io.*;
import java.nio.file.Path;
import java.util.Scanner;

public class Input {

    private Input(){
        super();
    }
    public static void getInput(String arg) throws FileNotFoundException {
        Path path = Path.of(arg);
        File file = new File(path.toString());
        StringBuilder build = new StringBuilder();
        try (Scanner scan = new Scanner(file)) {
            while (scan.hasNext()) {
                build.append(scan.nextLine()).append(" ").append((char) 10);
            }
        }
        CardParser parser = new CardParser();
        parser.getContactInfo(build.toString());
    }
}
