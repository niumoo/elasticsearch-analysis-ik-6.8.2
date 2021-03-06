package org.elasticsearch.index.analysis;

import org.apache.lucene.analysis.Tokenizer;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.env.Environment;
import org.elasticsearch.index.IndexSettings;
import org.wltea.analyzer.cfg.Configuration;
import org.wltea.analyzer.lucene.IKTokenizer;

public class IkTokenizerFactory extends AbstractTokenizerFactory {
    private Configuration configuration;

    public IkTokenizerFactory(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        super(indexSettings, name, settings);
        configuration = new Configuration(env, settings);
    }

    public static IkTokenizerFactory getIkTokenizerFactory(IndexSettings indexSettings, Environment env, String name,
        Settings settings) {
        return new IkTokenizerFactory(indexSettings, env, name, settings).setSmart(false);
    }

    public static IkTokenizerFactory getIkSmartTokenizerFactory(IndexSettings indexSettings, Environment env, String name,
        Settings settings) {
        return new IkTokenizerFactory(indexSettings, env, name, settings).setSmart(true);
    }

    /**
     * 使用单字分词
     * 
     * @param indexSettings
     * @param env
     * @param name
     * @param settings
     * @return
     */
    public static IkTokenizerFactory getSingleTokenizerFactory(IndexSettings indexSettings, Environment env, String name,
        Settings settings) {
        IkTokenizerFactory ikTokenizerFactory = new IkTokenizerFactory(indexSettings, env, name, settings).setSmart(false);
        ikTokenizerFactory.configuration.setUseSingleSegmenter(true);
        return ikTokenizerFactory;
    }

    /**
     * 中文单字分词，英文保留大小写分词，符号保留，空格过滤
     *
     * @param indexSettings
     * @param env
     * @param name
     * @param settings
     * @return
     */
    public static IkTokenizerFactory getCjkSingleEnStyleCleanSpace(IndexSettings indexSettings, Environment env, String name,
                                                               Settings settings) {
        IkTokenizerFactory ikTokenizerFactory = new IkTokenizerFactory(indexSettings, env, name, settings).setSmart(false);
        ikTokenizerFactory.configuration.setUseSingleSegmenter(true);
        ikTokenizerFactory.configuration.setEnableLowercase(false);
        ikTokenizerFactory.configuration.setCleanSpace(true);
        return ikTokenizerFactory;
    }


    /**
     * 中文单字分词，英文小写分词，符号保留，空格过滤。
     *
     * @param indexSettings
     * @param env
     * @param name
     * @param settings
     * @return
     */
    public static IkTokenizerFactory getCjkSingleEnLowcaseCleanSpace(IndexSettings indexSettings, Environment env, String name,
                                                                   Settings settings) {
        IkTokenizerFactory ikTokenizerFactory = new IkTokenizerFactory(indexSettings, env, name, settings).setSmart(false);
        ikTokenizerFactory.configuration.setUseSingleSegmenter(true);
        ikTokenizerFactory.configuration.setEnableLowercase(true);
        ikTokenizerFactory.configuration.setCleanSpace(true);
        return ikTokenizerFactory;
    }

    /**
     * 使用两字分词
     *
     * @param indexSettings
     * @param env
     * @param name
     * @param settings
     * @return
     */
    public static IkTokenizerFactory getTwoTokenizerFactory(IndexSettings indexSettings, Environment env, String name,
        Settings settings) {
        IkTokenizerFactory ikTokenizerFactory = new IkTokenizerFactory(indexSettings, env, name, settings).setSmart(false);
        ikTokenizerFactory.configuration.setUseTwoSegmenter(true);
        return ikTokenizerFactory;
    }

    public IkTokenizerFactory setSmart(boolean smart) {
        this.configuration.setUseSmart(smart);
        return this;
    }

    @Override
    public Tokenizer create() {
        return new IKTokenizer(configuration);
    }
}
