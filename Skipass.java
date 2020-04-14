

import java.sql.Timestamp;

public abstract class Skipass {
    private static int ID = 0;
    private int id;
    boolean blocked = false;
    public CardAccessType accessType;
    protected double cost;
    protected static final double Cost = 75;

    public abstract boolean checkPass(Register register);

    public Skipass(CardAccessType accessType, double cost) {
        this.accessType = accessType;
        this.cost = cost;
        id = ID++;
    }

    public double getCost() { return cost; }
    public void setCost(double cost) {
        if(cost <= 0) System.out.println("Invalid input");
        else this.cost = cost;
    }

    public int getId() { return id; }

    public CardAccessType getAccessType() { return accessType; }

    private boolean Warn() {
        //warnings 
        return true;
    }

    public boolean checkForPreferential(Register register) {
        if(!(this.accessType == CardAccessType.Preferential)) {
            register.addPasses(new PassInfo(new Timestamp(System.currentTimeMillis()), this, true));
            return true;
        }
        else {
            if(Warn()) {
                register.addPasses(new PassInfo(new Timestamp(System.currentTimeMillis()), this, true));
                return true;
            }
            else {
                register.addPasses(new PassInfo(new Timestamp(System.currentTimeMillis()), this, false));
                return false;
            }
        }
    }
}

