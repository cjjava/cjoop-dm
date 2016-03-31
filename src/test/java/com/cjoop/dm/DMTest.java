package com.cjoop.dm;

import com.cjoop.dm.DmSoft;

public class DMTest {

	public static void main(String[] args) {
		DmSoft dm = new DmSoft();
		System.out.println("version:" + dm.Ver());
		System.out.println("path:"+dm.GetBasePath());
	}
}
