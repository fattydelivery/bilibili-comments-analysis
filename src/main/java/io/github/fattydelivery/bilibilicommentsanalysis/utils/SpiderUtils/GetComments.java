package io.github.fattydelivery.bilibilicommentsanalysis.utils.SpiderUtils;

import io.github.fattydelivery.bilibilicommentsanalysis.entity.Comment;
import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @program:bilibili-comments-analysis
 * @description
 * @author: Jayce(Bingjie Yan)
 * @create: 2020-12-24-16:06
 **/
public class GetComments {
    public static ArrayList<Comment> Xml2ArrayList(Document doc) {
        Element rootElement = doc.getRootElement();
        List<Element> children = rootElement.getChildren();
        ArrayList<Comment> comments = new ArrayList<>();
        for (Element child : children) {
            if (!child.getName().equals("d")) continue;
            List<Attribute> attributes = child.getAttributes();
            String text = child.getText();
            String str[] = null;
            for (Attribute attr : attributes) {
                str = attr.getValue().split(",");
            }
            if (str.length != 8) {
                System.out.println("error!!");
            }
            Comment comment = new Comment(str[0], str[1], str[2], str[3], str[4], str[5], str[6], str[7], text);
            // System.out.println(comment.toString());
            comments.add(comment);
        }
        return comments;
    }

    public static void Xml2Csv(Document doc, String target, String fileName) {
        Element rootElement = doc.getRootElement();
        List<Element> children = rootElement.getChildren();
        PrintWriter writer = null;
        try {
            File dir = new File(target);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            File outFile = new File(target + fileName);
            if (!outFile.exists()) {
                try {
                    outFile.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            writer = new PrintWriter(outFile);
            for (Element child : children) {
                if (!child.getName().equals("d")) continue;
                List<Attribute> attributes = child.getAttributes();
                String text = child.getText();
                text.replaceAll(",", " "); // 防止有小可爱发包含,的弹幕
                String str[] = null;
                for (Attribute attr : attributes) {
                    str = attr.getValue().split(",");
                }
                if (str.length != 8) {
                    System.out.println("error!!");
                }
                Comment comment = new Comment(str[0], str[1], str[2], str[3], str[4], str[5], str[6], str[7], text);
                // System.out.println(comment.toString());
                // System.out.println(comment.toCsv());
                writer.write(comment.toCsv() + "\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            writer.close();
        }
    }

    public static void Xml2Txt(Document doc, String target, String fileName) {
        Element rootElement = doc.getRootElement();
        List<Element> children = rootElement.getChildren();
        PrintWriter writer = null;
        try {
            File dir = new File(target);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            File outFile = new File(target + fileName);
            if (!outFile.exists()) {
                try {
                    outFile.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            writer = new PrintWriter(outFile);
            for (Element child : children) {
                if (!child.getName().equals("d")) continue;
                List<Attribute> attributes = child.getAttributes();
                String text = child.getText();
                text.replaceAll("\t", " "); // 防止有小可爱发包含\t的弹幕
                String str[] = null;
                for (Attribute attr : attributes) {
                    str = attr.getValue().split(",");
                }
                if (str.length != 8) {
                    System.out.println("error!!");
                }
                Comment comment = new Comment(str[0], str[1], str[2], str[3], str[4], str[5], str[6], str[7], text);
                // System.out.println(comment.toString());
                // System.out.println(comment.toTxt());
                writer.write(comment.toTxt() + "\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            writer.close();
        }
    }
}
