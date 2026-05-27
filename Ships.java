import java.util.ArrayList;

public class Ships {
    private ArrayList<Integer> x = new ArrayList<Integer>();
    private ArrayList<Integer> y = new ArrayList<Integer>();
    private int size;
    private String name;
    private boolean vertical;

    public Ships(int s, String n) {
        size = s;
        name = n;
        placeShip();
    }

    private void placeShip() { 
        vertical = Math.random() < 0.5;
        int startRow, startCol;
        if (vertical) {
            startRow = (int)(Math.random() * (10 - size)) + 1; 
            startCol = (int)(Math.random() * 9) + 1; 
            for (int i = 0; i < size; i++) {
                x.add(startRow + i);
                y.add(startCol);
            }
        } else {
            startRow = (int)(Math.random() * 9) + 1;
            startCol = (int)(Math.random() * (10 - size)) + 1;
            for (int i = 0; i < size; i++) {
                x.add(startRow);
                y.add(startCol + i);
            }
        }
    }

    public boolean checkHit(int xPos, int yPos) {
        for (int i = 0; i < x.size(); i++) {
            if (x.get(i).intValue() == xPos && y.get(i).intValue() == yPos) {
                return true;
            }
        }
        return false;
    }

    public void removePosition(int xPos, int yPos) {
        for (int i = 0; i < x.size(); i++) {
            if (x.get(i).intValue() == xPos && y.get(i).intValue() == yPos) {
                x.remove(i);
                y.remove(i);
                break;
            }
        }
    }

    public boolean isSunk() {
        return x.size() == 0;
    }

    public String getName() {
        return name;
    }
}
