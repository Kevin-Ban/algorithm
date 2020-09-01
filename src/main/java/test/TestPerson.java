package test;

import java.io.Serializable;

@TestAnnotion("testClass")
public class TestPerson implements Serializable {

    private static final long serialVersionUID = 123L;

    private String name;

    private transient String password;

//    @Override
//    public void writeExternal(ObjectOutput out) throws IOException {
//        out.writeObject(this.name);
//        out.writeObject(this.password);
//    }
//
//    @Override
//    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
//        this.name = (String) in.readObject();
//        this.password = (String) in.readObject();
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "TestPerson{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
