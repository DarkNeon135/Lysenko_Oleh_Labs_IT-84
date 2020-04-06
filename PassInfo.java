import java.sql.Timestamp;

public class PassInfo {
    private Timestamp time;
    private Skipass skipass;
    private boolean access;

    public Skipass getSkipass() {
        return skipass;
    }

    public PassInfo(Timestamp time, Skipass skipass, boolean access) {
        this.time = time;
        this.skipass = skipass;
        this.access = access;
    }
}