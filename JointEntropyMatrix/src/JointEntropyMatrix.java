/**
 * 
 * @author pthiengburanathum
 * 1)Initialisation of the n*m matrix 
 * 2)Count occurrence of each base pair in this pair of columns
 * 3)Calculate total number of base pairs  
 * 4)Loop through the different base pair types (e.g. A:A, A:C, A:G, etc.)
 * 5)Compute the frequency of a given base pair
 * 6)Add new entropy term to the total joint entropy
 */

import java.util.Vector;


public class JointEntropyMatrix {
	private Vector<Integer> X;
	private Vector<Integer> Y;
	private int[][] matrix;
	
	public JointEntropyMatrix(Vector<Integer> X, Vector<Integer> Y) {
		this.X = X;
		this.Y = Y;
		this.matrix = new int[X.size()][Y.size()];
		
		initMatrix();
		showMatrix();
		
	}// end default constructor
	
	private void initMatrix() {
		for(int i = 0; i < X.size(); i++)
			for(int j = 0; j < Y.size(); j++) {
				matrix[i][j] = 0;
			}
	}
	
	private void occurrence() {
		
	}
	
	public void showMatrix() {
		for(int i = 0; i < X.size(); i++)
			for(int j = 0; j < Y.size(); j++) {
				System.out.print(matrix[i][j] + " ");
				if(j == Y.size()-1)
					System.out.println();
			}
		System.out.println();
	}

}// end class JointEntropyMatrix
