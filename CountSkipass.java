

import java.sql.Timestamp;

public class CountSkipass extends Skipass {

    private CountSkipass(CardAccessType accessType, int count, double cost) {
        super(accessType, cost);
        this.count = count;
    }

    private int count;
    private CardAccessType accessType;

    public int getCount() { return count; }

    public void setCount(int count) {
        if(count <= 0) { System.out.println("Invalid value"); }
        else {
            this.count = count;
        }
    }

    private void usePass() {
        count -= 1;
    }

    @Override
    public boolean checkPass(Register register) {
        if (count < 1) {
            System.out.println("Not enough passes");
            register.addPasses(new PassInfo(new Timestamp(System.currentTimeMillis()), this, false));
            return false;
        }
        else {
            return checkForPreferential(register);
        }
    }

    public static void createPass(CardAccessType cardAccessType, Integer numberOfPasses, Register register) {
        if(cardAccessType == CardAccessType.Preferential)
            register.addSkipasses(new CountSkipass(cardAccessType, numberOfPasses, (0.8*Cost)));
        if(cardAccessType == CardAccessType.VIP)
            register.addSkipasses(new CountSkipass(cardAccessType, numberOfPasses, (2*Cost)));
        if(cardAccessType == CardAccessType.Default)
            register.addSkipasses(new CountSkipass(cardAccessType, numberOfPasses, (1*Cost)));
    }
}