package org.example.app.composing;

import java.util.function.Function;

public class CurriedFunctions {
    public static <A, B, C> Function<B, C> partialApplyFirst(A a, Function<A, Function<B, C>> f) {
        return f.apply(a);
    }

    public static <A, B, C> Function<A, C> partialApplySecond(B b, Function<A, Function<B, C>> f) {
        return a -> f.apply(a).apply(b);
    }
}
