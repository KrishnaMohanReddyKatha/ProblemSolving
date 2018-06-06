// program to find longest substring  with non repeating characters 
import java.util.*;
public class LongestNonReapeatingSubString {
public static void main(String[] args) {
	String str = "ABDEFGABEF";
	int[] result = findLongestNonRepeatingSubString(str);
	System.out.println("left Index : " + result[0]);
	System.out.println("right Index : "  + result[1]);
	System.out.println("maxLength : " + result[2]);
	System.out.println("Max Sub String : " + str.substring(result[0], result[1]+1));
}
public static int[] findLongestNonRepeatingSubString(String str) {
	int [] indices = new int[3];
	int j = 0;
	int i = 0;
	HashSet<Character> currentWindow = new HashSet<Character>();
	currentWindow.add(str.charAt(j));
	int leftIndex = i;
	int rightIndex = j;
	int maxLength = rightIndex - leftIndex + 1;
	j++;
	while(j < str.length()) {
		if(! currentWindow.contains(str.charAt(j))) {
			currentWindow.add(str.charAt(j));
		}
		else {
			while(str.charAt(i) != str.charAt(j)) {
				currentWindow.remove(str.charAt(i));
				i ++ ;
			}
			currentWindow.remove(str.charAt(i));
			i++;
			currentWindow.add(str.charAt(j));
		}
		if(maxLength < (j - i + 1)) {
			maxLength = (j - i) + 1;
			rightIndex = j;
			leftIndex = i;
		}
		j++;
	}
	indices[0] = leftIndex;
	indices[1] = rightIndex;
	indices[2] = maxLength;
	return indices;
}
}
