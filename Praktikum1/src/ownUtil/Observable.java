package ownUtil;

public interface Observable {

	void addObserver(Observer obs);
	void removeobersver(Observer obs);
	void notifyObservers();
}
