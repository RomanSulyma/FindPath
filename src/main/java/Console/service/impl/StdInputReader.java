package Console.service.impl;

import Console.model.Maze;
import Console.service.AbstractInputReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Scanner;

//Service for reading data from console
@Service
public class StdInputReader implements AbstractInputReader {

    private Scanner scanner = new Scanner(System.in);

    @Autowired
    Maze maze;

    @Override
    public void buildMaze() {
        int rows;
        int columns;
        String row;
        char[][] grid;

        try {
            System.out.println("Enter number of rows:");
            rows = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter " + 1 + " row:");
            row = scanner.nextLine();
            columns = row.length();

            grid = new char[rows][columns];
            grid[0] = row.toCharArray();

            for (int i = 0; i < grid.length - 1; i++) {
                System.out.println("Enter " + (i + 2) + " row:");
                row = scanner.nextLine();
                grid[i + 1] = row.toCharArray();

                if (row.contains("S")) {
                    maze.setStartX(i + 1);
                    maze.setStartY(row.indexOf('S'));
                }
                if (row.contains("X")) {
                    maze.setEndX(i + 1);
                    maze.setEndY(row.indexOf('X'));
                }
            }
            maze.setGrid(grid);
        } catch (NumberFormatException e) {
            System.out.println("You've entered not number!");
        }

    }
}
