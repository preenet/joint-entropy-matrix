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
	private JMF myJMF;
	
	public JointEntropyMatrix(Vector<Integer> X, Vector<Integer> Y) {
		this.X = X;
		this.Y = Y;
		this.jmf = new Vector<JMF>();
		this.myJMF = null;
		
		displayX();
		
		displayY();
		
		calculateJMF();
		
	}// end default constructor

	public void calculateJMF() {
		// count frequency (occurrence) from the elements in X and Y
		
		for (int i = 0; i < X.size(); i++)
			for (int j = 0; j < Y.size(); j++) {
				// check if it is alright to insert into the array of object
				// 
				System.out.println("Checking (" +X.elementAt(i) +", " +Y.elementAt(j) + ")");
				if(isValidKey(X.elementAt(i), Y.elementAt(j))) {
					System.out.println("Key is valid (" +X.elementAt(i) +", " +Y.elementAt(j) + ")");
					myJMF = new JMF(X.elementAt(i), Y.elementAt(j));
					myJMF.increment();
					jmf.add(myJMF);
					System.out.println("Added to JMF array");
					displayJMF();
				}
				
				// in this case it is already exist in the array of object
				// so, we just get the index of that object and increment the frequency attribute
				// by one.
				else {
					System.out.println("Key is existed, incrementing.");
					System.out.println("(" + X.elementAt(i) + ", " + Y.elementAt(j) +")");
					jmf.elementAt(getKey(X.elementAt(i), Y.elementAt(j))).increment();;
				}
			}
		calculateProbability();
		displayJMF();
	}
	
	private void calculateProbability() {
		
		// find the total of possible outcome.
		int possibleOutcome = 0;
		for (int i = 0; i < jmf.size(); i++) 
			possibleOutcome += jmf.elementAt(i).getFrequency();
		
		for (int i = 0; i < jmf.size(); i++)
			jmf.elementAt(i).setProbability((double) jmf.elementAt(i).getFrequency() / possibleOutcome);
	}
	
	private boolean isValidKey(int x, int y) {
		
		System.out.println("isValid (" + x + ", " +y +")");
		if(jmf.size() == 0)
			return true;
		
		for(int i = 0; i < jmf.size(); i++) {
			if(jmf.elementAt(i).getX() == x && jmf.elementAt(i).getY() == y)
				return false;
		}
		return true;
	}
	
	private int getKey(int x, int y) {
		for (int i = 0; i < jmf.size(); i++) {
			if(jmf.elementAt(i).getX() == x && jmf.elementAt(i).getY() == y)
				return i;
		}
		return -1;
	}
	
	public void displayX() {
		System.out.println("X: ");
		for (int i = 0; i < X.size(); i++)
			System.out.println(X.elementAt(i));
		System.out.println();
	}
	
	public void displayY() {
		System.out.println("Y: ");
		for (int i = 0; i < Y.size(); i++)
			System.out.println(Y.elementAt(i));
		System.out.println();
	}

	public void displayJMF() {
		System.out.println("JMF: ");
		for(int i = 0; i < jmf.size(); i++)
			System.out.println(jmf.elementAt(i));
		System.out.println();
	}
}// end class JointEntropyMatrix
