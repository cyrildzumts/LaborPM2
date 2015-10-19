package aufgabenblatt1;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArrayListeTest {

	ArrayListe<Integer> list = new ArrayListe<Integer>();
	@Test
	public void testHinzufuegenT() {
		list.hinzufuegen(new Integer(9));
		list.hinzufuegen(new Integer(1));
		assertEquals(2, list.getAnzahlEmente());
	}

	@Test
	public void testEntfernen() {
		Integer myInt = new Integer(6);
		list.hinzufuegen(new Integer(9));
		list.hinzufuegen(new Integer(1));
		list.hinzufuegen(myInt);
		assertEquals(3, list.getAnzahlEmente());
		list.entfernen(myInt);
		assertEquals(2, list.getAnzahlEmente());

		
	}

	@Test
	public void testEntfernenElementAtIndex() {
		Integer myInt = new Integer(6);
		list.hinzufuegen(new Integer(9));
		list.hinzufuegen(new Integer(1));
		list.hinzufuegen(myInt);
		assertEquals(3, list.getAnzahlEmente());
		list.entfernenElementAtIndex(2);
		assertEquals(2, list.getAnzahlEmente());
		Integer intTest = list.get(1);
		assertEquals(1, intTest.intValue());
	}

	@Test
	public void testGet() {
		list.hinzufuegen(new Integer(9));
		list.hinzufuegen(new Integer(1));
		assertEquals(1, list.get(1).intValue());
		assertEquals(9, list.get(0).intValue());
	}

	@Test
	public void testGetAnzahlEmente() {
		for(int i = 0; i < 30; i++){
			list.hinzufuegen(new Integer(i));
		}
		assertEquals(30, list.getAnzahlEmente());
	}

	@Test
	public void testGetKleinstesElement() {
		list.hinzufuegen(new Integer(9));
		list.hinzufuegen(new Integer(1));
		list.hinzufuegen(new Integer(-1));
		assertEquals(-1, list.getKleinstesElement().intValue());
	}

	@Test
	public void testSumme() {
		for(int i = 1; i <= 10; i++){
			list.hinzufuegen(new Integer(i));
		}
		assertEquals(55, ArrayListe.summe(list));
		System.out.println(list);
	}

}
