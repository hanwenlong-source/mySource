package com.hanwenlong.code.bfs;

import java.util.*;

public class LeetCode_127 {

    public static void main(String[] args) {

        LeetCode_127 leetCode_127 = new LeetCode_127();
        String [] a = {"hot","dot","dog","lot","log","cog"};
        List list = new ArrayList();
        for (String s : a) {
            list.add(s);
        }
        String beginWord = "hit", endWord = "cog";
        System.out.println(leetCode_127.ladderLength(beginWord,endWord,list));

    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Queue<String> queue = new ArrayDeque<>();
        Set<String> set = new HashSet<>();

        if (!wordList.contains(endWord)) {
            return 0;
        }
        int step = 1;
        queue.offer(beginWord);
        set.add(beginWord);

        List<String> endWordList = getEndWordList(endWord);

        while (!queue.isEmpty()) {
            String chars1 = queue.poll();
            System.out.println("------------");

            for (int j=0;j<wordList.size();j++) {
                String word = wordList.get(j);
                for (int i = 1; i<=chars1.length(); i++) {
                    String s = word.substring(0, i-1) + "*" + word.substring(i, chars1.length());

//                    if (endWordList.contains(s)) {
//                        System.out.println("--"+word);
//                        char[] chars = s.toCharArray();
//                        for (char k='a';k<='z';k++) {
//                            chars[i-1] = k;
//                        }
//                    }

                    if (!set.contains(word)&&wordList.contains(word)) {
                        System.out.println(word);
                        queue.offer(word);
                        set.add(word);
                    }

                }
            }

            step++;

        }

        return step;
    }

    private List<String> getEndWordList(String chars1) {

        List<String> list = new ArrayList<>();
        for (int i=1; i<=chars1.length(); i++) {
            String s = chars1.substring(0, i-1) + "*" + chars1.substring(i, chars1.length());
            //System.out.println(s);
            list.add(s);
        }
        return list;
    }

}
