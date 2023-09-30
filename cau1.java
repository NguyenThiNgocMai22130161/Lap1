package lap_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class cau1 {
private int[] array;
public cau1 (int[] array) {
	this.array = array;
}
// Method mirror that outputs the contents of an array in a
// reverse order like a mirror
// Example: input [1, 2, 3] ==> output: [1, 2, 3, 3, 2, 1]
	public int[] mirror() {
		int[] result = new int[array.length*2];
		int mirrorIndex = result.length-1;
		for (int i=0 ;i < array.length; i++) {
			result [i] = array[i];
			result[mirrorIndex--]=array[i];
		}
		
		return result;
		
	}
	// removes all duplicate elements from an array and returns a
		// new array
		// Input: {2,2,3,4,5,7,3,4}
		// Output: {2,3,4,5,7}
		public int[] removeDuplicates() {
			Arrays.sort(array);
			int countElement = 0;
			int[] arrNewDuplicate = new int[array.length - 3];
			arrNewDuplicate[0] = array[0];

			for (int i = 1; i < array.length; i++) {
				boolean isDuplicate = false;
				for (int j=1;j<countElement;j++) {
					if (arrNewDuplicate[j]==array[i]) {
						isDuplicate=true;
						break;
					}
				}
				if(!isDuplicate) {
					arrNewDuplicate[countElement++]= array[i];
				}
			}
			return arrNewDuplicate;
			
		}
		//task1_2:
		// Input: 10 11 12 13 14 16 17 19 20 
		// Output: 15 18
		public int[] getMissingValues() {
			 List<Integer> missingValues = new ArrayList<>();
			 int minValue = array[0];
		     int maxValue = array[array.length - 1];
		     for (int i = array[0] + 1; i < array[array.length - 1]; i++) {
		         boolean found = false;
		         for (int j = 0; j < array.length; j++) {
		             if (array[j] == i) {
		                found = true;
		                break;
		                }
		            }
		            if (!found) {
		                missingValues.add(i);
		            }
		        }

		        int[] result = new int[missingValues.size()];
		        for (int i = 0; i < missingValues.size(); i++) {
		            result[i] = missingValues.get(i);
		        }
		return result; }
		
	public static void main (String[] args) {
		int[] array = {1,2,3};
		cau1 myArray= new cau1(array);
		int[] mirror = myArray.mirror();
		System.out.println(Arrays.toString(mirror));
		
		int [] arrayDuplicate = {2,2,3,4,5,7,3,4 };
		cau1 myArrDuplicate = new cau1(arrayDuplicate);
		int[] arrNewDuplicate = myArrDuplicate.removeDuplicates();
		System.out.println(Arrays.toString(arrNewDuplicate));
	
		int[] array2 = {10, 11, 12, 13, 14, 16, 17, 19, 20};
        cau1 myArray2= new cau1(array2);
        int[] missingValues = myArray2.getMissingValues();
        System.out.print("Missing Values: ");
        for (int value : missingValues) {
            System.out.print(value + " ");
        }
	}
		
	}
	


