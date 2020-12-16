package com.semanticsqare.thrillo.entities;

import static org.junit.Assert.*;

import org.junit.Test;

import com.semanticsqare.thrillo.constant.BookGenre;
import com.semanticsqare.thrillo.constant.MovieGenre;
import com.semanticsqare.thrillo.entites.Book;
import com.semanticsqare.thrillo.entites.Movie;
import com.semanticsqare.thrillo.manager.BookMarkManager;

public class Booktest {

	@Test
	public void testIsKidfreidly() {
		Book book=BookMarkManager.getInstance().createBook( 4000,"Walden",1854,"Wilder Publication",BookGenre.PHILOSOPHY,4.3	);
		boolean isKidfreidly=book.isKidfreidly();
		assertFalse("for PHILOSOPHY in BookGenre=isKidfreidly() must return false", isKidfreidly);
		//test2
		book=BookMarkManager.getInstance().createBook( 4000,"Walden",1854,"Wilder Publication",BookGenre.SELF_HELP,4.3	);
		 isKidfreidly=book.isKidfreidly();
		assertFalse("for SELF_HELP in BookGenre=isKidfreidly() must return false", isKidfreidly);
	
	}

}
