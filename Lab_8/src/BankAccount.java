public class BankAccount {
    private int ID;
    private double balance;
    private String name;
    private boolean isBlocked;

    public int getID() {
        return ID;
    }

    public double getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }

    public boolean isBlocked() {
        return isBlocked;
    }
    public BankAccount(int ID,double balance) {

        this.isBlocked = false;
        this.balance = balance;
    }
    public boolean deposit(double money){

        balance += money;
        return true;
}
    public boolean withDraw(double money){
        if(balance > money){
            balance -= money;
        }else {
            System.out.println("Not enough money");
        }
        return true;


    }

}
