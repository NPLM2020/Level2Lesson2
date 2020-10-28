import exceptions.MyArrayDataException;
import exceptions.MyArraySizeException;

public class Main {

    /**
     * 3. В методе main() вызвать полученный метод,
     * обработать возможные исключения MySizeArrayException и MyArrayDataException,
     * и вывести результат расчета.
     */
    public static void main(String[] args) {
        String[][] array = new String[][]{
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "a", "1", "1"},
                {"1", "1", "1", "1"},
        };

        MyArrayManager myArrayManager = new MyArrayManager();
        try {
            System.out.println("Sum of array elements is " + myArrayManager.SumArrayElements(array));
        } catch (MyArraySizeException | MyArrayDataException exception) {
            System.out.println("An error has occurred during execution!");
            exception.printStackTrace();
        }

    }
}
