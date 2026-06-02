package pekan8_2511533001;

public class ShellSort_2511533001 {
    
    public static void ShellSort_2511533001(int[] A) {
        int n_3001 = A.length;
        int gap_3001 = n_3001 / 2;

        while (gap_3001 > 0) {
            for (int i_3001 = gap_3001; i_3001 < n_3001; i_3001++) {
                int temp_3001 = A[i_3001];
                int j_3001 = i_3001;

                while (j_3001 >= gap_3001 && A[j_3001 - gap_3001] > temp_3001) {
                    A[j_3001] = A[j_3001 - gap_3001];
                    j_3001 = j_3001 - gap_3001;
                }

                A[j_3001] = temp_3001;
            }

            gap_3001 = gap_3001 / 2;
        }
    }

    public static void main(String[] args) {
        int[] data_3001 = {3, 10, 4, 6, 8, 9, 7, 2, 1, 5};

        System.out.print("Sebelum : ");
        printArray_2511533001(data_3001);

        ShellSort_2511533001(data_3001);

        System.out.print("Sesudah (Shell Sort): ");
        printArray_2511533001(data_3001);
    }

    public static void printArray_2511533001(int[] arr) {
        for (int i_3001 : arr)
            System.out.print(i_3001 + " ");
        System.out.println();
    }
}