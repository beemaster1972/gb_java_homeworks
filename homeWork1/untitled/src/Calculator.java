public class Calculator {
    public String operations = "+-*/";

    public int calculate(char op, int a, int b) {
        // Введите свое решение ниже
        int result=0;
        switch (op){
            case '+':
                result = a+b;
                break;
            case '-':
                result = a-b;
                break;
            case '*':
                result = a*b;
                break;
            case '/':
                result = a/b;
                break;
        }
        return result;


    }

    public static void main(String[] args) {
        int a = 0;
        char op = ' ';
        int b = 0;

        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            a = 3;
            op = '+';
            b = 7;
        } else {
            a = Integer.parseInt(args[0]);
            op = args[1].charAt(0);
            b = Integer.parseInt(args[2]);
        }
        Calculator calculator = new Calculator();
        if (calculator.operations.indexOf(op) == -1) {
            System.out.printf("Некорректный оператор: '%s'", op);
        } else {
            int result = calculator.calculate(op, a, b);
            System.out.println(result);
        }
    }
}