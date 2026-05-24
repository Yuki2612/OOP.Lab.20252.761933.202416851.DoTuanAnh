package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    // Thuộc tính riêng của Sách: danh sách các tác giả
    private List<String> authors = new ArrayList<String>();

    public Book() {
        super();
    }

    public Book(String title, String category, float cost) {
        super(title, category, cost);
    }

    // Thêm tác giả (Nếu chưa có trong list thì mới thêm)
    public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            authors.add(authorName);
            System.out.println("Tác giả '" + authorName + "' đã được thêm vào sách: " + getTitle());
        } else {
            System.out.println("Tác giả '" + authorName + "' đã tồn tại sẵn.");
        }
    }

    // Xóa tác giả (Nếu tìm thấy trong list thì mới xóa)
    public void removeAuthor(String authorName) {
        if (authors.contains(authorName)) {
            authors.remove(authorName);
            System.out.println("Đã xóa tác giả '" + authorName + "' khỏi sách: " + getTitle());
        } else {
            System.out.println("Không tìm thấy tác giả '" + authorName + "' để xóa.");
        }
    }

    public List<String> getAuthors() {
        return authors;
    }

    // Ghi đè phương thức toString để in thông tin đẹp mắt hơn
    @Override
    public String toString() {
        return "Sách [ID: " + getId() + ", Tiêu đề: " + getTitle() + ", Thể loại: " + getCategory() + ", Tác giả: " + authors + ", Giá: " + getCost() + "$]";
    }
}