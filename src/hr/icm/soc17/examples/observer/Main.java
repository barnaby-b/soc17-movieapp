package hr.icm.soc17.examples.observer;

public class Main {
	
	public static void main(String[] args) {
		ObservableNumber o = new ObservableNumber(12);
		o.registerObserver(new DefaultObserver());
		o.registerObserver(new DefaultObserver());

		
		
		o.setA(18);
	}
}
