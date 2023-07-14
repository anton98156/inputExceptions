package inputPersonalDataExceptions;

public class Main {
    public static void main(String[] args) {

        Intro.printIntro();
        String originalStr = Data.inputString();
        String[] humanData = Data.inputDataArray(originalStr);

        try {
            Data.checkAllOtherExpcetions(humanData);
        } catch (Exception e) {
            System.out.println("\nОшибка: " + e.getMessage());
        }

        FileCreator.createPersonalDataFile(humanData);

    }
}
