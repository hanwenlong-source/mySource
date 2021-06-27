package com.hanwenlong.code.bfs;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.List;

public class LeetCode_127_Answer {

    class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            if(!wordList.contains(endWord)) return 0;
            int count = 1;

            HashSet<String> wordSet = new HashSet<>();
            wordSet.addAll(wordList);
            wordSet.remove(beginWord);
            ArrayDeque<String> queue = new ArrayDeque<>();
            queue.addLast(beginWord);
            HashSet<String> visited = new HashSet<>();
            visited.add(beginWord);

            while(!queue.isEmpty())
            {
                int size = queue.size();
                for(int i = 0; i < size; i++)
                {
                    String temp = queue.removeFirst();
                    char[] chars = temp.toCharArray();

                    for(int j = 0; j < chars.length; j++)
                    {
                        char ch = chars[j];
                        for(char c = 'a'; c <= 'z'; c++)
                        {
                            if(c == ch)     continue;

                            chars[j] = c;
                            String str = toStr(chars);
                            if(str.equals(endWord)){
                                visited.add(str);
                                return count + 1;
                            }
                            if(!visited.contains(str) && wordSet.contains(str))
                            {
                                queue.addLast(str);
                                visited.add(str);
                            }
                        }

                        chars[j] = ch;
                    }
                }
                count++;
            }

            return visited.contains(endWord) ? count : 0;
        }

        private String toStr(char[] chars)
        {
            StringBuilder sb = new StringBuilder();
            for(char ch : chars)
                sb.append(ch);
            return sb.toString();
        }
    }

}
