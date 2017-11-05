package com.cross.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test {
	public Map<String, Object> returnedUrl(){
		Map<String, Object> returnCode = new HashMap<String, Object>();
		
		try {
			Process process = Runtime.getRuntime().exec("whoami"); 
			BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
			Scanner scanner = new Scanner(br); 
			scanner.useDelimiter(System.getProperty("line.separator"));
			
			//while(scanner.hasNext())
				returnCode.put("who", scanner.next());
				System.out.println(scanner.next()); 
				scanner.close(); br.close(); 
		
				if(process.exitValue() == 0){
					Thread.sleep(1000);
					System.out.println("정상적으로 프로세스 실행 종료");
					//유투브 업로드 메소드 구현
					returnCode.put("code", 0);
					
				}else{
					returnCode.put("code", 1);
					returnCode.put("who", "x");
				}
		
		} catch(Exception e) { 
			e.printStackTrace(); 
		}	
		
	return returnCode;
	}
	
}
