/*----------------------------------------------------------------------
	FILE        : ITextReceiver.java
	AUTHOR      : Oğuz Karan
    LAST UPDATE : 21.04.2023

	ITextTransmission interface for login operations

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/

package com.karandev.util.net.ip.protocol.standard.text;

import com.karandev.util.net.IReceiver;
import com.karandev.util.net.ISender;

public interface ITextTransmission extends ISender<String>, IReceiver<String> {

}
