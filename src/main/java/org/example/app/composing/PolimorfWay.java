package org.example.app.composing;

import java.util.function.Function;

public class PolimorfWay {
    public static <A, B, C> Function<Function<B, C>, 
           Function<Function<A, B>, Function<A, C>>> higherCompose() {
        return f -> g -> x -> f.apply(g.apply(x));
    }

    public static <A, B, C> Function<Function<A, B>, 
           Function<Function<B, C>, Function<A, C>>> higherAndThen() {
        return f -> g -> x -> g.apply(f.apply(x));
    }
}
