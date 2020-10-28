import exceptions.MyArrayDataException;
import exceptions.MyArraySizeException;

import java.io.IOException;

public class MyArrayManager {
    private final int arraySize = 4;

    /**
     * 1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4,
     * при подаче массива другого размера необходимо бросить исключение MyArraySizeException
     * 2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать.
     * Если в каком-то элементе массива преобразование не удалось
     * (например, в ячейке лежит символ или текст вместо числа), должно быть брошено исключение MyArrayDataException,
     * с детализацией в какой именно ячейке лежат неверные данные.
     *
     * @param array - 2-dimensional array of strings
     * @return Sum of array elements
     * @throws MyArraySizeException - Invalid array size
     * @throws MyArrayDataException - Invalid data in some cell
     */
    public int SumArrayElements(String[][] array) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;
        String sizeErrorTemplate = String.format("Invalid array size. The size must be [%s][%s]!",
                arraySize, arraySize);

        if (array.length != arraySize) {
            throw new MyArraySizeException(sizeErrorTemplate);
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i].length != arraySize) {
                throw new MyArraySizeException(sizeErrorTemplate);
            }
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (Exception exception) {
                    throw new MyArrayDataException(String.format("Invalid data in cell: [%s][%s]!", i, j), exception);
                }
            }
        }

        return sum;
    }
}
