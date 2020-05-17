public class Main {


    public static void main(String[] args) throws InterruptedException {
         int threads = 8;
        long points = 1000000;
        double piV ;

        MonteReal monteReal = new MonteReal(threads,points);
       piV = monteReal.PiCalculation();
       System.out.println("Threads: "+ threads);
        System.out.println("Points: "+ points);
       System.out.println(piV);
        System.out.println("Computing time(in ms): " + monteReal.Time());

    }


}
