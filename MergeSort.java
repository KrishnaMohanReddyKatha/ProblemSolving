public class MergeSort {
public static void main(String[] args) {
	int[] array = new int[10];
	array[0] = 5;array[1] = 7;array[2] = 9;array[3] = 2;array[4] = 6;
	array[5] = 1;array[6] = 3;array[7] = 4;array[8] = 8;array[9] = 0;
	Mergesort(array,0,9);
	System.out.print("final array : ");
	for(int i = 0; i< array.length; i++) {
		System.out.print(array[i] + " ");
	}
	System.out.println();
}
public static void Mergesort(int[] array,int p, int r) {
	if(p<r) {
		int q = (p+r)/2;
		Mergesort(array,p,q);
		Mergesort(array,q+1,r);
		Merge(array,p,q,r);
	}
}
public static void Merge(int[] array, int p, int q, int r) {
	int[] leftarray = new int[q-p+1];
	int[] rightarray = new int[r-q];
	int index = 0;
	for(int i= p ; i <= q ; i++) {
		leftarray[index] = array[i];
		index++;
	}
	index = 0;
	for(int i= q+1 ; i <= r ; i++) {
		rightarray[index] = array[i];
		index++;
	}
	
	int i = 0;
	int j = 0;
	index  = p;
	while(i<leftarray.length && j < rightarray.length) {
		if(leftarray[i] <= rightarray[j])
		{
			array[index] = leftarray[i];
			i++;
		}
		else {
			array[index] = rightarray[j];
			j++;
		}
		index++;
	}
		while(j < rightarray.length) {
			array[index] = rightarray[j];
			j++;
			index++;
		}

		while(i < leftarray.length) {
			array[index] = leftarray[i];
			i++;
			index++;
		}
  }
}
