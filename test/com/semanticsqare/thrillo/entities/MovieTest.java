package com.semanticsqare.thrillo.entities;

import static org.junit.Assert.*;

import org.junit.Test;

import com.semanticsqare.thrillo.constant.MovieGenre;
import com.semanticsqare.thrillo.entites.Movie;
import com.semanticsqare.thrillo.manager.BookMarkManager;

public class MovieTest {

	@Test
	public void testIsKidfreidly() {
		Movie movie=BookMarkManager.getInstance().createMovie(3000,"Citizen Kane",1941,new String[]{"Orson Welles","Joseph Cotten"},"Orson Welles",MovieGenre.HORROR,8.5);
		boolean isKidfreidly=movie.isKidfreidly();
		assertFalse("for horror in MovieGenre=isKidfreidly() must return false", isKidfreidly);
		//test2
		movie=BookMarkManager.getInstance().createMovie(3000,"Citizen Kane",1941,new String[]{"Orson Welles","Joseph Cotten"},"Orson Welles",MovieGenre.THRILLERS,8.5);
		 isKidfreidly=movie.isKidfreidly();
		assertFalse("for thrillers in MovieGenre=isKidfreidly() must return false", isKidfreidly);
	}

}
