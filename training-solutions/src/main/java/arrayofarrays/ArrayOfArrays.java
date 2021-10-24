package arrayofarrays;

public class ArrayOfArrays {

    public void printArrayOfArrays(int[][] a) {

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        ArrayOfArrays matrices = new ArrayOfArrays();

        matrices.printArrayOfArrays(new int[][]{{0, 1, 2}, {0, 1, 2}, {0, 1, 2}, {0, 1, 2}});

    }
}
