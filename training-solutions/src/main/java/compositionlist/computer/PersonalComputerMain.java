package compositionlist.computer;

public class PersonalComputerMain {

    public static void main(String[] args) {
        Cpu cpu = new Cpu("Intel Core i7", 3.5);
        PersonalComputer pc = new PersonalComputer(cpu);

        pc.addHardware(new Hardware("Monitor", "LG 27"));
        pc.addHardware(new Hardware("Mouse", "Logitech M100"));
        pc.addHardware(new Hardware("Keyboard", "Logitech K100"));

        pc.addSoftware(new Software("Windows", 10.0));
        pc.addSoftware(new Software("Java Hotspot", 17.0));

        System.out.println(pc.getCpu());
        System.out.println(pc.getHardwares());
        System.out.println(pc.getSoftwares());

        System.out.println(pc);
    }

}
