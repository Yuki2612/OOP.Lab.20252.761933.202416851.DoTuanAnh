package hust.soict.dsai.garbage;

import java.nio.file.Files;
import java.nio.file.Paths;

public class GarbageCreator {
    public static void main(String[] args) {
        String filename = "test.txt"; 
        byte[] inputBytes = { 0 };
        long startTime, endTime;

        try {
            inputBytes = Files.readAllBytes(Paths.get(filename));
        } catch (Exception e) {
            System.err.println("Lỗi đọc file. Vui lòng kiểm tra lại file test.txt đã tồn tại chưa.");
            e.printStackTrace();
        }

        startTime = System.currentTimeMillis();
        String outputString = "";

        for (byte b : inputBytes) {
            outputString += (char) b;
        }
        
        endTime = System.currentTimeMillis();
        System.out.println("Thoi gian chay cua GarbageCreator (su dung String): " + (endTime - startTime) + " ms");
    }
}