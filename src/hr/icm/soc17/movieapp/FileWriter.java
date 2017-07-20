package hr.icm.soc17.movieapp;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.stream.Collectors;

import hr.icm.soc17.movieapp.model.GlobalCollection;
import hr.icm.soc17.movieapp.model.Movie;
import javafx.collections.ListChangeListener;

public class FileWriter implements ListChangeListener<Movie> {

	@Override
	public void onChanged(Change<? extends Movie> c) {
		List<Movie> nonobservable = 
				GlobalCollection.getCollection().stream().collect(Collectors.toList());
		
		try {
			FileOutputStream fileOut = new FileOutputStream("movie-list.txt");
			ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
			objOut.writeObject(nonobservable);
			objOut.close();
			fileOut.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
