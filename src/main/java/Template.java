import java.util.List;
import java.util.Scanner;

/**
 * Created by Marinka on 01.07.2017.
 */
public class Template {
    private List <String> templates;
    private List <String> values;

    public List<String> getTemplates() {
        return templates;
    }

    public void setTemplates(List<String> templates) {
        this.templates = templates;
    }

    public List<String> getValues() {
        return values;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }



    public void templateParser(){
        Scanner sc = new Scanner(System.in);
    if (sc.hasNext(TemplateGenerator.getFieldStart())){

    }

      // return templates;
}


    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        TemplateGenerator tGenerator = new TemplateGenerator();
        System.out.println("Введите шаблон:");

    }
}