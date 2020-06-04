package chapter1

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GcdTestKotlin {
    @Test
    fun testGcd() {
        assertEquals(1, gcd(7, 5))
        assertEquals(6, gcd(18, 6))
        assertEquals(57, gcd(2166, 6099))
    }
}