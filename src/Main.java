import java.util.List;
public class Main {
    public static void main(String[] args) {
        SongService realService = new SongServiceDataBase();
        SongService proxyService = new SongServiceProxy(realService);
        System.out.println("Searching by ID:");
        System.out.println(proxyService.searchById(1));
        System.out.println("\nSearching by Title:");
        List<Song> songsByTitle = proxyService.searchByTitle("Beautiful");
        songsByTitle.forEach(System.out::println);
        System.out.println("\nSearching by Album:");
        List<Song> songsByAlbum = proxyService.searchByAlbum("The Marshall Mathers LP");
        songsByAlbum.forEach(System.out::println);
        System.out.println("\nSecond call to Search by ID:");
        long startTime = System.currentTimeMillis();
        System.out.println(proxyService.searchById(1));
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken for cached call: " + (endTime - startTime) + "ms");
    }
}

