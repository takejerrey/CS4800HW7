import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SongServiceDataBase implements SongService {
    private List<Song> songs = new ArrayList<>();
    public SongServiceDataBase() {
        songs.add(new Song(1, "Lose Yourself", "Eminem", "8 Mile", 321));
        songs.add(new Song(2, "The Real Slim Shady", "Eminem", "The Marshall Mathers LP", 284));
        songs.add(new Song(3, "Stan", "Eminem", "The Marshall Mathers LP", 366));
        songs.add(new Song(4, "Without Me", "Eminem", "The Eminem Show", 290));
        songs.add(new Song(5, "Mockingbird", "Eminem", "Encore", 250));
        songs.add(new Song(6, "Beautiful", "Eminem", "Relapse", 390));
        songs.add(new Song(7, "Rap God", "Eminem", "The Marshall Mathers LP 2", 363));
        songs.add(new Song(8, "Love the Way You Lie", "Eminem", "Recovery", 263));
        songs.add(new Song(9, "Not Afraid", "Eminem", "Recovery", 240));
        songs.add(new Song(10, "Killshot", "Eminem", "Single", 253));
    }
    @Override
    public Song searchById(Integer songID) {
        simulateDelay();
        return songs.stream()
                .filter(song -> song.getId().equals(songID))
                .findFirst()
                .orElse(null);
    }
    @Override
    public List<Song> searchByTitle(String title) {
        simulateDelay();
        return songs.stream()
                .filter(song -> song.getTitle().equalsIgnoreCase(title))
                .collect(Collectors.toList());
    }
    @Override
    public List<Song> searchByAlbum(String album) {
        simulateDelay();
        return songs.stream()
                .filter(song -> song.getAlbum().equalsIgnoreCase(album))
                .collect(Collectors.toList());
    }
    private void simulateDelay() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
