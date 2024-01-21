// - Создать множество ноутбуков.
// - Написать метод, который будет запрашивать у пользователя критерий (или критерии)
// фильтрации и выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно
// хранить в Map. Например:
// “Введите цифру, соответствующую необходимому критерию:
// 1 - ОЗУ
// 2 - Объем ЖД
// 3 - Операционная система
// 4 - Цвет …
// - Далее нужно запросить минимальные значения для указанных критериев - сохранить
// параметры фильтрации можно также в Map.
// - Отфильтровать ноутбуки их первоначального множества и вывести проходящие по
// условиям.

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * Store
 */
public class Store {

    private static Filter filter = new Filter();
    private static Set<Notebook> notebooks = new HashSet<>();
    public static Set<Notebook> filteredNotebooks = new HashSet<>();

    public static void printNotebooks(Set<Notebook> setNotebooks) {
        for (Notebook notebook : setNotebooks) {
            System.out.println(notebook);
        }
    }

    public static void addNotebook(String rawData) {


    }

    private static String[] getFilterParameter(String rawData) {
        String[] result = new String[2];
        Pattern pattern = Pattern.compile("^\\d:.");
        if (pattern.matcher(rawData).find()) {
            result = rawData.split(":");
        } else {
            result = new String[]{"0", ""};
        }
        return result;
    }

    public static Map<Integer, String> getFilter() {
        Map<Integer, String> result = new HashMap<>();
        String prompt =
                String.format(
                        "Введите параметры фильтра.%n"
                                + "Например:%n 1:Acer или 3:16%n"
                                + "Для числовых параметров (объем ОЗУ, объем накопителя, диагональ экрана)%n"
                                + "фильтр будет >=%n"
                                + "Чтобы закончить ввод фильтра введите 0.%n"
                                + "Доступные параметры фильтра:%n"
                                + "1. <Производитель>%n"
                                + "2. <Тип ОЗУ>%n"
                                + "3. <Объем ОЗУ>%n"
                                + "4. <Тип накопителя>%n"
                                + "5. <Объем накопителя>%n"
                                + "6. <Предустановленная ОС>%n"
                                + "7. <Диагональ экрана>%n"
                                + "0. Закончить ввод фильтра%n"
                                + "Введите параметр: ");
        String rawData = "";
        Scanner scanner = new java.util.Scanner(System.in);
        int answer = -999;
        String[] data = new String[2];
        while (answer != 0) {
            System.out.print("Текущий фильтр: ");
            System.out.println(result);
            System.out.print(prompt);
            rawData = scanner.nextLine();
            data = getFilterParameter(rawData);
            answer = Integer.parseInt(data[0]);
            if (answer != 0)
                result.put(answer, data[1]);
        }
        scanner.close();
        return result;
    }

    public static Set<Notebook> selectByFilter(Filter filter) {
        Set<Notebook> result = new HashSet<>();
        for (Notebook laptop : notebooks) {
            if (laptop.isFiltered(filter)) result.add(laptop);
        }
        return result;
    }

    public static void main(String[] args) {
        Notebook acer =
                new Notebook("Acer", "Aspire 3", "DDR4", 16, "NVME SSD", 500, "Windows 11", 15.4, 55_000);
        Notebook hp =
                new Notebook(
                        "Hewlett Packard", "HP 255 G9", "DDR4", 8, "SSD", 256, "Windows 11 Pro", 15.6, 44_900);
        Notebook acer1 =
                new Notebook("Acer", "Aspire 5", "DDR5", 32, "NVME SSD", 1000, "Windows 11 Pro", 17.5, 65_000);
        Notebook hp1 =
                new Notebook(
                        "Hewlett Packard", "HP 255 G8", "DDR4", 16, "SSD", 256, "Windows 11 Pro", 15.6, 48_900);
        Notebook acer2 =
                new Notebook("Acer", "Aspire 3", "DDR4", 8, "NVME SSD", 256, "Linux", 15.4, 50_000);
        Notebook hp2 =
                new Notebook(
                        "Hewlett Packard", "HP 255 G9", "DDR4", 8, "SSD", 256, "DOS", 15.6, 40_900);


        notebooks.add(acer);
        notebooks.add(hp);
        notebooks.add(acer1);
        notebooks.add(hp1);
        notebooks.add(acer2);
        notebooks.add(hp2);


        filter = new Filter(getFilter());
        Filter filter1 = new Filter("1:Hewlett Packard");
        System.out.println("Список всех ноутбуков:");
        printNotebooks(notebooks);
        filteredNotebooks = selectByFilter(filter);
        System.out.printf("Список ноутбуков отфильтрованных по:%n%s%n",filter);
        printNotebooks(filteredNotebooks);
        filteredNotebooks = selectByFilter(filter1);
        System.out.printf("Список ноутбуков отфильтрованных по:%n%s%n",filter1);
        printNotebooks(filteredNotebooks);
    }
}
