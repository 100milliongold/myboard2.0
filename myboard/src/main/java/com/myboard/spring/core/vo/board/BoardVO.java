package com.myboard.spring.core.vo.board;

public class BoardVO {

	private int bNo;
	private String bSubject;
	private String bContent;
	private int  bViews;
	private String bRegistdate;
	private String mId; // 로그인한 회원정보
	
	public int getbNo() {
		return bNo;
	}
	public void setbNo(int bNo) {
		this.bNo = bNo;
	}
	public String getbSubject() {
		return bSubject;
	}
	public void setbSubject(String bSubject) {
		this.bSubject = bSubject;
	}
	public String getbContent() {
		return bContent;
	}
	public void setbContent(String bContent) {
		this.bContent = bContent;
	}
	public int getbViews() {
		return bViews;
	}
	public void setbViews(int bViews) {
		this.bViews = bViews;
	}
	public String getbRegistdate() {
		return bRegistdate;
	}
	public void setbRegistdate(String bRegistdate) {
		this.bRegistdate = bRegistdate;
	}
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
}
