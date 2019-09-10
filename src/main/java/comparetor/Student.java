package comparetor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class Student implements Comparable<Student> {

    private int age;

    private String name;

    @Override
    public int compareTo(Student o) {
        if (o == null) {
            return 0;
        }
        if (o.age > this.age) {
            return -1;
        } else if (o.age < this.age) {
            return 1;
        }
        return 0;
    }
}
