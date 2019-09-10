package comparetor;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class CompareTest {

    public static void main(String[] args) {
        Student student = new Student(1, "1");
        Student student1 = new Student(2, "2");
        Student student2 = new Student(3, "3");
        Student student3 = new Student(4, "4");

        List<Student> list = Lists.newArrayListWithCapacity(10);
        list.add(student1);
        list.add(student3);
        list.add(student);
        list.add(student2);
        for (Student item : list) {
            System.out.println(item);
        }
        list.sort(Student::compareTo);

        System.out.println("-----------------------------------------");
        for (Student item : list) {
            System.out.println(item);
        }
        System.out.println("-----------------------------------------");

        Map<Student, String> map = Maps.newTreeMap(Student::compareTo);
        map.put(student1, "2");
        map.put(student3, "4");
        map.put(student2, "3");
        map.put(student, "1");

        Set<Student> keys = map.keySet();
        for (Student item : keys) {
            System.out.println(map.get(item));
        }
    }
}
