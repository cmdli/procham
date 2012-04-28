//Christopher de la Iglesia

import java.awt.Graphics;
import javax.swing.JFrame;

public class Screen extends JFrame {

    public static final int w = 500;
    public static final int h = 500;

    private Graphics draw, drawToScreen;
    private BufferedImage buffer;

    public Screen() {
	super("Program Chamber");
	setSize(w,h);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setVisible(true);

	buffer = new BufferedImage(w,h,BufferedImage.TYPE_INT_ARGB);
	drawToScreen = getGraphics();
	draw = buffer.getGraphics();
    }

    public void update(World wor) {
	
	draw.setColor(Color.white);
	draw.fillRect(0,0,w,h);
	
	double xtile = w/wor.ents.length;
	double ytile = h/wor.ents[0].length;

	for(int x = 0; x < wor.ents.length; x++) {
	    for(int y = 0; y < wor.ents[x].length; y++) {
		if(ents[x][y] instanceof Entity) {
		    draw.setColor(Color.pink);
		} else if(ents[x][y] instanceof Blank) {
		    draw.setColor(Color.gray);
		} else if(ents[x][y] instanceof Cell) {
		    draw.setColor(Color.blue);
		} else if(ents[x][y] instanceof Plant) {
		    draw.setColor(Color.green);
		}

		draw.fillRect(x*xtile,y*ytile,xtile,ytile);
	    }
	}

	drawToScreen.drawImage(buffer,0,30,null);
    }

}