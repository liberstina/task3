
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Marinka on 01.07.2017.
 Реализовать template generator. Например,есть шаблон:
 “Hello, ${name}” , и значение name=”Reader” ,
 Template Generator должен вернуть “Hello Reader”
 “Hello, ${name}”, и значение для name не было установлено -> Error
 “${one}, ${two}, ${three}”, значения one=”1”, two=”${2}”, three = 3
 “1, ${2}, 3”
 Шаблон и значения вводятся с консоли.
 Пример,
 Введите шаблон:
 “${greeting}, ${name}”
 Введите переменные:
 greeting=Hi, name=Petro
 Результат: Hi, Petro
*/
public class TemplateGenerator {
    private static final String fieldStart = "\\$\\{";
    private static final String fieldEnd = "\\}";
    private static final String regex = fieldStart + "([^}]+)" + fieldEnd;
    private static final Pattern pattern = Pattern.compile(regex);

    public static String getFieldStart() {
        return fieldStart;
    }

    public static String getFieldEnd() {
        return fieldEnd;
    }

    public static String getRegex() {
        return regex;
    }

    public static Pattern getPattern() {
        return pattern;
    }

    public static String format(String format, Map<String, Object> objects) throws NoSuchFieldException, IllegalAccessException {
        Matcher m = pattern.matcher(format);
        String result = format;
        while (m.find()) {
            String[] found = m.group(1).split("\\.");
            Object o = objects.get(found[0]);
            Field f = o.getClass().getField(found[1]);
            String newVal = f.get(o).toString();
            result = result.replaceFirst(regex, newVal);
        }
        return result;
    }


}