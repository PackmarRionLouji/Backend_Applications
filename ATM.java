import java.util.*;

class Account {
    protected String accountNumber;
    protected String pin;
    protected double balance;
    protected String name;
    Account(String name,String accountNumber, String pin,double balance) {
        this.accountNumber = accountNumber;
        this.pin = pin;
	this.name=name;
	this.balance=balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public boolean verifyPin(String enteredPin) {
        return pin.equals(enteredPin);
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("$" + amount + " has been deposited.");
        } else {
            System.out.println("Invalid amount.");
        }
    }
	
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("$" + amount + " has been withdrawn.");
	    return true;
        } else {
            System.out.println("Insufficient funds or invalid amount.");
            return false;
        }
    }
}

class AccountDetails
{
	List<Account> accountDetails=new ArrayList<Account>();
	void addData(Account details){
		accountDetails.add(details);
	}	
}

public class ATM {
    public static void main(String[] args) {
	
	ATM atm=new ATM();
        Account account = new Account("Jeeva","123456789", "1234",0.0);
        Scanner scanner = new Scanner(System.in);
	AccountDetails accDetails=new AccountDetails();
        System.out.println("Welcome to ATM");
	int accNum=10000;
	
        while (true) {
	    System.out.println("-------------------------\n|1. Create Account	|");
	    System.out.println("|2. Login to Account	|");
	    System.out.println("|3. Exit                |\n-------------------------");
	    System.out.print("Enter your choice: ");	
            int choice1=scanner.nextInt();
	    switch(choice1){
			case 1:
		            	System.out.print("Enter your name: ");
            			String name = scanner.next();
			        System.out.print("Enter your PIN: ");
            			String enteredPin = scanner.next();
            			Account account1=new Account(name,String.valueOf(accNum),enteredPin,0.0);
				accDetails.addData(account1);
				System.out.println("-------------------------------\n"+"Account Created Successfully...\nYour Account Number is "+accNum+"   \n-------------------------------");
				accNum+=1;
				break;
			case 2:
		            	System.out.print("Enter your account Number: ");
            			String enteredAccountNumber1 = scanner.next();
			        System.out.print("Enter your PIN: ");
            			String enteredPin1 = scanner.next();
				int counter=1;
				for(int i=0;i<accDetails.accountDetails.size();i++){
					if (enteredAccountNumber1.equals((accDetails.accountDetails).get(i).accountNumber) && enteredPin1.equals((accDetails.accountDetails).get(i).pin)) {
                				showAccountMenu((accDetails.accountDetails).get(i),scanner); 	
						counter=0;
						break;
            				}
				}
				if(counter==1){
					System.out.println("Invalid Credentials...");
				}
				break;
			case 3:
				System.out.println("Exiting...");
				System.exit(0);
			default:
				System.out.println("Enter valid Input....");
				
       	   }
    }
}
    public static void showAccountMenu(Account account, Scanner scanner) {
        int accNum=10000;
        	while (true) {
            		System.out.println("-------------------\n|1. Check Balance |");
           		System.out.println("|2. Deposit	  |");
      	                System.out.println("|3. Withdraw	  |");	
           	 	System.out.println("|4. Exit	  |\n-------------------");
	
			System.out.print("Enter your choice: ");
            		int choice = scanner.nextInt();

	                switch (choice) {
                		case 1:
                    			System.out.println("Your balance is: $" + account.getBalance());
                    			break;
                		case 2:
                    			System.out.print("Enter the deposit amount: $");
                    			double depositAmount = scanner.nextDouble();
                    			account.deposit(depositAmount);
                    			break;
                		case 3:
                    			System.out.print("Enter the withdrawal amount: $");
                    			double withdrawAmount = scanner.nextDouble();
                    			if (account.withdraw(withdrawAmount)) {
        	                		break;
		               	        }
	    		                break;
		           	case 4:
                    			System.out.println("Thank you "+account.name+" for using ATM. Goodbye!");
                    			break;
                		default:
                    			System.out.println("Invalid choice. Please try again.");
            
            		}
			if(choice==4){
				break;
			}	
        	}
    }
}
