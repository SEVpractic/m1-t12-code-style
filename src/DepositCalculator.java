import java.util.Scanner;
import static java.lang.Math.*;

public class DepositCalculator {
    Scanner scanner;
    private double amount;
    private double yearRate;
    private int depositPeriod;
    private double value;
    private int places;

    public static void main(String[] args) {
        new DepositCalculator().getDepositCalculations();
    }

    public DepositCalculator() {
        this.scanner = new Scanner(System.in);
    }

    double calculateComplexPercent(double amount, double yearRate, int depositPeriod) {
        this.amount = amount;
        this.yearRate = yearRate;
        this.depositPeriod = depositPeriod;
        double pay;

        pay = amount * pow((1 + yearRate / 12), 12 * depositPeriod);
        return doRoundOperation(pay, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        this.amount = amount;
        this.yearRate = yearRate;
        this.depositPeriod = depositPeriod;
        double pay;

        pay = amount + amount * yearRate * depositPeriod;
        return doRoundOperation(pay, 2);
    }

    double doRoundOperation(double value, int places) {
        this.value = value;
        this.places = places;
        double scale;

        scale = pow(10, places);
        return round(value * scale) / scale;
    }

    void getDepositCalculations() {
        int period;
        int action;
        int amount;
        double outAmount = 0;

        System.out.println("Введите сумму вклада в рублях:");
        amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();
        if (action ==1) {
            outAmount = calculateSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
            outAmount = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + outAmount);
    }
}
