/**
 * Created with IntelliJ IDEA.
 * User: darklink08150
 * Date: 7/30/12
 * Time: 11:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class EAT implements Instruction {

    int dir;

    public EAT(int ndir) {
        dir = ndir;
    }

    public void act(Cell[][] cells, int x, int y) {
        int dx = dir%3;
        int dy = (dir-dx)/3;
        cells[x][y].energy += cells[x+dx][y+dy].energy;
        cells[x+dx][y+dy] = new Cell();
    }

}
