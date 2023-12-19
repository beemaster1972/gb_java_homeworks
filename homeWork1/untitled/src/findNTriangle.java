
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class findNTriangle {
    public static void main(String[] args) {
        int n = 0;

        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            n = 4;
        }
        else{
            n = Integer.parseInt(args[0]);
        }

        // Вывод результата на экран
        AnswerTriangle ans = new AnswerTriangle();
        int itresume_res = ans.countNTriangle(n);
        System.out.println(itresume_res);
    }
}
class AnswerTriangle {
    public int countNTriangle(int n){
        // Введите свое решение ниже
        if (n<1) return -1;
        //System.out.println((1+n)/2);
        return (((1+n)*n/2));

    }
}

