package model;

import java.util.ArrayList;

public final class Logger {
	private static ArrayList<String> logs = new ArrayList<String>();
	
	public static void log(String log) {
		System.out.println(log);
		logs.add(log);
	}
	
	public static void log(String [] args) {
		if(args != null) {
			for(int i = 0; i < args.length; i++) {
				System.out.println(args[i]);
				logs.add(args[i]);
			}
		}
	}
}
