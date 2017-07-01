package com.cross.free;

public class Board {
	public int no;
	public String subject;
	public String content;
	public String regdate;
	public String file;
	
	public Board(){
		
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public Board(int no, String subject, String content, String regdate, String file) {
		super();
		this.no = no;
		this.subject = subject;
		this.content = content;
		this.regdate = regdate;
		this.file = file;
	}
	
	
	
}
