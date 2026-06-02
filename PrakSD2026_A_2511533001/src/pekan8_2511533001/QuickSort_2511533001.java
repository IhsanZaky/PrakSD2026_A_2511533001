package pekan8_2511533001;

public class QuickSort_2511533001 {
    
    static void swap_3001(int[] arr_3001, int i_3001, int j_3001) {
        int temp_3001 = arr_3001[i_3001];
        arr_3001[i_3001] = arr_3001[j_3001];
        arr_3001[j_3001] = temp_3001;
    }

    // metode tambahan untuk mengatur pivot menggunakan median of three
    static void medianOfThree_3001(int[] arr_3001, int low_3001, int high_3001) {
        int mid_3001 = low_3001 + (high_3001 - low_3001) / 2;

        // urutkan elemen low, mid, high
        if (arr_3001[low_3001] > arr_3001[mid_3001]) {
            swap_3001(arr_3001, low_3001, high_3001);
        }

        if (arr_3001[low_3001] > arr_3001[high_3001]) {
            swap_3001(arr_3001, low_3001, high_3001);
        }

        if (arr_3001[mid_3001] > arr_3001[high_3001]) {
            swap_3001(arr_3001, mid_3001, high_3001);
        }

        swap_3001(arr_3001, mid_3001, high_3001);
    }

    static int partition_3001(int[] arr_3001, int low_3001, int high_3001) {
        // panggil fungsi medianOfThree sebelum menentukan pivot
        medianOfThree_3001(arr_3001, low_3001, high_3001);

        int pivot_3001 = arr_3001[high_3001];
        int i_3001 = (low_3001 - 1);

        for (int j_3001 = low_3001; j_3001 <= high_3001 - 1; j_3001++) {
            // jika elemen saat ini lebih kecil dari pivot
            if (arr_3001[j_3001] < pivot_3001) {
                i_3001++;
                swap_3001(arr_3001, i_3001, j_3001);
            }
        }

        swap_3001(arr_3001, i_3001 + 1, high_3001);
        return (i_3001 + 1);
    }

    static void quickSort_2511533001(int[] arr_3001, int low_3001, int high_3001) {
        if (low_3001 < high_3001) {
            int pi_3001 = partition_3001(arr_3001, low_3001, high_3001);

            quickSort_2511533001(arr_3001, low_3001, pi_3001 - 1);
            quickSort_2511533001(arr_3001, pi_3001 + 1, high_3001);
        }
    }

    public static void printArr_3001(int[] arr_3001) {
        for (int i_3001 = 0; i_3001 < arr_3001.length; i_3001++) {
            System.out.print(arr_3001[i_3001] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr_3001[] = {10, 7, 8, 9, 1, 5};
        int n_3001 = arr_3001.length;

        System.out.print("Data sebelum diurutkan: ");
        printArr_3001(arr_3001);

        quickSort_2511533001(arr_3001, 0, n_3001 - 1);

        System.out.print("Data Terurut quicksort : ");
        printArr_3001(arr_3001);
    }
}