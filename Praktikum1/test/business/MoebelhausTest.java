package business;

import static org.junit.jupiter.api.Assertions.*;

import java.util.function.BooleanSupplier;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MoebelhausTest {

	private Moebelhaus moebelhaus;
	@Test
	void test() {
		BooleanSupplier booleanSupplier = () -> moebelhaus.getName().equals("Küchenstuhl");

		moebelhaus=new Moebelhaus("Küchenstuhl", "Küche","funktional" , "99", new String[]{"kunststoff","Metal"});
		assertTrue(booleanSupplier);
	}
	
	@Test
	void test2() {
				assertThrows(IllegalArgumentException.class, ()->{
				moebelhaus=new Moebelhaus("Küchenstuhl", "Küche","funktional" , "99", null);
			});
	}
}
