package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
    
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, cost, length, director);
    }

    @Override
    public void play() {
        System.out.println("--- PHÁT DVD: " + this.getTitle() + " ---");
        System.out.println("Đạo diễn: " + this.getDirector() + " | Thời lượng: " + this.getLength() + " min");
    }

    @Override
    public String toString() {
        return "DVD - " + getTitle() + " - " + getCategory() + " - Đạo diễn: " + getDirector() + " - Thời lượng: " + getLength() + " min: " + getCost() + " $";
    }
}