package com.chapter1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GcdTest {

    @Test
    void calculate() {
        assertEquals(1, new Gcd(7, 5).calculate());
        assertEquals(6, new Gcd(18, 6).calculate());
        assertEquals(57, new Gcd(2166, 6099).calculate());
    }
}