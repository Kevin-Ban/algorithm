package generic;

import java.util.ArrayList;
import java.util.List;

public class ChineseTest implements TestInterface<ChineseBean> {


    @Override
    public List<ChineseBean> list(ChineseBean chineseBean) {
        List<ChineseBean> beans = new ArrayList<>(16);
        beans.add(new ChineseBean("chinese"));
        return beans;
    }

    @Override
    public Integer update(ChineseBean chineseBean) {
        return null;
    }

    @Override
    public Integer insert(ChineseBean chineseBean) {
        return null;
    }

    @Override
    public Integer delete(List<Integer> ids) {
        return null;
    }
}
