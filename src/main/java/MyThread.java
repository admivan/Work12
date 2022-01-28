public class MyThread extends  Thread{
    TimeTwoArr arrtwo;

    /**
     * Конструктор
     * @param name принимаем имя
     * @param arrtwo принимаем массив
     */
    public MyThread(String name,TimeTwoArr arrtwo) {
        super(name);
        this.arrtwo=arrtwo;
    }

    /**
     * Переопределение метода run
     */
    @Override
    public void run() {
        System.out.println("Поток начал работу "+getName());
        arrtwo.Time();
        System.out.println("Поток завершил работу "+getName());
    }
}
