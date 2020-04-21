package org.elasticsearch.index.analysis;

import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.env.Environment;
import org.elasticsearch.index.IndexSettings;
import org.wltea.analyzer.cfg.Configuration;
import org.wltea.analyzer.lucene.IKAnalyzer;

public class IkAnalyzerProvider extends AbstractIndexAnalyzerProvider<IKAnalyzer> {
    private final IKAnalyzer analyzer;

    public IkAnalyzerProvider(IndexSettings indexSettings, Environment env, String name, Settings settings, boolean useSmart) {
        super(indexSettings, name, settings);
        Configuration configuration = new Configuration(env, settings).setUseSmart(useSmart);
        analyzer = new IKAnalyzer(configuration);
    }

    /**
     * 传入 Configuration 的构造器
     * 
     * @param indexSettings
     * @param name
     * @param settings
     * @param configuration
     */
    public IkAnalyzerProvider(IndexSettings indexSettings, String name, Settings settings, Configuration configuration) {
        super(indexSettings, name, settings);
        analyzer = new IKAnalyzer(configuration);
    }

    public static IkAnalyzerProvider getIkSmartAnalyzerProvider(IndexSettings indexSettings, Environment env, String name,
        Settings settings) {
        return new IkAnalyzerProvider(indexSettings, env, name, settings, true);
    }

    public static IkAnalyzerProvider getIkAnalyzerProvider(IndexSettings indexSettings, Environment env, String name,
        Settings settings) {
        return new IkAnalyzerProvider(indexSettings, env, name, settings, false);
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
    public static IkAnalyzerProvider getIkSingleAnalyzerProvider(IndexSettings indexSettings, Environment env, String name,
        Settings settings) {
        Configuration configuration = new Configuration(env, settings);
        configuration.setUseSingleSegmenter(true);
        return new IkAnalyzerProvider(indexSettings, name, settings, configuration);
    }

    /**
     * 中日韩文单字分词，英文保留大小写分词，符号保留，空格过滤。
     *
     * @param indexSettings
     * @param env
     * @param name
     * @param settings
     * @return
     */
    public static IkAnalyzerProvider getCjkSingleEnStyleCleanSpaceAnalyzerProvider(IndexSettings indexSettings, Environment env, String name,
                                                                 Settings settings) {
        Configuration configuration = new Configuration(env, settings);
        configuration.setUseSingleSegmenter(true);
        configuration.setEnableLowercase(false);
        configuration.setCleanSpace(true);
        return new IkAnalyzerProvider(indexSettings, name, settings, configuration);
    }

    /**
     * 中日韩文单字分词，英文小写分词，符号保留，空格过滤。
     *
     * @param indexSettings
     * @param env
     * @param name
     * @param settings
     * @return
     */
    public static IkAnalyzerProvider getCjkSingleEnLowcaseCleanSpaceAnalyzerProvider(IndexSettings indexSettings, Environment env, String name,
                                                                                   Settings settings) {
        Configuration configuration = new Configuration(env, settings);
        configuration.setUseSingleSegmenter(true);
        configuration.setEnableLowercase(true);
        configuration.setCleanSpace(true);
        return new IkAnalyzerProvider(indexSettings, name, settings, configuration);
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
    public static IkAnalyzerProvider getIkTwoAnalyzerProvider(IndexSettings indexSettings, Environment env, String name,
        Settings settings) {
        Configuration configuration = new Configuration(env, settings);
        configuration.setUseTwoSegmenter(true);
        return new IkAnalyzerProvider(indexSettings, name, settings, configuration);
    }

    @Override
    public IKAnalyzer get() {
        return this.analyzer;
    }
}
