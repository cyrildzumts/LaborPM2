package aufgabenblatt2;

import aufgabenblatt2.Rechner.Operation;

public class RechnerDemo {

	public static void main(String[] args) {
		
		Rechner rechner = new Rechner();
		System.out.println("Rechner Class Demo with BinaryOperator");
		
		System.out.println(rechner.berechne(Operation.ADD, 2.0, 5.0));
		System.out.println(rechner.berechne(Operation.SUB, 2.0, 5.0));
		System.out.println(rechner.berechne(Operation.MUL, 2.0, 5.0));
		System.out.println(rechner.berechne(Operation.DIV, 2.0, 5.0));
		
	
		System.out.println("Rechner Demo with our Own Interface");
		DoubleDoubleZuDouble demo ;
		demo = (double op1, double op2)->{
			System.out.println(" Lamda ADD");
			return (op1 + op2);
		};
		System.out.println(demo.werteAus(2.0, 5.0));
		
		demo = (double op1, double op2)->{
			System.out.println(" Lamda SUB");
			return (op1 - op2);
		};
		System.out.println(demo.werteAus(2.0, 5.0));
		
		demo = (double op1, double op2)->{
			System.out.println(" Lamda MUL");
			return (op1 * op2);
		};
		System.out.println(demo.werteAus(2.0, 5.0));
		
		demo = (double op1, double op2)->{
			System.out.println(" Lamda DIV");
			return (op1 / op2);
		};
		System.out.println(demo.werteAus(2.0, 5.0));
		
		demo =  (double op1, double op2) ->{
			System.out.println("Lamda Equation : y = ax+b\na = op1\nb = op2");
			if(!(Double.compare(op1, 0.0) == 0 ))
				return (-op2 / op1);
			return -1.0;
		};
		System.out.println(demo.werteAus(2.0, 5.0));
		
		

	}

}
