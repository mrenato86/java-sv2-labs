package collectionsiterator;

public class ChristmasPresent {

    private String giftDescription;
    private String nameOfGifted;
    private int price;

    public ChristmasPresent(String giftDescription, String nameOfGifted, int price) {
        this.giftDescription = giftDescription;
        this.nameOfGifted = nameOfGifted;
        this.price = price;
    }

    public String getGiftDescription() {
        return giftDescription;
    }

    public String getNameOfGifted() {
        return nameOfGifted;
    }

    public int getPrice() {
        return price;
    }
}
