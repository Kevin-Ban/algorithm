package collection;

import lombok.*;

import java.util.HashSet;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MapTest {

    public static void main(String[] args) throws InterruptedException {
        Student student = new Student("小明", "1");
        Student student1 = new Student("小明", "1");

        System.out.println("判断两个对象是否相等：" + student.equals(student1));
        System.out.println("第1个对象的hash值：" + student.hashCode());
        System.out.println("第2个对象的hash值：" + student1.hashCode());
        System.out.println("两个对象的hash值是否相等：" + (student.hashCode() == student1.hashCode()));

        HashSet set = new HashSet();
        set.add(student);
        set.add(student1);
        System.out.println("set内对象的数量：" + set.size());


        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        condition.await();

        condition.signal();
    }
}

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
class Student {

    private String name;

    private String id;

}
