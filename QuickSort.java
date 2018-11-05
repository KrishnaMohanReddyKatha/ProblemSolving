
public class QuickSort {
public static  void main(String[] args) {
	int[] array = new int[10];
	array[0] = 5;array[1] = 7;array[2] = 9;array[3] = 2;array[4] = 6;
	array[5] = 1;array[6] = 3;array[7] = 4;array[8] = 8;array[9] = 0;
	quicksort(array,0,9);
	for(int item: array) {
		System.out.print(item + " ");
	}
	System.out.println();
}
public static void quicksort(int[] array, int p, int r) {
	if(p<r) {
		int q = Partition.partition(array, p, r);
		quicksort(array,p,q-1);
		quicksort(array,q+1,r);
	}
}
}
