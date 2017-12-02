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
        if (input == null || "".equals(input)) {
            System.out.println("Official Input will be used.");
            input = getDefaultInput();
        }
        return input;
    }
}
