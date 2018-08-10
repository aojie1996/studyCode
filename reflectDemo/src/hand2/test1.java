package hand2;

import java.lang.reflect.Field;

public class test1 {
    public static void main(String[] args) throws Exception {
          Object a =new C();
        System.out.println(getFieldValue(a,"Aid").toString());
    }

    /**
     *通过传入object对象和属性名称返回Field对象
     * @param object
     * @param name
     * @return
     */
    public static Field getDeclaredField(Object object,String name){
        Field field=null;
        Class<?> clazz=object.getClass();
        for (;clazz != Object.class;clazz = clazz.getSuperclass()){
            //;clazz != Object.class比较传入的类的字节码对象是不是其父类Object的对象
            //clazz = clazz.getSuperclass()，得到其父类的字节码
            try {
                field = clazz.getDeclaredField(name);
                return field ;
            } catch (Exception e) {

            }
        }
        return null;
    }

    /**
     * 得到属性的值
     * @param object
     * @param fieldName
     * @return
     */
    public static Object getFieldValue(Object object, String fieldName) {

        /*根据对象和属性名通过取Field对象*/
        Field field = getDeclaredField(object, fieldName);

        /*赋权限*/
        field.setAccessible(true) ;
        try {
            /*获得属性值*/
            return field.get(object) ;

        } catch(Exception e) {
            e.printStackTrace() ;
        }

        return null;
    }




}
