/**
 * 
 * @author Pree
 *
 */
public class JMF {
	private int x;
	private int y;
	private int frequency;
	private double probability;
	
	public JMF() {
		
	}
	
	public JMF(int x, int y) {
		this.x = x;
		this.y = y;
		this.frequency = 0;
		this.probability = 0.0;
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return the frequency
	 */
	public int getFrequency() {
		return frequency;
	}

	/**
	 * @param frequency the frequency to set
	 */
	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	/**
	 * @return the probability
	 */
	public double getProbability() {
		return probability;
	}

	/**
	 * @param probability the probability to set
	 */
	public void setProbability(double probability) {
		this.probability = probability;
	}
	
	public void increment() {
		this.frequency++;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "JMF [x=" + x + ", y=" + y + ", frequency=" + frequency
				+ ", probability=" + probability + "]";
	}
	
}// end class
