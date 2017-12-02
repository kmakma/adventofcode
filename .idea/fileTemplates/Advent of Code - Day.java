import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ${NAME} {

    /**
     * official input
     * <p>
     * solution part one: 
     * <p>
     * solution part two: 
     */
    private static final String myInput = "";

    ${NAME}() {
        System.out.println("\n--- ${NAME}: ____ ---");
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter Input-String: ");
        String input = null;
        try {
            input = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (input == null || "".equals(input)) {
            input = myInput;
        }
        // wörk
        // TODO: ${DATE} work with input 
        System.out.println();
        // finished
    }

    public static void main(String[] args) {
        new ${NAME}();
    }
}
