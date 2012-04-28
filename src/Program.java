//Christopher de la Iglesia

import java.util.ArrayList;

public enum Type {
    BLANK, WAIT, MOV, CPY, EAT
}

class Instuction {
    Type ins;
    int args[2];
}

public class Program {
    
    ArrayList<Instruction> ins;

    public Program() {
	
    }

    public void run(World w,Cell c) {
	for(Instruction i : ins) {
	    switch(i.ins) {
	    case BLANK:
		break;
	    case WAIT:
		c.wait(i.args[0]);
		break;
	    case MOV:
		c.move(i.args[0],i.args[1]);
		break;
	    case CPY:
		c.copy(i.args[0]);
		break;
	    case EAT:
		c.eat(i.args[0]);
		break;
	    }
	}
    }

    public void mutate() {
	Random rnd = new Random();

	if(rnd.nextBoolean()) {
	    ins.add(randIns(rnd));
	    return;
	}

	int index = rnd.nextInt(ins.length);
	ins.set(index,randIns);

	
    }

    public int genLogNumber(Random rnd, int key, int s) {
	if(rnd.nextInt(key+1) == key) {
	    return s;
	}
	else {
	    return genLogNumber(rnd,key,s+1);
	}
    }

    public Instruction randIns(Random rnd) {
	Instruction tmp = new Instruction();
	tmp.type = rnd.nextInt(4) + 1;
	switch(tmp.type) {
	case WAIT:
	    tmp.args[0] = genLogNumber(rnd,3,0);
	    break;
	case MOV:
	    tmp.args[0] = genLogNumber(rnd,3,0);
	    tmp.args[1] = genLogNumber(rnd,3,0);
	    break;
	case CPY:
	    tmp.args[0] = genLogNumber(rnd,3,0);
	    tmp.args[1] = genLogNumber(rnd,3,0);
	    break;
	case EAT:
	    tmp.args[0] = rnd.nextInt(8);
	    break;
	}
	return tmp;
    }

}