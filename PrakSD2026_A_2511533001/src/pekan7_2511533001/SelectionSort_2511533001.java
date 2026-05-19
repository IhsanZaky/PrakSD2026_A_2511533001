package pekan7_2511533001;

public class SelectionSort_2511533001 {
		public static void selectionSort_2511533001(int[] arr_3001) {
			int n_3001 = arr_3001.length;
			for(int i_3001 = 0; i_3001 < n_3001; i_3001++) {
				int minIndex_3001 = i_3001;
				for(int j_3001 = i_3001 + 1; j_3001 < n_3001; j_3001++) {
					if(arr_3001[j_3001] < arr_3001[minIndex_3001]) {
						minIndex_3001 = j_3001;
					}
				}
				int temp_3001 = arr_3001[i_3001];
				arr_3001[i_3001] = arr_3001[minIndex_3001];
				arr_3001[minIndex_3001] = temp_3001;
			}
		} 
		public static void main(String[] args) {
			int arr_3001[] = {23, 78, 45, 8, 32, 56, 1};
			int n_3001 = arr_3001.length;
			System.out.printf("array yang belum terurut:\n");
			for(int i_3001 = 0; i_3001 < n_3001; i_3001++)
				System.out.print(arr_3001[i_3001] + " ");
			System.out.println("");
			selectionSort_2511533001(arr_3001);
			System.out.printf("array yang terurut:\n");
			for(int i_3001=0; i_3001 < n_3001; i_3001++)
				System.out.print(arr_3001[i_3001] + " ");
			System.out.println("");
		}
	}