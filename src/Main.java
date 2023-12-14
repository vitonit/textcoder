import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static int i;

    public static void main(String[] args) {

        char[] alphabetArr = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я', '?', '.', ',', ' ', '\n'};
        // char[] alphabetArr = {'а', 'б', "в", "г", "д", "е", "ж", "з", "и", "й", "к", "л", "м", "н", "о", "п", "р", "с", "т", "у", "ф", "х", "ц", "ч", "ш", "щ", "ъ", "ы", "ь", "э", "ю", "я", "?", ".", ",", " ", "\n"};
        // int[] days = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 67, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 53, 23, 24, 25, 26, 27, 28, 29, 30, 31};
        int[] codesAlphabet = {22, 15, 33, 45, 98, 27, 67, 90, 77, 43, 55, 82, 66, 91, 93, 81, 83, 56, 88, 35, 68, 11, 21, 14, 41, 23, 32, 57, 75, 19, 29, 44, 99, 72, 47, 74, 85,};
        double[] functionsArg = {2.0, 3.0, 3.0, 3.0, 5.0, 4.0, 2.0, 10.0, 20.0, 8.0, 8.0, 4.0, 6.0, 10.0, 20.0, 5.0, 6.0, 7.0, 8.0, 7.0, 8.0, 1.0, 3.0, 4.0, 5.0, 7.0, 2.0, 4.0, 5.0, 10.0, 10.0, 11.0};
        // char[] functions = {'2', '3', '3', '3', '5', '4', "2", "10", "20", "8", "8", "4", "6", "10", "20", "5", "6", "7", "8", "7", "8", "1", "3", "4", "5", "7", "2", "4", "5", "10", "10"};
        String[] functions = {"+", "-", "/", "*", "+", "-", "/", "*", "+", "-", "+", "-", "/", "*", "+", "-", "/", "*", "+", "-", "/", "*", "+", "-", "/", "*", "+", "-", "/", "*", "+", "*"};

        Scanner sc = new Scanner(System.in);
        System.out.println("Insert your text"); // Enter text for coding
        String text = sc.nextLine();

        System.out.println("Insert shift"); // Enter the shift parameter
        int dataShift = sc.nextInt();
        String text1 = sc.nextLine();

        System.out.println("Insert Date (dd.mm.yyyy)");
        String currentDate = sc.nextLine(); // Enter the date of departure of the message

        int DayOfMonth = Integer.parseInt(currentDate.substring(0, 2));  // We allocate from the date the number of the day
        int dataShiftResult = 0;  // We shift the date
        if (dataShiftResult > 31) {
            dataShiftResult = dataShiftResult - 31;
        }
        else
            dataShiftResult = DayOfMonth + dataShift;
        System.out.println(dataShiftResult);

        System.out.println(text);  // kontrole

        char[] textArray = text.toCharArray();  // We convert the text into a symbolic array
        System.out.println(Arrays.toString(textArray));

        double[] textCodesArray = new double[textArray.length];  // &&&&777
        int k = 0;
        for (int i = 0; i < textArray.length; i++) {
            for (int j = 0; j < alphabetArr.length; j++) {
                if (textArray[i] == alphabetArr[j]) {
                    textCodesArray[k] = codesAlphabet[j]; // We fill out an array of text codes

                    if (k < textArray.length) {
                        k++;
                    }

                }
            }
        }
        System.out.println(Arrays.toString(textCodesArray)); // контроль

        String[] parameterOne = {"+", "-", "/", "*"};
        for (int j = 0; j < parameterOne.length; j++) {
            if (parameterOne[j].equals(functions[dataShiftResult])) {
                int indexFunction = j;

                float[] finalTextCode = new float[(textArray.length + 1)];  // Create Array for storing the final code of the text
                finalTextCode[textArray.length] = dataShiftResult;  // The last member of the array
                 System.out.print(finalTextCode[textArray.length] + " ");

                switch (indexFunction) {
                    case 0:

                        for (int i = 0; i < textArray.length; i++) {
                            finalTextCode[i] = (float) (textCodesArray[i] + functionsArg[dataShiftResult]);
                            System.out.printf("%f ", finalTextCode[i]);
                        }

                        break;
                    case 1:
                        for (int i = 0; i < textArray.length; i++) {
                            finalTextCode[i] = (float) (textCodesArray[i] - functionsArg[dataShiftResult]);
                            System.out.printf("%f ", finalTextCode[i]);
                        }

                        break;
                    case 2:
                        for (int i = 0; i < textArray.length; i++) {
                            finalTextCode[i] = (float) (textCodesArray[i] / functionsArg[dataShiftResult]);
                            System.out.printf("%f ", finalTextCode[i]);
                        }

                        break;
                    case 3:
                        for (int i = 0; i < textArray.length; i++) {
                            finalTextCode[i] = (float) (textCodesArray[i] * functionsArg[dataShiftResult]);
                            System.out.printf("%f ", finalTextCode[i]);
                        }

                        break;

                    default:
                        throw new IllegalStateException("Unexpected value: " + indexFunction);
                }
            }
        }
    }
}