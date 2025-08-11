package pack2;

import java.io.*;
import java.util.*;

public class Lab42 {
    public static void main(String[] args) {
        try {
            File file = new File("numbers.txt");
            Scanner scanner = new Scanner(file);
            scanner.useDelimiter(",");

            while (scanner.hasNext()) {
                int num = Integer.parseInt(scanner.next().trim());
                if (num % 2 == 0) {
                    System.out.println(num);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }
}

