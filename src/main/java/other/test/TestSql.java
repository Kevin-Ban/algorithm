package other.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestSql {

    public static void main(String[] args) {
        String sql = "INSERT INTO `mysql_test`.`user_info` (`id`, `name`, `gender`, `city`, `phone`, `address`, `email`, `age`, `code`, `score`) " +
                "VALUES ";

        Random random = new Random();
        int length = 20;
        int index = 0;
        for (int j = 1; j <= length; j++) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < 1000000; i++) {
                index++;
                String s = "('" + SnowFlakeUtils.genId() + "', '姓名" + index + "', '" + gender(index) + "', '城市" + index % 50 + "', '"
                        + getTel() + "', '地址" + index + "', 'email" + index + "', '" + random.nextInt(50)
                        + "', " + random.nextInt(500) + ", " + random.nextDouble() * random.nextInt(1000) + ")\n";
                list.add(s);
            }
            String result = sql + String.join(",", list);
            System.out.println("已完成" + j + "百万，还剩" + (length - j) + "百万");
            FileUtils.fileLinesWrite("d:\\mysql_file\\new.sql", result, true);
        }
    }

    private static String gender(int i) {
        if (i % 2 == 0) {
            return "女";
        }
        return "男";
    }

    private static String[] telFirst = "134,135,136,137,138,139,150,151,152,157,158,159,130,131,132,155,156,133,153".split(",");

    private static String getTel() {
        int index = getNum(0, telFirst.length - 1);
        String first = telFirst[index];
        String second = String.valueOf(getNum(1, 888) + 10000).substring(1);
        String third = String.valueOf(getNum(1, 9100) + 10000).substring(1);
        return first + second + third;
    }

    public static int getNum(int start, int end) {
        return (int) (Math.random() * (end - start + 1) + start);
    }
}