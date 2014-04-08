package pl.koziolekweb.java8.collections;

import com.google.common.collect.Lists;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pl.koziolekweb.java8.Range;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Created by bartlomiej.kuczynski on 2014-04-08.
 */

@Test()
@Listeners(StatsListener.class)
public class StreamAntipatterns {

    public static final int MAX_SIZE = 1500000;
    private List<Integer> collect = Stream.iterate(1, x -> x + 1).limit(MAX_SIZE)
            .collect(Collectors.toList());


    @Test
    public void removeExtremumBad() {
        List<Integer> ranges = Stream.iterate(1, x -> x + 1).limit(15)
                .collect(Collectors.toList());
        List<Integer> collect = ranges.stream()
                .filter(x -> x != ranges.stream()
                        .mapToInt(Integer::intValue)
                        .max()
                        .getAsInt())
                .filter(x -> x != ranges.stream()
                        .mapToInt(Integer::intValue)
                        .min()
                        .getAsInt())
                .collect(Collectors.toList());
        assertThat(collect).hasSize(13);   // OK
        assertThat(collect).isEqualTo(Lists.newArrayList(new Range(2, 14)));   // OK

    }


    @Test
    public void removeExtremumGood() {
        List<Integer> ranges = Stream.iterate(1, x -> x + 1).limit(15)
                .collect(Collectors.toList());
        List<Integer> collect = ranges.stream()
                .sorted(Comparator.<Integer>reverseOrder())
                .skip(1)
                .sorted()
                .skip(1)
                .collect(Collectors.toList());
        assertThat(collect).hasSize(13);   // OK
        assertThat(collect).isEqualTo(Lists.newArrayList(new Range(2, 14)));   // OK
    }


    @Test(invocationCount = 100)
    public void parallelBad() {
        collect
                .parallelStream()
                .filter(x -> x % 9 == 0)
                .collect(Collectors.toList());
    }

    @Test(invocationCount = 100)
    public void parallelGood() {
        Stream.iterate(1, x -> x + 1).limit(MAX_SIZE)
                .collect(Collectors.toList())
                .stream()
                .filter(x -> x % 9 == 0)
                .collect(Collectors.toList());
    }

}
