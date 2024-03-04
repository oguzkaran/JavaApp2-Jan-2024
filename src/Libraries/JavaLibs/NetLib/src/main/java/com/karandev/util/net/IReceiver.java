/*----------------------------------------------------------------------
	FILE        : IReceiver.java
	AUTHOR      : Oğuz Karan
	LAST UPDATE : 21.04.2023

	IReceiver interface

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package com.karandev.util.net;

import java.io.IOException;
import java.util.List;

public interface IReceiver<T> {
    List<T> receive() throws IOException;
}
