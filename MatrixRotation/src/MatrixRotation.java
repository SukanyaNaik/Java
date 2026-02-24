
public class MatrixRotation {

	public static void main(String[] args) {
		int [][]matrix = {{1,2,3},{4,5,6},{7,8,9}};
		rotate(matrix);
		
		int len = matrix.length;
		for(int i = 0; i < len; i++) {
			for(int j = 0; j < len; j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void rotate(int[][] matrix) {
		int len = matrix.length;
		int [][]result = new int[len][len];
		
		for(int i = 0, k = len-1; i < len; i++, k--) {
			for(int j = 0; j < len; j++) {
				result[j][k] = matrix[i][j];
			}
		}
		
		matrix = result;
    }

}
