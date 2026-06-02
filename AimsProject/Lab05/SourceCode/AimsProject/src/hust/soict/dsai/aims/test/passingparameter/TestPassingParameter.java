package hust.soict.dsai.aims.test.passingparameter;

import hust.soict.dsai.aims.media.DigitalVideoDisc;

// Tạo một lớp Wrapper để phục vụ cho việc swap thực sự trong Java (Pass-by-value)
class DVDWrapper {
    DigitalVideoDisc dvd;
    public DVDWrapper(DigitalVideoDisc dvd) {
        this.dvd = dvd;
    }
}

public class TestPassingParameter {

    public static void main(String[] args) {
        // Sửa lại constructor khớp với định dạng 5 tham số của Lab 04
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle", "Animation", "Director A", 90, 19.95f);
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella", "Animation", "Director B", 85, 17.5f);

        // Khởi tạo các Wrapper để test hàm swap xịn
        DVDWrapper wJungle = new DVDWrapper(jungleDVD);
        DVDWrapper wCinderella = new DVDWrapper(cinderellaDVD);

        // 1. Thử nghiệm hàm swap lỗi (Mặc định của đề bài)
        System.out.println("--- Trước khi gọi hàm swap lỗi ---");
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());
        
        swap(jungleDVD, cinderellaDVD);
        
        System.out.println("\n--- Sau khi gọi hàm swap lỗi (Không có gì thay đổi) ---");
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());

        // 2. Thử nghiệm hàm swap xịn bằng cách dùng Wrapper công phá cơ chế Pass-by-value
        System.out.println("\n--- Trước khi gọi hàm swap xịn (Dùng Wrapper) ---");
        System.out.println("jungle dvd title: " + wJungle.dvd.getTitle());
        System.out.println("cinderella dvd title: " + wCinderella.dvd.getTitle());
        
        realSwap(wJungle, wCinderella);
        
        System.out.println("\n--- Sau khi gọi hàm swap xịn ---");
        System.out.println("jungle dvd title: " + wJungle.dvd.getTitle());
        System.out.println("cinderella dvd title: " + wCinderella.dvd.getTitle());
    }

    // Hàm swap lỗi mặc định của đề bài (Do Java truyền tham chiếu bằng giá trị)
    public static void swap(Object o1, Object o2) {
        Object tmp = o1;
        o1 = o2;
        o2 = tmp;
    }

    // Hàm swap xịn giải quyết yêu cầu bài Lab (Sử dụng đối tượng bao bọc)
    public static void realSwap(DVDWrapper dw1, DVDWrapper dw2) {
        DigitalVideoDisc temp = dw1.dvd;
        dw1.dvd = dw2.dvd;
        dw2.dvd = temp;
    }
}