import java.util.ArrayList;

public class Bank {

    private ArrayList<BankAccount> acc = new ArrayList<>();

    public ArrayList<BankAccount> getAcc() {
        return acc;
    }
    public int size(){
        int size = acc.size();
        return size;
    }

 public void addA(int id,double balance){
     acc.add(new BankAccount(id,  balance));
 }
 public BankAccount getBankAccount(int index){
       return acc.get(index);

 }
    public void Make_transfer(BankAccount from, BankAccount to, double money){
        if(from.getID()>to.getID()){
            synchronized (to){
                synchronized (from){
                    if (from.withDraw(money)) to.deposit(money);
                }
            }
        }else {
            synchronized (from){
                synchronized (to){
                    if (from.withDraw(money)) to.deposit(money);
                }
            }
        }
    }
    public double getAllBalances() {
        double total_sum = 0;
        for (BankAccount bankAccount : acc) {
            total_sum += bankAccount.getBalance();
        }
        return total_sum;
    }
}
