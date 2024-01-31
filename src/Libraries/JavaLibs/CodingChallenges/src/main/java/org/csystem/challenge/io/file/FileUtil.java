package org.csystem.challenge.io.file;

import java.io.File;

public class FileUtil {
    /**
     * Does not check if it is file or not
     * @param path path of file
     * @return length of the file
     */
    public static long size(String path)
    {
        return new File(path).length();
    }

    /**
     * Does not check if it is directory or not
     * @param dir path of the directory
     * @return files or directories in directory
     */
    public static String [] files(String dir)
    {
        return new File(dir).list();
    }

    /**
     * Checks if path is directory
     * @param path path information
     * @return true if path is a directory, otherwise false
     */
    public static boolean isDirectory(String path)
    {
        return new File(path).isDirectory();
    }

    //...
}
