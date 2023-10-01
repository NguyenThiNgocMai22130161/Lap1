package tast_1;

import java.util.Arrays;

public class task1_3 {

	// This method is used to display a Pascal triangle based
	// on the parameter n.
	// Where n represents the number of rows
	public static void printPascalTriangle(int row) {
		for (int i = 1; i <= row; i++) {
			int[] c1 = getPascalTriangle(i);
			for (int j = 0; j < c1.length;  j++) {
				System.out.print(c1[j] + " ");
				
			}
			System.out.println();
		}
	}

	// get the nth row.
	// For example: n=1 ==> {1}, n=2 ==> {1, 1}, ...
	public static int[] getPascalTriangle(int n) {
		if (n == 1) {
			return new int[] { 1 };
		} else {
			int[] prevRow = getPascalTriangle(n - 1);
			return generateNextRow(prevRow); // tạo hàng hiện tại dựa trên hàng trước đó.
		}
	}

	// generate the next row based on the previous row
	// Ex. prevRow = {1} ==> nextRow = {1, 1}
	// Ex. prevRow = {1, 1} ==> nextRow = {1, 2, 1}
	public static int[] generateNextRow(int[] prevRow) {
		// đệ quy
		if (prevRow.length == 1) {
			return new int[] { 1, 1 }; // hàng thứ 2 của tam giác
		} else {
			int[] result = new int[prevRow.length + 1];
			result[0] = 1;
			result[result.length - 1] = 1;
			for (int i = 1; i < result.length - 1; i++) {
				result[i] = prevRow[i - 1] + prevRow[i];
			}
			return result;
		}
	}

	public static void main(String[] args) {
		// Test case: printPascalTriangle
		int numRows = 5;
		task1_3.printPascalTriangle(numRows);
		// test generateNextRow
		int[] n1 = { 1, 3, 3, 1 };
		int[] nextRow = task1_3.generateNextRow(n1);
		System.out.println(Arrays.toString(generateNextRow(n1)));
	}
}
