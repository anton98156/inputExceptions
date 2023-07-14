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

    protected static void checkAllOtherExpcetions(String[] personalDataArray) {

        if (personalDataArray.length > 6) {
            throw new ArrayIndexOutOfBoundsException("введено больше данных, чем требуется.");
        }
        else if (personalDataArray.length < 6) {
            throw new ArrayIndexOutOfBoundsException("введено меньше данных, чем требуется.");
        }

        else if (containsNonLetters(personalDataArray[0]) == true ||
                        containsNonLetters(personalDataArray[1]) == true || containsNonLetters(personalDataArray[2]) == true) {
            throw new IllegalArgumentException("ФИО задано неверно");
        }

        else if (personalDataArray[3] != null && !personalDataArray[3].isEmpty()) {
            try { SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
            dateFormat.parse(personalDataArray[3]);
            } catch (ParseException e) {
                throw new IllegalArgumentException("введен неправильный формат даты " + e.getMessage().substring(18));
            }
        }

        else if (!personalDataArray[4].matches("\\d{7}")) {
            throw new IllegalArgumentException("неверный номер телефона, требуется семизначное число.");
        }

        else if (!personalDataArray[5].matches("f") && !personalDataArray[5].matches("m")) {
            throw new IllegalArgumentException("неверно указан пол, требуется ввести f или m на латинице.");
        }
    }

    private static boolean containsNonLetters(String str) {
        return str.matches(".*[^а-яА-Яa-zA-Z].*");
    }
}
