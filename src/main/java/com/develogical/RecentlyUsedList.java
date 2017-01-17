package com.develogical;

import java.util.ArrayList;
import java.util.List;

public class RecentlyUsedList {
    private final List<String> elements = new ArrayList<>();

    public int size() {
        return elements.size();
    }

    public void add(String s) {
        if (elements.contains(s)) {
            moveToFirst(s);
            return;
        }
        putAtFirst(s);
    }

    public String retrieve(int index) {
        String curr = elements.get(index);
        moveToFirst(curr);
        return curr;
    }

    private void putAtFirst(String s) {
        elements.add(0, s);
    }

    private void moveToFirst(String s) {
        elements.remove(s);
        putAtFirst(s);
    }
}
