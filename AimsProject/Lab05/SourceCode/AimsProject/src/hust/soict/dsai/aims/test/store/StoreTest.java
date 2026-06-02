package hust.soict.dsai.aims.test.store;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class StoreTest {
    public static void main(String[] args) {
        // Tạo cửa hàng mới
        Store store = new Store();

        // Tạo các sản phẩm DVD test
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 124, 24.95f);

        // Đã đổi từ addDVD sang addMedia chuẩn Lab 04
        store.addMedia(dvd1);
        store.addMedia(dvd2);

        // In kiểm tra danh sách cửa hàng
        store.printStore();

        // Thử nghiệm xóa sản phẩm khỏi cửa hàng
        System.out.println("\n--- Thử nghiệm xóa sản phẩm ---");
        store.removeMedia(dvd1);
        store.printStore();
    }
}