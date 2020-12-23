package io.github.fattydelivery.bilibilicommentsanalysis.utils;

import com.sun.xml.internal.bind.v2.TODO;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * @program:bilibili-comments-analysis
 * @description
 * @author: Jayce(Bingjie Yan)
 * @create: 2020-12-23-16:08
 **/
public class RequestData {
    public static JSONObject getJson(Rule rule) {
        validateRule(rule);
        String url = rule.getUrl();
        String[] params = rule.getParams();
        String[] values = rule.getValues();
        int requestType = rule.getRequestMoethod();

        String json = "";
        URL urls = null;
        String jsonObject = null;

        try {
            url = url + "?";
            for (int i = 0; i < params.length; i++) {
                if (i != 0) url = url + "&";
                url = url + params[i] + "=" + values[i];
            }
            // System.out.println(url);
            urls = new URL(url);
            java.net.HttpURLConnection conn = (java.net.HttpURLConnection) urls.openConnection();
            conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
            conn.setDoOutput(true);
            conn.setDoInput(true);

            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
            conn.setRequestProperty("Accept-Encoding", "gzip, deflate");
            conn.setRequestProperty("Content-Type", "application/json; charset=utf-8");

            InputStream inputStream = conn.getInputStream();
            BufferedReader bf = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));

            String line = null;
            while ((line = bf.readLine()) != null) {
                json = json + line;
            }
            if (inputStream != null) {
                inputStream.close();
            }
            // System.out.println(json);
            String[] strs = json.split("\\\\");
            String str = "";
            StringBuffer jsons = new StringBuffer("");
            for (int i = 0; i < strs.length; i++) {
                str = strs[i];
                jsons = jsons.append(str);
            }
            jsonObject = jsons.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new JSONObject(jsonObject);
    }

    // TODO: get comments list
    public Object getXml(Rule rule) {
        return null;
    }

    /**
     * 对传入的参数进行必要的校验
     */
    private static void validateRule(Rule rule) {
        String url = rule.getUrl();
        if (url.isEmpty()) {
            throw new RuleException("url不能为空！");
        }
        if (!(url.startsWith("http://") || url.startsWith("https://"))) {
            throw new RuleException("url的格式不正确！");
        }
        if (rule.getParams() != null && rule.getValues() != null) {
            if (rule.getParams().length != rule.getValues().length) {
                throw new RuleException("参数的键值对个数不匹配！");
            }
        }
    }

}
