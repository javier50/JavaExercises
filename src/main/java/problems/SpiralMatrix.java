package problems;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}};
        spiralMatrix(matrix).stream().forEach(result -> System.out.print(result + ","));
    }

    public static List<Integer> spiralMatrix(int[][] matrix) {
        List<Integer> spiral = new ArrayList<>();
        int startIndexX = 0, startIndexY = 0, endIndexX = matrix[0].length - 1, endIndexY = matrix.length - 1;
        // we have 4 moves left to right, up to down, right to left, down to up
        int typeMove = 0;
        boolean moreVals = true;
        while (!(startIndexX == startIndexY && startIndexX == endIndexY && endIndexX == endIndexY)) {
            System.out.println(String.format("startIndexX: %s, startIndexY: %s, endIndexX: %s, endIndexY: %s", startIndexX, startIndexY, endIndexX, endIndexY));
            switch (typeMove) {
                case 0:
                    for (int i = startIndexX; i <= endIndexX; i++) {
                        spiral.add(matrix[startIndexY][i]);
                    }
                    typeMove=1;
                    startIndexY++;
                    break;
                case 1:
                    for (int i = startIndexY; i <= endIndexY; i++) {
                        spiral.add(matrix[i][endIndexX]);
                    }
                    typeMove=2;
                    endIndexX--;
                    break;
                case 2:
                    for (int i = endIndexX; i >= startIndexX; i--) {
                        spiral.add(matrix[endIndexY][i]);
                    }
                    typeMove=3;
                    endIndexY--;
                    break;
                case 3:
                    for (int i = endIndexY; i >= startIndexY; i--) {
                        spiral.add(matrix[i][startIndexX]);
                    }
                    typeMove=0;
                    startIndexX++;
                    break;
            }
        }
        return spiral;
    }
}
