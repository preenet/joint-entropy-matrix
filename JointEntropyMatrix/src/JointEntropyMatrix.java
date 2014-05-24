/**
 * 
 * @author pthiengburanathum
 */

import java.util.Vector;


public class JointEntropyMatrix {
	private Vector<Integer> X;
	private Vector<Integer> Y;
	private Vector<JMF> jmf;
	private JMF myJMF;
	private double jointEntropy;
	private double totalProb;
	
	public JointEntropyMatrix(Vector<Integer> X, Vector<Integer> Y) {
		this.X = X;
		this.Y = Y;
		this.jmf = new Vector<JMF>();
		this.myJMF = null;
		this.jointEntropy = 0.0;
		this.totalProb = 0.0;
		calculateJMF();
	}// end default constructor

	public void calculateJMF() {
		// count frequency (occurrence) from the elements in X and Y
		for (int i = 0; i < X.size(); i++) {
				// check if it is alright to insert into the array of object
				
				if(isValidKey(X.elementAt(i), Y.elementAt(i))) {
					myJMF = new JMF(X.elementAt(i), Y.elementAt(i));
					myJMF.increment();
					jmf.add(myJMF);
				}
				// in this case it is already exist in the array of object
				// so, we just get the index of that object and increment the frequency attribute
				// by one.
				else 
					jmf.elementAt(getKey(X.elementAt(i), Y.elementAt(i))).increment();;	
		}
		calculateProbability();
		displayJMF();
	}
	
	private void calculateProbability() {
		for (int i = 0; i < jmf.size(); i++)
			jmf.elementAt(i).setProbability(jmf.elementAt(i).getFrequency() / X.size());
	}
	
	public void calculateJointEntropy() {
		  /*H(X,Y) = - sumx sumy p(xy) log p(xy)*/
		for (int i = 0; i < jmf.size(); i++)
			jointEntropy -= jmf.elementAt(i).getProbability() * logBaseTwo(jmf.elementAt(i).getProbability());
	}
	
	public void calculateTotalProbability() {
		for (int i = 0; i < jmf.size(); i++)
			totalProb += jmf.elementAt(i).getProbability();
	}
	
	private boolean isValidKey(int x, int y) {
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
	
	private double logBaseTwo(double x) {
	    return Math.log(x) / Math.log(2);
	}
	
	public void displayJMF() {
		for(int i = 0; i < jmf.size(); i++)
			System.out.println(jmf.elementAt(i));
		System.out.println();
	}
	
	public double getJointEntropy() {
		return this.jointEntropy;
	}
	
	public double getTotalProbability() {
		return this.totalProb;
	}
}// end class JointEntropyMatrix
