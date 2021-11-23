package algorithmsmax.sales;

import java.util.List;

public class Sales {

    public Salesperson selectSalesPersonWithMaxSalesAmount(List<Salesperson> sales) {
        if (sales == null) {
            return null;
        }
        Salesperson salespersonWithMaxAmount = sales.get(0);
        for (Salesperson salesperson : sales) {
            if (salesperson.getAmount() > salespersonWithMaxAmount.getAmount()) {
                salespersonWithMaxAmount = salesperson;
            }
        }
        return salespersonWithMaxAmount;
    }

    public Salesperson selectSalesPersonWithFurthestAboveTarget(List<Salesperson> sales) {
        if (sales == null) {
            return null;
        }
        Salesperson salespersonWithMaxAbove = sales.get(0);
        for (Salesperson salesperson : sales) {
            if (salesperson.getDiffFromTarget() >= 0 && salesperson.getDiffFromTarget() > salespersonWithMaxAbove.getDiffFromTarget()) {
                salespersonWithMaxAbove = salesperson;
            }
        }
        return salespersonWithMaxAbove;
    }

    public Salesperson selectSalesPersonWithFurthestBelowTarget(List<Salesperson> sales) {
        if (sales == null) {
            return null;
        }
        Salesperson salespersonWithMinBelow = sales.get(0);
        for (Salesperson salesperson : sales) {
            if (salesperson.getDiffFromTarget() < 0 && salesperson.getDiffFromTarget() < salespersonWithMinBelow.getDiffFromTarget()) {
                salespersonWithMinBelow = salesperson;
            }
        }
        return salespersonWithMinBelow;
    }

}
