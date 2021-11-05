package controlselection.accents;

public class WithoutAccents {

    public char stripAccent(char character) {
        String accented = "áéíóöőúüűÁÉÍÓÖŐÚÜŰ";
        String noAccent = "aeiooouuuAEIOOOUUU";
        int index = accented.indexOf(character);
        if (index >= 0) {
            return noAccent.charAt(index);
        }
        return character;
    }

}
