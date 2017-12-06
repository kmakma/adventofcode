package Days;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class Day03 extends Day {

    /**
     * official input
     * <p>
     * solution part one: 480
     * <p>
     * solution part two: 349975
     */
    private static final String myInput = "347991";

    public Day03() {
        System.out.println("\n--- Day 3: Spiral Memory ---");
        // input
        String input = readLine();
        // wörk
        int puzzleInput = parseInput(input);
        if (puzzleInput > 0) {
            loopingInSpiralToInteger(puzzleInput);
            getBiggerIntegerWhileWeirdlyAllocating(puzzleInput);
        }
        System.out.println();
        // finished
    }

    public static void main(String[] args) {
        new Day03();
    }

    @NotNull
    @Override
    String getDefaultInput() {
        return myInput;
    }

    private int parseInput(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    /**
     * http://stackoverflow.com/questions/398299/looping-in-a-spiral/398302#398302
     */
    @SuppressWarnings("unused")
    private void loopingInSpiralFromZero(double xSize, double ySize) {
        int x = 0;
        int y = 0;
        int dx = 0;
        int dy = -1;
        int dz;
        for (int i = 0; i < Math.pow(Math.max(xSize, ySize), 2); i++) {
            if ((-xSize / 2) < x && x <= (xSize / 2) && (-ySize / 2) < y && y <= ySize / 2) {
                System.out.println("doing stuff with: " + x + ", " + y);
            }
            if (x == y || (x < 0 && x == -y) || (x > 0 && x == 1 - y)) {
                dz = dx;
                dx = (-dy);
                dy = dz;
            }
            x += dx;
            y += dy;
        }
    }

    private void loopingInSpiralToInteger(int input) {
        // x and y are like in a coordinate system
        int x = 0;
        int y = 0;
        int dx = 0;
        int dy = -1;
        int dz;

        for (int i = 0; i < input - 1; i++) {
            if (x == y || (x < 0 && x == -y) || (x > 0 && x == 1 - y)) {
                dz = dx;
                dx = (-dy);
                dy = dz;
            }
            x += dx;
            y += dy;
        }
        System.out.println("Solution Part One:");
        System.out.println("\t" + (Math.abs(x) + Math.abs(y)));
    }

    private void getBiggerIntegerWhileWeirdlyAllocating(int input) {
        int x = 0;
        int y = 0;
        int dx = 0;
        int dy = -1;
        int dz;

        int[][] matrix = createMatrix(input);
        for (int i = 0; i < Math.pow(matrix.length, 2); i++) {
            int allocatedValue = allocateValue(x, y, matrix);
            if (allocatedValue > input) {
                System.out.println("Solution Part Two:");
                System.out.println("\t" + allocatedValue);
                return;
            }

            if (x == y || (x < 0 && x == -y) || (x > 0 && x == 1 - y)) {
                dz = dx;
                dx = (-dy);
                dy = dz;
            }
            x += dx;
            y += dy;
        }
    }

    @NotNull
    @Contract(pure = true)
    private int[][] createMatrix(int input) {
        int size = (int) Math.sqrt(input);
        if (size % 2 == 0) {
            size++;
        }
        return new int[size][size];
    }

    private int allocateValue(int x, int y, int[][] matrix) {
        int matrixX = x + (matrix.length / 2);
        int matrixY = y + (matrix.length / 2);
        int sum;
        if (x == 0 && y == 0) {
            sum = 1;
        } else {
            sum = getSumOfSurroundings(matrixX, matrixY, matrix);
        }
        matrix[matrixX][matrixY] = sum;
        return sum;
    }

    @Contract(pure = true)
    private int getSumOfSurroundings(int matrixX, int matrixY, int[][] matrix) {
        int sum = 0;
        if (matrixX > 0) {
            sum += matrix[matrixX - 1][matrixY];
            if (matrixY > 0) {
                sum += matrix[matrixX - 1][matrixY - 1];
            }
            if (matrixY < matrix.length - 1) {
                sum += matrix[matrixX - 1][matrixY + 1];
            }
        }
        if (matrixX < matrix.length - 1) {
            sum += matrix[matrixX + 1][matrixY];
            if (matrixY > 0) {
                sum += matrix[matrixX + 1][matrixY - 1];
            }
            if (matrixY < matrix.length - 1) {
                sum += matrix[matrixX + 1][matrixY + 1];
            }
        }
        if (matrixY > 0) {
            sum += matrix[matrixX][matrixY - 1];
        }
        if (matrixY < matrix.length - 1) {
            sum += matrix[matrixX][matrixY + 1];
        }
        return sum;
    }
}