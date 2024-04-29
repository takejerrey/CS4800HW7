
public class TextEditor {
    public static void main(String[] args) {
        CharacterProperties charProp1 = CharacterPropertiesFactory.getCharacterProperties("Arial", "Red", 12);
        CharacterProperties charProp2 = CharacterPropertiesFactory.getCharacterProperties("Calibri", "Blue", 14);
        CharacterProperties charProp3 = CharacterPropertiesFactory.getCharacterProperties("Verdana", "Black", 16);
        System.out.println(charProp1);
        System.out.println(charProp2);
        System.out.println(charProp3);
    }
}
