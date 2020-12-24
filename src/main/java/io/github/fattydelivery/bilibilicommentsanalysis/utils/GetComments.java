package io.github.fattydelivery.bilibilicommentsanalysis.utils;

import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;

import java.util.ArrayList;
import java.util.List;

/**
 * @program:bilibili-comments-analysis
 * @description
 * @author: Jayce(Bingjie Yan)
 * @create: 2020-12-24-16:06
 **/
public class GetComments {
    public static ArrayList<ArrayList<String> > Xml2ArrayList(Document doc) {
        Element rootElement = doc.getRootElement();
        //5.获取子节点
        List<Element> children = rootElement.getChildren();
        for (Element child : children) {
            if (child.getName().equals("d"));
            List<Attribute> attributes = child.getAttributes();
            //打印属性
            for (Attribute attr : attributes) {
                System.out.println(attr.getName()+":"+attr.getValue());
            }
            List<Element> childrenList = child.getChildren();
            System.out.println("======获取子节点-start======");
            for (Element o : childrenList) {
                System.out.println("节点名:"+o.getName()+"---"+"节点值:"+o.getValue());
            }
            System.out.println("======获取子节点-end======");
        }
        return null;
    }
}
