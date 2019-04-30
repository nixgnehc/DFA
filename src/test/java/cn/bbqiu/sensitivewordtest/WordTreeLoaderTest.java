package cn.bbqiu.sensitivewordtest;

import cn.bbqiu.sensitiveword.dfa.WordTreeLoader;
import org.junit.Test;

import java.util.Map;

/**
 * @author: nixgnehc nixgnehc@163.com
 * @date: 19-4-30
 * @time: 下午2:29
 * @Description: TODO..
 */

public class WordTreeLoaderTest {

    private WordTreeLoader loader = new WordTreeLoader();

    @Test
    public void loaderTest() {
        Map<String, Object> map = loader.loader(SensitiveWordData.sensitives());
        System.out.println(map);
    }
}
