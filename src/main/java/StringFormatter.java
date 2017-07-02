import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Marinka on 01.07.2017.
 */
public class StringFormatter {

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

    static class Dog {
        public String name;
        public String owner;
        public String gender;
    }

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        System.out.println();
        Dog d = new Dog();
        d.name = "fido";
        d.owner = "Jane Doe";
        d.gender = "him";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("d", d);
        System.out.println(
                StringFormatter.format(
                        "My dog is named ${d.name}, and ${d.owner} owns ${d.gender}.",
                        map));
    }
}