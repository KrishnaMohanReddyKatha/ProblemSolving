
public class MaximumSubArray {
public static void main(String[] args) {
	int[] array = new int[8];
	int[] result = new int[3];
	array[0] = -2;array[1] = -5;array[2] = 6;array[3] = -2;array[4] = -3;
	array[5] = 1;array[6] = 5;array[7] = -6;
	result = MaxSubArray(array,0,7);
	System.out.println(result[0] + " " + result[1] + " " + result[2]);
}
public static int[] MaxSubArray(int[] array, int p, int r) {
	int[] result = new int[3];
	if(p==r) {
		result[0] = p;
		result[1] = r;
		result[2] = array[p];
		return result;
	}
	else {
		int q = (p + r)/2;
		int[] left = MaxSubArray(array,p, q);
		int[] right = MaxSubArray(array,q+1,r);
		int [] cross = MaxCrossSubArray(array, p, q, r);
		/*System.out.println("left : "+ left[0] + " " + left[1] + " "+ left[2]);
		System.out.println("right : "+ right[0] + " " + right[1] + " "+ right[2]);
		System.out.println("cross : "+ cross[0] + " " + cross[1] + " "+ cross[2]);*/
		if(left[2] >= right[2] && right[2] >= cross[2]) {
			result = left;
		}
		else if(right[2] >= left[2] && left[2] >= cross[2]) {
			result = right;
		}
		else {
			result = cross;
		}
		return result;
	}
}

public static int[] MaxCrossSubArray(int[] array, int p, int q, int r) {
	int[] result = new int[3];
	int i = q;
	int leftIndex = i;
	int leftSum = array[i];
	int leftMaxSum = leftSum;
	i = i-1;
	while(i >=p) {
		leftSum+=array[i];
		if(leftSum > leftMaxSum ) {
			leftMaxSum = leftSum;
			leftIndex = i;
		}
		i--;
	}
	
	int j = q+1;
	int rightIndex = j;
	int rightSum = array[q+1];
	int rightMaxSum = rightSum;
	j+=1;
	while(j<=r) {
		rightSum+=array[j];
		if(rightSum > rightMaxSum) {
			rightMaxSum = rightSum;
			rightIndex = j;
		}
		j++;
	}
	result[0] = leftIndex;
	result[1] = rightIndex;
	result[2] = leftMaxSum + rightMaxSum;
	return result;
}
}
