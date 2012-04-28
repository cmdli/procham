//Christopher de la Iglesia

public class Cell {

    Program p;
    
    public Cell() {
	Cell(0,0,0, null);
    }

    public Cell(int e, Program p) {
	this.x = x;
	this.y = y;
	this.e = e;
	if(p == null)
	    p = new Program();
	else
	    this.p = p;
    }

    public void tick(int x, int y, World w) {
	this.x = x;
	this.y = y;

	if(t > 0) {
	    t--;
	    return;
	}
	    
	p.run(w,this);

    }

    public void move(World w, int xd, int yd) {

	if(!w.occupied(x+xd,y+yd)) {
	    w.move(x,y,xd,yd);
	}
    }

    public void copy(World w, int d) {

	switch(d) {
	case E:
	    w.addCell(int x, int y,new Cell(x+1,y,e/2,p));
	    break;
	case NE:
	    w.addCell(int x, int y,new Cell(e/2,p));
	    break;
	case N:
	    w.addCell(int x, int y,new Cell(e/2,p));
	    break;
	case NW:
	    w.addCell(int x, int y,new Cell(e/2,p));
	    break;
	case W:
	    w.addCell(int x, int y,new Cell(e/2,p));
	    break;
	case SW:
	    w.addCell(int x, int y,new Cell(e/2,p));
	    break;
	case S:
	    w.addCell(int x, int y,new Cell(e/2,p));
	    break;
	case SE:
	    w.addCell(int x, int y,new Cell(e/2,p));
	    break;
	}
	e /= 2;
    }

    public void wait(int t) {
	this.wait = t;
    }

    public void eat(World w,int d) {
	int xd = 0;
	int yd = 0;
	switch(d) {
	case E:
	    xd++;
	    break;
	case NE:
	    xd++;
	    yd--;
	    break;
	case N:
	    yd--;
	    break;
	case NW:
	    xd--;
	    yd--;
	    break;
	case W:
	    xd--;
	    break;
	case SW:
	    xd--;
	    yd++;
	    break;
	case S:
	    yd++;
	    break;
	case SE:
	    xd++;
	    yd++;
	    break;
	}

	if(w.occupied(x+xd,y+yd)) {
	    e += w.get(x+xd,y+yd).e;
	    w.delete(x+xd,y+yd);
	}
    }

}