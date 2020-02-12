package pl;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputStreamReader is = new InputStreamReader(System.in);
		BufferedReader buf = new BufferedReader(is);
		AppExecutor instance=new AppExecutor(is,buf);
		

	}

}
