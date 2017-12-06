package Days;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

abstract class Day {

    @NotNull
    abstract String getDefaultInput();

    @NotNull String readLine() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter one input-line: ");
        String input;
        try {
            input = br.readLine();
        } catch (IOException e) {
            System.err.println(getClass() + ": Error while reading line!");
            input = null;
        }
        return decideIfOfficialInput(input);
    }

    /**
     * @param outputType available types: {@link Output#CHAR_ARRAY}, {@link Output#INT_ARRAY}
     */
    @Nullable Object parseInput(Output outputType) {
        String input = readLine();

        switch (outputType) {
            case CHAR_ARRAY:
                return lineToCharObjectArray(input);
            case INT_ARRAY:
                return lineToIntArray(input);
            default:
                return null;
        }
    }

    @Nullable
    private int[] lineToIntArray(@NotNull String line) {
        int[] intArray = Arrays.stream(line.split("")).mapToInt(Integer::valueOf).toArray();
        if (intArray.length > 0) {
            return intArray;
        }
        return null;
    }

    @Nullable
    private Character[] lineToCharObjectArray(@NotNull String line) {
//        Character[] cOArray =  Arrays.stream(line.split("")).map(s -> s.charAt(0)).toArray(Character[]::new);
        Character[] charObjectArray = line.chars().mapToObj(c -> (char) c).toArray(Character[]::new);
        if (charObjectArray.length > 0) {
            return charObjectArray;
        }
        return null;
    }

    @NotNull
    private String decideIfOfficialInput(String input) {
        if (input == null || "".equals(input)) {
            System.out.println("Official Input will be used.");
            return getDefaultInput();
        }
        return input;
    }

    int normalizeIndex(int index, int size) {
        int normIndex = index;
        while (normIndex >= size) {
            normIndex -= size;
        }
        while (normIndex < 0) {
            normIndex += size;
        }
        return normIndex;
    }

    @NotNull String readLines() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter multiline Input-String (finish with empty line):");
        StringBuilder input = new StringBuilder();
        String line = null;
        do {
            if (line != null) {
                input.append(line);
                input.append("\n");
            }
            try {
                line = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } while (!(line == null || "".equals(line)));
        // TODO: 02.12.2017 prüfe wie neue zeilen dargestellt werden
        //        System.out.println(input.toString());
        return decideIfOfficialInput(input.toString());
    }

    enum Output {
        CHAR_ARRAY, INT_ARRAY
    }
}
