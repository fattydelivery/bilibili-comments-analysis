package io.github.fattydelivery.bilibilicommentsanalysis.utils.hbase2java;

import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;
import java.util.List;

public class getWordCloud {

    private static String kv;

    public String getKV() {
        String res = "[" + kv.substring(0, kv.length() - 1) + "]";
        return res;
    }

    public getWordCloud() throws IOException {
        kv = "";
        Connection con = new HbaseConnection().getConnection();
        Admin admin = con.getAdmin();
        if (admin != null) {
            try {
//                //获取到数据库所有表信息
//                HTableDescriptor[] allTable = admin.listTables();
//                for (HTableDescriptor hTableDescriptor : allTable) {
//                    System.out.println(hTableDescriptor.getNameAsString());
//                }
                //获取数据表对象
                Table table = con.getTable(TableName.valueOf("default:UserActivation"));

                //获取表中的数据
                ResultScanner scanner = table.getScanner(new Scan());

                //循环输出表中的数据
                for (Result result : scanner) {

//                    byte[] row = result.getRow();
//                    System.out.println("row key is:"+new String(row));

                    List<Cell> listCells = result.listCells();
                    for (Cell cell : listCells) {
                        StringBuffer sb = new StringBuffer()
                                .append(Bytes.toString(cell.getRow())).append("\t")
//                                .append(Bytes.toString(cell.getFamily())).append("\t")
//                                .append(Bytes.toString(cell.getQualifier())).append("\t")
                                .append(Bytes.toString(cell.getValue()));
//                        byte[] familyArray = cell.getFamilyArray();
//                        byte[] qualifierArray = cell.getQualifierArray();
//                        byte[] valueArray = cell.getValueArray();
                        String[] s = sb.toString().split("\t");
                        kv = kv + "{" + "\"name\":\"" + s[0] + "\",\"value\":" + Integer.parseInt(s[1]) * 10 + "},";
//                        map.put(s[0], s[1]);
//                        list.add(sb.toString());
//                        System.out.println("row value is:"+sb);//cell.getValue().toString());
//                        System.out.println("row value is:"+ new String(familyArray) +
//                                new String(qualifierArray) + new String(valueArray));
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
