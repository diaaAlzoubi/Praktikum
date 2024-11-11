package reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import business.Moebelhaus;

public class ConcreteCsvReaderProduct extends ReaderProduct {

	BufferedReader ein;
	
	public ConcreteCsvReaderProduct() {
		// TODO Auto-generated constructor stub
		
		try {
			ein= new BufferedReader(new FileReader("Moebelhaus.csv"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public String[] leseAusDatei() throws IOException {
		// TODO Auto-generated method stub
  			String[] zeile = ein.readLine().split(";");
  			ein.close();
	
		return zeile;
	}

	@Override
	public void schliesseDatei() throws IOException {
		// TODO Auto-generated method stub
		
		ein.close();
	}

	
	
}
