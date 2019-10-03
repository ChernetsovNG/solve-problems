package ru.nchernetsov.interviewPreparationKit;

import org.junit.Ignore;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class FrequencyQueriesTest {

    @Test
    public void test1() {
        List<int[]> queries = new ArrayList<>();
        queries.add(new int[]{1, 5});
        queries.add(new int[]{1, 6});
        queries.add(new int[]{3, 2});
        queries.add(new int[]{1, 10});
        queries.add(new int[]{1, 10});
        queries.add(new int[]{1, 6});
        queries.add(new int[]{2, 5});
        queries.add(new int[]{3, 2});
        assertThat(FrequencyQueries.freqQuery(queries)).isEqualTo(Arrays.asList(0, 1));
    }

    @Test
    public void test2() {
        List<int[]> queries = new ArrayList<>();
        queries.add(new int[]{3, 4});
        queries.add(new int[]{2, 1003});
        queries.add(new int[]{1, 16});
        queries.add(new int[]{3, 1});
        assertThat(FrequencyQueries.freqQuery(queries)).isEqualTo(Arrays.asList(0, 1));
    }

    @Test
    public void test3() {
        List<int[]> queries = new ArrayList<>();
        queries.add(new int[]{1, 3});
        queries.add(new int[]{2, 3});
        queries.add(new int[]{3, 2});
        queries.add(new int[]{1, 4});
        queries.add(new int[]{1, 5});
        queries.add(new int[]{1, 5});
        queries.add(new int[]{1, 4});
        queries.add(new int[]{3, 2});
        queries.add(new int[]{2, 4});
        queries.add(new int[]{3, 2});
        assertThat(FrequencyQueries.freqQuery(queries)).isEqualTo(Arrays.asList(0, 1, 1));
    }

    @Test
    public void test4() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        File inputFile = new File(classLoader.getResource("FrequencyQueries/test-case-4-input.txt").getFile());
        File expectedOutputFile = new File(classLoader.getResource("FrequencyQueries/test-case-4-output.txt").getFile());

        Path inputPath = inputFile.toPath();
        Path expectedOutputPath = expectedOutputFile.toPath();

        List<int[]> inputList = Files.lines(inputPath)
                .skip(1)
                .map(str -> {
                    String[] strSplit = str.split("\\s");
                    int operation = Integer.parseInt(strSplit[0]);
                    int number = Integer.parseInt(strSplit[1]);
                    return new int[]{operation, number};
                })
                .collect(Collectors.toList());

        List<Integer> expectedOutput = Files.lines(expectedOutputPath)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> freqQuery = FrequencyQueries.freqQuery(inputList);

        assertThat(freqQuery).isEqualTo(expectedOutput);
    }
}
