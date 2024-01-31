package org.csystem.challenge.io.file;

public class DirectoryInfo {
    private static long ms_length;

    private static void calculateLength(String dirPath)
    {
        for (var path : FileUtil.files(dirPath)) {
            if (FileUtil.isDirectory(path))
                calculateLength(path);

            ms_length += FileUtil.size(path);
        }
    }

    /**
     * Most operating system do not store the size of directories. It can be calculated from file lengths. This method
     * calculates the total size of the file in directory and its sun directories
     * @param dirPath directory path
     * @return the size of the directory
     */
    public static long length(String dirPath)
    {
        ms_length = 0;

        calculateLength(dirPath);

        return ms_length;
    }
}
