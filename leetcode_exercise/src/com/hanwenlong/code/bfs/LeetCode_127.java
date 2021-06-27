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

        while (!queue.isEmpty()) {
            String chars1 = queue.poll();
            int size = chars1.length();

            List<String> wordList2 = getWordList(chars1,size);
            ok:for (int j=0;j<wordList.size();j++) {
                String word = wordList.get(j);
//                if (word.equals(endWord)) {
//                    break;
//                }
                for (int i = 1; i<=size; i++) {
                    String s = word.substring(0, i-1) + "*" + word.substring(i, size);
                    if (wordList2.contains(s)) {
                        System.out.println(word);
                        queue.offer(word);
                        wordList.remove(j);
                        set.add(word);
                    }
                }
            }

            step++;

        }

        return step;
    }

    private List<String> getWordList(String chars1, int size) {

        List<String> list = new ArrayList<>();
        for (int i=1; i<=size; i++) {
            String s = chars1.substring(0, i-1) + "*" + chars1.substring(i, size);
            //System.out.println(s);
            list.add(s);
        }
        return list;
    }

}
