package cn.bbqiu.sensitiveword.dfa;

import cn.bbqiu.sensitiveword.SensitiveWord;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author: nixgnehc nixgnehc@163.com
 * @date: 19-4-30
 * @time: 下午2:15
 * @Description: TODO..
 */
public class DFASensitiveWord implements SensitiveWord {

    private Map<String, Object> sensitiveWords;

    private WordTreeLoader loader;

    public DFASensitiveWord(Set<String> set) {
        loader = new WordTreeLoader();
        updateSensitiveWord(set);
    }

    public void updateSensitiveWord(Set<String> set) {
        sensitiveWords = loader.loader(set);
    }

    @Override
    public boolean detect(String txt) {
        for (int i = 0; i < txt.length(); i++) {
            if (this.checkSensitiveWord(txt, i) > 0) {
                return true;
            }
        }
        return false;
    }


    @Override
    public Set<String> contain(String txt) {
        Set<String> sensitiveWordList = new HashSet<String>();
        for (int i = 0; i < txt.length(); i++) {
            int length = checkSensitiveWord(txt, i);
            if (length > 0) {
                sensitiveWordList.add(txt.substring(i, i + length));
                i = i + length - 1;
            }
        }
        return sensitiveWordList;
    }


    @Override
    public String replace(String txt, String replaceChar) {
        String resultTxt = txt;
        Set<String> set = contain(txt);
        Iterator<String> iterator = set.iterator();

        while (iterator.hasNext()) {
            String word = iterator.next();
            String replaceString = getReplaceChars(replaceChar, word.length());
            resultTxt = resultTxt.replaceAll(word, replaceString);
        }

        return resultTxt;
    }


    private String getReplaceChars(String replaceChar, int length) {
        String resultReplace = replaceChar;
        for (int i = 1; i < length; i++) {
            resultReplace += replaceChar;
        }
        return resultReplace;
    }


    public int checkSensitiveWord(String txt, int beginIndex) {
        int matchFlag = 0;

        Map nowMap = sensitiveWords;
        for (int i = beginIndex; i < txt.length(); i++) {
            char word = txt.charAt(i);
            nowMap = (Map) nowMap.get(word);
            if (nowMap != null) {
                matchFlag++;
                if (nowMap.containsKey(WordTreeLoader.swendkey) && nowMap.get(WordTreeLoader.swendkey).equals(WordTreeLoader.swendvalue)) {
                    return matchFlag;
                }
            } else {
                break;
            }
        }
        return 0;
    }
}