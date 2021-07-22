package util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ScannerBuffer {
	private static ScannerBuffer instance = new ScannerBuffer();
	public static ScannerBuffer getInstance() {
		return instance;
	}
	private ScannerBuffer() {}
	
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public String next() {
		try {
			return br.readLine();			
		}catch(Exception e) {
			return "";
		}
	}
	
	public int nextInt() {
		try {
			return Integer.parseInt(br.readLine());
		}catch(Exception e) {
			return 0;			
		}
	}
<<<<<<< HEAD
}
=======
}
>>>>>>> e2e548867e277d01b32df32f4d68afd9db1e63d9
