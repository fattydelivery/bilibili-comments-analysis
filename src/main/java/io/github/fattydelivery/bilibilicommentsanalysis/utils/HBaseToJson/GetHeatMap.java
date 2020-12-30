package io.github.fattydelivery.bilibilicommentsanalysis.utils.HBaseToJson;

import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;
import java.util.*;

/**
 * @program:HBaseToJava02
 * @description
 * @author: Bonnie(Wang nan)
 * @create: 2020-12-27
 **/
public class GetHeatMap {

    private static String time;
    private static String num;

    public String getKV() {
        time = time.substring(0, time.length() - 1);
        num = num.substring(0, num.length() - 1);
        return time + "," + num;
    }

    public GetHeatMap() throws IOException {
        Connection con = new HbaseConnection().getConnection();
        Map<Integer, Object> tmp = new LinkedHashMap<>();
        Admin admin = con.getAdmin();
        time = "";
        num = "";
        if (admin != null) {
            try {
                Table table = con.getTable(TableName.valueOf("default:HeatMap"));
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
                            time += i + " ";
                            num += tmp.get(i) + " ";
                        } else {
                            time += i + " ";
                            num += 0 + " ";
                        }
                    }
                    System.out.println("time: " + time);
                    System.out.println("num: " + num);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

