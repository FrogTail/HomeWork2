import java.util.Arrays;

public class HomeWork2
{
    public static void main (String[] args)
    {
        System.out.println("========= Задание 1 ========");
        int[] array1 = {0,1,1,0,1};
        System.out.println(" Изначальный массив: " +Arrays.toString(array1));
        task1(array1);
        System.out.println("Обработанный массив: " +Arrays.toString(array1));


        System.out.println("\n========= Задание 2 ========");
        int[] array2 = new int[8];
        System.out.println(" Изначальный массив: " +Arrays.toString(array2));
        task2(array2);
        System.out.println("Обработанный массив: " +Arrays.toString(array2));


        System.out.println("\n========= Задание 3 ========");
        int [] array3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(" Изначальный массив: " +Arrays.toString(array3));
        task3(array3);
        System.out.println("Обработанный массив: " +Arrays.toString(array3));


        System.out.println("\n========= Задание 4 ========");
        // возьмем обработанный массив из предыдущего задания
        System.out.println("Массив, в котором ищем значения: " +Arrays.toString(array3));
        System.out.println("Максимальное значение: " +findMax(array3));
        System.out.println("Минимальное значение: " +findMin(array3));


        System.out.println("\n========= Задание 5 ========");
        int[][] array5 = new int[5][5];
        task5(array5);

        for(int x=0; x<array5.length; x++)
        {
            for(int y=0; y<array5.length; y++)
            {
                System.out.printf("%3d", array5[x][y]);
            }
            System.out.println();
        }


        System.out.println("\n========= Задание 6 ========");
        int[] array6a = {1, 1, 1, 2, 1};
        int[] array6b = {2, 1, 1, 2, 1};
        int[] array6c = {10, 1, 2, 3, 4};
        System.out.println (task6(array6a));
        System.out.println (task6(array6b));
        System.out.println (task6(array6c));


        System.out.println("\n========= Задания 7 и 8 ========");
        int[] array7 = {0,1,2,3,4,5};
        System.out.println(" Изначальный массив: " +Arrays.toString(array7));
        tasks7and8(array7,-2);
        System.out.println("Обработанный массив: " +Arrays.toString(array7));
    }

    /*
    1 Задать целочисленный массив, состоящий из элементов 0 и 1.
    Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
    Написать метод, заменяющий в принятом массиве 0 на 1, 1 на 0;
     */
    private static void task1 (int[] array)
    {
        for (int i=0; i<array.length; i++)
        {
            if (array[i] == 0)
                array[i]=1;
            else if (array[i] == 1)
                array[i]=0;
            else
                System.out.println("[task1]: недопустимое значение ячейки №" +i);
        }
    }


    /*
    2 Задать пустой целочисленный массив размером 8.
    Написать метод, который помощью цикла заполнит его значениями 1 4 7 10 13 16 19 22;
     */
    private static void task2 (int[] array)
    {
        if (array.length>0)
            array[0]=1;
        else
            System.out.println("[task2]: массив не инициализирован!");

        for (int i=1; i<array.length; i++)
        {
            array[i]=1+i*3;
        }
    }


    /*
    3 Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ],
    написать метод, принимающий на вход массив и умножающий числа меньше 6 на 2;
     */
    private static void task3(int[] array)
    {
        for (int i=0; i<array.length; i++)
        {
            if (array[i]<6)
                array[i] *= 2;
        }
    }


    /*
    4 Задать одномерный массив.
    Написать методы поиска в нём минимального и максимального элемента;
     */
    private static int findMax (int[] array)
    {
        // Не совсем понятно, что имелось в виду в задании:
        // максимальное значение или номер элемента с максимальным значением
        // Выбрал первый вариант, тк элементов с одинаковым (максимальным) значением может быть несколько

        if (array.length>0)
        {
            int max = array[0];

            for (int i = 1; i < array.length; i++)
            {
                if (max < array[i])
                    max = array[i];
            }

            return max;
        }
        else
        {
            System.out.println("[findMax]: массив не инициализирован!");
            return 0;
        }
    }

    private static int findMin (int[] array)
    {
        if (array.length>0)
        {
            int min = array[0];

            for (int i = 1; i < array.length; i++)
            {
                if (min > array[i])
                    min = array[i];
            }

            return min;
        }
        else
        {
            System.out.println("[findMax]: массив не инициализирован!");
            return 0;
        }
    }


    /*
    5 * Создать квадратный целочисленный массив (количество строк и столбцов одинаковое),
    заполнить его диагональные элементы единицами, используя цикл(ы);
     */
    private static void task5(int[][] array)
    {
        for (int x=0; x<array.length; x++)
        {
            for (int y=0; y<array[x].length; y++)
            {
                if (x==y || y==array[x].length-x-1)
                    array[x][y]=1;
            }
        }
    }


    /*
    6 ** Написать метод, в который передается не пустой одномерный целочисленный массив,
    метод должен вернуть true если в массиве есть место,
    в котором сумма левой и правой части массива равны.
    Примеры: checkBalance([1, 1, 1, || 2, 1]) → true,
    checkBalance ([2, 1, 1, 2, 1]) → false,
    checkBalance ([10, || 1, 2, 3, 4]) → true.
    Абстрактная граница показана символами ||, эти символы в массив не входят.
     */
    private static boolean task6(int[] array)
    {
        int arraySum = 0;

        for (int i=0; i<array.length; i++)
        {
            arraySum += array[i];
        }

        if (arraySum%2 == 0)
        {
            int currentSum = 0;
            for (int i = 0; i < array.length; i++)
            {
                currentSum += array[i];
                if (currentSum == arraySum/2)
                    return true;
            }
        }

        return false;
    }

    /*
    7 *** Написать метод, которому на вход подаётся одномерный массив и число n
    (может быть положительным, или отрицательным),
    при этом метод должен циклически сместить все элементы массива на n позиций.

    8 **** Не пользоваться вспомогательным массивом при решении задачи 7.
     */
    private static void tasks7and8(int[] array, int shift)
    {
        if (shift <0)
            shift = array.length + shift;

        shift = shift % array.length;

        for (int j=0; j<shift; j++)
        {
            int reserve = array[0];
            for (int i = 0; i < array.length; i++)
            {
                if ((i + 1) < array.length)
                    array[i] = array[i + 1];
                else
                    array[i] = reserve;
            }
        }
    }
}
