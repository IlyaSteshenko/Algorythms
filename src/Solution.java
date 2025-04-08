import java.util.*;

public class Solution {

    // Roman to Decimal task
    public static int romanToDecimal(String romanNum) {
        String[] romanNumArr = romanNum.split("");
        Map<String, Integer> romanDecimalMap = getStringIntegerMap();
        int result = 0;

        String currEl;
        String doubleNum;

        for (int i = 0; i < romanNumArr.length; i++) {
            currEl = romanNumArr[i];

            if (i == romanNumArr.length - 1) {
                result += romanDecimalMap.get(currEl);
                break;
            }

            doubleNum = currEl + romanNumArr[i + 1];
            if (romanDecimalMap.get(doubleNum) != null) {
                result += romanDecimalMap.get(doubleNum);
                i++;
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

    // Two Sum
    public static int[] twoSum(int[] nums, int target) {
        if (nums.length == 2) {
            return new int[]{0, 1};
        }

        int[] result = new int[2];

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.get(diff) != null) {
                result[0] = i;
                result[1] = map.get(diff);
            }
        }

        return result;
    }

    // Add Two Numbers
//    public static LinkedList<Integer> addTwoNumbers(
//            LinkedList<Integer> originList, LinkedList<Integer> additionList) {
//    }

    // Математическое решение задачи
    public static boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x < 10) return true;
        if (x < 100) return x % 10 == x / 10;

        int digitsCount;
        int leftIndex = 0;

        // (int) Math.log10(x) - возвращает кол-во цифр в числе минус 1
        int rightIndex = (int) Math.log10(x);

        while (leftIndex < rightIndex) {
            if (x == 0) break;

            digitsCount = (int) Math.log10(x);
            int leftNum = x / (int) Math.pow(10, digitsCount);
            int rightNum = x % 10;

            if (leftNum != rightNum) return false;

            x /= 10;
            if (x == 0) return false;
            x %= (int) Math.pow(10, digitsCount - 1);

            leftIndex++;
            rightIndex--;
        }

        return true;
    }

    // Бинарный поиск по массиву чисел
    public static int binarySearchInt(List<Integer> searchableList, int requiredInt) {

        if (searchableList.get(0) == requiredInt) {
            return 0;
        }
        if (searchableList.get(searchableList.size() - 1) == requiredInt) {
            return searchableList.size() - 1;
        }

        int left = 0;
        int right = searchableList.size() - 1;
        int mid = (right + left) / 2;
        int iterator = 0;

        while (iterator != searchableList.size()) {
            if (searchableList.get(mid) == requiredInt) {
                return mid;
            } else if (searchableList.get(mid) > requiredInt) {
                right = mid;
                mid = (left + right) / 2;
                iterator++;
                continue;
            }
            left = mid;
            mid = (left + right) / 2;
            iterator++;
        }

        return -1;
    }

    // Минимальное кол-во купюр из банкомата по указанной сумме
    public static int minBanknotes(int[] banknotes, int amount) {
        Arrays.sort(banknotes);
        int count = 0;

        for (int i = banknotes.length - 1; i >= 0; i--) {
            count += amount / banknotes[i];
            amount %= banknotes[i];
        }

        return amount == 0 ? count : -1;
    }

}
