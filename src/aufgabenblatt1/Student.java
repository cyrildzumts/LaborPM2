package aufgabenblatt1;

import java.util.ArrayList;
<<<<<<< HEAD
=======
import java.util.Comparator;
>>>>>>> 0552985649d89be8da5a1c08e3ec050cb393e51d
import java.util.List;


/**
 * 
<<<<<<< HEAD
 * @author Theophile Teyou Soh
 * HAW HAMBURG
 * TI PM2
 * WS 2015
 * 
=======
>>>>>>> 0552985649d89be8da5a1c08e3ec050cb393e51d
 * @author Cyrille Ngassam Nkwenga
 * HAW HAMBURG
 * TI PM2
 * WS 2015
 * 
 *
 */
public class Student implements Comparable<Student>{

	
	private String vorname;
	private String nachname;
	private int matrikelNummer;
	private List<Pruefungsleistung> leistungen;
	
	public Student(String vorname, String nachname, int matrikelNummer){
		this.vorname = vorname;
		this.nachname = nachname;
		this.matrikelNummer = matrikelNummer;
		leistungen = new ArrayList<Pruefungsleistung>();
		
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public int getMatrikelNummer() {
		return matrikelNummer;
	}

	public void setMatrikelNummer(int matrikelNummer) {
		this.matrikelNummer = matrikelNummer;
	}

	public List<Pruefungsleistung> getLeistungen() {
		return leistungen;
	}

	public void setLeistungen(List<Pruefungsleistung> leistungen) {
		this.leistungen = leistungen;
	}

	@Override
	public int compareTo(Student student) {
		if(student != null){
			if( matrikelNummer < student.getMatrikelNummer()){
				return -1;
			}
			if( matrikelNummer == student.getMatrikelNummer()){
				return 0;
			}
			if( matrikelNummer > student.getMatrikelNummer()){
				return 1;
			}
		}
		return -1;
	}

	
	
	
}
