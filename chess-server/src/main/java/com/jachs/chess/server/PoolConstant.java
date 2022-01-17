package com.jachs.chess.server;

import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.jachs.chess.service.THREADTYPE;

/***
 * 
 * @author zhanchaohan
 *
 */
public class PoolConstant {
	public static Map<THREADTYPE,Set<Socket>>clientMap=new HashMap<THREADTYPE, Set<Socket>>();

	public static List<ObjectInputStream>oisList=new ArrayList<ObjectInputStream>();
	public static List<ObjectOutputStream>oosList=new ArrayList<ObjectOutputStream>();
}
