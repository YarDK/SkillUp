package multithreadskills.synchronizaed.racefix;

public class Account {

    private long balance;

    public Account(long balance) {
        this.balance = balance;
    }

    //public Account() {this(0L);}

    public Account() {
        this.balance = 0L;
    }

    public long getBalance(){
        return balance;
    }

    // синхронизировать метод, что бы потоки не изменяли его одновременно
    public synchronized void deposit(long amount){
        checkAmountNonNegative(amount);
        balance += amount;
    }

    // Лучше делать синхронизацию именно той части, где это нужно
    public void withdraw(long amount){
        checkAmountNonNegative(amount);
        synchronized (this) {
            if (balance < amount) {
                throw new IllegalArgumentException("not enough money");
            }
            balance -= amount;
        }
    }


    private void checkAmountNonNegative(long amount) {
        if(amount < 0){
            throw new IllegalArgumentException("negative amount");
        }
    }


}
