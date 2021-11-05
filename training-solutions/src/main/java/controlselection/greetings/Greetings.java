package controlselection.greetings;

public class Greetings {

    public String greet(int hours, int minutes){
        int inMinutes = 60 * hours + minutes;
        if (inMinutes > 300 && inMinutes <= 540){
            return "Good morning!";
        }else if (inMinutes > 540 && inMinutes <= 1110){
            return "Good day!";
        }else if (inMinutes > 1110 && inMinutes <= 1200){
            return "Good evening!";
        } else
            return "Good night!";
    }

}
