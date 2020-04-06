

import java.util.ArrayList;

public class Register {

    private ArrayList<Skipass> skipasses = new ArrayList<Skipass>();
    private ArrayList<PassInfo> passes = new ArrayList<PassInfo>();

    public void addPasses(PassInfo passInfo) { passes.add(passInfo); }

    public void addSkipasses(Skipass skipass) { this.skipasses.add(skipass); }
    public boolean findPass(Skipass skipass) {
        for (Skipass skpass : skipasses) {
            if(skpass == skipass) return true;
        }
        return false;
    }

    public void blockCard(int ID) {
        for (Skipass skipass : skipasses) {
            if (skipass.getId() == ID)
                skipass.blocked = true;
        }
    }

    public Skipass findCard(int ID) {
        for (Skipass skipass : skipasses) {
            if (skipass.getId() == ID) return skipass;
        }
        System.out.println("Nothing has been found");
        return null;
    }

    public ArrayList<PassInfo> getInfo(int ID) {
        ArrayList<PassInfo> result = new ArrayList<PassInfo>();
        for (PassInfo passInfo : passes) {
            if (passInfo.getSkipass().getId() == ID) {
                result.add(passInfo);
            }
        }
        return result;
    }

    public ArrayList<PassInfo> getInfo() {
        return passes;
    }

    public ArrayList<PassInfo> getInfo(CardAccessType accessType) {
        ArrayList<PassInfo> result = new ArrayList<PassInfo>();
        for (PassInfo passInfo : passes) {
            if (passInfo.getSkipass().getAccessType() == accessType) {
                result.add(passInfo);
            }
        }
        return passes;
    }
}