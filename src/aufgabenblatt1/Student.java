package aufgabenblatt1;

import java.util.ArrayList;
import java.util.List;


/**
 * 
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
	private List<ExamPerformances> leistungen;
	
	public Student(String vorname, String nachname, int matrikelNummer){
		this.vorname = vorname;
		this.nachname = nachname;
		this.matrikelNummer = matrikelNummer;
		leistungen = new ArrayList<ExamPerformances>();
		
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

	public List<ExamPerformances> getLeistungen() {
		return leistungen;
	}

	public void setLeistungen(List<ExamPerformances> leistungen) {
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
