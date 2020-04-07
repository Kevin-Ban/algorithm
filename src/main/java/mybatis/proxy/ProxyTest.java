package mybatis.proxy;

import mybatis.mapper.CityMapper;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProxyTest {

    public static void main(String[] args) {
        CityMapper cityMapper = new CityMappers();
        CityHandler cityHandler = new CityHandler(cityMapper);
        CityMapper o = (CityMapper) Proxy.newProxyInstance(ProxyTest.class.getClassLoader(), CityMappers.class.getInterfaces(), cityHandler);
        System.out.println(o.query(""));
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        int[] a = new int[]{2, 4, 3, 6, 3, 2, 5, 5};
        FindNumsAppearOnce(a, num1, num2);
        System.out.println(num1[0] + " " + num2[0]);
    }

    public static void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        for (int i = 0; i < array.length; i++) {
            int count = 0;
            for (int j = 0; j < array.length; j++) {
                if (array[i] == array[j]) {
                    count++;
                }
            }
            if (count == 1) {
                if (num1 != null) {
                    num1[0] = array[i];
                } else {
                    num2[0] = array[i];
                }
            }
        }
    }
}

class CityHandler implements InvocationHandler {

    private CityMapper cityMapper;

    public CityHandler(CityMapper cityMapper) {
        this.cityMapper = cityMapper;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object o = method.invoke(cityMapper, args);
        System.out.println("test");
        return o;
    }
}

class CityMappers implements CityMapper {

    @Override
    public List<Map<String, Object>> query(String name) {
        System.out.println("实现类1");
        return new ArrayList<>();
    }

    @Override
    public int insert(String name, String code) {
        return 0;
    }

    @Override
    public List<Map<String, Object>> queryByXml() {
        return null;
    }
}

