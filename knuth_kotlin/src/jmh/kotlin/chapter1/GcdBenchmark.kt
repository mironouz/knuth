package chapter1

import org.openjdk.jmh.annotations.Benchmark
import org.openjdk.jmh.annotations.BenchmarkMode
import org.openjdk.jmh.annotations.Fork
import org.openjdk.jmh.annotations.Measurement
import org.openjdk.jmh.annotations.Mode
import org.openjdk.jmh.annotations.Warmup

@Warmup(iterations = 2)
@Measurement(iterations = 2)
@BenchmarkMode(Mode.AverageTime)
@Fork(1)
open class GcdBenchmarkKotlin {
    @Benchmark
    fun bestCase() {
        gcd(1,1)
    }

    @Benchmark
    fun worstCase() {
        gcd(7540113804746346429L, 4660046610375530309L)
    }
}