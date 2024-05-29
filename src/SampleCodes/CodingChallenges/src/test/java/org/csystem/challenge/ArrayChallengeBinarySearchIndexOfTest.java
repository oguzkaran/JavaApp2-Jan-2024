package org.csystem.challenge;

import org.csystem.challenge.array.ArrayChallenge;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class ArrayChallengeBinarySearchIndexOfTest {
    public static int[] getArray(String path) throws IOException
    {

        try (var br = Files.newBufferedReader(Path.of(path), StandardCharsets.UTF_8)) {
            return Arrays.stream(br.readLine().split(","))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
    }

    @Test
    void testBinarySearchIndexOf_withGivenSortedLargeArray_shouldFoundNumbers() throws IOException
    {
        var arr = getArray("./testdata/sorted_numbers.csv");

        var expectedIdx1 = 998815;
        var expectedIdx2 = 50;
        var expectedIdx3 = 332815;

        var idx1 = ArrayChallenge.binarySearchIndexOf(arr, 999315);
        var idx2 = ArrayChallenge.binarySearchIndexOf(arr, 550);
        var idx3 = ArrayChallenge.binarySearchIndexOf(arr, 333315);

        Assertions.assertEquals(expectedIdx1, idx1);
        Assertions.assertEquals(expectedIdx2, idx2);
        Assertions.assertEquals(expectedIdx3, idx3);
    }


    @Test
    void testBinarySearchIndexOf_withGivenUnsortedLargeArray_shouldNotFoundNumbers() throws IOException
    {
        var arr = getArray("src/main/resources/unsorted_numbers.csv");

        var expectedIdx1 = -1;
        var expectedIdx2 = -1;
        var expectedIdx3 = -1;

        var idx1 = ArrayChallenge.binarySearchIndexOf(arr, 619688);
        var idx2 = ArrayChallenge.binarySearchIndexOf(arr, 550);
        var idx3 = ArrayChallenge.binarySearchIndexOf(arr, 333315);

        Assertions.assertEquals(expectedIdx1, idx1);
        Assertions.assertEquals(expectedIdx2, idx2);
        Assertions.assertEquals(expectedIdx3, idx3);
    }


    @Test
    void testBinarySearchIndexOf_withGivenSortedSmallArray_shouldFoundNumbers() throws IOException
    {
        var arr = getArray("src/main/resources/small_number_sorted.csv");

        var expectedIdx1 = 700;
        var expectedIdx2 = 2;

        var idx1 = ArrayChallenge.binarySearchIndexOf(arr, 1000);
        var idx2 = ArrayChallenge.binarySearchIndexOf(arr, 302);

        Assertions.assertEquals(expectedIdx1, idx1);
        Assertions.assertEquals(expectedIdx2, idx2);
    }


    @Test
    void testBinarySearchIndexOf_withGivenUnsortedSmallArray_shouldNotFoundNumbers() throws IOException
    {
        var arr = getArray("src/main/resources/small_number_unsorted.csv");

        var expectedIdx1 = -1;
        var expectedIdx2 = -1;

        var idx1 = ArrayChallenge.binarySearchIndexOf(arr, 425);
        var idx2 = ArrayChallenge.binarySearchIndexOf(arr, 302);

        Assertions.assertEquals(expectedIdx1, idx1);
        Assertions.assertEquals(expectedIdx2, idx2);
    }
}
