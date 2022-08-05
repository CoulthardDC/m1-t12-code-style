import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double amount, double yearRate, int depositPeriod ) {
        double pay = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return roundTo(pay, 2);
    }

    double calculateSimplePercent(double amount,double yearRate, int depositPeriod) {
        return roundTo(amount + amount * yearRate * depositPeriod, 2);
    }

    //Peer-review: Здесь назавние перменной "ScaLe" в не верном формате
    double roundTo(double value, int places) { // Округление до знака
        double ScaLe = Math.pow(10, places); //100
        return Math.round(value * ScaLe) / ScaLe;
    }

    // Peer-review: Объявление переменных перед их первым использованием (period и action) весма спорно. На мой взгляд
    // их стоит объявить в том месте где они начинаю использоваться (тоесть в этом случае в строках 45 и 47).
    // Штука это возможно субъективаная. Может есть случаи где такой подход выгоден, но чаще это просто усложняет чтение
    // кода и делает его грамоздким
    //
    // Так же здесь можно разбить код на логически блоки с помощью пустых строк по типу:
    //
    //    void someUnrealMethod() {
    //        *Здесь некий сканер*
    //
    //        *Вывод информативного сообщение*
    //        *Запрос ввода от пользователя и запись результата в переменную*
    //
    //        *Вывод информативного сообщение*
    //        *Запрос ввода от пользователя и запись результата в переменную*
    //
    //        *Некоторая обработка согласно полученым данным*
    //    }
    void calculateContribution() {
        int period;
        int action;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt( );
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();
        double result = 0;
        if (action == 1) {
            result = calculateSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
            result = calculateComplexPercent(amount, 0.06, period);
        }
      System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + result);
    }

    // Peer-review: main бы наверх самый не?!)) Всё таки я его в конце класса увидел впервые толька на java и только в этом
    // задании)
    public static void main(String[] args) {
        new DepositCalculator().calculateContribution();
    }
}
