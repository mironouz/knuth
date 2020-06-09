long gcd(long m, long n) {
    long d = m % n;
    while (d != 0) {
        m = n;
        n = d;
        d = m % n;
    }
    return n;
}