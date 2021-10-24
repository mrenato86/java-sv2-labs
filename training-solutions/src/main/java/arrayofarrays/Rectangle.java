package arrayofarrays;

public class Rectangle {

    public int[][] rectangularMatrix(int size) {
        int[][] rectangular = new int[size][size];
        for (int i = 0; i < rectangular.length; i++) {
            for (int j = 0; j < rectangular[i].length; j++) {
                rectangular[i][j] = i;
            }
        }
        return rectangular;
    }

    public static void main(String[] args) {
        Rectangle rectangular = new Rectangle();
        int[][] testRectangle = rectangular.rectangularMatrix(10);

        for (int[] i : testRectangle) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
