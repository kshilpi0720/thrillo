package com.semanticsqare.thrillo.entities;

import static org.junit.Assert.*;

import org.junit.Test;

import com.semanticsqare.thrillo.entites.WebLink;
import com.semanticsqare.thrillo.manager.BookMarkManager;

public class WebLinktest {

	@Test
	public void testIsKidfreidly() {
		//test1:porn in url------false
		WebLink weblink=BookMarkManager.getInstance().createWebLink(2000,"Taming Tiger","http://www.javaworld.com/article/2072759/core-java/taming-porn--part-2.html","http://www.javaworld.com");
		boolean isKidfreidly= weblink.isKidfreidly();
		assertFalse("for porn in Url=isKidfreidly() must return false", isKidfreidly);
		//test2:porn in title------false
		weblink=BookMarkManager.getInstance().createWebLink(2000,"Taming porn","http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html","http://www.javaworld.com");
		 isKidfreidly= weblink.isKidfreidly();
		assertFalse("for porn in title=isKidfreidly() must return false", isKidfreidly);
		//test3:adult in host------false
		weblink=BookMarkManager.getInstance().createWebLink(2000,"Taming tiger","http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html","http://www.adult.com");
		 isKidfreidly= weblink.isKidfreidly();
		assertFalse("for adult in host=isKidfreidly() must return false", isKidfreidly);
		//test4:adult in url but not in host part-----true
		weblink=BookMarkManager.getInstance().createWebLink(2000,"Taming Tiger","http://www.javaworld.com/article/2072759/core-java/taming-adult--part-2.html","http://www.javaworld.com");
		 isKidfreidly= weblink.isKidfreidly();
		assertTrue("for adult in url not in host part=isKidfreidly() must return true", isKidfreidly);
		//test5:adult in title only------true
		weblink=BookMarkManager.getInstance().createWebLink(2000,"Taming adult","http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html","http://www.javaworld.com");
		 isKidfreidly= weblink.isKidfreidly();
		assertTrue("for adult in title=isKidfreidly() must return true", isKidfreidly);
	}

}
