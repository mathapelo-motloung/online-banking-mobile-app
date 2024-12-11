package accounts;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import accounts.Account.AccountBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

public class Controller {
	
	private List<Account> accounts;

    public Controller() {
        this.accounts = new ArrayList<>();
    }
	
	
	private static Account parse (String data) throws IllegalArgumentException{

		String  [] row = data.split(",");
		if (row.length != 6) throw new IllegalArgumentException("Invalid CSV format");
		
		AccountBuilder builder = new AccountBuilder();
		builder.accountNumber = Integer.parseInt(row[0]);
		builder.routingNumber = Integer.parseInt(row[1]);
		builder.accountNickname = row[2];
		builder.currentBalance = Double.parseDouble(row[3]);
		builder.earlyDirectDeposit = row[4];
		builder.overdraftTransfer = row[5];
		builder.overdraftProtection = row [6];
		builder.accountType = row[7];
		Account account = new Account(builder);
		return account;
}

	
	public static void read(List<Account> list, String inputLocation) throws FileNotFoundException{
		
		String accountDetailsFile = "/AccountDetails.csv";
		BufferedReader reader = null;
		String line = null;
		
		try {
			reader = new BufferedReader( new FileReader(accountDetailsFile));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			while ((line = reader.readLine()) != null) {
				//String  [] row = line.split(",");
				Account account=parse(line);
				list.add(account);
				for(Account item: list) {
					System.out.printf("%-10s", item);
				}
				System.out.println();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	};
	
	public static void writeInOrder(List<Account> list, String location) throws FileNotFoundException {
	    // Sort the list of accounts
	    list.sort(Comparator.comparing((Account account) -> account.getAccountOwner().getName())
	            .thenComparingInt(account -> account.getAccountOwner().getAge())
	            .thenComparingDouble(Account::getCurrentBalance));

	    // Write sorted accounts to the file
	    try (PrintWriter writer = new PrintWriter(location)) {
	        // Write the CSV header
	        writer.println("AccountNumber,RoutingNumber,Nickname,Balance,AccountType");

	        // Write each account in CSV format
	        for (Account account : list) {
	            writer.println(account.toFile());
	        }
	    }
	}

    public void transfer(Account sender, Account receiver, double amount) {
        if (sender.withdraw(amount)) {
            receiver.deposit(amount);
        }
    }
	
}
