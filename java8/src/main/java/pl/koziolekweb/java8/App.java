package pl.koziolekweb.java8;

import org.testng.annotations.Test;

import java.net.SocketException;

/**
 * TODO write JAVADOC!!!
 * User: koziolek
 */
public class App {

	@Test
	public void getLocalIp() throws SocketException {
		byte[] b = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0x46,0x46};
		byte o = b[18];
		byte y = b[19];
		System.out.println(o+y);
	}
}
