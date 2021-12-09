package interfacerules.bill;

import java.util.List;

public class ComplexBillWriter implements BillWriter {

    @Override
    public String writeBill(List<String> billItems) {
        StringBuilder sb = new StringBuilder();
        for (String line : billItems) {
            String[] parts = line.split(";");
            int pieces = Integer.parseInt(parts[2]);
            int price = Integer.parseInt(parts[1]);
            sb.append(String.format("%s; darabszám: %d, egységár: %d, összesen: %d Ft", parts[0], pieces, price, (pieces * price))).append("\n");
        }
        return sb.toString();
    }
}
