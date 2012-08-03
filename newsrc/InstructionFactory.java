import java.util.Random;

/**
 * Creator: Christopher
 * Date: 7/30/12
 * Time: 6:50 PM
 */
public class InstructionFactory {

    public static final int NUM_TYPES = 4;

    public static final int INS_WAIT = 0;
    public static final int INS_MOVE = 1;
    public static final int INS_CLONE = 2;
    public static final int INS_EAT = 3;

    public static Instruction getRandom() {
        int type = new Random().nextInt(NUM_TYPES);
        Instruction ret;
        switch(type) {
            case INS_MOVE: ret = getMOVE(); break;
            case INS_CLONE: ret = getCLONE(); break;
            case INS_EAT: ret = getEAT(); break;
            case INS_WAIT: default: ret = getWAIT(); break;
        }
        return ret;
    }

    public static Instruction getWAIT() {
        int time = getLogRand(new Random(),1,0.5);
        return new WAIT(time);
    }

    public static Instruction getMOVE() {
        Random rng = new Random();
        int x = getLogRand(rng,0,0.5);
        int y = getLogRand(rng,0,0.5);
        return new MOVE(x,y);
    }

    public static Instruction getCLONE() {
        int dir = new Random().nextInt(8);
        if(dir >= 4)
            dir += 1;
        return new CLONE(dir);
    }

    public static Instruction getEAT() {
        int dir = new Random().nextInt(8);
        if(dir >= 4)
            dir += 1;
        return new EAT(dir);
    }

    public static int getLogRand(Random rng, int i, double base) {
        if(rng.nextDouble() > base)
            return i;
        return getLogRand(rng,i+1,base);
    }
}

