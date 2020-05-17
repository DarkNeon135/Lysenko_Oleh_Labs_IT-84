import java.util.ArrayList;

public class MonteReal {
    public int threads ;
    public long pointsInCircle;
    public long pointsInSquare ;
    public long start;
    public long finished;

    public MonteReal(int threads,long pointsInSquare) {
        this.threads = threads;
        this.pointsInSquare = pointsInSquare;
    }



    public ArrayList<Monte_Thread> MTArrayList = new ArrayList<>();
    public ArrayList<Thread> threadArrayList = new ArrayList<>();

        public double PiCalculation() throws InterruptedException {
     start = System.currentTimeMillis();
    for(int i = 0;i < threads;i++){
    Monte_Thread monte_thread = new Monte_Thread(pointsInSquare/threads);
    Thread thread = new Thread(monte_thread);
    thread.start();
    MTArrayList.add(monte_thread);
    threadArrayList.add(thread);
    }
    pointsInSquare = 0;
    for(Thread thread : threadArrayList){
        if(thread.isAlive()){
            thread.join();
        }
    }
    for (Monte_Thread monte_thread : MTArrayList){
        pointsInSquare +=  monte_thread.getAllPoints();
        pointsInCircle +=  monte_thread.getP_in_Circle();
    }

finished = System.currentTimeMillis();
return 4*(pointsInCircle*1.0 /pointsInSquare);
}
    public long Time(){
        return finished - start;
    }



}
