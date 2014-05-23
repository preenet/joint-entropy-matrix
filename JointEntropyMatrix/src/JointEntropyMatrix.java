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
	private Vector<JMF> jmf;

	
	public JointEntropyMatrix(Vector<Integer> X, Vector<Integer> Y) {
		this.X = X;
		this.Y = Y;
		this.jmf = new Vector<JMF>();

	}// end default constructor

	public void checkOccur() {
		
	}

}// end class JointEntropyMatrix
