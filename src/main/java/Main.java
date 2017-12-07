import Days.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.ZoneId;

public class Main {

    private static ZoneId zoneId = ZoneId.of("EST", ZoneId.SHORT_IDS);

    public static void main(String[] args) {
        System.out.println("\t* * * * * * * * * * * *");
        System.out.println("\t* Advent of Code 2017 *");
        System.out.println("\t* * * * * * * * * * * *\n");

        boolean isContinue = true;
        while (isContinue) {
            isContinue = chooseDay();
        }
    }

    private static boolean chooseDay() {
        int day;
        do {
            day = enterDay();
        } while (day < 0);
        switch (day) {
            case 0:
                return false;
            case 1:
                new Day01();
                break;
            case 2:
                new Day02();
                break;
            case 3:
                new Day03();
                break;
            case 4:
                new Day04();
                break;
            case 5:
                new Day05();
                break;
            case 6:
                new Day06();
                break;
            case 7:
                new Day07();
                break;
//            case 8:
//                break;
//            case 9:
//                break;
//            case 10:
//                break;
//            case 11:
//                break;
//            case 12:
//                break;
//            case 13:
//                break;
//            case 14:
//                break;
//            case 15:
//                break;
//            case 16:
//                break;
//            case 17:
//                break;
//            case 18:
//                break;
//            case 19:
//                break;
//            case 20:
//                break;
//            case 21:
//                break;
//            case 22:
//                break;
//            case 23:
//                break;
//            case 24:
//                break;
            default:
                System.out.println("\tDay " + day + " not yet implemented!");
                break;
        }
        return true;
    }

    private static int enterDay() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter day [default: " + getCurrentDay() + "] or \"exit\": ");
        String dayInput = null;
        try {
            dayInput = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (dayInput == null) {
            return -1;
        }
        if ("".equals(dayInput)) {
            return getCurrentDay();
        }
        if ("exit".equals(dayInput)) {
            return 0;
        }
        int day;
        try {
            day = Integer.parseInt(dayInput);
        } catch (NumberFormatException e) {
            return -1;
        }
        if (day > 0 && day < 26) {
            return day;
        }
        return -1;
    }

    /**
     * @return Days.Day of Month in New York (0am @ New York = new puzzle)
     */
    private static int getCurrentDay() {
        return LocalDate.now(zoneId).getDayOfMonth();
    }
}
