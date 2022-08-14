package com.chapter1;

public class Gcd {
    private long m;
    private long n;

    public Gcd(long m, long n) {
        this.m = m;
        this.n = n;
    }

    public long calculate() {
        long r = m % n;
        while (r != 0) {
            m = n;
            n = r;
            r = m % n;
        }
        return n;
    }
}