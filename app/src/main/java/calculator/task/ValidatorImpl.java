package calculator.task;

class ValidatorImpl implements Validator {
    @Override
    public void validateVarRange(Integer firstVar, Integer secondVar) throws ValidationException {
        if (firstVar > 10 || firstVar < 1 || secondVar > 10 || secondVar < 1) {
            throw new ValidationException("Variables must be between 1 to 10!");
        }
    }

    @Override
    public void validateVarType(Boolean firstVar, Boolean secondVar) throws ValidationException {
        if (firstVar != secondVar) {
            throw new ValidationException("Both of variables have to be Arabic or Roman! Check your equation.");
        }
    }
}
