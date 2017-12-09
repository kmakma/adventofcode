package Days;

import Days.tools.RegisterInstruction;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * solution part one: 4448
 * <p>
 * solution part two: 6582
 *
 * @see <a href="http://adventofcode.com/2017/day/8">Advent of Code: Day 8</a>
 */
public class Day08 extends Day {

    private final Map<String, Integer> registers = new HashMap<>();
    private int largestValueEver = 0;

    public Day08() {
        System.out.println("\n--- Day 8: I Heard You Like Registers ---");
        // input
        @SuppressWarnings("unchecked") List<RegisterInstruction> regInstr = (List<RegisterInstruction>) parseInputLines(
                Return.REG_INSTR);
        // wörk
        if (regInstr != null) {
            executeInstructions(regInstr);
        }
        System.out.println();
        // finished
    }

    public static void main(String[] args) {
        new Day08();
    }

    private void executeInstructions(List<RegisterInstruction> regInstr) {
        for (RegisterInstruction instruction : regInstr) {
            if (checkCondition(instruction)) {
                executeOperation(instruction);
            }
        }
        Integer largestValue = Collections.max(registers.values());
        System.out.println("Solution Part One:");
        System.out.println("\t" + largestValue);
        System.out.println("Solution Part Two:");
        System.out.println("\t" + largestValueEver);
    }

    private void executeOperation(RegisterInstruction instruction) {
        int oldValue = getRegisterValue(instruction.getModifyRegister());
        int newValue = oldValue + (instruction.getModifyingOperation() * instruction.getChangeRegisterBy());
        if (newValue > largestValueEver) {
            largestValueEver = newValue;
        }
        registers.put(instruction.getModifyRegister(), newValue);
    }

    private boolean checkCondition(RegisterInstruction instruction) {
        int registerValue = getRegisterValue(instruction.getConditionRegister());
        int compareValue = instruction.getConditionCompareValue();
        switch (instruction.getConditionOperator()) {
            case EQUAL:
                return registerValue == compareValue;
            case NOT_EQUAL:
                return registerValue != compareValue;
            case GREATER:
                return registerValue > compareValue;
            case LESS:
                return registerValue < compareValue;
            case GREATER_EQUAL:
                return registerValue >= compareValue;
            case LESS_EQUAL:
                return registerValue <= compareValue;
        }
        return false;
    }

    private int getRegisterValue(String register) {
        Integer registerValue = registers.putIfAbsent(register, 0);
        if (registerValue == null) {
            registerValue = 0;
        }
        return registerValue;
    }

    @NotNull
    @Override
    String getDefaultInput() {
        return MyInput.DAY08.getInput();
    }
}