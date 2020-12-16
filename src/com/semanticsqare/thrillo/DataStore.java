package com.semanticsqare.thrillo;

import com.semanticsqare.thrillo.IOUtil.IOUtil;
import com.semanticsqare.thrillo.constant.Gender;
import com.semanticsqare.thrillo.constant.UserType;
import com.semanticsqare.thrillo.entites.BookMark;
import com.semanticsqare.thrillo.entites.User;
import com.semanticsqare.thrillo.entites.UserBookMark;
import com.semanticsqare.thrillo.manager.BookMarkManager;
import com.semanticsqare.thrillo.manager.UserManager;

public class DataStore {
public static final int USER_BOOKMARK_LIMIT = 5;
public static final int TOTAL_USER_COUNT = 5;
public static final int BOOKMARK_COUNT_PER_TYPE = 5;
public static final int BOOKMARK_TYPE_COUNT = 3;

private static User[] user=new User[TOTAL_USER_COUNT];
private static BookMark[][] bookmark=new BookMark[BOOKMARK_TYPE_COUNT][BOOKMARK_COUNT_PER_TYPE];
private static UserBookMark[] userbookmarks=new UserBookMark[TOTAL_USER_COUNT*USER_BOOKMARK_LIMIT];
public static User[] getUser() {
	return user;
}





public static BookMark[][] getBookmark() {
	return bookmark;
}




public static UserBookMark[] getUserbookmark() {
	return userbookmarks;
}
private static int bookmarkindex; 



public static void loadData(){
	loadUsers();
	loadWeblinks();
	loadMovie();
	LoadBook();
}

private static void loadUsers() {
	String[] data = new String[TOTAL_USER_COUNT];
	IOUtil.read(data, "Usser");
	int rowNum = 0;
	for (String row : data) {
		String[] values = row.split("\t");
		
		int gender = Gender.Male;
		if (values[5].equals("f")) {
			gender = Gender.Female;
		} else if (values[5].equals("t")) {
			gender = Gender.TransGender;
		}
			
		user[rowNum++] = UserManager.getInstance().createUser(Long.parseLong(values[0]), values[1], values[2], values[3], values[4], gender, values[6]);
	//  System.out.println("user");
	}
}

private static void loadWeblinks() {
	String[] data = new String[BOOKMARK_COUNT_PER_TYPE];
	IOUtil.read(data, "Web-Link");
	int colNum = 0;
	for (String row : data) {
		String[] values = row.split("\t");
		
		bookmark[0][colNum++] = BookMarkManager.getInstance().createWebLink(Long.parseLong(values[0]), values[1], values[2], values[3]/*, values[4]*/);
		// System.out.println("weblink");
	}
}

private static void loadMovie() {
	String[] data = new String[BOOKMARK_COUNT_PER_TYPE];
	IOUtil.read(data, "Movie");
	int colNum = 0;
	for (String row : data) {
		String[] values = row.split("\t");
		String[] cast = values[3].split(",");
		//String[] directors = values[4].split(",");
		bookmark[1][colNum++] = BookMarkManager.getInstance().createMovie(Long.parseLong(values[0]),values[1], Integer.parseInt(values[2]), cast, "", values[4], Double.parseDouble(values[6])/*, values[7]*/);
	
		// System.out.println("movie");
		}
}

private static void LoadBook() {		    	
	String[] data = new String[BOOKMARK_COUNT_PER_TYPE];
	IOUtil.read(data, "Book");
	int colNum = 0;
	for (String row : data) {
		String[] values = row.split("\t");
		//String[] authors = values[4].split(",");
		bookmark[2][colNum++] = BookMarkManager.getInstance().createBook(Long.parseLong(values[0]), "", Integer.parseInt(values[2]), values[3],  values[4], Double.parseDouble(values[5])/*, values[7]*/);
		// System.out.println("books");
		}
}	
/*
Long.parseLong(values[0]), values[1], "", Integer.parseInt(values[2]), cast, directors, values[5], Double.parseDouble(values[6])

private static void loadMovie() {
	bookmark[1][0]=BookMarkManager.getInstance().createMovie(3000,"Citizen Kane",1941,new String[]{"Orson Welles","Joseph Cotten"},"Orson Welles","Classics",8.5);
    bookmark[1][1]=BookMarkManager.getInstance().createMovie(3001,"The Grapes of Wrath",1940,new String[]{"Henry Fonda","Jane Darwell"},"John Ford","Classics",8.5);
    bookmark[1][2]=BookMarkManager.getInstance().createMovie(3002,"A Touch of Greatness",2004,new String[] {"Albert Cullum"},"eslie Sullivan","	Documentaries",7.3	);
    bookmark[1][3]=BookMarkManager.getInstance().createMovie(3003,"The Big Bang Theory",2007,new String[] {"Kaley Cuoco","Jim Parsons"},"Chuck Lorre","TV Shows",8.7);
    bookmark[1][4]=BookMarkManager.getInstance().createMovie(3004,"Ikiru",1952,new String[] { "Takashi Shimura","Minoru Chiaki"},"Akira Kurosawa","Foreign Movies",8.4);
    		
}


private static void loadWeblinks() {
	bookmark[0][0]=BookMarkManager.getInstance().createWebLink(2000,"Taming Tiger","http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html","http://www.javaworld.com");
    bookmark[0][1]=BookMarkManager.getInstance().createWebLink(2001,"How do I import a pre-existing Java project into Eclipse and get up and running?","http://stackoverflow.com/questions/142863/how-do-i-import-a-pre-existing-java-project-into-eclipse-and-get-up-and-running","http://www.stackoverflow.com");	
     bookmark[0][2]=BookMarkManager.getInstance().createWebLink(2002,"Interface vs Abstract Class","http://mindprod.com/jgloss/interfacevsabstract.html","http://mindprod.com");
    bookmark[0][3]=BookMarkManager.getInstance().createWebLink(2003,"NIO tutorial by Greg Travis","http://cs.brown.edu/courses/cs161/papers/j-nio-ltr.pdf","http://cs.brown.edu	unknown");
    bookmark[0][4]=BookMarkManager.getInstance().createWebLink(2004,"Virtual Hosting and Tomcat","http://tomcat.apache.org/tomcat-6.0-doc/virtual-hosting-howto.html","http://tomcat.apache.org");	
}


private static void loadUsers() {
	user[0]= UserManager.getInstance().createUser(1000,"user0@semanticsquare.com","test","John","M",Gender.Male,UserType.User);
	user[1]= UserManager.getInstance().createUser(1001,"user1@semanticsquare.com","test","Sam","M",Gender.Male,UserType.User);	
	user[2]= UserManager.getInstance().createUser(1002,"user2@semanticsquare.com","test","Anita","M",Gender.Male,UserType.Editor);
	user[3]= UserManager.getInstance().createUser(1003,"user3@semanticsquare.com","test","Sara","M",Gender.Female,UserType.Editor);
	user[4]= UserManager.getInstance().createUser(1004,"user4@semanticsquare.com","test","Dheeru","M",Gender.Male,UserType.Chif_Editor);
	
}*/


public static User[] getUsers() {
	// TODO Auto-generated method stub
	loadUsers();
	return user;
}


public static BookMark[][] getBookMark() {
	// TODO Auto-generated method stub
	LoadBook();
	loadMovie();
	loadWeblinks();
	
	return bookmark;
}


public static void add(UserBookMark userbookmark) {
	userbookmarks[bookmarkindex]=userbookmark;
	
	bookmarkindex++;
}





}
