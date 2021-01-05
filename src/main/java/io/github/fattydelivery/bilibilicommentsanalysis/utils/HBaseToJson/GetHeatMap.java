package io.github.fattydelivery.bilibilicommentsanalysis.utils.HBaseToJson;

import io.github.fattydelivery.bilibilicommentsanalysis.properties.PropertiesUtil;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;
import org.json.JSONObject;

import java.io.IOException;
import java.util.*;

/**
 * @program:HBaseToJava02
 * @description
 * @author: Bonnie(Wang nan)
 * @create: 2020-12-27
 **/
public class GetHeatMap {
    private ArrayList<Integer> timeArr;
    private ArrayList<Integer> numArr;

    public String getKV() {
        JSONObject json = new JSONObject();
        for (int i=0; i<timeArr.size(); i++) {
            json.put(timeArr.get(i).toString(), numArr.get(i));
        }
        return json.toString();
    }

    public GetHeatMap(String bvid) {
        Connection con = null;
        try {
            con = new HbaseConnection().getConnection();
            Map<Integer, Object> tmp = new LinkedHashMap<>();
            Admin admin = con.getAdmin();
            timeArr = new ArrayList<Integer>();
            numArr = new ArrayList<Integer>();
            if (admin != null) {
                try {
                    Table table = con.getTable(TableName.valueOf(PropertiesUtil.getProperty("hbase.table.heatmap.name")));
                    ResultScanner scanner = table.getScanner(new Scan());

                    Map<String, Integer> map = new HashMap<>();

                    //循环输出表中的数据
                    for (Result result : scanner) {
                        List<Cell> listCells = result.listCells();
                        for (Cell cell : listCells) {
                            //判断是否bvid是否等于rowkey
                            int len = bvid.length();
                            String row = new String(cell.getRow());
                            if(row.length()<len || !row.startsWith(bvid)){
                                continue;
                            }

                            Get get = new Get(cell.getRow());
                            get.addColumn(Bytes.toBytes(PropertiesUtil.getProperty("hbase.table.heatmap.name.cf")),
                                    Bytes.toBytes("time"));
                            get.addColumn(Bytes.toBytes(PropertiesUtil.getProperty("hbase.table.heatmap.name.cf")),
                                    Bytes.toBytes("count"));
                            Result result1 = table.get(get);
                            byte[] val1 = result1.getValue(Bytes.toBytes(PropertiesUtil.getProperty("hbase.table.heatmap.name.cf")),
                                    Bytes.toBytes("time"));
                            byte[] val2 = result1.getValue(Bytes.toBytes(PropertiesUtil.getProperty("hbase.table.heatmap.name.cf")),
                                    Bytes.toBytes("count"));
                            tmp.put(Bytes.toInt(val1), Integer.parseInt(Bytes.toString(val2)));
                        }
                    }
                    if (tmp != null && !tmp.isEmpty()) {
                        Set<Integer> set = tmp.keySet();
                        Object[] obj = set.toArray();
                        Arrays.sort(obj);
                        int max = (int) obj[obj.length - 1];
                        for (int i = 1; i <= max; i++) {
                            if (tmp.containsKey(i)) {
                                timeArr.add(i);
                                numArr.add((Integer) tmp.get(i));
                            } else {
                                timeArr.add(i);
                                numArr.add(0);
                            }
                        }
                        // System.out.println("time: " + time);
                        // System.out.println("num: " + num);
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

