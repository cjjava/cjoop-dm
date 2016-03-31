package com.cjoop.dm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ProcessInputStream extends Thread{
	
	private InputStream is; 
	
	public ProcessInputStream(InputStream is){
		this.is = is;
	}
	
	public void run() {
		try {
			BufferedReader br = new BufferedReader(
					new InputStreamReader(is,"GBK"));
			String line = null;
			while ((line = br.readLine()) != null) {
				if (line != null) {
					System.out.println(line);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(is !=null){
					is.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
