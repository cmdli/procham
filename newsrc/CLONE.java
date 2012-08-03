/**
 * Created with IntelliJ IDEA.
 * User: darklink08150
 * Date: 7/30/12
 * Time: 11:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class CLONE implements Instruction {

    int dir;

    public CLONE(int ndir) {
        dir = ndir;
    }

    public void act(Cell[][] cells, int x, int y) {
        Cell c = cells[x][y];
        int dx = dir%3;
        int dy = (dir-dir%3)/3;
        cells[x+dx][y+dy] = new Cell(c.energy/2, new Program(c.prog));
        c.energy /= 2;
    }
}
