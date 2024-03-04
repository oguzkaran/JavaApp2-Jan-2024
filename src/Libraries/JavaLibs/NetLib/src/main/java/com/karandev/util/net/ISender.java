/*----------------------------------------------------------------------
	FILE        : ISender.java
	AUTHOR      : Oğuz Karan
    LAST UPDATE : 21.04.2023

	ISender interface

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package com.karandev.util.net;

import java.io.IOException;

public interface ISender<T> {
    void send(T t) throws IOException;
}
