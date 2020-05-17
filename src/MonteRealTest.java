import static org.junit.jupiter.api.Assertions.*;

class MonteRealTest {

    @org.junit.jupiter.api.Test
    void piCalculation() throws InterruptedException {
        int threads = 10;
        long points = 10000000;
        double expected = 3.141024;
        MonteReal mr = new MonteReal(threads, points);
        double actual = mr.PiCalculation();
        assertEquals(expected,actual, 0.001);
    }
    @org.junit.jupiter.api.Test
    void piCalculation1() throws InterruptedException {
        int threads = 13;
        long points = 1000000;
        double expected = 3.14314314;
        MonteReal mr = new MonteReal(threads, points);
        double actual = mr.PiCalculation();
        assertEquals(expected,actual, 0.001);
    }
}