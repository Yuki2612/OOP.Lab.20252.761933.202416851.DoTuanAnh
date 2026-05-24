package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;
import java.util.Scanner;

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Khởi tạo dữ liệu mẫu chạy thử nghiệm
        initSampleData();

        int choice;
        do {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); 
            switch (choice) {
                case 1: storeMenuLoop(); break;
                case 2: updateStoreLogic(); break;
                case 3: cartMenuLoop(); break;
                case 0: System.out.println("Cảm ơn bro đã sử dụng hệ thống AIMS!"); break;
                default: System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        } while (choice != 0);
    }

    private static void initSampleData() {
        store.addMedia(new DigitalVideoDisc("The Matrix", "Action", "Lana Wachowski", 136, 24.95f));
        store.addMedia(new Book("Clean Code", "Technology", 45.5f));
        CompactDisc cd = new CompactDisc("Chill List", "Pop", 15.0f, 60, "Sơn Tùng", "M-TP");
        cd.addTrack(new Track("Chúng Ta Của Tương Lai", 240));
        store.addMedia(cd);
    }

    public static void showMenu() {
        System.out.println("\n--- MAIN MENU ---");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.print("Vui lòng chọn (0-3): ");
    }

    public static void storeMenuLoop() {
        int choice;
        do {
            store.printStore();
            System.out.println("\n--- STORE OPTIONS ---");
            System.out.println("1. See a media's details");
            System.out.println("2. Add a media to cart");
            System.out.println("3. Play a media");
            System.out.println("4. See current cart");
            System.out.println("0. Back");
            System.out.print("Vui lòng chọn (0-4): ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Nhập tên sản phẩm muốn xem: ");
                    String t1 = scanner.nextLine();
                    Media m1 = store.searchByTitle(t1);
                    if (m1 != null) {
                        System.out.println(m1.toString());
                        System.out.println("1. Add to cart | 0. Back");
                        if(scanner.nextInt() == 1) cart.addMedia(m1);
                    } else {
                        System.out.println("Không tìm thấy!");
                    }
                    break;
                case 2:
                    System.out.print("Nhập tên sản phẩm muốn thêm vào giỏ: ");
                    Media m2 = store.searchByTitle(scanner.nextLine());
                    if (m2 != null) cart.addMedia(m2);
                    else System.out.println("Không tìm thấy!");
                    break;
                case 3:
                    System.out.print("Nhập tên sản phẩm muốn phát: ");
                    Media m3 = store.searchByTitle(scanner.nextLine());
                    if (m3 instanceof Playable) ((Playable) m3).play();
                    else System.out.println("Sản phẩm này không hỗ trợ phát âm thanh!");
                    break;
                case 4: 
                    cartMenuLoop(); 
                    break;
            }
        } while (choice != 0);
    }

    public static void updateStoreLogic() {
        System.out.println("1. Thêm sản phẩm vào Store | 2. Xóa sản phẩm khỏi Store");
        int op = scanner.nextInt(); 
        scanner.nextLine();
        if (op == 1) {
            System.out.print("Nhập tiêu đề sách mới: ");
            String title = scanner.nextLine();
            store.addMedia(new Book(title, "General", 10.0f));
        } else if (op == 2) {
            System.out.print("Nhập tiêu đề muốn xóa: ");
            Media m = store.searchByTitle(scanner.nextLine());
            if (m != null) store.removeMedia(m);
        }
    }

    public static void cartMenuLoop() {
        int choice;
        do {
            cart.printCart();
            System.out.println("\n--- CART OPTIONS ---");
            System.out.println("1. Filter medias in cart");
            System.out.println("2. Sort medias in cart");
            System.out.println("3. Remove media from cart");
            System.out.println("4. Play a media");
            System.out.println("5. Place order");
            System.out.println("0. Back");
            System.out.print("Vui lòng chọn (0-5): ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Lọc theo: 1. ID | 2. Title");
                    if (scanner.nextInt() == 1) {
                        System.out.print("Nhập ID: "); 
                        cart.searchById(scanner.nextInt());
                    } else {
                        scanner.nextLine(); 
                        System.out.print("Nhập Title: "); 
                        cart.searchByTitle(scanner.nextLine());
                    }
                    break;
                case 2:
                    System.out.println("Sắp xếp theo: 1. Title | 2. Cost");
                    if (scanner.nextInt() == 1) cart.sortByTitle();
                    else cart.sortByCost();
                    break;
                case 3:
                    System.out.print("Nhập tên sản phẩm muốn xóa khỏi giỏ: ");
                    Media m = cart.searchCartMedia(scanner.nextLine());
                    if (m != null) cart.removeMedia(m);
                    break;
                case 4:
                    System.out.print("Nhập tên thiết bị muốn phát: ");
                    Media p = cart.searchCartMedia(scanner.nextLine());
                    if (p instanceof Playable) ((Playable) p).play();
                    else System.out.println("Không phát được!");
                    break;
                case 5:
                    System.out.println("Đơn hàng đã được thiết lập thành công! Đang làm trống giỏ hàng...");
                    cart.clearCart();
                    break;
            }
        } while (choice != 0);
    }
}