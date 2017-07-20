package hr.icm.soc17.movieapp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

import hr.icm.soc17.movieapp.model.GlobalCollection;
import hr.icm.soc17.movieapp.model.Movie;
import javafx.application.Application;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MovieApplication extends Application {
	
	private static BorderPane startScreenContent;
	
	public static void main(String[] args) {
		GlobalCollection.getCollection().addListener(new FileWriter());
		GlobalCollection.getCollection().addListener(new ListChangeListener<Movie>() {
			@Override
			public void onChanged(Change<? extends Movie> c) {
				System.out.println("List changed!");
			}
		});
		initalizeMovieCollection();
		
		launch(args);
		
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane master = FXMLLoader.load(getClass().getResource("view/main-view.fxml"));
		
		Scene mainScene = new Scene(master, 800, 600);
		primaryStage.setScene(mainScene);
		primaryStage.setTitle("ICM MovieApp 2017");
		primaryStage.show();
		
	}
	
	public static BorderPane getStartScreenContent() throws IOException {
		if (startScreenContent != null) {
			return startScreenContent;
		}
		
		startScreenContent = FXMLLoader.load(MovieApplication.class.getResource("view/movie-table.fxml"));
		return startScreenContent;
	}
	
	public static void initalizeMovieCollection() {
		Movie shawsank = new Movie("The Shawshank Redemption", 9.3, 1994, "Morgan Freeman, Tim Robbins, Bob Gunton", 
				"Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.");

		
		Movie godfather = new Movie("The Godfather", 9.2, 1972, "Marlon Brando, Al Pacino, James Caan",
				"The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.");
		
		Movie godfather2 = new Movie("The Godfather II", 9.0, 1974, "Al Pacino, Robert De Niro, Robert Duvall",
				"The early life and career of Vito Corleone in 1920s New York is portrayed while his son, "
				+ "Michael, expands and tightens his grip on the family crime syndicate.");
		
		Movie darkKnight = new Movie("The Dark Knight", 9.0, 2008, "Christian Bale, Heath Ledger, Aaron Eckhart",
				"When the menace known as the Joker emerges from his mysterious past, he wreaks havoc and chaos on the people of Gotham, "
				+ "the Dark Knight must accept one of the greatest psychological and physical tests of his ability to fight injustice.");	
		
		try {
			FileInputStream fileIn = new FileInputStream("movie-list.txt");
			ObjectInputStream objIn = new ObjectInputStream(fileIn);
			
			@SuppressWarnings("unchecked")
			List<Movie> list = (List<Movie>) objIn.readObject();
			
			list.forEach(m -> GlobalCollection.getCollection().add(m));
			
			objIn.close();
			fileIn.close();
			
		} catch (FileNotFoundException e) {
			GlobalCollection.getCollection().add(darkKnight);
			GlobalCollection.getCollection().add(godfather);
			GlobalCollection.getCollection().add(shawsank);
			GlobalCollection.getCollection().add(godfather2);	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
