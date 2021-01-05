package io.github.fattydelivery.bilibilicommentsanalysis.utils.HBaseToJson;

import io.github.fattydelivery.bilibilicommentsanalysis.properties.PropertiesUtil;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;
import org.json.JSONObject;
import scala.Int;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program:HBaseToJava02
 * @description
 * @author: Bonnie(Wang nan)
 * @create: 2020-12-25
 **/
public class GetWordCloud {

    private static String kv;
    private ArrayList<String> keyArr;
    private ArrayList<Integer> valueArr;

    public String getKV() {
        /*
        String res = "";
        if (kv.length()>0) res = kv.substring(0, kv.length() - 1);
        else res = "{}";
         */
        // System.out.println(res);
        JSONObject json = new JSONObject();
        for (int i=0; i<keyArr.size(); i++) {
            json.put(keyArr.get(i), valueArr.get(i));
        }
        return json.toString();
    }

    public GetWordCloud() {
        kv = "";
        Connection con = null;
        try {
            con = new HbaseConnection().getConnection();
            Admin admin = con.getAdmin();
            keyArr = new ArrayList<String>();
            valueArr = new ArrayList<Integer>();
            if (admin != null) {
                try {
                    //获取数据表对象
                    Table table = con.getTable(TableName.valueOf(PropertiesUtil.getProperty("hbase.table.wordcount.name")));

                    //获取表中的数据
                    ResultScanner scanner = table.getScanner(new Scan());

                    int flag = 0;
                    String v = "";
                    Map<String, Integer> map = new HashMap<>();

                    //循环输出表中的数据
                    for (Result result : scanner) {
                        List<Cell> listCells = result.listCells();
                        for (Cell cell : listCells) {
                            Get get = new Get(cell.getRow());
                            get.addColumn(Bytes.toBytes(PropertiesUtil.getProperty("hbase.table.wordcount.name.cf")),
                                    Bytes.toBytes("word"));
                            get.addColumn(Bytes.toBytes(PropertiesUtil.getProperty("hbase.table.wordcount.name.cf")),
                                    Bytes.toBytes("count"));
                            Result result1 = table.get(get);
                            byte[] val1 = result1.getValue(Bytes.toBytes(PropertiesUtil.getProperty("hbase.table.wordcount.name.cf")),
                                    Bytes.toBytes("word"));
                            byte[] val2 = result1.getValue(Bytes.toBytes(PropertiesUtil.getProperty("hbase.table.wordcount.name.cf")),
                                    Bytes.toBytes("count"));
                            map.put(Bytes.toString(val1), Integer.parseInt(Bytes.toString(val2)));
                        }
                    }
                    for (Map.Entry<String, Integer> entry : map.entrySet()) {
                        String mapKey = entry.getKey();
                        int mapValue = entry.getValue();
                        keyArr.add(mapKey);
                        valueArr.add(mapValue);
                        kv = kv + "{" + "\"name\":\"" + mapKey + "\",\"value\":" + mapValue + "},";
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
