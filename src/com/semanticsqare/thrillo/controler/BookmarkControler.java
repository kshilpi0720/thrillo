package com.semanticsqare.thrillo.controler;

import com.semanticsqare.thrillo.entites.BookMark;
import com.semanticsqare.thrillo.entites.User;
import com.semanticsqare.thrillo.entites.UserBookMark;
import com.semanticsqare.thrillo.manager.BookMarkManager;

public class BookmarkControler {
	private static BookmarkControler instace=new BookmarkControler();
	private BookmarkControler() {};
	public static BookmarkControler getInstance() {
		return instace;
		
	}
	
	public void setkidFreindlystatus(User user, String kidFreindlystatus, BookMark bookmark) {
		BookMarkManager.getInstance().setkidFreindlystatus(user,kidFreindlystatus,bookmark);

		
		
	}
	public void share(User user, BookMark bookmarks) {
		BookMarkManager.getInstance().share(user,bookmarks);
		
	}
	public void saveUserBookmark(User user, BookMark bookmark) {
		BookMarkManager.getInstance().saveUserBookmark(user,bookmark);
		
	}
	
	
	

}
