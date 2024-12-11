package accounts;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String accountDetailsFile = "src\\AccountDetails.csv";
		BufferedReader reader = null;
		String line = "";
		
		try {
			reader = new BufferedReader( new FileReader(accountDetailsFile));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while ((line = reader.readLine()) != null) {
				String [] row = line.split(",");
				for(String index: row) {
					System.out.printf("%-10s", index);
				}
				System.out.println();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	};
	

	}


