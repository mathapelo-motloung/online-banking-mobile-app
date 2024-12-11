package accounts;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class Account implements Comparable<Account> {

	int accountNumber;
	int routingNumber;
	String accountNickname;
	double currentBalance;
	String earlyDirectDeposit;
	String overdraftTransfer;
	String overdraftProtection;
	String accountType;
	Date dateOpened;
	Date nextStatementDate;
	Owner accountOwner;
	Transaction currentTransaction;
	
	Account (AccountBuilder builder) {
		
		
        this.accountNumber = builder.accountNumber;
        this.routingNumber = builder.routingNumber;
        this.accountNickname = builder.accountNickname;
        this.currentBalance = builder.currentBalance;
        this.accountType = builder.accountType;
        this.earlyDirectDeposit = builder.earlyDirectDeposit;
		this.overdraftTransfer = builder.overdraftTransfer;
		this.overdraftProtection = builder.overdraftProtection;
        this.accountOwner = builder.accountOwner;
    }

	// Builder Class
	public static class AccountBuilder {
		int accountNumber;
		int routingNumber;
		String accountNickname;
		double currentBalance;
		String earlyDirectDeposit;
		String overdraftTransfer;
		String overdraftProtection;
		String accountType;
		Owner accountOwner;

		
		public AccountBuilder accountNumber(int accountNumber) {
			this.accountNumber = accountNumber;
			return this;
		}

		public AccountBuilder routingNumber(int routingNumber) {
			this.routingNumber = routingNumber;
			return this;
		}

		public AccountBuilder accountNickname(String accountNickname) {
			this.accountNickname = accountNickname;
			return this;
		}

		public AccountBuilder currentBalance(double currentBalance) {
			this.currentBalance = currentBalance;
			return this;
		}

		public AccountBuilder earlyDirectDeposit(String earlyDirectDeposit) {
			this.earlyDirectDeposit = earlyDirectDeposit;
			return this;
		}

		public AccountBuilder overdraftTransfer(String overdraftTransfer) {
			this.overdraftTransfer = overdraftTransfer;
			return this;
		}

		public AccountBuilder overdraftProtection(String overdraftProtection) {
			this.overdraftProtection = overdraftProtection;
			return this;
		}

		public AccountBuilder accountType(String accountType) {
			this.accountType = accountType;
			return this;
		}
		public AccountBuilder accountOwner(Owner accountOwner) {
			this.accountOwner = accountOwner;
			return this;
		}
		
		public Account build() {
	        return new Account(this);
	    }
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public int getRoutingNumber() {
		return routingNumber;
	}

	public void setRoutingNumber(int routingNumber) {
		this.routingNumber = routingNumber;
	}

	public String getAccountNickname() {
		return accountNickname;
	}

	public void setAccountNickname(String accountNickname) {
		this.accountNickname = accountNickname;
	}

	public double getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(double currentBalance) {
		this.currentBalance = currentBalance;
	}

	public String getEarlyDirectDeposit() {
		return earlyDirectDeposit;
	}

	public void setEarlyDirectDeposit(String earlyDirectDeposit) {
		this.earlyDirectDeposit = earlyDirectDeposit;
	}

	public String getOverdraftTransfer() {
		return overdraftTransfer;
	}

	public void setOverdraftTransfer(String overdraftTransfer) {
		this.overdraftTransfer = overdraftTransfer;
	}

	public String getOverdraftProtection() {
		return overdraftProtection;
	}

	public void setOverdraftProtection(String overdraftProtection) {
		this.overdraftProtection = overdraftProtection;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public Date getDateOpened() {
		return dateOpened;
	}

	public void setDateOpened(Date dateOpened) {
		this.dateOpened = dateOpened;
	}

	public Date getNextStatementDate() {
		return nextStatementDate;
	}

	public void setNextStatementDate(Date nextStatementDate) {
		this.nextStatementDate = nextStatementDate;
	}

	public Owner getAccountOwner() {
		return accountOwner;
	}

	public void setAccountOwner(Owner accountOwner) {
		this.accountOwner = accountOwner;
	}

	public Transaction getCurrentTransaction() {
		return currentTransaction;
	}

	public void setCurrentTransaction(Transaction currentTransaction) {
		this.currentTransaction = currentTransaction;
	}

	public void deposit(double amount) {
		if (amount > 0) {
			currentBalance += amount; // Increase the balance by the deposit amount
			System.out.println("Deposited $" + amount + ". New balance: $" + currentBalance);
		} else {
			System.out.println("Invalid deposit amount. Amount must be greater than 0.");
		}
	}

	public void withdraw(double amount) {
		if (amount > 0) {
			if (amount <= currentBalance) {
				currentBalance -= amount; // Decrease the balance by the withdrawal amount
				System.out.println("Withdrew $" + amount + ". New balance: $" + currentBalance);
			} else {
				System.out.println("Insufficient balance for withdrawal.");
			}
		} else {
			System.out.println("Invalid withdrawal amount. Amount must be greater than 0.");
		}
	}

	public String toCSV() {
		return accountNumber + ","+ 
			   routingNumber + ","+ 
			   accountNickname  + ","+
			   currentBalance  + ","+
			   earlyDirectDeposit  + ","+
			   overdraftTransfer  + ","+
			   overdraftProtection  + ","+
			   accountType  + ","+
			   dateOpened  + ","+
			   nextStatementDate  + ","+
			   accountOwner  + ","+
			   currentTransaction;
	}

	// Static method to write multiple accounts to a file in CSV format
	public static void toFile(List<Account> accounts, String fileName) {
		try (FileWriter writer = new FileWriter(fileName)) {
			// Write header (optional)
			writer.append("Account Number,Account Holder Name,Balance\n");
			// Write each account's data in CSV format
			for (Account account : accounts) {
				writer.append(account.toCSV());
				writer.append("\n");
			}
			System.out.println("Data successfully written to " + fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return Objects.equals(accountNickname, other.accountNickname) && accountNumber == other.accountNumber
				&& Objects.equals(accountOwner, other.accountOwner) && Objects.equals(accountType, other.accountType)
				&& Double.doubleToLongBits(currentBalance) == Double.doubleToLongBits(other.currentBalance)
				&& Objects.equals(currentTransaction, other.currentTransaction)
				&& Objects.equals(dateOpened, other.dateOpened)
				&& Objects.equals(earlyDirectDeposit, other.earlyDirectDeposit)
				&& Objects.equals(nextStatementDate, other.nextStatementDate)
				&& Objects.equals(overdraftProtection, other.overdraftProtection)
				&& Objects.equals(overdraftTransfer, other.overdraftTransfer) && routingNumber == other.routingNumber;
	}

	@Override
	public int compareTo(Account other) {
		if (this.currentBalance < other.currentBalance) {
            return -1; // Current account has less balance
        } else if (this.currentBalance > other.currentBalance) {
            return 1; // Current account has more balance
        } else {
            return 0; // balances are equal
        }
	}

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", routingNumber=" + routingNumber + ", accountNickname="
				+ accountNickname + ", currentBalance=" + currentBalance + ", earlyDirectDeposit=" + earlyDirectDeposit
				+ ", overdraftTransfer=" + overdraftTransfer + ", overdraftProtection=" + overdraftProtection
				+ ", accountType=" + accountType + ", dateOpened=" + dateOpened + ", nextStatementDate="
				+ nextStatementDate + ", accountOwner=" + accountOwner + ", currentTransaction=" + currentTransaction
				+ "]";
	}
}
