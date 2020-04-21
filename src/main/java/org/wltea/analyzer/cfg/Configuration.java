/**
 * 
 */
package org.wltea.analyzer.cfg;

import java.io.File;
import java.nio.file.Path;

import org.elasticsearch.common.inject.Inject;
import org.elasticsearch.common.io.PathUtils;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.env.Environment;
import org.elasticsearch.plugin.analysis.ik.AnalysisIkPlugin;
import org.wltea.analyzer.dic.Dictionary;

public class Configuration {

    private Environment environment;
    private Settings settings;

    // 是否启用智能分词
    private boolean useSmart;

    // 是否启用远程词典加载
    private boolean enableRemoteDict = false;

    // 是否启用小写处理
    private boolean enableLowercase = true;

    // 是否是本地测试模式
    private boolean isLocal = false;

    // 是否使用单字分词，保留特殊字符,
    private boolean useSingleSegmenter = false;

    // 是否使用二分分词器，英文，汉字，符号除外
    private boolean useTwoSegmenter = false;

    // 是否过滤掉空格符号
    private boolean cleanSpace = false;

    @Inject
    public Configuration(Environment env, Settings settings) {
        this.environment = env;
        this.settings = settings;
        this.useSmart = settings.get("use_smart", "false").equals("true");
        this.enableLowercase = settings.get("enable_lowercase", "true").equals("true");
        this.enableRemoteDict = settings.get("enable_remote_dict", "true").equals("true");
        Dictionary.initial(this);
    }

    /**
     *
     * 本地测试时可以使用的构造器
     * 
     * @param use_smart 是否智能分词
     */
    public Configuration(boolean use_smart) {
        this.useSmart = use_smart;
        this.isLocal = true;
        Dictionary.initial(this);
    }

    public Path getConfigInPluginDir() {
        return PathUtils
            .get(new File(AnalysisIkPlugin.class.getProtectionDomain().getCodeSource().getLocation().getPath()).getParent(), "config")
            .toAbsolutePath();
    }

    public boolean isUseSmart() {
        return useSmart;
    }

    public Configuration setUseSmart(boolean useSmart) {
        this.useSmart = useSmart;
        return this;
    }

    public Environment getEnvironment() {
        return environment;
    }

    public Settings getSettings() {
        return settings;
    }

    public boolean isEnableRemoteDict() {
        return enableRemoteDict;
    }

    public boolean isEnableLowercase() {
        return enableLowercase;
    }

    public void setEnableLowercase(boolean enableLowercase) {
        this.enableLowercase = enableLowercase;
    }

    public boolean isLocal() {
        return isLocal;
    }

    public void setLocal(boolean local) {
        isLocal = local;
    }

    public boolean isUseSingleSegmenter() {
        return useSingleSegmenter;
    }

    public void setUseSingleSegmenter(boolean useSingleSegmenter) {
        this.useSingleSegmenter = useSingleSegmenter;
    }

    public boolean isUseTwoSegmenter() {
        return useTwoSegmenter;
    }

    public void setUseTwoSegmenter(boolean useTwoSegmenter) {
        this.useTwoSegmenter = useTwoSegmenter;
    }

    public boolean isCleanSpace() {
        return cleanSpace;
    }

    public void setCleanSpace(boolean cleanSpace) {
        this.cleanSpace = cleanSpace;
    }
}
