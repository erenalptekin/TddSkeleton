package com.develogical;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class RecentlyUsedList {
    private final List<String> elements = new ArrayList<>();

    public int size() {
        return elements.size();
    }

    public void add(String s) {
        if (elements.contains(s)) {
            elements.remove(s);
            elements.add(0,s);
            return;
        }
        elements.add(0, s);
    }

    public String retrieve(int index) {
        String curr = elements.get(index);
        elements.remove(index);
        elements.add(0,curr);
        return curr;
    }
}
