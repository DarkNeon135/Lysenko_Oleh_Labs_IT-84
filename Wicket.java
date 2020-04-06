import java.sql.Timestamp;

public class Wicket {

    public static boolean checkCard(Skipass skipass, Register register) {
        if (!register.findPass(skipass)) return false;
        if (skipass.blocked) {
            register.addPasses(new PassInfo(new Timestamp(System.currentTimeMillis()), skipass, false));
        }
        return skipass.checkPass(register);
    }
}