package Days.tools;

import org.jetbrains.annotations.Nullable;

public class RegisterInstruction {
    private final String modifyRegister;
    private final int modifyingOperation;
    private final int changeRegisterBy;
    private final String conditionRegister;
    private final RelationalOperator conditionOperator;
    private final int conditionCompareValue;

    public RegisterInstruction(String modifyRegister, int modifyingOperation, int changeRegisterBy,
                               String conditionRegister, RelationalOperator conditionOperator,
                               int conditionCompareValue) {
        this.modifyRegister = modifyRegister;
        this.modifyingOperation = modifyingOperation;
        this.changeRegisterBy = changeRegisterBy;
        this.conditionRegister = conditionRegister;
        this.conditionOperator = conditionOperator;
        this.conditionCompareValue = conditionCompareValue;
    }

    @Nullable
    public static RegisterInstruction parse(String instructionLine) {
        if (instructionLine == null) {
            return null;
        }
        String[] splitLine = instructionLine.split(" ");
        if (splitLine.length != 7) {
            return null;
        }

        String modReg = splitLine[0];

        int op;
        if ("inc".equals(splitLine[1])) {
            op = 1;
        } else if ("dec".equals(splitLine[1])) {
            op = -1;
        } else {
            return null;
        }

        int changeBy;
        try {
            changeBy = Integer.parseInt(splitLine[2]);
        } catch (NumberFormatException e) {
            return null;
        }

        if (!"if".equals(splitLine[3])) {
            return null;
        }

        String condReg = splitLine[4];

        RelationalOperator condOp = RelationalOperator.parse(splitLine[5]);
        if (condOp == null) {
            return null;
        }

        int condValue;
        try {
            condValue = Integer.parseInt(splitLine[6]);
        } catch (NumberFormatException e) {
            return null;
        }

        return new RegisterInstruction(modReg, op, changeBy, condReg, condOp, condValue);
    }

    public String getModifyRegister() {
        return modifyRegister;
    }

    public int getModifyingOperation() {
        return modifyingOperation;
    }

    public int getChangeRegisterBy() {
        return changeRegisterBy;
    }

    public String getConditionRegister() {
        return conditionRegister;
    }

    public RelationalOperator getConditionOperator() {
        return conditionOperator;
    }

    public int getConditionCompareValue() {
        return conditionCompareValue;
    }
}
