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

    public GetHeatMap() {
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

                    for (Result result : scanner) {
                        List<Cell> listCells = result.listCells();
                        for (Cell cell : listCells) {
                            StringBuffer sb = new StringBuffer()
                                    .append(Bytes.toString(cell.getRow())).append("\t")
                                    .append(Bytes.toString(cell.getValue()));
                            String[] s = sb.toString().split("\t");
                            tmp.put(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
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

