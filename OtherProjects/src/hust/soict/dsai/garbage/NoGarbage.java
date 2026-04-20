package hust.soict.dsai.garbage;

import java.nio.file.Files;
import java.nio.file.Paths;

public class NoGarbage {
    public static void main(String[] args) {
        String filename = "test.txt"; 
        byte[] inputBytes = { 0 };
        long startTime, endTime;

        try {
            inputBytes = Files.readAllBytes(Paths.get(filename));
        } catch (Exception e) {
            e.printStackTrace();
        }

        startTime = System.currentTimeMillis();

        StringBuilder outputStringBuilder = new StringBuilder();
        for (byte b : inputBytes) {
            outputStringBuilder.append((char) b);
        }
        
        endTime = System.currentTimeMillis();
        System.out.println("Thoi gian chay cua NoGarbage (su dung StringBuilder): " + (endTime - startTime) + " ms");
     // This comment is added for Task 10: Release flow demonstration 
        }
}