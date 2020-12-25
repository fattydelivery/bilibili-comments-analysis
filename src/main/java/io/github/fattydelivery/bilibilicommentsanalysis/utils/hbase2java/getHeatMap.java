package io.github.fattydelivery.bilibilicommentsanalysis.utils.hbase2java;

import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;
import java.util.List;

public class getHeatMap {

    private static String time;
    private static String num;

    public String getKV() {
        time = time.substring(0, time.length() - 1);
        num = num.substring(0, num.length() - 1);
        return time + "," + num;
    }

    public getHeatMap() throws IOException {
        Connection con = new HbaseConnection().getConnection();
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
                        time += s[0] + " ";
                        num += s[1] + " ";
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
