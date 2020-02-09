package org.wltea.analyzer.core;

/**
 * 单字分词器
 */
class CJKSingleSegmenter implements ISegmenter {

    // 子分词器标签
    static final String SEGMENTER_NAME = "CJK_SINGLE_SEGMENTER";

    public void analyze(AnalyzeContext context) {
        if (CharacterUtil.CHAR_USELESS != context.getCurrentCharType()
                && CharacterUtil.CHAR_ENGLISH != context.getCurrentCharType()
                && CharacterUtil.CHAR_ARABIC != context.getCurrentCharType()) {
            Lexeme newLexeme = new Lexeme(context.getBufferOffset(), context.getCursor(), 1, Lexeme.TYPE_CNWORD);
            context.addLexeme(newLexeme);
        }
        context.unlockBuffer(SEGMENTER_NAME);
    }

    public void reset() {
        // 清空队列
    }

}
