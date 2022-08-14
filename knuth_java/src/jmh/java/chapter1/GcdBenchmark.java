package chapter1;


import com.chapter1.Gcd;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Warmup;

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