/*----------------------------------------------------------------------
	FILE        : TcpUtil.java
	AUTHOR      : Oğuz Karan
	LAST UPDATE : 21.04.2023

	Utility class for TCP socket operations

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package com.karandev.util.net;

import com.karandev.util.net.exception.NetworkException;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

public final class TcpUtil {
	private static int receive(DataInputStream dis, byte [] data, int offset, int length) throws IOException
	{
	    int result;
	    int left = length, index = 0;

	    while (left > 0) {
	        if ((result = dis.read(data, offset, left)) == -1)
	            return -1;
	        
	        if (result == 0)
	            break;
	        
	        index += result;
	        left -= result;
	    }

	    return index;
	}

	private static int receive(DataInputStream dis, byte [] data) throws IOException
	{
	    return receive(dis, data, 0, data.length);
	}

	private static int send(DataOutputStream dos, byte [] data, int offset, int length) throws IOException
	{						
		int curOffset = offset;		
		int left = length;
		int total = 0;
		int written;
		int initWritten = dos.size();
		
		while (curOffset < length) {
			dos.write(data, curOffset, left);
			dos.flush();
			written = dos.size() - initWritten;
			total += written;			
			left -= written;
			curOffset += written;
		}	
		
		return total;
	}
	
	private static int send(DataOutputStream dos, byte [] data) throws IOException
	{
	    return send(dos, data, 0, data.length);
	}

	private TcpUtil() {}

	public static Optional<ServerSocket> getFirstAvailableSocket(int backlog, int minPort, int maxPort)
	{
		Optional<ServerSocket> result = Optional.empty();

		for (int port = minPort; port <= maxPort; ++port)
			try {
				result = Optional.of(new ServerSocket(backlog, port));
			}
			catch (IOException ignore) {
			}

		return result;
	}

	public static Optional<ServerSocket> getFirstAvailablePort(int minPort, int maxPort)
	{
		Optional<ServerSocket> result = Optional.empty();

		for (int port = minPort; port <= maxPort; ++port)
			try {
				result = Optional.of(new ServerSocket(port));
			}
			catch (IOException ignore) {
			}

		return result;
	}

	public static Optional<ServerSocket> getFirstAvailableSocket(int backlog, int...ports)
	{
		Optional<ServerSocket> result = Optional.empty();

		for (var port : ports)
			try {
				result = Optional.of(new ServerSocket(backlog, port));
			}
			catch (IOException ignore) {
			}

		return result;
	}

	public static Optional<ServerSocket> getFirstAvailableSocket(int...ports)
	{
		Optional<ServerSocket> result = Optional.empty();

		for (var port : ports)
			try {
				result = Optional.of(new ServerSocket(port));
			}
			catch (IOException ignore) {
			}

		return result;
	}


	public static int receive(Socket socket, byte [] data, int offset, int length)
	{
		try {
			return receive(new DataInputStream(socket.getInputStream()), data, offset, length);
		}
		catch (Throwable ex) {
			throw new NetworkException("TcpUtil.receive", ex);
		}
	}

	public static int receive(Socket socket, byte [] data)
	{
		try {
			return receive(socket, data, 0, data.length);
		}
		catch (Throwable ex) {
			throw new NetworkException("TcpUtil.receive", ex.getCause());
		}
	}

	public static int send(Socket socket, byte [] data, int offset, int length)
	{
		try {
			return send(new DataOutputStream(socket.getOutputStream()), data, offset, length);
		}
		catch (Throwable ex) {
			throw new NetworkException("TcpUtil.send", ex);
		}
	}

	public static int send(Socket socket, byte [] data)
	{
		try {
			return send(socket, data, 0, data.length);
		}
		catch (Throwable ex) {
			throw new NetworkException("TcpUtil.send", ex.getCause());
		}
	}

	public static byte receiveByte(Socket socket)
	{
		try {
			byte [] data = new byte[1];

			receive(socket, data);

			return data[0];
		}
		catch (NetworkException ex) {
			throw new NetworkException("TcpUtil.receiveByte", ex.getCause());
		}
		catch (Throwable ex) {
			throw new NetworkException("TcpUtil.receiveByte", ex);
		}
	}

	public static short receiveShort(Socket socket)
	{
		try {
			byte[] data = new byte[2];

			receive(socket, data);

			return BitConverter.toShort(data);
		}
		catch (NetworkException ex) {
			throw new NetworkException("TcpUtil.receiveShort", ex.getCause());
		}
		catch (Throwable ex) {
			throw new NetworkException("TcpUtil.receiveShort", ex);
		}
	}

	public static int receiveInt(Socket socket)
	{
		try {
			byte[] data = new byte[4];

			receive(socket, data);

			return BitConverter.toInt(data);
		}
		catch (NetworkException ex) {
			throw new NetworkException("TcpUtil.receiveInt", ex.getCause());
		}
		catch (Throwable ex) {
			throw new NetworkException("TcpUtil.receiveInt", ex);
		}
	}

	public static long receiveLong(Socket socket)
	{
		try {
			byte[] data = new byte[8];

			receive(socket, data);

			return BitConverter.toLong(data);
		}
		catch (NetworkException ex) {
			throw new NetworkException("TcpUtil.receiveLong", ex.getCause());
		}
		catch (Throwable ex) {
			throw new NetworkException("TcpUtil.receiveLong", ex);
		}
	}

	public static float receiveFloat(Socket socket)
	{
		try {
			byte[] data = new byte[4];

			receive(socket, data);

			return BitConverter.toFloat(data);
		}
		catch (NetworkException ex) {
			throw new NetworkException("TcpUtil.receiveFloat", ex.getCause());
		}
		catch (Throwable ex) {
			throw new NetworkException("TcpUtil.receiveFloat", ex);
		}
	}

	public static double receiveDouble(Socket socket)
	{
		try {
			byte[] data = new byte[8];

			receive(socket, data);

			return BitConverter.toDouble(data);
		}
		catch (NetworkException ex) {
			throw new NetworkException("TcpUtil.receiveDouble", ex.getCause());
		}
		catch (Throwable ex) {
			throw new NetworkException("TcpUtil.receiveDouble", ex);
		}
	}

	public static char receiveChar(Socket socket)
	{
		try {
			byte[] data = new byte[2];

			receive(socket, data);

			return BitConverter.toChar(data);
		}
		catch (NetworkException ex) {
			throw new NetworkException("TcpUtil.receiveChar", ex.getCause());
		}
		catch (Throwable ex) {
			throw new NetworkException("TcpUtil.receiveChar", ex);
		}
	}

	public static boolean receiveBoolean(Socket socket)
	{
		try {
			return new DataInputStream(socket.getInputStream()).readByte() != 0;
		}
		catch (Throwable ex) {
			throw new NetworkException("TcpUtil.receiveBoolean", ex);
		}
	}

	public static String receiveStringViaLength(Socket socket)
	{
		return receiveStringViaLength(socket, StandardCharsets.UTF_8);
	}

	public static String receiveStringViaLength(Socket socket, Charset charset)
	{
		try {
			byte[] dataLen = new byte[4];
			receive(socket, dataLen);

			byte[] data = new byte[BitConverter.toInt(dataLen)];

			receive(socket, data);

			return BitConverter.toString(data, charset);
		}
		catch (NetworkException ex) {
			throw new NetworkException("TcpUtil.receiveStringViaLength", ex.getCause());
		}
		catch (Throwable ex) {
			throw new NetworkException("TcpUtil.receiveStringViaLength", ex);
		}
	}

	public static String receiveString(Socket socket, int length)
	{
		return receiveString(socket, length, StandardCharsets.UTF_8);
	}

	public static String receiveString(Socket socket, int length, Charset charset)
	{
		try {
			byte[] data = new byte[length];

			receive(socket, data);

			return BitConverter.toString(data, charset);
		}
		catch (NetworkException ex) {
			throw new NetworkException("TcpUtil.receiveString", ex.getCause());
		}
		catch (Throwable ex) {
			throw new NetworkException("TcpUtil.receiveString", ex);
		}
	}

	public static void receiveFile(Socket socket, File file)
	{
		receiveFile(socket, file.getAbsolutePath());
	}

	public static void receiveFile(Socket socket, String path)
	{
		try (FileOutputStream fos = new FileOutputStream(path)) {
			int result;

			for (;;) {
				var data = new byte[receiveInt(socket)];
				result = receive(socket, data);

				if (result <= 0)
					break;

				fos.write(data, 0, result);
			}
		}
		catch (NetworkException ex) {
			throw new NetworkException("TcpUtil.receiveFile", ex.getCause());
		}
		catch (Throwable ex) {
			throw new NetworkException("TcpUtil.receiveFile", ex);
		}
	}

	public static void sendByte(Socket socket, byte val)
	{
		try {
			send(socket, BitConverter.getBytes(val));
		}
		catch (Throwable ex) {
			throw new NetworkException("TcpUtil.sendByte", ex);
		}
	}

	public static void sendShort(Socket socket, short val)
	{
		try {
			send(socket, BitConverter.getBytes(val));
		}
		catch (NetworkException ex) {
			throw new NetworkException("TcpUtil.sendShort", ex.getCause());
		}
		catch (Throwable ex) {
			throw new NetworkException("TcpUtil.sendShort", ex);
		}
	}

	public static void sendInt(Socket socket, int val)
	{
		try {
			send(socket, BitConverter.getBytes(val));
		}
		catch (NetworkException ex) {
			throw new NetworkException("TcpUtil.sendInt", ex.getCause());
		}
		catch (Throwable ex) {
			throw new NetworkException("TcpUtil.sendInt", ex);
		}
	}

	public static void sendLong(Socket socket, long val)
	{
		try {
			send(socket, BitConverter.getBytes(val));
		}
		catch (NetworkException ex) {
			throw new NetworkException("TcpUtil.sendLong", ex.getCause());
		}
		catch (Throwable ex) {
			throw new NetworkException("TcpUtil.sendLong", ex);
		}
	}

	public static void sendFloat(Socket socket, float val)
	{
		try {
			send(socket, BitConverter.getBytes(val));
		}
		catch (NetworkException ex) {
			throw new NetworkException("TcpUtil.sendFloat", ex.getCause());
		}
		catch (Throwable ex) {
			throw new NetworkException("TcpUtil.sendFloat", ex);
		}
	}

	public static void sendDouble(Socket socket, double val)
	{
		try {
			send(socket, BitConverter.getBytes(val));
		}
		catch (NetworkException ex) {
			throw new NetworkException("TcpUtil.sendDouble", ex.getCause());
		}
		catch (Throwable ex) {
			throw new NetworkException("TcpUtil.sendDouble", ex);
		}
	}

	public static void sendChar(Socket socket, char val)
	{
		try {
			send(socket, BitConverter.getBytes(val));
		}
		catch (NetworkException ex) {
			throw new NetworkException("TcpUtil.sendChar", ex.getCause());
		}
		catch (Throwable ex) {
			throw new NetworkException("TcpUtil.sendChar", ex);
		}
	}

	public static void sendBoolean(Socket socket, boolean val)
	{
		try {
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

			dos.writeByte(val ? 1 : 0);
			dos.flush();
		}
		catch (Throwable ex) {
			throw new NetworkException("TcpUtil.sendBoolean", ex);
		}
	}

	public static void sendStringViaLength(Socket socket, String str)
	{
		sendStringViaLength(socket, str, StandardCharsets.UTF_8);
	}

	public static void sendStringViaLength(Socket socket, String str, Charset charset)
	{
		try {
			byte[] data = BitConverter.getBytes(str, charset);
			byte[] dataLen = BitConverter.getBytes(data.length);

			send(socket, dataLen);
			send(socket, data);
		}
		catch (NetworkException ex) {
			throw new NetworkException("TcpUtil.sendStringViaLength", ex.getCause());
		}
		catch (Throwable ex) {
			throw new NetworkException("TcpUtil.sendStringViaLength", ex);
		}
	}

	public static void sendString(Socket socket, String str)
	{
		sendString(socket, str, StandardCharsets.UTF_8);
	}

	public static void sendString(Socket socket, String str, Charset charset)
	{
		try {
			byte[] data = BitConverter.getBytes(str, charset);

			send(socket, data);
		}
		catch (NetworkException ex) {
			throw new NetworkException("TcpUtil.sendString", ex.getCause());
		}
		catch (Throwable ex) {
			throw new NetworkException("TcpUtil.sendString", ex);
		}
	}

	public static void sendFile(Socket socket, File file, int blockSize)
	{
		sendFile(socket, file.getAbsolutePath(), blockSize);
	}

	public static void sendFile(Socket socket, String path, int blockSize)
	{
		byte [] data = new byte[blockSize];

		try (FileInputStream fis = new FileInputStream(path)) {
			int result;

			for (;;) {
				result = fis.read(data);
				if (result <= 0)
					break;

				sendInt(socket, result);
				send(socket, data, 0, result);
			}
		}
		catch (NetworkException ex) {
			throw new NetworkException("TcpUtil.sendFile", ex.getCause());
		}
		catch (Throwable ex) {
			throw new NetworkException("TcpUtil.sendFile", ex);
		}
	}
}
