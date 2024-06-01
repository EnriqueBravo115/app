package org.example.app.composing;

import java.util.function.Function;

public class NamedFunctionComposer {
    public static Function<Integer, Integer> addTwo = x -> x + 2;

    public static Function<Integer, Integer> square = x -> x * x;

    public static Function<Function<Integer, Integer>, 
        Function<Function<Integer, Integer>, Function<Integer, Integer>>> 
            compose = x -> y -> z -> x.apply(y.apply(z));

    public static Function<Integer, Integer> addTwoAndSquare = compose.apply(square).apply(addTwo);
}
