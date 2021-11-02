package stringmethods.filename;

public class FileNameManipulator {

    public char findLastCharacter(String str) {
        str = str.strip();
        return str.charAt(str.length() - 1);
    }

    public String findFileExtension(String fileName) {
        fileName = fileName.strip();
        return fileName.substring(fileName.lastIndexOf('.'));
    }

    public boolean identifyFilesByExtension(String ext, String fileName) {
        ext = ext.strip();
        fileName = fileName.strip();
        return fileName.endsWith(ext);
    }

    public boolean compareFilesByName(String searchedFileName, String actualFileName) {
        return searchedFileName.strip().equalsIgnoreCase(actualFileName.strip());
    }

    public String changeExtensionToLowerCase(String fileName) {
        fileName = fileName.strip();
        int extStart = fileName.lastIndexOf('.') + 1;
        return fileName.substring(0, extStart) + fileName.substring(extStart).toLowerCase();
    }

    public String replaceStringPart(String fileName, String present, String target) {
        return fileName.strip().replace(present, target);
    }

    public static void main(String[] args) {
        FileNameManipulator fnm = new FileNameManipulator();
        System.out.println("findLastCharacter:");
        System.out.println(fnm.findLastCharacter("  program.exe  \n"));

        System.out.println("\nfindFileExtension:");
        System.out.println(fnm.findFileExtension("\n program.exe   "));

        System.out.println("\nidentifyFilesByExtension:");
        System.out.println(fnm.identifyFilesByExtension("dat ", "info.dat\n"));
        System.out.println(fnm.identifyFilesByExtension("dat ", "program.exe \n"));

        System.out.println("\ncompareFilesByName:");
        System.out.println(fnm.compareFilesByName("Program.EXE \n", "program.exe"));
        System.out.println(fnm.compareFilesByName("info.dat \n", "program.exe"));

        System.out.println("\nchangeExtensionToLowerCase:");
        System.out.println(fnm.changeExtensionToLowerCase("PROGRAM.EXE"));

        System.out.println("\nreplaceStringPart:");
        System.out.println(fnm.replaceStringPart("long name of it.dat", " ", "_"));
        System.out.println(fnm.replaceStringPart("picture.png", "jpeg", "jpg"));
        System.out.println(fnm.replaceStringPart("picture.jpeg", "jpeg", "jpg"));

    }

}
