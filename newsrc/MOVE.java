/**
 * Creator: Christopher
 * Date: 7/30/12
 * Time: 7:09 PM
 */
public class MOVE implements Instruction {

    int x;
    int y;

    public MOVE(int nx, int ny) {
        x = nx;
        y = ny;
    }

    public void act(Cell[][] cells, int x, int y) {
        Cell tmp = cells[x][y];
        cells[x+this.x][y+this.y] = tmp;
        cells[x][y] = new Cell();
    }

}
