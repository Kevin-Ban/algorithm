package zip;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ZipTest {

    public static void main(String[] args) throws IOException {
        //新建读取zip流
//        ZipInputStream zip = new ZipInputStream(new FileInputStream("G:\\sendi_Company\\人防\\导入测试\\专业队.zip"), Charset.forName("gbk"));
//
//        BufferedReader buf = new BufferedReader(new InputStreamReader(zip));
//
//        //此类用于表示 ZIP 文件条目
//        ZipEntry Entry;
//
//
//        while((Entry=zip.getNextEntry())!=null){
//            System.out.println(Entry.getName());
//
//            FileInputStream stream = zip
//
////            String str;
////            while ((str = buf.readLine()) != null) {
////                System.out.println(str + "\n");
////            }
//            //关闭当前 ZIP条目并定位流以读取下一个条目
//            zip.closeEntry();
//        }
//        //流关闭
//        buf.close();
//        zip.close();

        ZipFile zipFile = new ZipFile("G:\\sendi_Company\\人防\\导入测试\\专业队.zip", Charset.forName("gbk"));
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        while (entries.hasMoreElements()){
            ZipEntry entry = entries.nextElement();
            System.out.println(entry.getName());
            if(entry.getName().endsWith(".xlsm")){
                ArrayList<ArrayList<ArrayList<String>>> list = PoiUtils.readDataFromXlsmExcel(zipFile.getInputStream(entry), 0, 1, 0, 10);
                System.out.println(list);
            }
        }

    }
}
