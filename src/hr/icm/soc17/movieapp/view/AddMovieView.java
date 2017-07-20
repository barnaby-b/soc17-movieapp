package hr.icm.soc17.movieapp.view;

import java.util.ArrayList;
import java.util.List;

import hr.icm.soc17.movieapp.model.GlobalCollection;
import hr.icm.soc17.movieapp.model.Movie;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AddMovieView {
	
	@FXML
	private TextField titleText;
	
	
	@FXML
	private TextArea descText;
	
	@FXML
	private TextArea castText;
	
	@FXML
	private 	ComboBox<Integer> yearCombo;
	
	public AddMovieView() {
		
	}
	
	public void initialize() {
		List<Integer> years = new ArrayList<Integer>();
		
		for (int i = 1920; i <= 2017; i++) {
			years.add(i);
		}		
		
		yearCombo.getItems().addAll(years);
		yearCombo.getSelectionModel().select(0);
	}
	
	@FXML
	private void addMovie(ActionEvent e) {
		if (titleText.getText().trim().isEmpty()) {
			return;
		}
		
		if (descText.getText().trim().isEmpty()) {
			return;
		}
		
		if (castText.getText().trim().isEmpty()) {
			return;
		}
		
		Movie m = new Movie(titleText.getText(), 4.9, yearCombo.getSelectionModel().getSelectedItem(), castText.getText(), descText.getText());
		GlobalCollection.getCollection().add(m);
		((MainView) ViewProvider.getViewByName("main")).removeSelected();
	}
	
	@FXML
	private void cancelAdding(ActionEvent e) {
		((MainView) ViewProvider.getViewByName("main")).removeSelected();
	}

}
