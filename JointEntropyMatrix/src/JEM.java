
/**
 * 
 * @author pthiengburanathum
 *
 */

import java.io.IOException;
import java.util.Vector;

public class JEM {
	public static void main(String args[]) {

		
		System.out.println("Starting Joint Entropy Matrix...");
		
		ExternalFile myExtFile;
		String dataLine = "";
		Vector<Integer> X;
		Vector<Integer> Y;
		
		X = new Vector<Integer>();
		Y = new Vector<Integer>();
		
		JointEntropyMatrix myJEM;
		
		try {
			myExtFile = new ExternalFile("X.dat");
			dataLine = myExtFile.getLine();
			X.addElement(Integer.parseInt(dataLine));
			while(!myExtFile.havehitEOF()) {
				dataLine = myExtFile.getLine();
				X.addElement(Integer.parseInt(dataLine));
			}
			
			myExtFile = new ExternalFile("Y.dat");
			dataLine = myExtFile.getLine();
			Y.addElement(Integer.parseInt(dataLine));
			while(!myExtFile.havehitEOF()) {
				dataLine = myExtFile.getLine();
				Y.addElement(Integer.parseInt(dataLine));
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Size of input: " + X.size());
		System.out.println("Size of input: " + Y.size());
		
		myJEM = new JointEntropyMatrix(X, Y);
		
		System.out.println("Done!...");
	}
}// end class
