package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.Scanner;

public class Input {

    private Input(){
        super();
    }
    public static void getInput(String arg) throws FileNotFoundException {
        Path path = Path.of(arg);
        File file = new File(path.toString());
        Scanner input = new Scanner(file);
        while(input.hasNext()){
            System.out.println(input.nextLine());
        }
    }
}
