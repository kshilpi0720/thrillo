package com.semanticsqare.thrillo.dao;

import com.semanticsqare.thrillo.DataStore;
import com.semanticsqare.thrillo.entites.BookMark;
import com.semanticsqare.thrillo.entites.UserBookMark;

public class BookMarkDao {
	public BookMark[][] getBookMark(){
		return DataStore.getBookMark();
		
	}

	public void saveUserBookmark(UserBookMark userbookmark) {
		DataStore.add(userbookmark);
		
	}

}
