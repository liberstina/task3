import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Marinka on 01.07.2017.
 */
public class Demo {
    public static void main(String[] args) throws Exception {
        String fieldStart = "\\$\\{";
        String fieldEnd = "\\}";
        System.out.println("Введите шаблон:");
        Scanner scan = new Scanner(System.in);
        int num = 0;
        List<String> vars = new ArrayList<>();
        String str = null;
        String template = null;
        String variableValue = null;
        String templateVariableValue = null;
        String templateVariableName = null;

        if(scan.hasNext()){
            str = scan.nextLine();
        }

        int countStart=0, countEnd = 0;
        for (char element : str.toCharArray()){
            if (element == '{') countStart++;
            if (element == '{') countEnd++;
        }
        if (countStart == countEnd)
            num = countStart;
                    else
            System.out.println("Вы ввели ошибочный шаблон. Повторите ввод.");
        {
        if(scan.hasNext()) {
            str = scan.nextLine();
        }
        }



        if (template.contains("${") && template.contains("}")){
            templateVariableName = template.replace("${","").replace("}", "");
        }
        System.out.println("Введите значение переменной (формат ввода 'переменная=значение'):");
        if (scan.hasNext()){
            variableValue = scan.nextLine();
        }

        if (variableValue.contains(templateVariableName + "=")){
            templateVariableValue = variableValue.replace(templateVariableName + "=", "");
        }
        System.out.println("Результат: " + templateVariableValue);

    }
}
