package Console.service;

import Console.model.Maze;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Service for finding the way
@Service
public class MazeService {

    @Autowired
    Maze maze;

    public boolean solve(int row, int column) {

        if (maze.getGrid() != null) {

            StringBuilder string = maze.getStringBuilder();
            char[][] grid = maze.getGrid();
            char path = ' ';
            boolean done = false;

            if (valid(row, column)) {

                grid[row][column] = '!';

                if (row == maze.getEndX() && column == maze.getEndY())
                    done = true;
                else {
                    path = 'd';
                    done = solve(row + 1, column);
                    if (!done) {
                        path = 'r';
                        done = solve(row, column + 1);
                    }
                    if (!done) {
                        path = 'u';
                        done = solve(row - 1, column);
                    }
                    if (!done) {
                        path = 'l';
                        done = solve(row, column - 1);
                    }
                }
                if (done) {
                    string.append(path).append(",");
                    grid[row][column] = 'V';
                }
            }
            maze.setGrid(grid);
            maze.setStringBuilder(string);

            return done;
        }
        return false;
    }

    private boolean valid(int row, int column) {

        char[][] grid = maze.getGrid();

        boolean result = false;

        if (row >= 0 && row < grid.length && column >= 0 && column < grid[0].length)

            if (grid[row][column] == '.' || grid[row][column] == 'S' || grid[row][column] == 'X')
                result = true;

        return result;
    }

}


