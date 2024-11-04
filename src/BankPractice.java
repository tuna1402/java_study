import java.util.ArrayList;

abstract class Account {
    String accountNumber;
    double balance;

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount) {
        System.out.println("입금: " + amount);
        balance += amount;
    }

    public abstract void withdraw(double amount) throws InsufficientFundsException;

    public void showBalance() {
        System.out.println("계좌 번호: " + accountNumber + "잔액: " + balance);
    }
}

class SavingsAccount extends Account{
    double interestRate;

    public SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    public void addInterest() {
        double interest = balance * interestRate;
        balance += interest;
        System.out.println("이자 " + interest + "가 추가 되었습니다.");
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        if (balance < amount) {
            throw new InsufficientFundsException("잔액 부족");
        }
        balance -= amount;
        System.out.println(amount + "출금\n" + "잔액: " + balance);
    }
}

class CheckingAccount extends Account {

    public CheckingAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        if (balance < amount) {
            throw new InsufficientFundsException("잔액 부족");
        }
        balance -= amount;
        System.out.println(amount + "출금\n" + "잔액 " + balance);
    }

    public void writeCheck(double amount) {
        if (balance < amount) {
           System.out.println("잔액 부족");
        } else {
            balance -= amount;
            System.out.println("수표 발행");
        }
    }
}

class Customer {
    String name;
    ArrayList<Account> accounts;

    public Customer(String name) {
        this.name = name;
        accounts = new ArrayList<>();
    }

    public void openAccount(Account account) {
        accounts.add(account);
        System.out.println("계좌 개설: " + account.accountNumber);
    }

    public void closeAccount(Account account) {
        accounts.remove(account);
        System.out.println("계좌 삭제: " + account.accountNumber);
    }

    public void showAccounts() {
        System.out.println(name + "의 계좌 목록: ");
        for (Account account : accounts) {
            account.showBalance();
        }
    }
}

class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

public class BankPractice {
    public static void main(String[] args) {
        Customer customer = new Customer("Alice");

        SavingsAccount savings = new SavingsAccount("SA-12345", 1000, 0.05);
        CheckingAccount checking = new CheckingAccount("CA-67890", 500);

        customer.openAccount(savings);
        customer.openAccount(checking);

        try {
            savings.deposit(200);
            savings.addInterest();
            savings.withdraw(500);

            checking.deposit(300);
            checking.writeCheck(400);
            checking.withdraw(600); // 잔액 부족 예외 발생
        } catch (InsufficientFundsException e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

        customer.showAccounts();
    }
}
