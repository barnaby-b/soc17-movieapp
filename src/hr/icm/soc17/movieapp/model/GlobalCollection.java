package hr.icm.soc17.movieapp.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class GlobalCollection {
	
	private static ObservableList<Movie> movies;
	
	static {
		movies = FXCollections.observableArrayList();
	}
	
	private GlobalCollection() {
		
	}
	
	
	public static ObservableList<Movie> getCollection() {
		return movies;
	}
	
}
