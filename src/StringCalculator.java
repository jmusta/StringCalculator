import java.util.ArrayList;

public class StringCalculator {
	
	protected String[] inputs;
	protected ArrayList<Integer> numbers;
	protected int result;
	
	StringCalculator(){
		numbers = new ArrayList<Integer>();
	}
	
	protected void setInput(String input) {
		inputs = input.split(",");
	}
	
	protected boolean checkInput() {
		
		if(inputs.length == 1 && inputs[0].isEmpty()) {
			return true;
		}
		
		for(int i = 0; i < inputs.length; i++) {
			for(int j = 0; j < inputs[i].length(); j++) {
				if(!Character.isDigit(inputs[i].charAt(j))) {
					return false;
				}
			}
		}	
		
		return true;
	}
	
	protected void parseNumbers() {
		
		if(inputs[0].isEmpty()) {
			numbers.add(0);
			return;
		}
		
		for(int i = 0; i < inputs.length; i++) {
			numbers.add(Integer.parseInt(inputs[i]));
		}
		
		return;
	}
	
	protected void calculateSum() {
		result = 0;
		
		for(Integer i : numbers) {
			result += i;
		}
	}
	
	
	
	public int add(String numbersStr) throws StringCalculatorException {
		// Returns the sum of the numbers given in numbersStr
		
		numbers.clear();		
		
		setInput(numbersStr);
		
		if(!checkInput()) {
			throw new StringCalculatorException();
		}
		
		parseNumbers();
		
		calculateSum();
		
		return result;
	}
	
	
}
