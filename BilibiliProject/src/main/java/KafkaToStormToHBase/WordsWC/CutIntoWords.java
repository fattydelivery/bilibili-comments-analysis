package KafkaToStormToHBase.WordsWC;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * @program:BilibiliProject
 * @description:分词
 * @auther:滕畅
 * @create:2020-12-23 23:43
 **/
public class CutIntoWords {
    private static final List<String> DIC = new ArrayList<>();
    private static int MAX_LENGTH;
    static{
        try {
            System.out.println("开始初始化词典");
            int max=3;
//            int count=0;
            List<String> lines = Files.readAllLines(Paths.get("D:\\IDEA\\projects\\dic.txt"), Charset.forName("utf-8"));
            for(String line : lines){
                DIC.add(line);
//                count++;
                if(line.length()>max){
                    max=line.length();
                }
            }
            MAX_LENGTH = max;
//            System.out.println("完成初始化词典，词数目："+count);
            System.out.println("最大分词长度："+MAX_LENGTH);
        } catch (IOException ex) {
            System.err.println("词典装载失败:"+ex.getMessage());
        }
    }
//    public static void main(String[] args){
//        String text = "在普通的太阳系有颗普通的地球，普通的地球上有台普通的电脑，普通的电脑前有个大帅逼";
//        System.out.println(seg(text));
//    }
    public static List<String> seg(String text){
        List<String> result = new ArrayList<>();
        while(text.length()>0){
            int len=MAX_LENGTH;
            if(text.length()<len){
                len=text.length();
            }
            //取指定的最大长度的文本去词典里面匹配
            String tryWord = text.substring(0, 0+len);
            while(!DIC.contains(tryWord)){
                //如果长度为一且在词典中未找到匹配，则按长度为一切分
                if(tryWord.length()==1){
                    break;
                }
                //如果匹配不到，则长度减一继续匹配
                tryWord=tryWord.substring(0, tryWord.length()-1);
            }
            result.add(tryWord);
            //从待分词文本中去除已经分词的文本
            text=text.substring(tryWord.length());
        }
        return result;
    }
}
