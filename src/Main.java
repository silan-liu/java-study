import supermarket.Category;
import supermarket.Phone;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        Phone phone = new Phone("iphone 7", "iOS", "iPhone", 400);

        System.out.println(phone.describe());
        System.out.println(phone.isHot());
        System.out.println(phone.getPhoneDesc());

        // 反射
        Class clazz = phone.getClass();

        // 属性反射
        Field brandField = clazz.getField("brand");
        brandField.set(phone, "iOS-mock");

        System.out.println(brandField.get(phone));
        System.out.println((phone.brand));

        // 方法反射
        Method describeMethod = clazz.getMethod("describe");
        System.out.println(describeMethod.getReturnType());
        String desc = (String) describeMethod.invoke(phone);
        System.out.println(desc);

        // 私有静态属性反射
        Field countField = clazz.getDeclaredField("count");
        countField.setAccessible(true);

        System.out.println("修改 count 的值为 20");
        countField.set(null, 20);

        System.out.println("count 修改后的值为：" + countField.get(null));

        // 静态方法反射
        Method countMethod = clazz.getMethod("getCount");
        int res = (int) countMethod.invoke(null);
        System.out.println(res);
        System.out.println(Phone.getCount());

        Category type = Category.RED;
        System.out.println(type);
        System.out.println(Category.values());
    }
}
