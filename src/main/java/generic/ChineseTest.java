package generic;

import java.util.ArrayList;
import java.util.List;

public class ChineseTest implements TestInterface<ChineseBean> {


    @Override
    public BaseBean<ChineseBean> list(ChineseBean chineseBean) {
        List<ChineseBean> beans = new ArrayList<>(16);
        beans.add(new ChineseBean("chinese"));
        BaseBean bean = new BaseBean();
        bean.setList(beans);
        bean.setTotal(beans.size());
        return bean;
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
