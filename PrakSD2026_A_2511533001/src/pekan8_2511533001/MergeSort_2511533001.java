package pekan8_2511533001;

public class MergeSort_2511533001 {

    void merge_3001(int[] arr_3001, int l_3001, int m_3001, int r_3001) {
        // find sizes of two subarrays to be merged
        int n1_3001 = m_3001 - l_3001 + 1;
        int n2_3001 = r_3001 - m_3001;

        /* create temp arrays */
        int L_3001[] = new int[n1_3001];
        int R_3001[] = new int[n2_3001];

        /* copy data to temp arrays */
        for (int i_3001 = 0; i_3001 < n1_3001; ++i_3001)
            L_3001[i_3001] = arr_3001[l_3001 + i_3001];

        for (int j_3001 = 0; j_3001 < n2_3001; ++j_3001)
            R_3001[j_3001] = arr_3001[m_3001 + 1 + j_3001];

        int i_3001 = 0, j_3001 = 0;

        // initial index merged subarray array
        int k_3001 = l_3001;

        while (i_3001 < n1_3001 && j_3001 < n2_3001) {
            if (L_3001[i_3001] <= R_3001[j_3001]) {
                arr_3001[k_3001] = L_3001[i_3001];
                i_3001++;
            } else {
                arr_3001[k_3001] = R_3001[j_3001];
                j_3001++;
            }
            k_3001++;
        }

        /* copy remaining elements of L[] if any */
        while (i_3001 < n1_3001) {
            arr_3001[k_3001] = L_3001[i_3001];
            i_3001++;
            k_3001++;
        }

        /* copy remaining elements of R[] if any */
        while (j_3001 < n2_3001) {
            arr_3001[k_3001] = R_3001[j_3001];
            j_3001++;
            k_3001++;
        }
    }

    void sort_3001(int arr_3001[], int l_3001, int r_3001) {
        if (l_3001 < r_3001) {
            // find the middle point
            int m_3001 = (l_3001 + r_3001) / 2;

            // sort first and second halves
            sort_3001(arr_3001, l_3001, m_3001);
            sort_3001(arr_3001, m_3001 + 1, r_3001);

            // merge the sorted halves
            merge_3001(arr_3001, l_3001, m_3001, r_3001);
        }
    }

    /* a utility function to print array of size n */
    static void printArray_3001(int arr_3001[]) {
        int n_3001 = arr_3001.length;

        for (int i_3001 = 0; i_3001 < n_3001; ++i_3001)
            System.out.print(arr_3001[i_3001] + " ");

        System.out.println();
    }

    public static void main(String args[]) {
        int arr_3001[] = {12, 11, 13, 5, 6, 7};

        System.out.println("Sebelum terurut: ");
        printArray_3001(arr_3001);

        MergeSort_2511533001 ob_3001 = new MergeSort_2511533001();
        ob_3001.sort_3001(arr_3001, 0, arr_3001.length - 1);

        System.out.println("\nSesudah Terurut menggunakan merge sort");
        printArray_3001(arr_3001);
    }
}