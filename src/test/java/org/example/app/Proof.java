package org.example.app;

import org.example.app.composing.CurriedFunctions;
import org.example.app.composing.PolimorfWay;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.function.Function;

import static org.example.app.composing.AnonymousFunctionComposer.*;
import static org.example.app.composing.NamedFunctionComposer.addTwoAndSquare;

public class Proof {
    public static final Function<Integer, Integer> triple = x -> x * 3;
    public static final Function<Integer, Integer> square = x -> x * x;

    @Test
    public void anonymousFunctionTest() {
        assertEquals(Integer.valueOf(4), addTwo.apply(2));
        assertEquals(Integer.valueOf(16), square.apply(4));
        assertEquals(Integer.valueOf(16), compose(square, addTwo).apply(2));
    }

    @Test
    public void namedFunctionTest() {
        assertEquals(Integer.valueOf(36), addTwoAndSquare.apply(4));
    }

    @Test
    public void polimorfWayTest() {
        assertEquals(Integer.valueOf(36),
                PolimorfWay.<Integer, Integer, Integer>higherCompose().apply(square).apply(triple).apply(2));

        assertEquals(Integer.valueOf(12),
                PolimorfWay.<Integer, Integer, Integer>higherAndThen().apply(square).apply(triple).apply(2));
    }

    @Test
    public void curriedFunctionTest() {
        Function<Integer, Function<Double, Double>> f = a -> b -> a * (1 + b / 100);
        Function<Double, Double> g = CurriedFunctions.partialA(89, f);

        assertEquals(f.apply(89).apply(7.0), g.apply(7.0));
        assertEquals(f.apply(89).apply(0.0), g.apply(0.0));
        assertEquals(f.apply(89).apply(16.65), g.apply(16.65));
    }
}
