package com.young.libdemo.jsoup;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author: yzx
 * @date: 2018/8/21
 * @description: HttpClient+Jsoup爬虫测试
 */
public class JsoupDemo {


    @Test
    public void test01() throws IOException {


        //获取到了所有的url来源，解析
        ArrayList<String> srcUrls = new ArrayList<>();
        String firstUrl = "https://wh.ke.com/xiaoqu/";
        srcUrls.add("https://wh.ke.com/xiaoqu/");
        //2--100  先49-->后99
        for (int i = 0; i < 99; i++) {
            String url = firstUrl+"pg"+(i+2);
            srcUrls.add(url);
        }

        CloseableHttpClient httpClient = HttpClients.createDefault();
        ArrayList<String> targets = new ArrayList<>();
        {
        for (String srcUrl : srcUrls) {
            //每一个大页面
//            System.out.println(srcUrl);

            HttpGet httpGet = new HttpGet(srcUrl);
            CloseableHttpResponse httpResponse = null;
            //异常捕获
            try {
                httpResponse = httpClient.execute(httpGet);
            } catch (IOException e) {
                e.printStackTrace();
            }
            HttpEntity entity = httpResponse.getEntity();
            String html = EntityUtils.toString(entity, "utf-8");
            Document document = Jsoup.parse(html);
            Elements a = document.getElementsByAttribute("href");

            String reg = "^.*\\d{13}.*$";
            for (Element element : a) {
                //获取带有a链接的url
                String hrefStr = element.attr("href");
                if (hrefStr.contains("https://wh.ke.com/xiaoqu/") && hrefStr.matches(reg)) {
                    System.out.println(hrefStr);
                    targets.add(hrefStr);
                }
            }
            httpResponse.close();

        }
            HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
            HSSFSheet sheet = hssfWorkbook.createSheet("yzx-data");
            for (int i = 0; i < targets.size(); i++) {


                String detailHtmlStr = targets.get(i);
                HttpGet httpGet = new HttpGet(detailHtmlStr);
                CloseableHttpResponse httpResponse = null;
                //异常捕获
                try {
                    httpResponse = httpClient.execute(httpGet);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                HttpEntity entity = httpResponse.getEntity();
                String html = EntityUtils.toString(entity, "utf-8");
                Document document = Jsoup.parse(html);
                //解析document
                //1.首选获取—-楼盘名称detailTitle
                Elements aClass = document.getElementsByAttribute("class");

                HSSFRow rowi = sheet.createRow(i);

                for (Element element : aClass) {
                    String aClass1 = element.attr("class");

                    if (aClass1.equals("detailTitle")) {
                        HSSFCell cell00 = rowi.createCell(0);
                        cell00.setCellValue(element.text());
                    }
                    if (aClass1.equals("xiaoquInfoContent")&&element.text().contains("户")) {
                        HSSFCell cell01 = rowi.createCell(1);
                        cell01.setCellValue(element.text());
                    }

                }

                FileOutputStream fileOutputStream = new FileOutputStream("d:\\yzx01.xls");
                hssfWorkbook.write(fileOutputStream);
                fileOutputStream.flush();
            }

        }

        httpClient.close();
    }
}
