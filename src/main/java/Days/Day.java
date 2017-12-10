package Days;

import Days.tools.RegisterInstruction;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

abstract class Day {

    static final String REGEX_NOTHING = "";
    static final String REGEX_COMMA = ",";

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

    @Nullable List<RegisterInstruction> linesToRegisterInstructions() {
        // TODO: 10.12.2017
//        List<String> input = readLines();
        String input = readLinesToString();

        List<RegisterInstruction> regInstrs = new ArrayList<>();
        BufferedReader br = new BufferedReader(new StringReader(input));

        String line;
        while (true) {
            try {
                line = br.readLine();
            } catch (IOException e) {
                System.err.println(getClass() + ": Error while reading line!");
                return null;
            }
            if (line != null && !"".equals(line)) {
                regInstrs.add(RegisterInstruction.parse(line));
            } else {
                break;
            }
        }

        return regInstrs;

    }

    private List<String> readLines() {
        return null;
        // TODO: 10.12.2017
    }

    @Nullable int[] lineToAsciiIntArray(String line) {
        char[] charArray = line.toCharArray();
        if (charArray.length > 0) {
            int[] intArray = new int[charArray.length];
            for (int i = 0; i < charArray.length; i++) {
                intArray[i] = charArray[i];
            }
            return intArray;
        }
        return null;
    }

    @Nullable int[] lineToIntArray(String splitRegex) {
        return lineToIntArray(null, splitRegex);
    }

    @Nullable int[] lineToIntArray(String line, String splitRegex) {
        if (line == null) {
            line = readLine();
        }
        int[] intArray = Arrays.stream(line.split(splitRegex)).mapToInt(Integer::valueOf).toArray();
        if (intArray.length > 0) {
            return intArray;
        }
        return null;
    }

    @Nullable char[] lineToCharArray() {
        String line = readLine();
        char[] charArray = line.toCharArray();
        if (charArray.length > 0) {
            return charArray;
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

    @NotNull String readLinesToString() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter multiline Input (finish with empty line):");
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
        return decideIfOfficialInput(input.toString());
    }
}
