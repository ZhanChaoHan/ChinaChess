package com.jachs.chess.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Test;

import com.jachs.chess.service.entity.Message;

/***
 * 
 * @author zhanchaohan
 *
 */
public class Test1 {
	
	@Test
	public void test1() {
		System.out.println(THREADTYPE.Session);
		System.out.println(THREADTYPE.Game);
	}
	
	@Test
	public void test3() throws FileNotFoundException, IOException, ClassNotFoundException {
		String path="f:\\a";
		ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(path));
		ObjectInputStream ois=new ObjectInputStream(new FileInputStream(path));
		
		Message mess=new Message();
		mess.setStatus(0);
		mess.setUser_name("aa");
		mess.setMessage("abc");
		
		oos.writeObject(mess);
		
		Message mc= (Message) ois.readObject();
		
		System.out.println(mc.getStatus());
		System.out.println(mc.getUser_name());
		System.out.println(mc.getMessage());
	}
}
