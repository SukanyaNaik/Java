import java.util.ArrayList;
import java.util.Stack;

public class CircuitParser {

	public static void main(String[] args) {
		ArrayList<String> circuitsExpression = new ArrayList<String>();
		//circuitsExpression.add("[|,[&,1,[!,0]],[!,[&,[|,1,0],[!,1]]]]");
		circuitsExpression.add("[&,[|,1,[!,1]],[|,0,[&,1,1]]]");
		Stack <Character> result = new Stack<>();
		Stack <Character> operationsStack = new Stack<>();
		Stack <Character> operandsStack = new Stack<>();
         
        int countOpen = 0;
        String str = "";
        Character operation = ' ';
        Character operand1 = ' ';
        Character operand2 = ' ';
        Integer op1, op2, res = 0;
        char ch = ' ';

        str = circuitsExpression.get(0);
        for (int i = 0; i < str.length(); i++) {
            ch = str.charAt(i);
           
            if(ch == '['){
            	countOpen++;
            	
            }
            if(ch == ']') {
            	countOpen--;
            	
                operation = operationsStack.pop();
                
                if(operation =='!'){
                	if(!operandsStack.isEmpty()) {
                		operand1 = operandsStack.pop();
                	} else {
                		operand1 = result.pop();
                	}
                	if(operand1 == '1') {
                		result.push('0');
                	}
                	else {
                		result.push('1');
                	}
                }
                
                else if (operation == '&' || operation == '|') {
                	if(!operandsStack.isEmpty()) {
                		operand1 = operandsStack.pop();
                		if(!operandsStack.isEmpty()) {
                			operand2 = operandsStack.pop();
                		}
                		else if(!result.isEmpty()) {
                			operand2 = result.pop();
                		}
                	} else {
                		if(!result.isEmpty()) {
                			operand1 = result.pop();
                		}
                		if(!result.isEmpty()) {
                			operand2 = result.pop();
                		}
                	}
                	op1 = Integer.parseInt(String.valueOf(operand1));
            		op2 = Integer.parseInt(String.valueOf(operand2));
                	if(operation == '&') {
                		res = (op1&op2);
                	}
                	else if(operation == '|') {
                		res = (op1|op2);
                	}
                	result.push(Character.forDigit(res, 10));
                }
                System.out.println(operation + " " + result.peek());
            }
            if(ch == '|' || ch == '&' || ch == '!') { 
                operationsStack.push(ch);
            }
            if(ch == '1' || ch == '0'){
                operandsStack.push(ch);
            }
        }
        //result.add(1);
        
        System.out.println("Result - " + result.pop());
        if(operandsStack.isEmpty() && operationsStack.isEmpty() && result.isEmpty()) {
        	System.out.println("All Stacks are empty");
        }
	}

}
