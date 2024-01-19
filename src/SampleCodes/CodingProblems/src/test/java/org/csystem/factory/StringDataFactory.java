package org.csystem.factory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public final class StringDataFactory {
    private StringDataFactory()
    {}

    public static Collection<List<String>> getOrderedData(Comparator<String> comparator)
    {
        var coll = getData();

        coll.forEach(list -> list.sort(comparator));

        return coll;
    }

    public static Collection<List<String>> getData()
    {
        var list = new ArrayList<List<String>>();

        try (var br = Files.newBufferedReader(Path.of("testdata/stringdata.txt"), StandardCharsets.UTF_8)) {
            String line;

            while ((line = br.readLine()) != null) {
                var lineList = new ArrayList<String>(Arrays.asList(line.split("[ ,]+")));
                list.add(lineList);
            }
        }
        catch (IOException ex) {
            System.err.println(ex.getMessage());
        }

        return list;
    }

    public static Collection<String> getStringCollection(String path)
    {
        var list = new ArrayList<String>();

        try (var br = Files.newBufferedReader(Path.of(path), StandardCharsets.UTF_8)) {
            String line;

            while ((line = br.readLine()) != null)
                list.add(line);
        }
        catch (IOException ex) {
            System.err.println(ex.getMessage());
        }

        return list;
    }

    public static Collection<List<String>> getDataWithEmptyList()
    {
        var coll = getData();

        coll.add(new ArrayList<>());

        return coll;
    }
}
