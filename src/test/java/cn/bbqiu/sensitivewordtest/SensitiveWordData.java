package cn.bbqiu.sensitivewordtest;

import com.google.common.collect.Sets;

import java.util.Set;

/**
 * @author: nixgnehc nixgnehc@163.com
 * @date: 19-4-30
 * @time: 下午3:03
 * @Description: TODO..
 */

public class SensitiveWordData {

    public static Set<String> sensitives() {
        Set<String> set = Sets.newHashSet();
        set.add("驰名");
        set.add("驰名商标");
        set.add("驰名品牌");

        set.add("first");
        set.add("sex");
        set.add("xjp");
        set.add("文");

        set.add("第一");
        set.add("第一商标");
        set.add("第一品牌");
        return set;
    }
}
