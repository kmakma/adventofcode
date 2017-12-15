package Days;

import Days.tools.RegisterInstruction;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;

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

    @NotNull List<String> lineToStringList(String splitRegex) {
        String line = readLine();
        String[] stringArray = line.split(splitRegex);
        return new ArrayList<>(Arrays.asList(stringArray));
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

    @Nullable Map<Integer, Integer> linesToIntMap() {
        String input = readLinesToString();

        BufferedReader br = new BufferedReader(new StringReader(input));
        Map<Integer, Integer> inputMap = new HashMap<>();

        String line;
        while (true) {
            try {
                line = br.readLine();
            } catch (IOException e) {
                System.err.println(getClass() + ": Error while reading line!");
                return null;
            }
            if (line != null && !"".equals(line)) {
                String[] splitLine = line.split(": ");
                try {
                    inputMap.put(Integer.parseInt(splitLine[0]), Integer.parseInt(splitLine[1]));

                } catch (NumberFormatException e) {
                    return null;
                }
            } else {
                break;
            }
        }
        return inputMap;
    }

    @Nullable List<RegisterInstruction> linesToRegisterInstructions() {
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

    String knotHashAsciiIntArrayToHex(int[] asciiArray) {
        int[] withSuffix = addSuffix(asciiArray);
        int[] denseHash = getDenseHash(withSuffix);
        return parseDenseHashToHex(denseHash);
    }

    private int[] addSuffix(int[] input) {
        int[] suffix = {17, 31, 73, 47, 23};
        int[] newArray = new int[input.length + suffix.length];
        System.arraycopy(input, 0, newArray, 0, input.length);
        System.arraycopy(suffix, 0, newArray, input.length, suffix.length);
        return newArray;
    }

    private int[] getDenseHash(int[] input) {
        int[] sparseHash = getSparseHash(input);
        int[] denseHash = new int[sparseHash.length / 16];
        for (int i = 0; i < sparseHash.length / 16; i++) {
            denseHash[i] = useBitwiseXOR(Arrays.copyOfRange(sparseHash, 16 * i, 16 * i + 16));
        }
        return denseHash;
    }

    private int[] getSparseHash(int[] input) {
        int currentPosition = 0;
        int jumpSize = 0;
        int[] sparseHash = new int[256];
        for (int i = 0; i < sparseHash.length; i++) {
            sparseHash[i] = i;
        }
        for (int i = 0; i < 64; i++) {
            for (int length : input) {
                reverseSubarrayOf(sparseHash, currentPosition, length);
                currentPosition = normalizeIndex(currentPosition + length + jumpSize, sparseHash.length);
                jumpSize++;
            }
        }
        return sparseHash;
    }

    void reverseSubarrayOf(int[] array, int startIndex, int length) {
        for (int i = 0; i < length / 2; i++) {
            int fstI = normalizeIndex(i + startIndex, array.length);
            int sndI = normalizeIndex(startIndex + length - 1 - i, array.length);

            int temp = array[fstI];
            array[fstI] = array[sndI];
            array[sndI] = temp;
        }
    }

    @Contract(pure = true)
    private int useBitwiseXOR(@NotNull int[] array) {
        int result = array[0];
        for (int i = 1; i < array.length; i++) {
            result ^= array[i];
        }
        return result;
    }

    @NotNull
    private String parseDenseHashToHex(@NotNull int[] denseHash) {
        StringBuilder sb = new StringBuilder();
        for (int hash : denseHash) {
            sb.append(String.format("%02X", hash));
        }
        return sb.toString();
    }

    String parseHexStringToBinString(String hex) {
        StringBuilder sb = new StringBuilder();
        for (String hexChar : hex.split("")) {
            int dec = Integer.parseInt(hexChar, 16);
            sb.append(addLeadingZeros(Integer.toBinaryString(dec)));
        }
        return sb.toString();
    }

    @NotNull
    private String addLeadingZeros(String binaryString) {
        StringBuilder sb = new StringBuilder(binaryString);
        while (4 % sb.length() != 0 || sb.length() < 4) {
            sb.insert(0, "0");
        }
        return sb.toString();
    }

    void printMatrix(int[][] matrix) {
        for (int[] line : matrix) {
            for (int number : line) {
                System.out.print(number + "\t");
            }
            System.out.println();
        }
        System.out.println();
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

    int[] specialLinesToIntArr() {
        String input = readLinesToString();

        int[] intArr = new int[2];
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
                String[] splitLine = line.split(" ");
                try {
                    if("A".equals(splitLine[1])) {
                        intArr[0]=Integer.parseInt(splitLine[4]);
                    } else if("B".equals(splitLine[1])) {
                        intArr[1]=Integer.parseInt(splitLine[4]);
                    } else {
                        return null;
                    }
                } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                    return null;
                }
            } else {
                break;
            }
        }
        return intArr;
    }
}
