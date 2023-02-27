package calculator.task;

interface Validator {
    void validateVarRange(Integer firstVar, Integer secondVar) throws ValidationException;
    void validateVarType(Boolean firstVar, Boolean secondVar) throws ValidationException;
}
