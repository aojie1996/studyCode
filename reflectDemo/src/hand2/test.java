package hand2;

import java.lang.reflect.Field;
import java.util.*;

public class test {
    public static void main(String[] args) {
        A a = new C();
        //SuperClass cla =new SubClass();

        List<SensorData> s = sensorDataList(a);
        for (SensorData ss : s) {
            System.out.println(ss);
        }

    }

    /**
     * 通过反射获取各个属性名称和属性值封装成类
     *
     * @param sensorDataDto
     * @return
     */
    public static List<SensorData> sensorDataList(Object sensorDataDto) {
        List<SensorData> sensorDatas = new ArrayList<SensorData>();
        Class<?> clazz = sensorDataDto.getClass();
        try {
            exceClass(sensorDataDto, sensorDatas, clazz);
        } catch (Exception e) {

        }
        return sensorDatas;
    }

    private static void exceClass(Object sensorDataDto, List<SensorData> sensorDatas, Class<?> clazz) throws Exception {
        if (clazz != Object.class) {
            System.out.println(clazz);
            returnclassF(sensorDataDto, sensorDatas, clazz);
            Class<?> clazzs = clazz.getSuperclass();
            exceClass(sensorDataDto, sensorDatas, clazzs);
        }
    }

    private static void returnclassF(Object sensorDataDto, List<SensorData> sensorDatas, Class<?> clazz) throws Exception {
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            SensorData sensorData = new SensorData();
            sensorData.setSensorId(field.getName().toString());
            sensorData.setSensorValue(field.get(sensorDataDto));
            sensorDatas.add(sensorData);
        }
    }

}