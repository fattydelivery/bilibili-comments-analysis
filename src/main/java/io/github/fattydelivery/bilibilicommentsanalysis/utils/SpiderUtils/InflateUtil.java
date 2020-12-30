package io.github.fattydelivery.bilibilicommentsanalysis.utils.SpiderUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.Inflater;

/**
 * @program:bilibili-comments-analysis
 * @description
 * @author: Jayce(Bingjie Yan)
 * @create: 2020-12-24-14:43
 **/
public class InflateUtil {
    public static String inflate(URL urls) {
        try {
            HttpURLConnection conn = (HttpURLConnection) urls.openConnection();
            conn.connect();
            Inflater decompresser = new Inflater(true);
            DataInputStream in = new DataInputStream(conn.getInputStream());
            DataOutputStream out = null;
            // System.out.println(in.available());

            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            out = new DataOutputStream(bos);
            byte[] buffer = new byte[1024];
            int count = 0;
            while ((count = in.read(buffer)) > 0) {
                out.write(buffer, 0, count);
                // System.out.println(count);
            }
            // System.out.println(bos.toString());
            decompresser.setInput(bos.toByteArray());
            byte[] result = new byte[1024];
            String str = "";
            int resultLength = 0;
            while((resultLength = decompresser.inflate(result))>0) {
                str += new String(result, 0, resultLength, "UTF-8");
            }
            return str;
            // System.out.println(result);
            // System.out.println(resultLength);
            // System.out.println(new String(result, 0, resultLength, "UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
