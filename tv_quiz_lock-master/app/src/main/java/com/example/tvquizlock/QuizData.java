package com.example.tvquizlock;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuizData {
    public static final String PASSWORD = "8888";

    public static class Item {
        String q;
        String a;
        String[] opt;
        Item(String q, String[] opt, String a) {
            this.q = q;
            this.opt = opt;
            this.a = a;
        }
    }

    public static List<Item> getList() {
        List<Item> list = new ArrayList<>();
        list.add(new Item("“举头望明月”下一句？", new String[]{"低头思故乡", "更上一层楼"}, "低头思故乡"));
        list.add(new Item("一年有几个季度？", new String[]{"4", "12"}, "4"));
        list.add(new Item("三角形有几条边？", new String[]{"3", "4"}, "3"));
        return list;
    }

    public static Item random() {
        List<Item> l = getList();
        return l.get(new Random().nextInt(l.size()));
    }
}