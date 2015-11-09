package aufgabenblatt1;

public class ZahlPredicate {
	public static boolean test(ArrayListe<?> list){
		try{
			return list.get(0) instanceof Integer ? true : false;
		}
		catch (IndexOutOfBoundsException error){
			System.out.println("die Liste ist leer");
			return false;
		}
	}
}
