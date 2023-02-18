import java.util.TreeMap;

public class RomanNumber {

    public final static TreeMap<Integer, String> romanMap = new TreeMap<Integer, String>();

    static {
        romanMap.put(400, "CD");
        romanMap.put(100, "C");
        romanMap.put(90, "XC");
        romanMap.put(50, "L");
        romanMap.put(40, "XL");
        romanMap.put(10, "X");
        romanMap.put(9, "IX");
        romanMap.put(8, "VIII");
        romanMap.put(7, "VII");
        romanMap.put(6, "VI");
        romanMap.put(5, "V");
        romanMap.put(4, "IV");
        romanMap.put(3, "III");
        romanMap.put(2, "II");
        romanMap.put(1, "I");
    }

    public final static String ConvertToRoman(int number) {
        if (number <= 0) {throw new RuntimeException("В римской системе нет отрицательных чисел");}
        int floorKey = romanMap.floorKey(number);
        if (number == floorKey) {
            return romanMap.get(number);
        }
        return romanMap.get(floorKey) + ConvertToRoman(number - floorKey);
    }

}
