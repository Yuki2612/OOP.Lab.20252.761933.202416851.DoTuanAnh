package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.Media;
import java.util.ArrayList;
import java.util.Collections;

public class Cart {
    // Thay đổi từ mảng DVD[] cũ sang ArrayList<Media> xịn xò của Lab 04
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    public void addMedia(Media media) {
        if (!itemsOrdered.contains(media)) {
            itemsOrdered.add(media);
            System.out.println("Đã thêm \"" + media.getTitle() + "\" vào giỏ hàng thành công!");
        } else {
            System.out.println("Sản phẩm \"" + media.getTitle() + "\" đã tồn tại trong giỏ hàng.");
        }
    }

    public void removeMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println("Đã xóa \"" + media.getTitle() + "\" khỏi giỏ hàng.");
        } else {
            System.out.println("Không tìm thấy sản phẩm \"" + media.getTitle() + "\" trong giỏ hàng.");
        }
    }

    public float totalCost() {
        float sum = 0;
        for (Media media : itemsOrdered) {
            sum += media.getCost();
        }
        return sum;
    }

    public void clearCart() {
        itemsOrdered.clear();
    }

    public void searchById(int id) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                System.out.println("[Tìm thấy] " + media.toString());
                found = true;
            }
        }
        if (!found) System.out.println("Không tìm thấy sản phẩm nào có ID: " + id);
    }

    public void searchByTitle(String title) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                System.out.println("[Tìm thấy] " + media.toString());
                found = true;
            }
        }
        if (!found) System.out.println("Không tìm thấy sản phẩm nào có tiêu đề: " + title);
    }

    public void sortByTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
        printCart();
    }

    public void sortByCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
        printCart();
    }

    public Media searchCartMedia(String title) {
        for (Media media : itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(title)) return media;
        }
        return null;
    }

    public void printCart() {
        System.out.println("\n***********************GIỎ HÀNG CỦA BẠN***********************");
        for (Media media : itemsOrdered) {
            System.out.println("- " + media.toString());
        }
        System.out.println("Tổng chi phí: " + totalCost() + " $");
        System.out.println("**************************************************************");
    }
}