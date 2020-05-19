import java.util.ArrayList;
import java.util.Random;
public class Main {

    public static void main(String[] args) throws InterruptedException {
        Bank bank = new Bank();
//        BankAccount bankAccount = new BankAccount(233,5880);
//        BankAccount bankAccount1 = new BankAccount(343, 455);
//      bank.addA(bankAccount);
//      bank.addA(bankAccount1);
//      System.out.println(bank.getAllBalances());
        Random random = new Random();
        int id = 0 + (int) (Math.random() * 100);

        double balance = 100 + (int) (Math.random() * 5000);

        while (100 > bank.size())
            bank.addA(id, balance);

        System.out.println(bank.getAcc());

        ArrayList<Thread> threads = new ArrayList<>();

        for(int i = 0;i < 20;i++) {
            int from = random.nextInt(bank.size());
            int to = random.nextInt(bank.size());
            double money = 35;
            threads.add(new Thread(() -> bank.Make_transfer(bank.getBankAccount(from), bank.getBankAccount(to), money)));
        }
            for (Thread thread1 : threads) {
                thread1.start();
            }
            for(Thread thread2 : threads){
                if(thread2.isAlive()){

                        thread2.join();

                }
            }

        }
    }



