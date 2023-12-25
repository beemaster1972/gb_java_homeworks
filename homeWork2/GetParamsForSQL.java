/*
Сформируйте SQL-запрос

Инструкция по использованию платформы



Дана строка sql-запроса:

select * from students where "
Сформируйте часть WHERE этого запроса, используя StringBuilder. Данные (параметры) для фильтрации приведены в виде json-строки в примере ниже. Если значение null, то параметр не должен попадать в запрос.

Напишите свой код в методе answer класса Answer. Метод answer принимает на вход два параметра:

String QUERY - начало SQL-запроса String PARAMS - JSON с параметрами

Пример: Строка sql-запроса:

select * from students where
Параметры для фильтрации:

 {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
Результат:

select * from students where name='Ivanov' and country='Russia' and city='Moscow'
 */


import java.util.HashMap;
import java.util.Map;

public class GetParamsForSQL {
    public static void main(String[] args) {
        String QUERY = "";
        String PARAMS = "";

        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            QUERY = "select * from students where ";
            //PARAMS = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"} ";
            PARAMS = "{\"name\":\"null\", \"country\":\"null\", \"city\":\"null\", \"age\":\"null\"} ";
        } else {
            QUERY = args[0];
            PARAMS = args[1];
        }

        Answer ans = new Answer();
        System.out.println(ans.answer(QUERY, PARAMS));
    }
}

class Answer {
    public static StringBuilder answer(String QUERY, String PARAMS) {
        // Напишите свое решение ниже
        StringBuilder result = new StringBuilder(QUERY);
        String[] params = PARAMS.replaceAll("[\s{}\"]", "").split("[,:]");
        for (int i = 0; i < params.length - 1; i += 2) {
            if (i != 0 && result.indexOf("and", result.length() - 4) == -1 && result.indexOf("where",result.length()-6)==-1)
                result.append(" and ");
            if (!params[i + 1].contains("null")) result.append(params[i] + "='" + params[i + 1] + "'");
        }
        if (result.indexOf("and", result.length() - 4) != -1){
            result.delete(result.length()-5,result.length());
        }
        return result;


    }
}
