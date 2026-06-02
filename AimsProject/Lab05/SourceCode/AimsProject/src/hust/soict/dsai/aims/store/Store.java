package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.media.Media;
import java.util.ArrayList;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();

    public void addMedia(Media media) {
        if (!itemsInStore.contains(media)) {
            itemsInStore.add(media);
            System.out.println("Đã thêm \"" + media.getTitle() + "\" vào cửa hàng.");
        } else {
            System.out.println("\"" + media.getTitle() + "\" đã tồn tại trong cửa hàng.");
        }
    }

    public void removeMedia(Media media) {
        if (itemsInStore.contains(media)) {
            itemsInStore.remove(media);
            System.out.println("Đã xóa \"" + media.getTitle() + "\" khỏi cửa hàng.");
        } else {
            System.out.println("Không tìm thấy sản phẩm.");
        }
    }

    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }

    public Media searchByTitle(String title) {
        for (Media media : itemsInStore) {
            if (media.getTitle().equalsIgnoreCase(title)) return media;
        }
        return null;
    }

    public void printStore() {
        System.out.println("\n--- DANH SÁCH CỬA HÀNG AIMS ---");
        for (Media media : itemsInStore) {
            System.out.println(media.getId() + ". " + media.toString());
        }
    }
}