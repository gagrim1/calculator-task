package calculator.task;

import java.util.Map;
import java.util.TreeMap;

class ConverterImpl implements Converter {
    private final Map<Character, Integer> romanKeyMap = new TreeMap<>();
    private final TreeMap<Integer, String> arabicKeyMap = new TreeMap<>();

    ConverterImpl() {
        romanKeyMap.put('I', 1);
        romanKeyMap.put('V', 5);
        romanKeyMap.put('X', 10);
        romanKeyMap.put('L', 50);
        romanKeyMap.put('C', 100);
        romanKeyMap.put('D', 500);
        romanKeyMap.put('M', 1000);

        arabicKeyMap.put(1000, "M");
        arabicKeyMap.put(900, "CM");
        arabicKeyMap.put(500, "D");
        arabicKeyMap.put(400, "CD");
        arabicKeyMap.put(100, "C");
        arabicKeyMap.put(90, "XC");
        arabicKeyMap.put(50, "L");
        arabicKeyMap.put(40, "XL");
        arabicKeyMap.put(10, "X");
        arabicKeyMap.put(9, "IX");
        arabicKeyMap.put(5, "V");
        arabicKeyMap.put(4, "IV");
        arabicKeyMap.put(1, "I");
    }


    @Override
    public String intToRoman(Integer number) {
        String roman = "";
        int arabianKey;
        do {
            arabianKey = arabicKeyMap.floorKey(number);
            roman += arabicKeyMap.get(arabianKey);
            number -= arabianKey;
        } while (number != 0);
        return roman;
    }

    @Override
    public Integer romanToInt(String digit) {
        int end = digit.length() - 1;
        char[] charArray = digit.toCharArray();
        int arabian;
        int result = romanKeyMap.get(charArray[end]);
        for (int i = end - 1; i >= 0; i--) {
            arabian = romanKeyMap.get(charArray[i]);

            if (arabian < romanKeyMap.get(charArray[i + 1])) {
                result -= arabian;
            } else {
                result += arabian;
            }
        }
        return result;
    }

    @Override
    public Boolean isRoman(String number) {
        return romanKeyMap.containsKey(number.charAt(0));
    }

    @Override
    public Operation parseOperation(char[] operationArray) throws ValidationException {
        if (operationArray.length != 1) {
            throw new ValidationException("Equation is not valid!");
        }
        return Operation.findByField(operationArray[0]);
    }
}
