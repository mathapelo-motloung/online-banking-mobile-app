package accounts;

import java.util.Objects;

public class Transaction implements Comparable<Transaction>{
	
	String senderAccount;
	String receiverAccount;
	double amount;
	Date transactionDate;
	Time transactionTime;
		
	public Transaction() {
		// TODO Auto-generated constructor stub
	}
	public Transaction( String transaction ) {
		transaction = this.senderAccount + ":" + this.receiverAccount + ":" + this.amount + ":" + this.transactionDate + ":" + this.transactionTime;
	}
	public Transaction( String sender, String receiver, double amount, Date date, Time time) {
		this.senderAccount = sender;
		this.receiverAccount = receiver;
		this.amount = amount;
		this.transactionDate =  date;
		this.transactionTime = time;
	}
	@Override
	public String toString() {
		return "Transaction [senderAccount=" + senderAccount + ", receiverAccount=" + receiverAccount + ", amount="
				+ amount + ", transactionDate=" + transactionDate + ", transactionTime=" + transactionTime + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		return Double.doubleToLongBits(amount) == Double.doubleToLongBits(other.amount)
				&& Objects.equals(receiverAccount, other.receiverAccount)
				&& Objects.equals(senderAccount, other.senderAccount)
				&& Objects.equals(transactionDate, other.transactionDate)
				&& Objects.equals(transactionTime, other.transactionTime);
	}
	@Override
	public int compareTo(Transaction other) {  
		
		 // Compare by transaction times
        int timestampComparison = this.transactionTime.compareTo(other.transactionTime);
        if (timestampComparison != 0) {
            return timestampComparison;
        }
        // If transaction times are equal, compare by amount
        int amountComparison = Double.compare(this.amount, other.amount);
        if (amountComparison != 0) {
            return amountComparison;
        }
        // If amounts are also equal, compare by date
        return this.transactionDate.compareTo(other.transactionDate);
	}
	


}
