import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SongServiceProxy implements SongService {
    private SongService songService;
    private Map<Integer, Song> cacheById = new HashMap<>();

    public SongServiceProxy(SongService songService) {
        this.songService = songService;
    }
    @Override
    public Song searchById(Integer songID) {
        return cacheById.computeIfAbsent(songID, k -> songService.searchById(k));
    }
    @Override
    public List<Song> searchByTitle(String title) {
        return songService.searchByTitle(title);
    }
    @Override
    public List<Song> searchByAlbum(String album) {
        return songService.searchByAlbum(album);
    }
}
