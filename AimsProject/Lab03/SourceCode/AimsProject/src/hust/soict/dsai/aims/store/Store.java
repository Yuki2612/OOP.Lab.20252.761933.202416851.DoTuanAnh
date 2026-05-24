package hust.soict.dsai.aims.store;

import java.util.ArrayList;
import hust.soict.dsai.aims.media.Media;

public class Store {

    // Thay thế mảng tĩnh bằng ArrayList động
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();

    // Đổi tên hàm và tham số sang kiểu Media
    public void addMedia(Media media) {
        if (!itemsInStore.contains(media)) {
            itemsInStore.add(media);
            System.out.println("Đã thêm '" + media.getTitle() + "' vào cửa hàng.");
        } else {
            System.out.println("Sản phẩm '" + media.getTitle() + "' đã có sẵn trong cửa hàng.");
        }
    }

    // Đổi tên hàm và tham số sang kiểu Media
    public void removeMedia(Media media) {
        if (itemsInStore.contains(media)) {
            itemsInStore.remove(media);
            System.out.println("Đã xóa '" + media.getTitle() + "' khỏi cửa hàng.");
        } else {
            System.out.println("Không tìm thấy '" + media.getTitle() + "' trong cửa hàng.");
        }
    }

    // Hàm in danh sách cửa hàng (bổ sung để tiện kiểm tra cho menu ở Bước 13)
    public void print() {
        System.out.println("***********************STORE***********************");
        System.out.println("Items in store:");
        for (int i = 0; i < itemsInStore.size(); i++) {
            System.out.println((i + 1) + ". " + itemsInStore.get(i).toString());
        }
        System.out.println("***************************************************");
    }
}