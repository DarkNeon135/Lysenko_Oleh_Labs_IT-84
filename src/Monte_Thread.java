public class Monte_Thread implements Runnable{
    public long p_in_Circle;
    public long all_points;

    public final long getP_in_Circle() {
        return p_in_Circle;
    }

    public final double getAllPoints() {
        return all_points;
    }
    public Monte_Thread(long aPoints) {
        this.all_points= aPoints;
    }

    @Override
    public void run() {
    int currentpoint = 0;
    while(currentpoint<all_points)
    {
        double x = Math.random();
        double y = Math.random();
        double  radius = Math.sqrt(Math.pow(x,2)+Math.pow(y,2));
        if (radius<=1)
            p_in_Circle++;
        currentpoint++;
    }

    }
}
