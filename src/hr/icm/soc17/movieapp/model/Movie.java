package hr.icm.soc17.movieapp.model;

import java.io.Serializable;


public class Movie implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	
	
	private String title;
	private double rating;
	private int year;
	private String cast;
	private String desc;
	
	public Movie(String title, double rating, int year, String cast, String desc) {
		
		if (cast == null) {
			throw new RuntimeException("Cast was null.");
		}
		
		if (title == null) {
			throw new RuntimeException("Title was null.");
		}
		
		if (desc == null) {
			throw new RuntimeException("Description was null.");
		}
		
		
		this.title = title;
		this.rating = rating;
		this.year = year;
		this.cast = cast;
		this.desc = desc;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		if (title == null) {
			throw new RuntimeException("Title was null.");
		}
		
		this.title = title;
		
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {		
		this.rating = rating;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getCast() {
		return this.cast;
	}


	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		if (desc == null) {
			throw new RuntimeException("Description was null.");
		}
		
		this.desc = desc;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cast == null) ? 0 : cast.hashCode());
		result = prime * result + ((desc == null) ? 0 : desc.hashCode());
		long temp;
		temp = Double.doubleToLongBits(rating);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + year;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		if (cast == null) {
			if (other.cast != null)
				return false;
		} else if (!cast.equals(other.cast))
			return false;
		if (desc == null) {
			if (other.desc != null)
				return false;
		} else if (!desc.equals(other.desc))
			return false;
		if (Double.doubleToLongBits(rating) != Double.doubleToLongBits(other.rating))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (year != other.year)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Movie [title=" + title + ", rating=" + rating + ", year=" + year + ", cast=" + cast + ", desc=" + desc
				+ "]";
	}
	
	
}