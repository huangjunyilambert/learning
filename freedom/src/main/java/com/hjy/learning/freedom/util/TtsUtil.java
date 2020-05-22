package com.hjy.learning.freedom.util;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huangjy on 2019/8/24.
 * 文本切割
 */
public class TtsUtil {
    public static List<String> segment(String text, int count) {
        List<String> result = new ArrayList<>();

        if (StringUtils.isEmpty(text) || count < 1) {
            return result;
        }
        int segmentCount = text.length() / count + (text.length() % count == 0 ? 0 : 1);
        int startIndex = 0;
        int endIndex = count;
        for (int i = 0; i < segmentCount; i++) {
            if (endIndex > text.length()) {
                endIndex = text.length();
            }
            result.add(text.substring(startIndex, endIndex));
            startIndex += count;
            endIndex += count;
        }
        return result;

    }

    public static void main(String[] args) {
        String text = "玛丽·居里（玛丽亚·斯克沃多夫斯卡-居里，Marie Skłodowska Curie，1867年11月7日-1934年7月4日），世称“居里夫人”，出生于华沙，毕业于巴黎大学，法国著名波兰裔科学家、物理学家、化学家，巴黎大学第一位女教授，放射性研究的先驱者，首位获得诺贝尔奖的女性。1903年，她和丈夫共同获得诺贝尔物理学奖。1911年，又因放射化学方面的成就获得诺贝尔化学奖，因而成为世界上第一个两获诺贝尔奖的人。由于长期接触放射性物质，居里夫人于1934年7月4日因恶性白血病逝世";
        TtsUtil.segment(text, 12).forEach(t-> System.out.println(t));
        System.out.println(text.length());
    }

}
