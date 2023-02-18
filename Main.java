import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(calc(input));
    }

    public static String calc(String input) {
        // Exception
        if (input.length() < 5) {throw new RuntimeException("Строка не является математической операцией");}
        // Exception
        String[] forException = input.split("[+\\-*/]");
        if (forException.length != 2) {throw new RuntimeException("Формат математической операции " +
                    "не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");}

        input = input.replaceAll("\\s+", " ").trim();
        String[] array = input.split(" ");
        String num1 = (array[0]);
        String operation = array[1];
        String num2 = (array[2]);
        // Exception
        if ((isArabicForOne(num1) && isRomanForOne(num2)) || (isArabicForOne(num2) && isRomanForOne(num1))) {
            throw new RuntimeException("Используются одновременно разные системы счисления");
        }

        if (isArabic(num1, num2)) {
            Integer n1 = Integer.parseInt(num1);
            Integer n2 = Integer.parseInt(num2);
            if ((n1 < 1) || (n1 > 10) || (n2 < 1) || (n2 > 10)) {
                throw new RuntimeException("Вы ввели не допустимое значение. Введите число от 1 до 10");
            }
            int result;
            switch (operation) {
                case "+":
                    result = n1 + n2;
                    break;
                case "-":
                    result = n1 - n2;
                    break;
                case "*":
                    result = n1 * n2;
                    break;
                case "/":
                    result = n1 / n2;
                    break;
                default:
                    throw new RuntimeException("Вы ввели не подходящий символ. Введите +,-,* или /");
            }
            return String.valueOf(result);
        }
        return RomanCalc(num1, num2, operation);
    }
    // Methods
    public static String RomanCalc(String num1, String num2, String operation) {
        Integer n1 = null;
        Integer n2 = null;
        for (Map.Entry<Integer, String> entry : RomanNumber.romanMap.entrySet()) {
            if (entry.getValue().equals(num1)) {
                n1 = entry.getKey();
            }
            if (entry.getValue().equals(num2)) {
                n2 = entry.getKey();
            }
        }
        if (!isRoman(num1, num2)) {
            throw new RuntimeException("Вы ввели не допустимое значение. Введите цифру от I до X");
        }
        int result;
        switch (operation) {
            case "+":
                result = n1 + n2;
                break;
            case "-":
                result = n1 - n2;
                break;
            case "*":
                result = n1 * n2;
                break;
            case "/":
                result = n1 / n2;
                break;
            default:
                throw new RuntimeException("Вы ввели не подходящий символ. Введите +,-,* или /");
        }
        return RomanNumber.ConvertToRoman(result);
    }

    public final static boolean isArabic(String num1, String num2) {
        List<String> arabicList = List.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
        return arabicList.contains(num1) && arabicList.contains(num2);
    }

    public final static boolean isArabicForOne(String num1) {
        List<String> arabicList = List.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
        return arabicList.contains(num1);
    }

    public final static boolean isRoman(String num1, String num2) {
        List<String> romanList = List.of("I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X");
        return romanList.contains(num1) && romanList.contains(num2);
    }

    public final static boolean isRomanForOne(String num1) {
        List<String> romanList = List.of("I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X");
        return romanList.contains(num1);
    }
}

