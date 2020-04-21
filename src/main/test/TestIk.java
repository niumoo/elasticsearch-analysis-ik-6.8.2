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
        String text = "这是三十万八千四百七，？！十@#!二年前1231国的Hello WORld java";
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
