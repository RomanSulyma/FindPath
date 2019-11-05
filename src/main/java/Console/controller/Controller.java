package Console.controller;

import Console.model.Maze;
import Console.service.AbstractInputReader;
import Console.service.impl.FileInputReader;
import Console.service.MazeService;
import Console.service.impl.StdInputReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class Controller {

    private static Maze maze;
    private static MazeService mazeService;
    private static AbstractInputReader fileInputReader;
    private static AbstractInputReader stdInputReader;

    public static void main(String[] args) {
        config();
        solve();
    }

    public static void config() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("console");
        context.refresh();

        mazeService = context.getBean(MazeService.class);
        maze = context.getBean(Maze.class);
        fileInputReader = context.getBean(FileInputReader.class);
        stdInputReader = context.getBean(StdInputReader.class);
    }

    //this Method used for start with Main method
    public static String solve() {
        Scanner scanner = new Scanner(System.in);
        String solvingPath = null;

        System.out.println("Choose input type : 1 - File input , 2 - Console input");
        String choose = scanner.nextLine();

        switch (choose) {
            case "1":
                fileInputReader.buildMaze();
                break;
            case "2":
                stdInputReader.buildMaze();
                break;
            default:
                System.out.println("You've not made a choice!");
        }
        if (mazeService.solve(maze.getStartX(), maze.getStartY())) {
            System.out.println(maze.toString());
            solvingPath = maze.getStringBuilder().toString();
        } else
            System.out.println("Solve not found!");
        return solvingPath;
    }

    //this Method used for tests only
    public static String solveForTest() {
        String solvingPath = null;
        fileInputReader.buildMaze();
        if (mazeService.solve(maze.getStartX(), maze.getStartY())) {
            System.out.println(maze.toString());
            solvingPath = maze.getStringBuilder().toString();
        } else
            System.out.println("Solve not found!");
        return solvingPath;
    }
}
