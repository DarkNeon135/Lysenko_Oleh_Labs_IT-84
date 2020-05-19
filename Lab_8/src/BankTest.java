import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {

    @org.junit.jupiter.api.Test
    void make_transfer() {

    }

    @org.junit.jupiter.api.Test
    void getAllBalances() {
        Bank bank = new Bank();
        Random random = new Random();
        double exprcted = 0;
        int id = 0 + (int) (Math.random() * 100);

        double balance = 100 + (int) (Math.random() * 5000);

        while (3 > bank.size()) {
            bank.addA(id, balance);
            exprcted += balance;
        }
        assertEquals(exprcted, bank.getAllBalances());
    }
}