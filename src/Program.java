import java.util.ArrayList;
import java.util.Random;

/**
 * Creator: Christopher
 * Date: 7/30/12
 * Time: 6:39 PM
 */
public class Program {

    ArrayList<Instruction> ins;
    int pointer;

    int id;

    public Program() {
        this(-1);
    }

    public Program(int nid) {
        pointer = 0;
        id = nid;
        ins = new ArrayList<Instruction>();
        ins.add(new WAIT(Simulation.MAX_TICKS));
    }

    public Program(Program p) {
        ins = (ArrayList<Instruction>)p.ins.clone();
        pointer = p.pointer;
        id = p.id;
    }

    //Adds an instruction to the end of the program
    public void add(Instruction in) {
        ins.add(in);
    }

    public void replace(int i, Instruction in) {
        if(i >= ins.size())
            return;
        ins.set(i, in);
    }

    public Instruction get(int i) {
        if(i > ins.size())
            return null;
        return ins.get(i);
    }

    public Instruction getNext() {
        if(pointer >= ins.size()) {
            pointer -= ins.size()-1;
        }
        Instruction ret = ins.get(pointer);
        pointer++;
        return ret;
    }

    public void addRandom(int num) {
        for(int i = 0; i < num; i++) {
            ins.add(InstructionFactory.getRandom());
        }
    }

    public Program mutate(int numDiff) {
        Program ret = new Program(this);
        for(int i = 0; i < numDiff; i++) {
            Instruction diff = InstructionFactory.getRandom();
            int index = new Random().nextInt(ins.size());
            ret.replace(index,diff);
        }
        return ret;
    }
}
