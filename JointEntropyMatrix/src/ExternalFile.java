/**
 * @pthinegburanathum
 */
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExternalFile {
 
    	private BufferedReader extFile;
 
    	public ExternalFile(String ext_file) throws IOException {
    		extFile = new BufferedReader(new InputStreamReader(new FileInputStream(ext_file)));
    	}
 
    	public String getLine() throws IOException {
    		return extFile.readLine();
    	}
 
    	public boolean havehitEOF() throws IOException {
    		return !extFile.ready();
    	}
 
    	public void close() throws IOException {
    		extFile.close();
    	}

} // end class ExternalFile

