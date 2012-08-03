/**
 * Creator: Christopher
 * Date: 7/30/12
 * Time: 7:06 PM
 */
public class WAIT implements Instruction {

    int baseTime;
    int time;

    public WAIT(int ntime) {
        baseTime = ntime;
        time = ntime;
    }

    public void act(Cell[][] cells, int x, int y) {
        if(time <= 0) {
            time = baseTime;
            return;
        }
        cells[x][y].prog.pointer--;
        time--;
    }
}
