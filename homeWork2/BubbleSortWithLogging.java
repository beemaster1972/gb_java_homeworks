/*
Сортировка пузырьком с логированием

Инструкция по использованию платформы



Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.

Напишите свой код в методе sort класса BubbleSort. Метод sort принимает на вход один параметр:

int[] arr - числовой массив

После каждого прохода по массиву ваш код должен делать запись в лог-файл 'log.txt' в формате год-месяц-день час:минуты {массив на данной итерации}. Для логирования использовать логгер logger класса BubbleSort.

Пример


arr = new int[]{9, 4, 8, 3, 1};
sort(arr)

// При чтении лог-файла получим:
2023-05-19 07:53 [4, 8, 3, 1, 9]
2023-05-19 07:53 [4, 3, 1, 8, 9]
2023-05-19 07:53 [3, 1, 4, 8, 9]
2023-05-19 07:53 [1, 3, 4, 8, 9]
2023-05-19 07:53 [1, 3, 4, 8, 9]
 */

import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
//import java.time.LocalDateTime;
import java.util.Arrays;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BubbleSortWithLogging {
    public static void main(String[] args) {
        int[] arr = {};

        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            //arr = new int[]{9, 4, 8, 3, 1};
            arr = new int[]{9, 3, 4, 8, 2, 5, 7, 1, 6, 10};
        } else {
            arr = Arrays.stream(args[0].split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        BubbleSort ans = new BubbleSort();
        ans.sort(arr);

        try (BufferedReader br = new BufferedReader(new FileReader("log.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

class BubbleSort {
    private static File log;
    private static FileWriter fileWriter;

    public static void sort(int[] mas){
        log = new File("log.txt");
        try {fileWriter = new FileWriter(log,false);}
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        SimpleDateFormat logFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        boolean isSorted = false;
        int temp;
        while (!isSorted){
            isSorted = true;
            for (int j = 0; j < mas.length - 1; j++) {
                if (mas[j] > mas[j + 1]) {
                    isSorted = false;
                    temp = mas[j];
                    mas[j] = mas[j+1];
                    mas[j+1] = temp;
                }
            }

            try {
                fileWriter.write(logFormatter.format(new Date(System.currentTimeMillis()))+" "+Arrays.toString(mas)+"\n");

            }
            catch (IOException ex){
                System.out.println(ex.getMessage());
            }
        }
        try {
            //fileWriter.write(logFormatter.format(new Date(System.currentTimeMillis()))+" "+Arrays.toString(mas)+"\n");
            fileWriter.flush();
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
