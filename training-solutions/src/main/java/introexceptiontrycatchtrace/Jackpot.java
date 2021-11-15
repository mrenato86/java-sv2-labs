package introexceptiontrycatchtrace;

public class Jackpot {

    public static void main(String[] args) {
        Winner winner = new Winner();
        try {
            System.out.println(winner.getWinner());
        } catch (NullPointerException npe) {
            System.out.println("Error during drawing the winner!");
        }
    }
}
