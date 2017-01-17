package com.develogical;

import java.util.ArrayList;
import java.util.List;

public class RecentlyUsedList<T> {
    private final List<T> elements = new ArrayList<>();

    public int size() {
        return elements.size();
    }

    public void add(T s) {
        if (elements.contains(s)) {
            moveToFirst(s);
            return;
        }
        putAtFirst(s);
    }

    public T retrieve(int index) {
        T curr = elements.get(index);
        moveToFirst(curr);
        return curr;
    }

    private void putAtFirst(T s) {
        elements.add(0, s);
    }

    private void moveToFirst(T s) {
        elements.remove(s);
        putAtFirst(s);
    }
}
