import java.util.Arrays;

public class Main {
    static final int SIZE = 10_000_000; //Создание массива
    static final int HALF = SIZE / 2;

    /**
     * Мои результаты
     * 1.084 Время выполнения
     * Массив разделен за 0.009 секунд
     * Поток начал работу 1
     * Поток начал работу 2
     * Поток 2 выполнил свою работу за 0.478 миллисекунд
     * Поток 1 выполнил свою работу за 0.479 миллисекунд
     * Поток завершил работу 2
     * Поток завершил работу 1
     * Склейка массива выполнена за 0.009 секунд
     * Выполнение программы завершено за 0.504 секунд
     */

    public static void main(String[] args) {
        float[] arr = new float[SIZE]; //Объявление массива
        float arr1[] = new float[HALF];//Объявление массива второго задания
        float arr2[] = new float[HALF];//Объявление массива второго задания
        TimeMiles(arr); //Запуск метода
        TimeMilesTwo(arr, arr1, arr2);//Запуск метода
    }

    /**
     * Метод первого задания подсчет времени выполнения
     *
     * @param arr принимает массив
     */
    public static void TimeMiles(float[] arr) {
        float second; //Переменная для перевода миллисекунд в секунды
        Arrays.fill(arr, 1.0f);//Заполнение массива 1
        long start = System.currentTimeMillis(); //Запоминаем время прошедших с полуночи
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2)); // выполнение формулы по заданию
            // System.out.print(arr[i]);
        }
        long end = System.currentTimeMillis();//Запоминаем время прошедших с полуночи
        second = end - start; //Высчитываем разницу прошедшего времени
        System.out.println(second / 1000 + " Время выполнения"); //Выводим и высчитываем секунды
    }

    public static void TimeMilesTwo(float[] arr, float[] arr1, float[] arr2) {
        float second; //Переменная для перевода миллисекунд в секунды
        Arrays.fill(arr, 1.0f);//Заполнение массива 1
        long start = System.currentTimeMillis(); //Запоминаем время прошедших с полуночи
        System.arraycopy(arr, 0, arr1, 0, HALF);
        System.arraycopy(arr, HALF, arr2, 0, HALF);
        long halftime = System.currentTimeMillis(); //Запоминаем время прошедших с полуночи
        second = halftime - start;
        second=(second/1000)%60;
        System.out.println("Массив разделен за " + second + "  секунд");//Выводим время
        second = 0;//Обнуление
        /**
         * Ресурс для работы прошу поправить как правильнее выражаться в принципе это объект
         */
        TimeTwoArr timeTwoArr = new TimeTwoArr(arr1, 1);//Ресурс для работы с передачей туда массива 1
        TimeTwoArr timeTwoArr2 = new TimeTwoArr(arr2, 2);//Ресурс для работы с передачей туда массива 2
        MyThread myThread = new MyThread("1", timeTwoArr);
        MyThread myThread2 = new MyThread("2", timeTwoArr2);
        myThread.start();//Запуск потока
        myThread2.start();//Запуск потока 2

        try {
            /**
             * Ожидание завершения 2 потоков
             */
            myThread.join();
            myThread2.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        long halftime2 = System.currentTimeMillis();
        System.arraycopy(arr1, 0, arr, 0, HALF);
        System.arraycopy(arr2, 0, arr, HALF, HALF);
        long end = System.currentTimeMillis();
        second = end - halftime2;
        second=(second/1000)%60;
        System.out.println("Склейка массива выполнена за " + second + " секунд");//Выводим время
        second = 0;
        second = end - start;
        second=(second/1000)%60;
        System.out.println("Выполнение программы завершено за " + second + " секунд");//Выводим время
    }

}
