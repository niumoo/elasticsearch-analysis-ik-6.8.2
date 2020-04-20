import java.io.StringReader;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.junit.Test;
import org.wltea.analyzer.cfg.Configuration;
import org.wltea.analyzer.lucene.IKAnalyzer;

public class TestIk {

    public static void main(String[] args) throws Exception {
        new TestIk().testAnalyzer();
    }

    @Test
    public void testAnalyzer() throws Exception {
        // String text = "￥中华人民共和国的也￥%……&*， 阿斯达1231^&*1";
        // String text = "中华abc人民共￥和1231国的Hello WORld java";
        // String text = "外一个阶段三十岁了";
        // String text = "这是三十万年前";
        String text = "陕西西工大附中2019高三上第四次适应性训练年末 陕西西工大附中2019高三上第四次适应性训练 年末 英语英 语第I卷第一部分 英语知识运用 共四节 满分55分 第一节 语音知识 共5小题 每小题1分 满分5分 1 mosquito A involve B motorcycle C conclude D women2 plenty A experience B passenger C expression D generation3 supply A yourselves B quickly C recycle D bicycle4 singer A strong B finger C single D stranger5 failure A mountain B bargain C captain D available第二节 情景对话 共5小题 每小题1分 满分5分 Hello can I help you Yes I d like to go on a sailing holiday this summer in Italy 6 No I wanted to go to Sweden last year 7 Well it is quite expensive Sailing holidays start at about three hundred dollars Yes my friends went in August last year 8 The most I can pay is three hundred and eighty dollars Well that should be enough 9 Well I d prefer a lake in the mountains Okay The Aqua Centre in North Italy will be the best for you 10 Okay Can I pay by credit card I haven t got my cheque book Yes that s fine A They paid four hundred and fifty dollars each B That costs 375 C but I couldn t spare enough time D Would you like to be by the sea or a lake E Have you been sailing before F You ve got to pay 475 G but I didn t have enough money 第三节 语法和词汇知识 共15小题 每小题1分 满分15分 11 Do you know if Linda is willing to take charge of the program does it A It takes no time B It counts for nothing C It doesn t hurt to ask D It doesn t make sense 12 We all agree that good knowledge of physics is a must in explaining such natural phenomena A a 不填 B a a C 不填 a D 不填 不填13 After that he knew he could any emergency by doing what he could to the best of his ability A get away with B get on with C get through D get across14 After the adjustment of financial policies many netizens put up posts 90 percent carried the message of approval A of which B of whom C of them D of what15 Use your head Nothing taught by others can have the same effect on you as learned by yourself A those B that C what D the one16 Why did you drop the chance of earning big money You know I don t want to get rich by taking risks A All is well that ends well B One man s meat is another s poisonC Better safe than sorry D No sweet without sweat17 Studying alone you are free to choose what to learn and when you don t need others agreement A while B if C though D as18 Full use should be made our spare time for the exam is drawing near Exactly A with B of C for D by19 As is known to all Montreal is the second largest French speaking city in the world A Paris is the largest 省略部分 counts74 patience75 exists短文改错1 brother加s2 died dead3 us me4 used using5 in a local restaurant6 travel traveled7 after before8 and or9 去掉but10 patiently patient书面表达Dear Editor I m writing to tell you about the discussion we ve recently had about how to deal with bad behaviors in public like smoking and spitting This is to remind or to fine I m in favor of reminding them My reasons are as follows At first what I think is that those who smoke or spit in public may not have noticed the warning signs and that they don t do it on purpose Then in the meantime if they are fined they ll feel hatred for society which is not in accordance with social harmony Here come my suggestions We may as well set up some warning signs in the place that can attract people s attention in which way they can realize their mistakes and correct them willingly In addition I recommend making them aware of the duty of protecting our environment via public service advertisements in the newspaper or on TV That s all for my opinions I am waiting for your ideas Others think these people should be fined properly because generally speaking those who go against the rules are usually frequent wrong doers So they will not learn to obey rules unless they are taught a lesson What s more reminders won t work on them any longer Yours Li Hua一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一一";
        // String text = " java";
        Configuration configuration = new Configuration(false);
        // configuration.setUseSingleSegmenter(true);
        configuration.setUseTwoSegmenter(true);
        // configuration.setUseSingleSegmenter(true);
        // configuration.setCleanSpace(true);
        // 创建分词对象
        Analyzer ikAnalyzer = new IKAnalyzer(configuration);
        StringReader reader = new StringReader(text);
        // 分词
        TokenStream ts = ikAnalyzer.tokenStream("", reader);
        CharTermAttribute term = ts.getAttribute(CharTermAttribute.class);
        // 遍历分词数据
        ts.reset();
        while (ts.incrementToken()) {
            System.out.print(term.toString() + "|");
        }
        reader.close();
        System.out.println();
    }
}
