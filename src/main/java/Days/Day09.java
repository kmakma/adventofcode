package Days;

import Days.tools.Status;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * solution part one: 12803
 * <p>
 * solution part two: 6425
 *
 * @see <a href="http://adventofcode.com/2017/day/9">Advent of Code: Day 9</a>
 */
public class Day09 extends Day {

    private static final Character OPEN_GROUP = '{';
    private static final Character OPEN_GARBAGE = '<';
    private static final Character CLOSE_GROUP = '}';
    private static final Character CLOSE_GARBAGE = '>';
    private static final Character COMMA = ',';
    private static final Character EXMARK = '!';
    private int depth;
    private int score;
    private int nonCanceledChars;
    private @NotNull Status status = Status.START;

    public Day09() {
        System.out.println("\n--- Day 9: Stream Processing ---");
        // input
        Character[] input = (Character[]) parseInputLine(Return.CHAR_ARRAY);
        // wörk
        if (input != null) {
            calculateScore(input);
        }
        System.out.println();
        // finished
    }

    public static void main(String[] args) {
        new Day09();
    }

    private void calculateScore(Character[] inputChars) {
        depth = 0;
        score = 0;
        nonCanceledChars = 0;
        for (Character input : inputChars) {
            switchStatus(input);
        }
        System.out.println("Solution Part One:");
        System.out.println("\t" + score);
        System.out.println("Solution Part Two:");
        System.out.println("\t" + nonCanceledChars);
    }

    private void switchStatus(Character input) {
        switch (status) {
            case START:
                status = parseStart(input);
                break;
            case OPENED_GROUP:
                status = parseOpenedGroup(input);
                break;
            case CLOSED_GROUP:
                status = parseClosed(input);
                break;
            case OPENED_GARBAGE:
                status = parseOpenedGarbage(input);
                break;
            case CLOSED_GARBAGE:
                status = parseClosed(input);
                break;
            case USED_COMMA:
                status = parseUsedComma(input);
                break;
            case USED_EXMARK:
                status = parseUsedExMark();
                break;
            case FINISHED:
                status = explode();
                break;
            case EXPLODED:
                System.out.println("Error, calculation aborted");
                break;
            default:
                status = explode();
        }
    }

    @NotNull
    private Status parseStart(Character input) {
        if (isOpenGroup(input)) {
            return openGroup();
        } else {
            return explode();
        }
    }

    @NotNull
    private Status parseOpenedGroup(Character input) {
        if (isOpenGroup(input)) {
            return openGroup();
        } else if (isCloseGroup(input)) {
            return closeGroup();
        } else if (isOpenGarbage(input)) {
            return openGarbage();
        } else {
            return explode();
        }
    }

    @NotNull
    private Status parseClosed(Character input) {
        if (isCloseGroup(input)) {
            return closeGroup();
        } else if (isComma(input)) {
            return useComma();
        } else {
            return explode();
        }
    }

    @NotNull
    private Status parseOpenedGarbage(Character input) {
        if (isCloseGarbage(input)) {
            return closeGarbage();
        } else if (isExMark(input)) {
            return useExMark();
        } else {
            nonCanceledChars++;
            return noStatusChange();
        }
    }

    @NotNull
    private Status parseUsedComma(Character input) {
        if (isOpenGroup(input)) {
            return openGroup();
        } else if (isOpenGarbage(input)) {
            return openGarbage();
        } else {
            return explode();
        }
    }

    @Contract(pure = true)
    @NotNull
    private Status parseUsedExMark() {
        return openGarbage();
    }

    @Contract(value = "null -> false", pure = true)
    private boolean isOpenGroup(Character input) {
        return OPEN_GROUP.equals(input);
    }

    @Contract(value = "null -> false", pure = true)
    private boolean isCloseGroup(Character input) {
        return CLOSE_GROUP.equals(input);
    }

    @Contract(value = "null -> false", pure = true)
    private boolean isOpenGarbage(Character input) {
        return OPEN_GARBAGE.equals(input);
    }

    @Contract(value = "null -> false", pure = true)
    private boolean isCloseGarbage(Character input) {
        return CLOSE_GARBAGE.equals(input);
    }

    @Contract(value = "null -> false", pure = true)
    private boolean isComma(Character input) {
        return COMMA.equals(input);
    }

    @Contract(value = "null -> false", pure = true)
    private boolean isExMark(Character input) {
        return EXMARK.equals(input);
    }

    @NotNull
    private Status openGroup() {
        depth++;
        score += depth;
        return Status.OPENED_GROUP;
    }

    @NotNull
    private Status closeGroup() {
        depth--;
        if (depth != 0) {
            return Status.CLOSED_GROUP;
        } else {
            return Status.FINISHED;
        }
    }

    @Contract(pure = true)
    @NotNull
    private Status openGarbage() {
        return Status.OPENED_GARBAGE;
    }

    @Contract(pure = true)
    @NotNull
    private Status closeGarbage() {
        return Status.CLOSED_GARBAGE;
    }

    @Contract(pure = true)
    @NotNull
    private Status useComma() {
        return Status.USED_COMMA;
    }

    @Contract(pure = true)
    @NotNull
    private Status useExMark() {
        return Status.USED_EXMARK;
    }

    @Contract(pure = true)
    @NotNull
    private Status noStatusChange() {
        return status;
    }

    @NotNull
    private Status explode() {
        depth = -1;
        score = -1;
        return Status.EXPLODED;
    }

    @NotNull
    @Override
    String getDefaultInput() {
        return MyInput.DAY09.getInput();
    }
}