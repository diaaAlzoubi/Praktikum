package reader;

public class ConcreteReaderCreator extends ReaderCreator {

	@Override
	public ReaderProduct factoryMethod(String typ) {
		// TODO Auto-generated method stub
		if ("csv".equals(typ)) {
			return new ConcreteCsvReaderProduct();
		}
		else {
			return new ConcreteTxtReaderProduct();
		}
		
	}

}
