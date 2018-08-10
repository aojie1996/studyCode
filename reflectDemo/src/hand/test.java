package hand;

import java.lang.reflect.Field;
import java.util.*;

public class test {
    public static void main(String[] args) throws Exception {
        Person p = new Person();
        Student s=new Student();
        Student1 s1 = new Student1();


//        String filename="name";
//        Class cla = p.getClass();
//        Field field = cla.getDeclaredField(filename);
//        field.setAccessible(true);
//        Object object=field.get(p);
//        System.out.println(object.toString());

        Field[] fields = getAllFields(p);
        for (int i=0;i<fields.length;i++){
            fields[i].setAccessible(true);
            System.out.println(fields[i]);
        }

    }

    public static Field[] getAllFields(Object object){
        Class clazz = object.getClass();
        List<Field> fieldList = new ArrayList<>();
        while (clazz != null){
            fieldList.addAll(new ArrayList<>(Arrays.asList(clazz.getDeclaredFields())));
            clazz = clazz.getSuperclass();
        }
        Field[] fields = new Field[fieldList.size()];
        fieldList.toArray(fields);//toArray方法将list对象转化为数组
        return fields;
    }

}
