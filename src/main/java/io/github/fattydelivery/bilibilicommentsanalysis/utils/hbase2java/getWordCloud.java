package io.github.fattydelivery.bilibilicommentsanalysis.utils.hbase2java;

import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program:HBaseToJava02
 * @description
 * @author: Bonnie(Wang nan)
 * @create: 2020-12-25
 **/
public class getWordCloud {

    private static String kv;

    public String getKV() {
        String res = "[" + kv.substring(0, kv.length() - 1) + "]";
        System.out.println(res);
        return res;
    }

    public getWordCloud() throws IOException{
        kv = "";
        Connection con = new HbaseConnection().getConnection();
        Admin admin = con.getAdmin();
        if (admin != null) {
            try {
                //获取数据表对象
                Table table = con.getTable(TableName.valueOf("default:testTable"));

                //获取表中的数据
                ResultScanner scanner = table.getScanner(new Scan());

                int flag=0;
                String v="";
                Map<String, Integer> map = new HashMap<>();

                //循环输出表中的数据
                for (Result result : scanner) {
                    List<Cell> listCells = result.listCells();
                    for (Cell cell : listCells) {
                        Get get = new Get(cell.getRow());
                        get.addColumn(Bytes.toBytes("cf"), Bytes.toBytes("word"));
                        get.addColumn(Bytes.toBytes("cf"), Bytes.toBytes("count"));
                        Result result1 = table.get(get);
                        byte[] val1 = result1.getValue(Bytes.toBytes("cf"), Bytes.toBytes("word"));
                        byte[] val2 = result1.getValue(Bytes.toBytes("cf"), Bytes.toBytes("count"));
                        map.put(Bytes.toString(val1), Integer.parseInt(Bytes.toString(val2)));
                    }
                }
                for(Map.Entry<String, Integer> entry : map.entrySet()){
                    String mapKey = entry.getKey();
                    int mapValue = entry.getValue();
                    kv = kv + "{" + "\"name\":\"" + mapKey + "\",\"value\":" + mapValue * 10 + "},";
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
