import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: darklink08150
 * Date: 7/31/12
 * Time: 11:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class Simulation {

    public static final int MAX_TICKS = 100000;

    Cell[][] cells;
    Program pl1, pl2;

    public Simulation() {

    }

    public Simulation(int w, int h, Program npl1, Program npl2) {
        cells = new Cell[w][h];
        for(int x = 0; x < cells.length; x++)
            for(int y = 0; y < cells[x].length; y++)
                cells[x][y] = new Cell();

        pl1 = npl1;
        pl2 = npl2;
    }


    public int run() {
        int win = -1;
        int ticks = 0;

        while(win == -1 || ticks < MAX_TICKS) {
            Cell[][] newCells = cells.clone();

            //Run next step in the program
            for(int x = 0; x < cells.length; x++) {
                for(int y = 0; y < cells[x].length; y++) {
                    cells[x][y].prog.getNext().act(newCells,x,y);
                    cells[x][y].energy--;
                    if(cells[x][y].energy <= 0)
                        cells[x][y] = new Cell();
                }
            }
            //Check for win condition
            boolean survive1 = false;
            boolean survive2 = false;
            for(int x = 0; x < cells.length; x++) {
                for(int y = 0; y < cells[x].length; y++) {
                    if(newCells[x][y].prog.id == pl1.id)
                        survive1 = true;
                    if(newCells[x][y].prog.id == pl2.id)
                        survive2 = true;
                }
            }
            if(survive1 && !survive2)
                win = 1;
            else if(!survive1 && survive2)
                win = 2;

            //Checks for draw
            ticks++;
            if(ticks > MAX_TICKS)  {
                win = 3;
                break;
            }
        }

        return win;
    }

    public static Simulation genWorld1(Program p1, Program p2) {
        Simulation ret = new Simulation(20,20,p1,p2);

        Cell[][] cells = ret.cells;
        for(int x = 0; x < cells.length; x++) {
            for(int y = 0; y < cells[x].length; y++) {
                if((x+1)%3 == 0 && (y+1)%3 == 0)
                    cells[x][y] = new Cell(5);
            }
        }

        cells[0][0] = new Cell(50,p1);
        cells[19][19] = new Cell(50,p2);

        return ret;
    }

    public static Simulation loadFromImage(String url, Program p1, Program p2, int playerEnergy, int plantEnergy) throws IOException {
        BufferedImage src = ImageIO.read(new File(url));
        Simulation ret = new Simulation(src.getWidth(),src.getHeight(),p1,p2);

        for(int x = 0; x < src.getWidth(); x++) {
            for(int y = 0; y < src.getHeight(); y++) {
                switch(src.getRGB(x,y)) {
                    case 0xFF0000:
                        ret.cells[x][y] = new Cell(playerEnergy,p1);
                        break;
                    case 0x00FF00:
                        ret.cells[x][y] = new Cell(plantEnergy);
                        break;
                    case 0x0000FF:
                        ret.cells[x][y] = new Cell(playerEnergy,p2);
                        break;
                    default:
                        ret.cells[x][y] = new Cell();
                        break;
                }
            }
        }

        return ret;
    }
}
