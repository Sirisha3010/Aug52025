package pack2;

import java.io.*;

public class Lab41 {
    public static void main(String[] args) throws IOException {

        File file = new File("myfile.txt");

        if (!file.exists()) {
            System.out.println("File not found: " + file.getAbsolutePath());
            return;
        }
        BufferedReader br = new BufferedReader(new FileReader(file));
        StringBuilder content = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            content.append(line).append("\n");
        }
        br.close();

        content.reverse();

        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        bw.write(content.toString());
        bw.close();

        System.out.println("File reversed successfully!");
    }
}


