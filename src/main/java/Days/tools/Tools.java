package Days.tools;

import org.jetbrains.annotations.Nullable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

class Tools {

    @Nullable
    static List<String[]> splitInput(String input) {
        BufferedReader br = new BufferedReader(new StringReader(input));
        String line;
        List<String[]> splitLines = new ArrayList<>();
        do {
            try {
                line = br.readLine();
            } catch (IOException e) {
                System.err.println("IOException while reading string.");
                return null;
            }
            if (line == null) {
                break;
            }
            String[] splitLine = line.trim().split(" ", 3);
            if (splitLine.length >= 2) {
                splitLines.add(splitLine);
            }
        } while (!"".equals(line));
        return splitLines;
    }
}
