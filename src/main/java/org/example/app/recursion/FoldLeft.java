package org.example.app.recursion;

import java.util.List;
import java.util.function.Function;

import static org.example.app.recursion.TailCall.*;
import static org.example.app.recursion.Utilities.*;

public class FoldLeft {
    public static <T, U> U foldLeft(List<T> ts, U identity, Function<U, Function<T, U>> f) {
        return foldLeft_(ts, identity, f).eval();
    }

    private static <T, U> TailCall<U> foldLeft_(List<T> ts, U identity, Function<U, Function<T, U>> f) {
        return ts.isEmpty()
                ? ret(identity)
                : sus(() -> foldLeft_(tail(ts), f.apply(identity).apply(head(ts)), f));
    }
}
