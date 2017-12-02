package Days;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

abstract class Day {

    abstract String getDefaultInput();

    @NotNull String readLine() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter Input-String: ");
        String input = null;
        try {
            input = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return decideIfOfficialInput(input);
    }

    private String decideIfOfficialInput(String input) {
        if (input == null || "".equals(input)) {
            System.out.println("Official Input will be used.");
            return getDefaultInput();
        }
        return input;
    }

    @NotNull String readLines() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter multiline Input-String (finish with empty line):");
        StringBuilder input = new StringBuilder();
        String line = null;
        do {
            if (line != null) {
                input.append(line);
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
}
