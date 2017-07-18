package com.cross.util;

import com.cross.model.User;

public class Validation {
	//create temp password
	public static String getTempPwd(int len){
		
		char tmp[] = new char[62];
		for(int k=0 ; k<26 ; k++){
			tmp[k] = (char)(int)(65+k);
		}
		for(int k=0 ; k<26; k++){
			tmp[k+26] = (char)(int)(97+k);
		}
		for(int k=0; k<10 ; k++){
			tmp[k+52] = (char)(int)(48+k);
		}
		int idx = 0;
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<len; i++){
			idx = (int)(tmp.length*Math.random());
			sb.append(tmp[idx]);
		}
		return sb.toString();
	}
	
	//login checking
	public static boolean loginChk(User user, String inputPwd){
		if(user.getUser_pwd().equals(inputPwd)){
			return true; //success
		}else{
			return false;
		}
	}
	
}
