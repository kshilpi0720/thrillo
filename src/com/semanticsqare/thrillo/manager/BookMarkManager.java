package com.semanticsqare.thrillo.manager;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import com.semanticsqare.thrillo.IOUtil.HttpConnect;
import com.semanticsqare.thrillo.IOUtil.IOUtil;
import com.semanticsqare.thrillo.dao.BookMarkDao;
import com.semanticsqare.thrillo.entites.Book;
import com.semanticsqare.thrillo.entites.BookMark;
import com.semanticsqare.thrillo.entites.Movie;
import com.semanticsqare.thrillo.entites.User;
import com.semanticsqare.thrillo.entites.UserBookMark;
import com.semanticsqare.thrillo.entites.WebLink;

public class BookMarkManager {
	private static BookMarkManager instance=new BookMarkManager();
	private static BookMarkDao dao=new BookMarkDao();
	private BookMarkManager() {}
	
	public static BookMarkManager getInstance() {
		return instance;
		
	}
	public Movie createMovie( long id, String title, int releaseYear, String [] cast, String directors, String genre, double imdbRating)
	{
		Movie movie=new Movie();
		movie.setId(id);
		movie.setTitle(title);
		//movie.setProfileUrl(profileUrl);
		movie.setReleaseYear(releaseYear);
		movie.setCast(cast);
		movie.setDirectors(directors);
		movie.setGenre(genre);
		movie.setImdbRating(imdbRating);
		return movie;
	
	}

	public WebLink createWebLink(long id,String title, String Url,String host) {
		// TODO Auto-generated method stub
		WebLink weblink=new WebLink();
		weblink.setId(id);
		weblink.setTitle(title);
		weblink.setUrl(Url);
		weblink.setHost(host);
		
		return weblink;
	}
	public Book createBook(long id, String title, int publicationYear,String publiser,String genre, double amazonRating)
	{
		Book book=new Book();
		book.setId(id);
		book.setTitle(title);
		book.setPublicationYear(publicationYear);
		book.setPubliser(publiser);
		book.setGenre(genre);
		book.setAmazonRating(amazonRating);
		return book;
		
	}
	public BookMark[][] getBookMark()
	{
		return dao.getBookMark();
	}

	
		
		
		
		
		
	

	public void setkidFreindlystatus(User user, String kidFreindlystatus, BookMark bookmark) {
		bookmark.setKidFreindlystatus(kidFreindlystatus);
		bookmark.setKidFriendlyMark(user);
		System.out.println("kid freidly status"+" "+kidFreindlystatus+", Marked by"+user.getEmail()+bookmark);
		
	}

	public void share(User user, BookMark bookmarks) {
		bookmarks.setSharedBy(user);
		System.out.println("Data to be shared");
		if(bookmarks instanceof Book) {
			System.out.println(((Book)bookmarks).getItemdata());	
		}else if(bookmarks instanceof WebLink)
		{
			System.out.println(((WebLink)bookmarks).getItemdata());
		}
	}

	public void saveUserBookmark(User user, BookMark bookmark) {
		UserBookMark userBookmark = new UserBookMark();
		userBookmark.setUser(user);
		userBookmark.setBookmark(bookmark);
		
		
		if (bookmark instanceof WebLink) {
			try {				
				String url = ((WebLink)bookmark).getUrl();
				if (!url.endsWith(".pdf")) {
					String webpage = HttpConnect.download(((WebLink)bookmark).getUrl());
					if (webpage != null) {
						IOUtil.write(webpage, bookmark.getId());
					}
				}				
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		dao.saveUserBookmark(userBookmark);
	}

	
		
	}

	



	
	

