package org.csystem.challenge.io.file;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DirectoryInfoLengthTest {
    @Test
    public void testDocs()
    {
        var expected = 13717;

        Assertions.assertEquals(expected, DirectoryInfo.length("./docs/legal"));
    }
}
