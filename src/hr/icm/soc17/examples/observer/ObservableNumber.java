package hr.icm.soc17.examples.observer;

import java.util.ArrayList;
import java.util.List;

public class ObservableNumber {
	private int a;
	
	private List<NumberObserver> observers;
	
	
	public ObservableNumber(int a) {
		
		observers = new ArrayList<NumberObserver>();
		this.a = a;
	}



	public int getA() {
		return a;
	}


	public void setA(int a) {
		for (NumberObserver o : observers) {
			o.numberChanged(a);
		}
		this.a = a;
	}
	
	public void registerObserver(NumberObserver o) {
		observers.add(o);
	}
	
}
