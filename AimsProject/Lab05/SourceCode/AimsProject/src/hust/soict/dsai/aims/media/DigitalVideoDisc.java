package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable {
    
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, cost, length, director);
    }

    @Override
    public void play() throws PlayerException {
        if (this.getLength() <= 0) {
            throw new PlayerException("ERROR: DVD length is non-positive!");
        }
        System.out.println("--- PHÁT DVD: " + this.getTitle() + " ---");
        System.out.println("Đạo diễn: " + this.getDirector() + " | Thời lượng: " + this.getLength() + " min");
    }

    @Override
    public String toString() {
        return "DVD - " + getTitle() + " - " + getCategory() + " - Đạo diễn: " + getDirector() + " - Thời lượng: " + getLength() + " min: " + getCost() + " $";
    }
}