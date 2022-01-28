public class TimeTwoArr {
    float[] arr;
    int number;

    /**
     * Констриктор
     *
     * @param arr    принимаем массив
     * @param number принимаем номер потока
     */
    public TimeTwoArr(float[] arr, int number) {
        this.arr = arr;
        this.number = number;
    }

    public void Time() {
        float second;
        long start = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            //  System.out.println(arr[i]);
        }
        long end = System.currentTimeMillis();
        second = end - start;
        second = (second / 1000) % 60;
        System.out.println("Поток " + number + " выполнил свою работу за " + second + " миллисекунд");//Выводим время
    }
}
