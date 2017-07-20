package hr.icm.soc17.movieapp.view;

import java.util.HashMap;
import java.util.Map;

public class ViewProvider {
	private static Map<String, Object> views;
	
	static {
		views = new HashMap<String, Object>();
	}
	
	public static void registerView(String name, Object view) {
		views.put(name, view);
	}
	
	public static Object getViewByName(String name) {
		return views.get(name);
	}
}
