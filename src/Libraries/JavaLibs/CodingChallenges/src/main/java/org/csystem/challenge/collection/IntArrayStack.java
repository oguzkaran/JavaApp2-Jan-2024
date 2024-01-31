/*
    Sınıf Çalışması: Aşağıdaki stack sınıfını public bölümünü değiştirmeden yazınız.
    Açıklamalar:
        - Sınıf içsel olarak bir dizi kullanacaktır
        - Hiç bir metot herhangi bir exception fırlatmayacaktır
*/

package org.csystem.challenge.collection;

/**
 *
 * Fixed stack that stores int values. Stack capacity does not grow. It is fixed
 */
public class IntArrayStack {
    /**
     * Creates a fixed stack
     * @param capacity of the stack
     */
    public IntArrayStack(int count)
    {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Pushes a value to the stack if available
     * @param value for push
     * @return true if stack is available, false if stack full
     */
    public boolean push(int value)
    {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Peek the last element from stack
     * @return last element from stack, zero if stack is empty
     */
    public int peek()
    {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Pops a last in value from stack if stack is not empty
     * @return true if stack is available, false if stack is empty
     */
    public boolean pop()
    {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     *  Check if stack is empty
     * @return true if stack is empty, otherwise false
     */
    public boolean isEmpty()
    {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Gets the size of the elements int the stack
     *
     * @return size of the elements int the stack
     */
    public int size()
    {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Gets the capacity of the elements int the stack
     *
     * @return capacity of the elements int the stack
     */
    public int capacity()
    {
        throw new UnsupportedOperationException("TODO");
    }
}
