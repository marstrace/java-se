package top.top7.test;

import sun.nio.cs.StandardCharsets;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/******
 *       Created by LEARNING on 2020/11/3 17:19.
 *
 **********************************************************************
 *                .-~~~~~~~~~-._       _.-~~~~~~~~~-.
 *            __.'              ~.   .~              `.__
 *          .'//                  \./                  \\`.
 *        .'//                     |                     \\`.
 *      .'// .-~"""""""~~~~-._     |     _,-~~~~"""""""~-. \\`.
 *    .'//.-"                 `-.  |  .-'                 "-.\\`.
 *  .'//______.============-..   \ | /   ..-============.______\\`.
 *.'______________________________\|/______________________________`.
 *
 *
 *                     Don't forget to be awesome!                      
 **********************************************************************
 */

/**
 * 测试第一季friends中有多少个单词,及出现频率
 */
public class Test1 {
    public static void main(String[] args) throws Exception {
        String s = new String(Files.readAllBytes(Paths.get("I:/friends.txt")));
        System.out.println(s.length());//15543
        List<String> list = Arrays.asList(s.split(" "));
        TreeSet<String> strings = new TreeSet<>(list);
        System.out.println(strings.size());//1069
        TreeMap<String, Integer> stringIntegerTreeMap = new TreeMap<>();
        for (String ss : list) {
            for (String sss : ss.split(":")) {
                stringIntegerTreeMap.put(sss.trim(), stringIntegerTreeMap.get(ss.trim()) == null ? 1 : stringIntegerTreeMap.get(ss.trim()) + 1);
            }
        }
        System.out.println(stringIntegerTreeMap.size());//1186

        Set<Map.Entry<String, Integer>> entries = stringIntegerTreeMap.entrySet();
        for (Map.Entry<String, Integer> m : entries) {
            System.out.println(m.getKey() + "----->\t" + m.getValue());
        }
    }
}
