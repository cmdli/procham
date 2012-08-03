/**
 * Creator: Christopher
 * Date: 7/30/12
 * Time: 6:39 PM
 */
public class Cell {

    int x, y;
    int energy;
    Program prog;

    public Cell() {
        this(0, new Program());
    }

    public Cell(int nenergy) {
        this(nenergy,new Program());
    }

    public Cell(int nenergy, Program nprog) {
        prog = nprog;
        energy = nenergy;
    }

}
