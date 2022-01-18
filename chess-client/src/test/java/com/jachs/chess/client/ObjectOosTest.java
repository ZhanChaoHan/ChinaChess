package com.jachs.chess.client;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import org.junit.Test;

import com.jachs.chess.service.entity.Message;

/***
 * 
 * @author zhanchaohan
 *
 */
public class ObjectOosTest {

	@Test
	public void test1() throws FileNotFoundException, IOException {
		String path="f:\\a";
		
		ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(path));
		
		Message mess=new Message();
		mess.setStatus(0);
		mess.setUser_name("aa");
		mess.setMessage("abc");
		
		oos.writeObject(mess);
	}
}
