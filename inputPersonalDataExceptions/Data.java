package inputPersonalDataExceptions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Data {

    protected static String inputString() {
        Scanner sc = new Scanner(System.in);
        String inputStr = sc.nextLine();
        sc.close();

        return inputStr;
    }

    protected static String[] inputDataArray(String input) {
        String[] inputArray = input.split(" ");
        return inputArray;
    }

    protected static void checkAllOtherExpcetions(String[] arr) {

        if (arr.length > 6) {
            throw new ArrayIndexOutOfBoundsException("введено больше данных, чем требуется.");
        }
        else if (arr.length < 6) {
            throw new ArrayIndexOutOfBoundsException("введено меньше данных, чем требуется.");
        }

        else if (containsNonLetters(arr[0]) == true ||
                        containsNonLetters(arr[1]) == true || containsNonLetters(arr[2]) == true) {
            throw new IllegalArgumentException("ФИО задано неверно");
        }

        else if (arr[3] != null && !arr[3].isEmpty()) {
            try { SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
            dateFormat.parse(arr[3]);
            } catch (ParseException e) {
                throw new IllegalArgumentException("введен неправильный формат даты " + e.getMessage().substring(18));
            }
        }

        else if (!arr[4].matches("\\d{7}")) {
            throw new IllegalArgumentException("неверный номер телефона, требуется семизначное число.");
        }
        
        else if (!arr[5].matches("f") && !arr[5].matches("m")) {
            throw new IllegalArgumentException("неверно указан пол, требуется ввести f или m на латинице.");
        }
    }

    private static boolean containsNonLetters(String str) {
        return str.matches(".*[^а-яА-Яa-zA-Z].*");
    }
}
