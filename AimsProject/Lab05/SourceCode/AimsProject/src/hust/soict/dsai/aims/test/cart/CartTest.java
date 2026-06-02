package hust.soict.dsai.aims.test.cart;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class CartTest {
    public static void main(String[] args) {
        // Tạo giỏ hàng mới
        Cart cart = new Cart();

        // Tạo các sản phẩm DVD test
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 124, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", "John Musker", 90, 18.99f);

        // Đã đổi từ addDigitalVideoDisc sang addMedia chuẩn Lab 04
        cart.addMedia(dvd1);
        cart.addMedia(dvd2);
        cart.addMedia(dvd3);

        // In kiểm tra giỏ hàng
        cart.printCart();

        // Chạy thử nghiệm các hàm tìm kiếm
        System.out.println("\n--- Thử nghiệm tìm kiếm ---");
        cart.searchById(2);
        cart.searchByTitle("Aladdin");
    }
}