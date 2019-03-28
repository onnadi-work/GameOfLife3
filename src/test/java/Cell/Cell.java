package Cell;

public class Cell {
    public static final boolean ALIVE = true;
    public static final boolean DEAD = false;
    public static final int LIFE_NEIGHBOR_THRESHOLD = 2;
    public static final int OVERCROWDING_THRESHOLD = 3;

    boolean status;

    int numberLiveNeighbors;

    public Cell(boolean s){
        status = s;
    }

    public Cell(){
        status = ALIVE;
    }
    public boolean status(){
        return status;
    }

    public void dies() {
        status = DEAD;
    }

    public void setNumberOfLiveNeighbors(int numberLiveNeighbors) {
        this.numberLiveNeighbors = numberLiveNeighbors;
    }

    public Cell nextGeneration() {
        if(numberLiveNeighbors < LIFE_NEIGHBOR_THRESHOLD || numberLiveNeighbors > OVERCROWDING_THRESHOLD) {
            this.status = DEAD;
        }
        else if(numberLiveNeighbors == 3) {
            this.status = ALIVE;
        }

        return this;
    }
}
