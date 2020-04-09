package other.test;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class HttpUtil {

    public static String http(String url, Map<String, String> params) {
        URL u = null;
        HttpURLConnection con = null;
        // 构建请求参数
        StringBuilder sb = new StringBuilder();
        if (params != null) {
            for (Map.Entry<String, String> e : params.entrySet()) {
                sb.append(e.getKey());
                sb.append("=");
                sb.append(e.getValue());
                sb.append("&");
            }
            sb.substring(0, sb.length() - 1);
        }
        System.out.println("send_url:" + url);
        System.out.println("send_data:" + sb.toString());
        // 尝试发送请求
        try {
            u = new URL(url);
            con = (HttpURLConnection) u.openConnection();
            //// POST 只能为大写，严格限制，post会不识别
            con.setRequestMethod("POST");
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setUseCaches(false);
            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            OutputStreamWriter osw = new OutputStreamWriter(con.getOutputStream(), StandardCharsets.UTF_8);
            osw.write(sb.toString());
            osw.flush();
            osw.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                con.disconnect();
            }
        }
        // 读取返回内容
        StringBuffer buffer = new StringBuffer();
        try {
            //一定要有返回值，否则无法把请求发送给server端。
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8));
            String temp;
            while ((temp = br.readLine()) != null) {
                buffer.append(temp);
                buffer.append("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return buffer.toString();
    }

    public static void main(String[] args) {
        Map<String, String> param = new HashMap<>(16);
        param.put("gsdz", "越秀");
        String ip = "10.194.253.122";
        String szys = "http://ghzyj.gz.gov.cn/sofpro/bmyyqt/gzlpc/gfgs/szys/xmxzyjs.jsp";
        String ghgs = "http://ghzyj.gz.gov.cn/sofpro/bmyyqt/gzlpc/gfgs/pqgs.jsp";
        String sfzx = "http://10.194.253.122/sofpro/bmyyqt/gzlpc/sfcx/sfcx.jsp";
        String result = http(ghgs, param);
        Document document = Jsoup.parse(result);
//        String curPageNo = document.getElementById("thisPage").attr("value");
        String curPageNo = document.getElementById("curPageNo").attr("value");
        Element ePage = document.getElementsByClass("pagination_index_last").get(0);
        String s = ePage.text();
        String totalRecord = s.substring(s.indexOf("共") + 1, s.indexOf("条"));
        String pageSize = "15";

        System.out.println(curPageNo + " " + totalRecord);

//        Elements elements = Optional.ofNullable(document.getElementsByClass("zxxx_list_table")).map(c -> c.get(0)).map(c -> c.select("tr")).orElse(null);
        Elements elements = Optional.ofNullable(document.getElementsByClass("pqgs_list_table")).map(c -> c.get(0)).map(c -> c.select("tr")).orElse(null);
        if (elements != null) {
            elements.remove(0);
            // region 协助司法执行信息查询
//            for (Element e : elements) {
//                Elements tds = e.getElementsByTag("td");
//                String date = tds.get(0).text();
//                String number = tds.get(1).text();
//                String type = tds.get(2).text();
//                String unit = tds.get(3).text();
//                String manager = tds.get(4).text();
//                String content = tds.get(5).text();
//                System.out.println(date + " " + number + " " + type + " " + unit + " " + manager + " " + content);
//            }
            // endregion

            // region 公示查询
            for (Element e : elements) {
                Element aTag = e.getElementsByTag("a").get(0);
                String name = aTag.text();
                String href = aTag.attr("href");

                String info = e.getElementsByTag("p").get(0).text();
                String number = info.substring(info.indexOf("案号：") + 3, info.indexOf("公示类别："));
                String type = info.substring(info.indexOf("公示类别：") + 5, info.indexOf("建设单位："));
                String unit = info.substring(info.indexOf("建设单位：") + 5);

                System.out.println(e);
                Elements tds = e.getElementsByTag("td");
                String status = tds.get(1).text();
                String date = tds.get(2).text();
                System.out.println(number + " " + type + " " + unit + " " + status + " " + date);
            }
            // endregion

            //region 四证一书
//            for(Element e : elements) {
//                Element aTag = e.getElementsByTag("a").get(0);
//                String name = aTag.text();
//                String href = aTag.attr("href");
//                String info = e.getElementsByTag("p").get(0).text();
//                String number = info.substring(info.indexOf("案号：") + 3, info.indexOf("建设单位："));
//                String unit = info.substring(info.indexOf("建设单位：") + 5, info.indexOf("发文号："));
//                String sendNumber = info.substring(info.indexOf("发文号：") + 4, info.length() - 1);
//                System.out.println("总：" + info);
//                System.out.println(number + " " + unit + " " + sendNumber);
//
//                String date = Optional.ofNullable(e.getElementsByTag("td")).map(c -> c.get(1)).map(c -> c.text()).orElse("");
//                System.out.println(date);
//            }
            //endregion
        }


    }


}