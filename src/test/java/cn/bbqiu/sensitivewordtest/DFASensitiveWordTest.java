package cn.bbqiu.sensitivewordtest;

import cn.bbqiu.sensitiveword.SensitiveWord;
import cn.bbqiu.sensitiveword.dfa.DFASensitiveWord;
import org.junit.Test;

import java.util.Set;

/**
 * @author: nixgnehc nixgnehc@163.com
 * @date: 19-4-30
 * @time: 下午2:15
 * @Description: TODO..
 */

public class DFASensitiveWordTest {

    @Test
    public void dfaTest() {
        SensitiveWord sensitiveWord = new DFASensitiveWord(SensitiveWordData.sensitives());
        String string = "全球最大xjpp驰名商标的中ssex文第一商sexx标搜索引擎、致力驰名商标于第一商标让网民更便first2捷地第一获取信息，找到所求。超第一过千亿的中文网页数据库，可以瞬间找驰名商标到相关的搜索xjp结果。";
        System.out.println("待检测语句字数：" + string.length());
        System.out.println("检测是否包含敏感词：" + sensitiveWord.detect(string));
        Set<String> set = sensitiveWord.contain(string);
        System.out.println("敏感词的个数为：" + set.size() + "。包含：" + set);
        System.out.println("敏感词替换:" + sensitiveWord.replace(string, "*"));
    }


}
