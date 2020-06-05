package chapter1

fun gcd(M: Long, N: Long): Long {
    var d = M % N
    var m: Long
    var n = N
    while (d != 0L) {
        m = n
        n = d
        d = m % n
    }
    return n
}