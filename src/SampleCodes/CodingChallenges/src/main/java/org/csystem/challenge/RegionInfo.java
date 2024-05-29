package org.csystem.challenge;

import java.util.Random;

/**
 * Class that includes values in [0, 1]. Zero is water and one is land
 */
public class RegionInfo {
    private final int [][] m_terrain;

    /**
     * Fill the matrix with random values
     * @param random Random generator that is used for fill matrix with random values in [0, 1]
     * @param row Number of rows
     * @param col Number of columns
     */
    public RegionInfo(Random random, int row, int col)
    {
        throw new UnsupportedOperationException("TODO:");
    }

    /**
     * Set the matrix. Does not check anything
     * @param matrix A matrix that include values zero or one
     */
    public RegionInfo(int [][] matrix)
    {
        throw new UnsupportedOperationException("TODO:");
    }

    /**
     *
     * @return number of islands in region
     */
    public int islandCount()
    {
        throw new UnsupportedOperationException("TODO:");
    }

    //...
}
