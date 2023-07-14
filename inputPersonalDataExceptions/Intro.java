package inputPersonalDataExceptions;

public class Intro {

    protected static void printIntro() {

        System.out.println("\nВведите данные через пробел в следующем формате:");
        System.out.println("Фамилия Имя Отчество датаРОЖДЕНИЯ номерТЕЛЕФОНА пол");
        System.out.println("* датаРОЖДЕНИЯ - в формате dd.mm.yyyy");
        System.out.println("* номерТЕЛЕФОНА - семизначное число");
        System.out.println("* пол - символ латиницей f или m");
        System.out.println("При нарушении правил ввода программа уведомит вас об ошибке.");

        System.out.println("\nВвод: ");

    }
}
