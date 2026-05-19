package tripleo.elijah_fluffy.util;

import tripleo.elijah_fluffy.adt.Adder;

import java.util.ArrayList;
import java.util.List;

public class StringAdder implements Adder<String> {
    List<String> l = new ArrayList<>();

    @Override
    public void add(final String x) {
        l.add(x);
    }

    public List<String> getList() {
        return l;
    }
}
