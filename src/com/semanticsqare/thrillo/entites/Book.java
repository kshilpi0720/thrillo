package com.semanticsqare.thrillo.entites;

import org.apache.commons.lang3.StringUtils;

import com.semanticsqare.thrillo.constant.BookGenre;
import com.semanticsqare.thrillo.constant.MovieGenre;
import com.semanticsqare.thrillo.partner.Shareable;

public class Book extends BookMark implements Shareable {
	
	private String publiser;
	private int publicationYear;
	private String author;
	private String genre;
	private double amazonRating;
	public int getPublicationYear() {
		return publicationYear;
	}
	
	public String getPubliser() {
		return publiser;
	}
	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
	}
	public void setPubliser(String publiser) {
		this.publiser = publiser;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public double getAmazonRating() {
		return amazonRating;
	}
	public void setAmazonRating(double amazonRating) {
		this.amazonRating = amazonRating;
	}
	@Override
	public String toString() {
		return "Book [publicationYear=" + publicationYear + ", publiser=" + publiser + ", author=" + author + ", genre="
				+ genre + ", amazonRating=" + amazonRating + "]";
	}
	@Override
	public boolean isKidfreidly() {
		if(genre.equals(BookGenre.PHILOSOPHY)||genre.equals(BookGenre.SELF_HELP))
			return false;
		
		return true;
	}
	@Override
	public String getItemdata() {
		StringBuilder builder= new StringBuilder();
		builder.append("<item>");
		builder.append("<type>book</type>");
		builder.append("<title>").append(getTitle()).append("</title>");
		builder.append("<author>").append(StringUtils.join(author,",")).append("</author>");
		builder.append("<publiser>").append(publiser).append("</publiser>");
		builder.append("<publicationYear>").append(publicationYear).append("</publicationYear>");
		
		builder.append("<genre>").append(genre).append("</genre>");
		builder.append("<amazonRating>").append(amazonRating).append("</amazonRating>");

		builder.append("</item>");
		return builder.toString();
	}

}
