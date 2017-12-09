package Days.tools;

public enum RelationalOperator {
    EQUAL, NOT_EQUAL, GREATER, LESS, GREATER_EQUAL, LESS_EQUAL;

    public static RelationalOperator parse(String operator) {
        switch (operator) {
            case "==":
                return EQUAL;
            case "!=":
                return NOT_EQUAL;
            case ">":
                return GREATER;
            case "<":
                return LESS;
            case ">=":
                return GREATER_EQUAL;
            case "<=":
                return LESS_EQUAL;
            default:
                return null;
        }
    }
}
