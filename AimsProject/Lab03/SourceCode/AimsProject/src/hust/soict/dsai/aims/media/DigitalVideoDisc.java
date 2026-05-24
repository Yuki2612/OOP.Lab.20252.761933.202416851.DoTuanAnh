package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
    private static int nbDigitalVideoDiscs = 0;

    public DigitalVideoDisc(String title) {
        super(title);
        nbDigitalVideoDiscs++;
        this.setId(nbDigitalVideoDiscs);
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        super(title, category, cost);
        nbDigitalVideoDiscs++;
        this.setId(nbDigitalVideoDiscs);
    }

    public DigitalVideoDisc(String title, String category, String director, float cost) {
        super(title, category, director, cost);
        nbDigitalVideoDiscs++;
        this.setId(nbDigitalVideoDiscs);
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, director, length, cost);
        nbDigitalVideoDiscs++;
        this.setId(nbDigitalVideoDiscs);
    }

    public boolean isMatch(String title) {
        return this.getTitle().toLowerCase().contains(title.toLowerCase());
    }

    @Override
    public String toString() {
        return "DVD - " + getTitle() + " - " + getCategory() + " - " + getDirector() + " - " + getLength() + ": " + getCost() + " $";
    }

    @Override
    public void play() {
        if (this.getLength() <= 0) {
            System.out.println("Không thể phát DVD: " + this.getTitle() + " do thời lượng không hợp lệ.");
            return;
        }
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }
}