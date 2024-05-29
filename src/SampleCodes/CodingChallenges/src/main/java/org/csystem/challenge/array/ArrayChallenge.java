package org.csystem.challenge.array;

public final class ArrayChallenge {
    private ArrayChallenge()
    {
    }

    public static  int linearSearchIndexOf(int [] a, int val)
    {
        for (var i = 0; i < a.length; ++i)
            if (a[i] == val)
                return i;

        return -1;
    }

    public static  int binarySearchIndexOf(int [] a, int val)
    {
        int left = 0;
        int right = a.length - 1;
        int mid;

        while (left <= right) {
            mid = (left + right) / 2;
            if (a[mid] == val)
                return mid;

            if (a[mid] < val)
                left = mid + 1;
            else if (val < a[mid])
                right = mid - 1;
        }

        return -1;
    }
}

