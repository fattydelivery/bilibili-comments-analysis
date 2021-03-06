package io.github.fattydelivery.bilibilicommentsanalysis.utils.HBaseToJson;

import io.github.fattydelivery.bilibilicommentsanalysis.properties.PropertiesUtil;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.*;

import java.io.IOException;
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
public class HbaseConnection {

    Connection con;

    public Connection getConnection() {
        return con;
    }

    public HbaseConnection() throws IOException {
        //第一步，设置HBsae配置信息
//        HbaseConnection hc = new HbaseConnection();
        Configuration configuration = HBaseConfiguration.create();
        Map<String, Object> map = new HashMap<String, Object>();
        List<Object> list = new ArrayList<Object>();
        //注意。这里这行目前没有注释掉的，这行和问题3有关系  是要根据自己zookeeper.znode.parent的配置信息进行修改。
//        configuration.set("zookeeper.znode.parent","/hbase-unsecure"); //与 hbase-site-xml里面的配置信息 zookeeper.znode.parent 一致


        configuration.set("hbase.zookeeper.quorum", PropertiesUtil.getProperty("hbase.ip"));  //hbase 服务地址
        configuration.set("hbase.zookeeper.property.clientPort", PropertiesUtil.getProperty("hbase.port")); //端口号
        //这里使用的是接口Admin   该接口有一个实现类HBaseAdmin   也可以直接使用这个实现类
        // HBaseAdmin baseAdmin = new HBaseAdmin(configuration);
        con = ConnectionFactory.createConnection(configuration);
//            System.out.println(hc.getKV());
//            JSONArray json = new JSONArray(list);
////            hc.getResults(json);
//            System.out.println(json);

    }
}
