//Christopher de la Iglesia

public class World {

    Entity[][] ents;
    int w, h;
    public static final int PLANT_ENERGY = 10;
    public static final int CELL_ENERGY = 10;

    public World(int w, int h) {
	ents = new Entity[w][h];
	this.w = w;
	this.h = h;
    }

    public void tick() {
	for(int x = 0; x < w; x++) {
	    for(int y = 0; y < h; y++) {
		ents[x][y].tick(x,y,this);
	    }
	}
    }

    public void addCell(int x, int y, Cell nc) {
	if(!occupied(x,y)) {
	    ents[x][y] == nc;
	}
    }

    public void move(int x, int y, int xd, int yd) {
	Entity tmp = ents[x][y];
	ents[x][y] = ents[x+xd][y+yd];
	ents[x+xd][y+yd] = tmp;
    }

    public boolean occupied(int x, int y) {
	return !(ents[x][y] instanceof Blank);
    }

    public void load(String name, Program p1, Program p2) {
	try {
	    File file = new File(name);
	    BufferedImage img = ImageIO.loadFile(file);

	    ents = new Entity[img.getWidth()][img.getHeight()];

	    for(int x = 0; x < img.getWidth(); x++) {
		for(int y = 0; y < img.getHeight(); y++) {
		    ents[x][y] = loadFromColor(img.getRGB(x,y),p1,p2);
		}
	    }
	}
	catch(Exception e) {

	}
    }

    public Entity loadFromColor(int rgb, Program p1, Program p2) {
	switch(rgb) {
	case 0xFFFFFF:
	    return new Blank();
	    break;
	case 0x00FF00:
	    return new Plant(PLANT_ENERGY);
	    break;
	case 0xFF0000:
	    return new Cell(CELL_ENERGY,p1);
	    break;
	case 0x0000FF:
	    return new Cell(CELL_ENERGY,p2);
	    break;
	}
    }

}