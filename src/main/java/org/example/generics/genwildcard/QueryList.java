package org.example.generics.genwildcard;

import java.util.ArrayList;
import java.util.List;

public class QueryList<T extends QueryItem> extends ArrayList<T> {
//    private List<T> items;

    public QueryList() {

    }

    public QueryList(List<T> items) {
        super(items);
//        this.items = items;
    }

    public List<T> getMatches(String field, String value) {
        List<T> matches = new QueryList<>();
        for (var item : this) {
            if (item.matchFieldValue(field, value)) {
                matches.add(item);
            }
        }
        return matches;
    }

    public static <T extends QueryItem> List<T> getMatches(List<T> items, String field, String value) {
        List<T> matches = new ArrayList<>();
        for (var item : items) {
            if (item.matchFieldValue(field, value)) {
                matches.add(item);
            }
        }
        return matches;
    }
}
