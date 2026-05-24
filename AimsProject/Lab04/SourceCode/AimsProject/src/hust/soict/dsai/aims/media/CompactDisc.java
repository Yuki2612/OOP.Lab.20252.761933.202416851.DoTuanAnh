package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc {
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<Track>();

    public CompactDisc(String title, String category, String artist, float cost) {
        super(title, category, cost);
        this.artist = artist;
    }

    public String getArtist() {
        return artist;
    }

    // Thêm track vào CD
    public void addTrack(Track track) {
        if (tracks.contains(track)) {
            System.out.println("Track " + track.getTitle() + " đã tồn tại trong CD.");
        } else {
            tracks.add(track);
            System.out.println("Đã thêm track: " + track.getTitle());
        }
    }

    // Xóa track khỏi CD
    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Đã xóa track: " + track.getTitle());
        } else {
            System.out.println("Track " + track.getTitle() + " không có trong CD.");
        }
    }

    // Tổng chiều dài CD bằng tổng chiều dài các track
    @Override
    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }
}