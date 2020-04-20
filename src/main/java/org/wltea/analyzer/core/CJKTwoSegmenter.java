package org.wltea.analyzer.core;

/**
 * 双字分词器
 */
class CJKTwoSegmenter implements ISegmenter {

    // 子分词器标签
    static final String SEGMENTER_NAME = "CJK_TWO_SEGMENTER";

    public void analyze(AnalyzeContext context) {
        if (CharacterUtil.CHAR_CHINESE == context.getCurrentCharType()
            || CharacterUtil.CHAR_OTHER_CJK == context.getCurrentCharType()) {

            if (CharacterUtil.CHAR_CHINESE == context.getNextCharType()
                    || CharacterUtil.CHAR_OTHER_CJK == context.getNextCharType()) {
                Lexeme newLexeme = new Lexeme(context.getBufferOffset(), context.getCursor(), 2, Lexeme.TYPE_CNWORD);
                context.addLexeme(newLexeme);
            }
        }
        context.unlockBuffer(SEGMENTER_NAME);
    }

    public void reset() {
        // 清空队列
    }

}
