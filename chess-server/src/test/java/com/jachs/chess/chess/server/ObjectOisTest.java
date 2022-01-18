package com.jachs.chess.chess.server;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import org.junit.Test;

import com.jachs.chess.service.entity.Message;

/***
 * 
 * @author zhanchaohan
 *
 */
public class ObjectOisTest {
	
	@Test
	public void test1() throws FileNotFoundException, IOException, ClassNotFoundException {
		String path="f:\\a";
		ObjectInputStream ois=new ObjectInputStream(new FileInputStream(path));
		
		Message mc= (Message) ois.readObject();
		
		System.out.println(mc.getStatus());
		System.out.println(mc.getUser_name());
		System.out.println(mc.getMessage());
	}
}
