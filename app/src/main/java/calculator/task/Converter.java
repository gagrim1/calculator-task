package calculator.task;

import java.util.Map;
import java.util.TreeMap;

interface Converter {
    String intToRoman(Integer number);
    Integer romanToInt(String digit) throws ValidationException;
    Boolean isRoman(String number);
    Operation parseOperation(char[] operationArray) throws ValidationException;
}
