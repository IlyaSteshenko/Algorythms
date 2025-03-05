import java.util.HashMap;
import java.util.Map;

public class Solution {

    // Roman to Decimal task
    public static int romanToDecimal(String romanNum) {
        String[] romanNumArr = romanNum.split("");
        Map<String, Integer> romanDecimalMap = getStringIntegerMap();
        int result = 0;

        for (int i = 0; i < romanNumArr.length; i++) {
            String currEl = romanNumArr[i];

            if (i == romanNumArr.length - 1) {
                result += romanDecimalMap.get(currEl);
                break;
            }

            String doubleNum = currEl + romanNumArr[i + 1];
            if (romanDecimalMap.get(doubleNum) != null) {
                result += romanDecimalMap.get(doubleNum);
                i += 1;
                continue;
            }
            result += romanDecimalMap.get(currEl);
        }

        return result;
    }

    private static Map<String, Integer> getStringIntegerMap() {
        Map<String, Integer> romanDecimalMap = new HashMap<>();
        romanDecimalMap.put("I", 1);
        romanDecimalMap.put("V", 5);
        romanDecimalMap.put("X", 10);
        romanDecimalMap.put("L", 50);
        romanDecimalMap.put("C", 100);
        romanDecimalMap.put("D", 500);
        romanDecimalMap.put("M", 1000);
        romanDecimalMap.put("IV", 4);
        romanDecimalMap.put("IX", 9);
        romanDecimalMap.put("XL", 40);
        romanDecimalMap.put("XC", 90);
        romanDecimalMap.put("CD", 400);
        romanDecimalMap.put("CM", 900);
        return romanDecimalMap;
    }

}
