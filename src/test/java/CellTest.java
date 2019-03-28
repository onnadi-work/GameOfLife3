import Cell.Cell;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CellTest {
    @Test
    public void testAlive(){
        assertEquals(true, new Cell(Cell.ALIVE).status());
    }

    @Test
    public void testDead(){
        Cell cell = new Cell();
        cell.dies();
        assertEquals(false, cell.status());
    }

    @Test
    public void testUnderpopulation(){
        Cell cell = new Cell(Cell.ALIVE);
        cell.setNumberOfLiveNeighbors(1);
        assertEquals(false, cell.nextGeneration().status());
    }

    @Test
    public void testOverpopulation(){
        Cell cell = new Cell(Cell.ALIVE);
        cell.setNumberOfLiveNeighbors(4);
        assertEquals(false, cell.nextGeneration().status());
    }

    @Test
    public void testResurrection(){
        Cell cell = new Cell(Cell.DEAD);
        cell.setNumberOfLiveNeighbors(3);
        assertEquals(true, cell.nextGeneration().status());
    }
}
