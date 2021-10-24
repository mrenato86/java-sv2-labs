package arrayofarrays;

public class Triangular {

    public int[][] triangularMatrix(int size) {
        int[][] triangular = new int[size][];
        for (int i = 0; i < triangular.length; i++) {
            triangular[i] = new int[i + 1];
            for (int j = 0; j < triangular[i].length; j++) {
                triangular[i][j] = i;
            }
        }
        return triangular;
    }

    public static void main(String[] args) {
        Triangular triangular = new Triangular();
        int[][] testTriangular = triangular.triangularMatrix(10);

        for (int[] i : testTriangular) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

}
