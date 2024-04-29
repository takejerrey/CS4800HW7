import java.util.Map;
import java.util.HashMap;
public class CharacterPropertiesFactory {
    private static final Map<String, CharacterProperties> propertiesMap = new HashMap<>();

    public static CharacterProperties getCharacterProperties(String font, String color, int size) {
        String key = font + color + size;
        if (!propertiesMap.containsKey(key)) {
            propertiesMap.put(key, new CharacterProperties(font, color, size));
        }
        return propertiesMap.get(key);
    }
}
