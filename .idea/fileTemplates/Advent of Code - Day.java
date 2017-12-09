package Days;

import org.jetbrains.annotations.NotNull;

/**
 * solution part one: ___
 * <p>
 * solution part two: ___
 *
 * @see <a href="http://adventofcode.com/2017/day/___">Advent of Code: Day ___</a>
 */
public class ${NAME} extends Day {

    public ${NAME}() {
        System.out.println("\n--- ${NAME}: ____ ---");
        // input
        String input = readLine();
        // wörk
        // TODO: ${DATE} work with input 
        System.out.println();
        // finished
    }

    public static void main(String[] args) {
        new ${NAME}();
    }

    @NotNull
    @Override
    String getDefaultInput() {
        return MyInput.${NAME}.getInput();
    }
}