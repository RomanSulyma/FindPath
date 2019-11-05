package Console.model;

import org.springframework.stereotype.Component;

//Class for saving array and final result of solving
@Component
public class Maze {

    private StringBuilder stringBuilder = new StringBuilder();
    private char[][] grid;
    private int startX;
    private int startY;
    private int endX;
    private int endY;

    @Override
    public String toString() {

        grid[startX][startY] = 'S';
        grid[endX][endY] = 'X';

        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[row].length; column++)
                System.out.print(grid[row][column]);
            System.out.println();
        }

        System.out.println("Optimal way:");
        return stringBuilder.reverse().replace(0, 1, "").toString();
    }

    public char[][] getGrid() {
        return grid;
    }

    public void setGrid(char[][] grid) {
        this.grid = grid;
    }

    public int getStartX() {
        return startX;
    }

    public void setStartX(int startX) {
        this.startX = startX;
    }

    public int getStartY() {
        return startY;
    }

    public void setStartY(int startY) {
        this.startY = startY;
    }

    public int getEndX() {
        return endX;
    }

    public void setEndX(int endX) {
        this.endX = endX;
    }

    public int getEndY() {
        return endY;
    }

    public void setEndY(int endY) {
        this.endY = endY;
    }

    public StringBuilder getStringBuilder() { return stringBuilder; }

    public void setStringBuilder(StringBuilder stringBuilder) { this.stringBuilder = stringBuilder; }
}
