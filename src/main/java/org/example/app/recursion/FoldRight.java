package org.example.app.recursion;

import static org.example.app.recursion.TailCall.*;
import static org.example.app.recursion.Utilities.*;

import java.util.List;
import java.util.function.Function;

public class FoldRight {
    public static <T, U> U foldRight(List<T> ts, U identity, Function<T, Function<U, U>> f) {
        return foldRight_(identity, reverse(ts), f).eval();
    }

    private static <T, U> TailCall<U> foldRight_(U acc, List<T> ts, Function<T, Function<U, U>> f) {
        return ts.isEmpty()
                ? ret(acc)
                : sus(() -> foldRight_(f.apply(head(ts)).apply(acc), tail(ts), f));
    }
}
