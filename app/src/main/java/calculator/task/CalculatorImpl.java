package calculator.task;

class CalculatorImpl implements Calculator {
    private final Converter converter = Factory.getInstance().create(Converter.class);
    private final Validator validator = Factory.getInstance().create(Validator.class);

    @Override
    public String calculate(String input) throws ValidationException {
        boolean isRoman = false;
        int firstValue;
        int secondValue;
        int result;
        String[] inputParts = input.split(" ");
        validator.validateVarType(converter.isRoman(inputParts[0]), converter.isRoman(inputParts[2]));
        try {
            firstValue = Integer.parseInt(inputParts[0]);
            secondValue = Integer.parseInt(inputParts[2]);
        } catch (NumberFormatException ex) {
            firstValue = converter.romanToInt(inputParts[0]);
            secondValue = converter.romanToInt(inputParts[2]);
            isRoman = true;
        }
        validator.validateVarRange(firstValue, secondValue);
        Operation operation = converter.parseOperation(inputParts[1].toCharArray());
        result = operate(operation, firstValue, secondValue, isRoman);
        if (isRoman) {
            return converter.intToRoman(result);
        }
        return Integer.toString(result);
    }

    private static Integer operate(Operation operation, int firstValue, int secondValue, boolean isRoman) throws ValidationException {
        int result = 0;
        switch (operation) {
            case ADD -> result = firstValue + secondValue;
            case SUB -> {
                if (isRoman && firstValue <= secondValue) {
                    throw new ValidationException("Result can not be negative or zero with roman numerals!");
                }
                result = firstValue - secondValue;
            }
            case MULT -> result = firstValue * secondValue;
            case DIV -> result = firstValue / secondValue;
            case UNDEFINED -> throw new ValidationException("Operation is not valid! Check your equation.");
        }
        return result;
    }
}
