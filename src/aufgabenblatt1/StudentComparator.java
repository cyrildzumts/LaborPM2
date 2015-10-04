package aufgabenblatt1;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {

	@Override
	public int compare(Student student1, Student student2) {
		String name1 = student1.getNachname() + student1.getVorname();
		String name2 = student2.getNachname() + student2.getVorname();
		return name1.compareTo(name2);
	}

}
