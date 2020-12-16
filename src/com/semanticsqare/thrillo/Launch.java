package com.semanticsqare.thrillo;

import com.semanticsqare.thrillo.entites.BookMark;
import com.semanticsqare.thrillo.entites.User;
import com.semanticsqare.thrillo.manager.BookMarkManager;
import com.semanticsqare.thrillo.manager.UserManager;

public class Launch {
	private static User[] users;
	private static BookMark[][] bookmarks;
	private static void loadData() {
		System.out.println("data is loading");
		DataStore.loadData();
		users=UserManager.getInstance().getUsers();
		bookmarks=BookMarkManager.getInstance().getBookMark();
	//	System.out.println("printing data");
		//printUserData();
		//printBookMarkData();
		
	}

	

	private static void printUserData() {
		for (User user:users)
		{
			System.out.println(user);
		}
		
	}
	private static void printBookMarkData() {
		for(BookMark[] bookmarkList:bookmarks)
			for (BookMark bookmark : bookmarkList) {
				System.out.println(bookmark);
			}
			   
		
			
		
	}
	private static void start() {
		
		//System.out.println("Bookmarking....");
		for(User user:users)
		{
			view.browse(user,bookmarks);
		}
	}

	public static void main(String[] args) {
		loadData();
		start();
	}



	

	

}
