package Console.service.impl;

import Console.model.Maze;
import Console.service.AbstractInputReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import java.io.*;

//Service for reading data from file
@Service
public class FileInputReader implements AbstractInputReader {

    @Autowired
    Maze maze;

    @Autowired
    Environment environment;

    @Override
    public void buildMaze() {
        int height = 0;
        int width = 0;
        char[][] grid;
        String row;

        try {
            BufferedReader br = new BufferedReader(new FileReader(environment.getProperty("pathToFile")));

            while ((row = br.readLine()) != null) {
                if (width == 0)
                    width = row.length();
                height = height + 1;
            }
            br.close();

            grid = new char[height][width];
            br = new BufferedReader(new FileReader(environment.getProperty("pathToFile")));

            for (int i = 0; i < grid.length; i++) {
                row = br.readLine();
                grid[i] = row.toCharArray();

                    if (row.contains("S")) {
                    maze.setStartX(i);
                    maze.setStartY(row.indexOf('S'));
                    }
                    if (row.contains("X")) {
                    maze.setEndX(i);
                    maze.setEndY(row.indexOf('X'));
                    }
                }
            maze.setGrid(grid);
        } catch (IOException e) {
            System.out.println("File not found");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("File have errors");
        }
    }


}
