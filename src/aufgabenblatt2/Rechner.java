package aufgabenblatt2;

/**
 * @author Cyrille Ngassam Nkwenga
 * 
 * 
 * HAW HAMBURG
 * WS 2015
 * Programming Methodic 2
 * Prof : Herr Phillip Jenke
 * TI B2
 * 
 * Description : Rechner allows us to apply basics arithmics such as :
 * Addition, Substraction, Multiply and Division.
 * The operation is coded with a key so that Rechner always knows what 
 * operation we want it to compute.
 * 
 * In this Class we use the BinaryOperator<T> Functional Interface to implement
 * all the Operation we want to offer.
 *  
 */
import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;

public class Rechner {
	
	/**
	 * Operation represent the code used to encode the Operation 
	 */
	public enum Operation{
		ADD, SUB, MUL, DIV;
	};
	/**
	 * rechnerMap olds the relation between the code of the operation and
	 * the implemented Interface to be used.
	 */
	private Map<Operation, BinaryOperator<Double>> rechnerMap;
//	
//	private BinaryOperator<Double> addInterface = (Double op1, Double op2) ->{
//		System.out.println("ADD");
//		return (op1 + op2);
//	};
//	private BinaryOperator<Double> subInterface = (Double op1, Double op2) ->{
//		System.out.println("SUB");
//		return (op1 - op2);
//	};
//	private BinaryOperator<Double> mulInterface = (Double op1, Double op2) ->{
//		System.out.println("MUL");
//		return (op1 * op2);
//	};
//	private BinaryOperator<Double> divInterface = (Double op1, Double op2) ->{
//		System.out.println("DIV");
//		if(!(Double.compare(op2, 0.0) == 0 ))
//			return (op1 / op2);
//		return -1.0;
//	};
	
	/**
	 * With help from Lamdas we map the relation between the operation key 
	 * and the code to be run.
	 */
	public Rechner(){
		rechnerMap = new HashMap<Operation, BinaryOperator<Double>>();
		
		rechnerMap.put(Operation.ADD, (Double op1, Double op2)->{
			System.out.println("ADD");
			return (op1 + op2);
		});
		rechnerMap.put(Operation.SUB, (Double op1, Double op2)->{
			System.out.println("SUB");
			return (op1 - op2);
		});
		rechnerMap.put(Operation.MUL, (Double op1, Double op2) ->{
			System.out.println("MUL");
			return (op1 * op2);
		});
		rechnerMap.put(Operation.DIV, (Double op1, Double op2) ->{
			System.out.println("DIV");
			if(!(Double.compare(op2, 0.0) == 0 ))
				return (op1 / op2);
			return -1.0;
		});
	}
	
	/**
	 * 
	 * @param operation represents the key to decode the operation to be used
	 * @param op1 is the first operand of our BinaryOperator interface
	 * @param op2 is the second operand of our BinaryOperator interface
	 * @return the result of the operation code by operation between op1 and op2
	 */
	public double berechne(Operation operation, double op1, double op2 ){
		
		return rechnerMap.get(operation).apply(op1, op2);
	   }
	
}
