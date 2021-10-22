package statements;

public class Investment {

    private double cost = 0.3;
    private int fund;
    private int interestRate;
    private boolean active = true;

    public Investment(int fund, int interestRate) {
        this.fund = fund;
        this.interestRate = interestRate;
    }

    public int getFund() {
        return fund;
    }

    public double getYield(int days){
        return days * (fund * (interestRate/100.)/365);
    }

    public double close(int days){
        double payment = active ? (fund + getYield(days)) * (1-cost/100) : 0.;
        active = false;
        return payment;

        //Alternative:
        /*if(active) {
            active = false;
            return (fund + getYield(days)) * (1-cost/100);
        }
        return 0.;*/
    }
}
