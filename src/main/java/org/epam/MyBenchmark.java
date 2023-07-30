package org.epam;

import org.openjdk.jmh.annotations.Benchmark;

import java.nio.file.Path;


public class MyBenchmark {
    private static final Path SAMPLE_PATH = Path.of("/home/user/projects/dict/src/main/resources/words.txt");

    @Benchmark
    public int forwardLoop() {
        var count = 0;
        // calculate loop boundaries at each iteration
        for (
                var i = 0;
                i < SAMPLE_PATH.getNameCount();
                i++
        ) {
            count++;
        }
        return count;
    }

    @Benchmark
    public int reverseLoop() {
        var count = 0;
        // calculate loop boundaries once at the very beginning
        for (
                var i = SAMPLE_PATH.getNameCount();
                i > 0;
                i--
        ) {
            count++;
        }
        return count;
    }
}
