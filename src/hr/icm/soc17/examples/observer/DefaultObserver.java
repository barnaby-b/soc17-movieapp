package hr.icm.soc17.examples.observer;

public class DefaultObserver implements NumberObserver{

	@Override
	public void numberChanged(int b) {
		System.out.println("Broj promijenjen na " + b);
	}

}
