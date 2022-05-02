package br.com.summit.gridGenerator;

import java.util.Scanner;

public class GridGenerator {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        Integer min = 0;
        Integer max = 0;

        System.out.print("rows >");
        int rows = s.nextInt();

        System.out.print("columns >");
        int columns = s.nextInt();

        String maxStr = s.nextLine();

        String parser;

        System.out.println("minimun (or Enter for 0) >");
        parser = (s.nextLine());
        if (parser.isEmpty()){
            min = 0;
        } else {
            min = Integer.parseInt(parser);
        }

        System.out.println("maximum (or Enter for 1000) >");
        parser = s.nextLine();
        if (parser.isEmpty()){
            max = 1000;
        } else {
            max = Integer.parseInt(parser);
        }


        System.out.println(min + " " + max);

        int[][] grid = new int[rows][columns];

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < columns; j++) {

                int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);

                System.out.print(grid[i][j] + random_int + "   ");

            }

            System.out.println("   ");
        }

    }
}

