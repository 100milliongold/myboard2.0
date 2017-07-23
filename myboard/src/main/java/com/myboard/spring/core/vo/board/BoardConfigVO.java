package com.myboard.spring.core.vo.board;

public class BoardConfigVO {
	
	private int num;
	private String boardTable;
	private String title;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBoardTable() {
		return boardTable;
	}
	public void setBoardTable(String boardTable) {
		this.boardTable = boardTable;
	}
}
