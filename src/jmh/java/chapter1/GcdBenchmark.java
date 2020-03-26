package chapter1;

import org.openjdk.jmh.annotations.*;

@Warmup(iterations = 2)
@Measurement(iterations = 2)
@BenchmarkMode(Mode.AverageTime)
@Fork(1)
public class GcdBenchmark {

    @Benchmark
    public void bestCase() {
        new Gcd(1, 1).calculate();
    }

    @Benchmark
    public void worstCase() {
        new Gcd(7540113804746346429l, 4660046610375530309l).calculate();
    }
}