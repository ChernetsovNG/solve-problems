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
        List<List<Integer>> queries = new ArrayList<>();
        queries.add(Arrays.asList(1, 5));
        queries.add(Arrays.asList(1, 6));
        queries.add(Arrays.asList(3, 2));
        queries.add(Arrays.asList(1, 10));
        queries.add(Arrays.asList(1, 10));
        queries.add(Arrays.asList(1, 6));
        queries.add(Arrays.asList(2, 5));
        queries.add(Arrays.asList(3, 2));
        assertThat(FrequencyQueries.freqQuery(queries)).isEqualTo(Arrays.asList(0, 1));
    }

    @Test
    public void test2() {
        List<List<Integer>> queries = new ArrayList<>();
        queries.add(Arrays.asList(3, 4));
        queries.add(Arrays.asList(2, 1003));
        queries.add(Arrays.asList(1, 16));
        queries.add(Arrays.asList(3, 1));
        assertThat(FrequencyQueries.freqQuery(queries)).isEqualTo(Arrays.asList(0, 1));
    }

    @Test
    public void test3() {
        List<List<Integer>> queries = new ArrayList<>();
        queries.add(Arrays.asList(1, 3));
        queries.add(Arrays.asList(2, 3));
        queries.add(Arrays.asList(3, 2));
        queries.add(Arrays.asList(1, 4));
        queries.add(Arrays.asList(1, 5));
        queries.add(Arrays.asList(1, 5));
        queries.add(Arrays.asList(1, 4));
        queries.add(Arrays.asList(3, 2));
        queries.add(Arrays.asList(2, 4));
        queries.add(Arrays.asList(3, 2));
        assertThat(FrequencyQueries.freqQuery(queries)).isEqualTo(Arrays.asList(0, 1, 1));
    }

    @Test
    public void test4() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        File inputFile = new File(classLoader.getResource("FrequencyQueries/test-case-4-input.txt").getFile());
        File expectedOutputFile = new File(classLoader.getResource("FrequencyQueries/test-case-4-output.txt").getFile());

        Path inputPath = inputFile.toPath();
        Path expectedOutputPath = expectedOutputFile.toPath();

        List<List<Integer>> inputList = Files.lines(inputPath)
                .skip(1)
                .map(str -> {
                    String[] strSplit = str.split("\\s");
                    Integer operation = Integer.parseInt(strSplit[0]);
                    Integer number = Integer.parseInt(strSplit[1]);
                    return Arrays.asList(operation, number);
                })
                .collect(Collectors.toList());

        List<Integer> expectedOutput = Files.lines(expectedOutputPath)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> freqQuery = FrequencyQueries.freqQuery(inputList);

        assertThat(freqQuery).isEqualTo(expectedOutput);
    }

    @Test
    @Ignore
    public void test7() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        File inputFile = new File(classLoader.getResource("FrequencyQueries/test-case-7-input.txt").getFile());
        File expectedOutputFile = new File(classLoader.getResource("FrequencyQueries/test-case-7-output.txt").getFile());

        Path inputPath = inputFile.toPath();
        Path expectedOutputPath = expectedOutputFile.toPath();

        List<List<Integer>> inputList = Files.lines(inputPath)
                .skip(1)
                .map(str -> {
                    String[] strSplit = str.split("\\s");
                    Integer operation = Integer.parseInt(strSplit[0]);
                    Integer number = Integer.parseInt(strSplit[1]);
                    return Arrays.asList(operation, number);
                })
                .collect(Collectors.toList());

        List<Integer> expectedOutput = Files.lines(expectedOutputPath)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> freqQuery = FrequencyQueries.freqQuery(inputList);

        assertThat(freqQuery).isEqualTo(expectedOutput);
    }
}
