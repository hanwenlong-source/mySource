package com.hanwenlong.util;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Tools {

    //打印map
    public static void printMap(Object map) {

        Set<Object> objects = ((Map<Object,Object>)map).keySet();
        for (Object k : objects) {
            System.out.println(k+":"+((Map<Object,Object>)map).get(k));
        }
    }

}
