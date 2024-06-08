package org.example.app.composing;

import java.util.function.Function;

public class AnonymousClassesComposer {
    public static Function<Integer, Integer> addTwo = new Function<>() {
        @Override
        public Integer apply(Integer t) {
            return t + 2;
        }
    };

    public static Function<Integer, Integer> square = new Function<>() {
        @Override
        public Integer apply(Integer t) {
            return t * t;
        }
    };

    public static Function<Integer, Integer> compose(Function<Integer, Integer> f1, Function<Integer, Integer> f2) {
        return new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer t) {
                return f1.apply(f2.apply(t));
            }
        };
    }
}
