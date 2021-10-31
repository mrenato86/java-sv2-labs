package enumtype.university;

public enum University {

    ELTE("Eötvös Loránd Tudományegyetem"), SZTE("Szegedi Tudományegyetem"),
    BME("Budapesti Műszaki és Gazdaságtudományi Egyetem"), PPKE("Pázmány Péter Katolikus Egyetem"),
    DE("Debreceni Egyetem"), SE("Semmelweis Egyetem"), PTE("Pécsi Tudományegyetem"),
    BCE("Budapesti Corvinus Egyetem");

    private final String name;

    University(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
