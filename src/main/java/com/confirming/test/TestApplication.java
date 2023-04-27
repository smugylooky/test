package com.confirming.test;

import com.confirming.test.service.ProveedorService;


public class TestApplication {
	
	public static void main(String[] args) {
		if (args.length == 1) {
			new ProveedorService().setUpConnection(args[0]);
		}
	}

}
