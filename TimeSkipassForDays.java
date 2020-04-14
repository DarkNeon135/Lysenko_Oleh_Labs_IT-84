import java.sql.Timestamp;
import java.time.LocalDate;

public class TimeSkipassForDays extends TimeSkipass {

    private int numberOfDays;
    private LocalDate expireDate;

    public LocalDate getExpireDate() { return expireDate; }

    public TimeSkipassForDays(CardAccessType accessType, LocalDate expireDate, double cost) {
        super(accessType, cost);
        this.expireDate = expireDate;
    }

    public int getNumberOfDays() { return numberOfDays; }

    public void setNumberOfDays(int numberOfDays) {
        if(numberOfDays <= 0){
            System.out.println("Invalid value");
        }
        else {
            this.numberOfDays = numberOfDays;
        }
    }


    public static void createPass(CardAccessType cardAccessType, int numberOfDays, Register register) {
        LocalDate expireDate = LocalDate.now().plusDays(numberOfDays);
        if(cardAccessType == CardAccessType.Preferential)
            register.addSkipasses(new TimeSkipassForDays(cardAccessType, expireDate, (0.8*Cost)));
        if(cardAccessType == CardAccessType.VIP)
            register.addSkipasses(new TimeSkipassForDays(cardAccessType, expireDate, (2*Cost)));
        if(cardAccessType == CardAccessType.Default)
            register.addSkipasses(new TimeSkipassForDays(cardAccessType, expireDate, (1*Cost)));
    }

    @Override
    public boolean checkPass(Register register) {
        if(expireDate.compareTo(LocalDate.now()) < 0) {
            register.addPasses(new PassInfo(new Timestamp(System.currentTimeMillis()), this, false));
            return false;
        }
        else {
            return checkForPreferential(register);
        }
    }
}
