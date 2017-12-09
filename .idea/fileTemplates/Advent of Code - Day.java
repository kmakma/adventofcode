package Days;

import org.jetbrains.annotations.NotNull;

public class ${NAME} extends Day {

    /**
     * official input
     * <p>
     * solution part one: ___
     * <p>
     * solution part two: ___
     */
    private static final String myInput = "";

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
        return myInput;
    }
}