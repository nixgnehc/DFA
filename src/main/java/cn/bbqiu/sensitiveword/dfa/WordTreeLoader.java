package cn.bbqiu.sensitiveword.dfa;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author: nixgnehc nixgnehc@163.com
 * @date: 19-4-30
 * @time: 下午2:15
 * @Description: TODO..
 */
public class WordTreeLoader {


    protected static final String swendkey = "isEnd";
    protected static final String swendvalue = "1";


    public Map loader(Set<String> keyWordSet) {
        Map<String, Object> words = new HashMap(keyWordSet.size());

        Iterator<String> iterator = keyWordSet.iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            Map nowMap = words;
            for (int i = 0; i < key.length(); i++) {
                char keyChar = key.charAt(i);
                Object wordMap = nowMap.get(keyChar);
                if (wordMap != null) {
                    nowMap = (Map) wordMap;
                } else {
                    Map newWorMap = new HashMap<String, String>();
                    nowMap.put(keyChar, newWorMap);
                    nowMap = newWorMap;
                }

                if (i == key.length() - 1) {
                    nowMap.put(swendkey, swendvalue);
                }
            }
        }
        words = compress(words);
        return words;
    }

    /**
     * 压缩
     *
     * @param map
     * @return
     */
    private Map<String, Object> compress(Map<String, Object> map) {

        Map<String, Object> result = new HashMap<>();
        if (map.containsKey(swendkey)) {
            result.put(swendkey, swendvalue);
        } else {
            map.entrySet().stream().forEach(x -> {
                result.put(x.getKey(), compress((Map<String, Object>) x.getValue()));
            });
        }
        return result;
    }
}