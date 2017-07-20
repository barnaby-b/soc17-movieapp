package hr.icm.soc17.movieapp.view;

import java.io.IOException;

import hr.icm.soc17.movieapp.MovieApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class MainView {
	
	@FXML
	private TabPane tabs;
	
	public MainView() {
		ViewProvider.registerView("main", this);
	}
	
	public void initialize() throws IOException {
		Tab startScreenTab = new Tab("Start Screen");
		tabs.getTabs().add(startScreenTab);
		startScreenTab.setContent(MovieApplication.getStartScreenContent());
	}
	
	public void spawnTab(Tab t, boolean selectOnSpawn) {
		tabs.getTabs().add(t);
		
		if (selectOnSpawn)
			tabs.getSelectionModel().select(t);
	}
	
	public void removeTab(Tab t) {
		tabs.getTabs().remove(t);
	}
	
	public void removeSelected() {
		tabs.getTabs().remove(tabs.getSelectionModel().getSelectedItem());
	}
}
