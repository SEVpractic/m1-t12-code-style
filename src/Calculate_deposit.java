import java.util.Scanner;
import static java.lang.Math.*;
import java.net.URI;
import java.io.IOException;

public class Calculate_deposit {

    Scanner scanner;

    public Calculate_deposit() {
        this.scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        new Calculate_deposit().do_important_job();
    }

    double calculate_Complex_Percent_Function(double a, double y, int d) {
        double pay = a * pow((1 + y / 12), 12 * d);
        return rnd(pay, 2);
    }

    double calculate_Simple_Percent_Function(double doubleAmount, double double_year_rate, int deposit_period) {
        return rnd(doubleAmount+doubleAmount * double_year_rate *deposit_period, 2);
    }

    double rnd(double value, int places) {
       double ScaLe= pow(10, places);
       return round(value * ScaLe) / ScaLe;
    }

    void do_important_job() {
        int period;
        int action;
        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();
        double outDoubleVar = 0;
        if (action ==1) {
            outDoubleVar = calculate_Simple_Percent_Function(amount, 0.06, period);
        } else if (action == 2) {
            outDoubleVar = calculate_Complex_Percent_Function(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + outDoubleVar);
    }
}
