package cn.bbqiu.sensitiveword;

import java.util.Set;

/**
 * @author: nixgnehc nixgnehc@163.com
 * @date: 19-4-30
 * @time: 下午2:52
 * @Description: TODO..
 */

public interface SensitiveWord {

    /**
     * 检测
     * @param txt
     * @return
     */
    public boolean detect(String txt);

    /**
     * 替换
     * @param txt
     * @param replaceChar
     * @return
     */
    public String replace(String txt, String replaceChar);

    /**
     * 包含的敏感词查找
     * @param txt
     * @return
     */
    public Set<String> contain(String txt);
}
