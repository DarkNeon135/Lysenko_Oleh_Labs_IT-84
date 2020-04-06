import java.sql.Timestamp;
import java.time.LocalTime;


public class TimeSkipassForHours extends TimeSkipass {

    private TimeSkipassForHours(CardAccessType accessType, TimeSkipassForHoursDurationType durationType, double cost) {
        super(accessType, cost);
        this.durationType = durationType;
    }

    TimeSkipassForHoursDurationType durationType;

    public static void createPass(CardAccessType cardAccessType, TimeSkipassForHoursDurationType durationType, Register register) {
        if (cardAccessType == CardAccessType.Preferential)
            register.addSkipasses(new TimeSkipassForHours(cardAccessType, durationType, (0.8 * Cost)));
        if (cardAccessType == CardAccessType.VIP)
            register.addSkipasses(new TimeSkipassForHours(cardAccessType, durationType, (2 * Cost)));
        if (cardAccessType == CardAccessType.Default)
            register.addSkipasses(new TimeSkipassForHours(cardAccessType, durationType, (1 * Cost)));
    }

    @Override
    public boolean checkPass(Register register) {
        switch (this.durationType) {
            case Morning:
                if (LocalTime.now().isAfter(LocalTime.of(9, 0))
                        && LocalTime.now().isBefore(LocalTime.of(14, 0))) {
                    return checkForPreferential(register);
                }
            case Afternoon:
                if (LocalTime.now().isAfter(LocalTime.of(14, 0))
                        && LocalTime.now().isBefore(LocalTime.of(19, 0))) {
                    return checkForPreferential(register);
                }
            case Night:
                if (LocalTime.now().isAfter(LocalTime.of(19, 0))
                        && LocalTime.now().isBefore(LocalTime.of(24, 0))) {
                    return checkForPreferential(register);
                }
        }
        register.addPasses(new PassInfo(new Timestamp(System.currentTimeMillis()), this, false));
        return false;
    }
}

