package com.semanticsqare.thrillo.entites;
import com.semanticsqare.thrillo.constant.*;

public abstract class BookMark {
	private long id;
	private String title;
	private String profileUrl;
	private String kidFreindlystatus=KidFreindlystatus.UNKNOWN;
	private User kidFriendlyMark;
	private User sharedBy;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getProfileUrl() {
		return profileUrl;
	}
	public void setProfileUrl(String profileUrl) {
		this.profileUrl = profileUrl;
	}
	 
	public abstract boolean isKidfreidly();
	public String getKidFreindlystatus() {
		return kidFreindlystatus;
	}
	public String setKidFreindlystatus(String kidFreindlystatus) {
		
		return kidFreindlystatus;
	}
	public User getKidFriendlyMark() {
		return kidFriendlyMark;
	}
	public void setKidFriendlyMark(User kidFriendlyMark) {
		this.kidFriendlyMark = kidFriendlyMark;
	}
	public User getSharedBy() {
		return sharedBy;
	}
	public void setSharedBy(User sharedBy) {
		this.sharedBy = sharedBy;
	}
	
	

}
