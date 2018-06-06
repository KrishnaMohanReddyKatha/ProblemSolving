// program for evaluating a string arithmetic expression
import java.util.*;
public class ExpressionEvaluation {
	public static void main(String[] args) {
		String expression = "(8*5+9)/3";
		String postfixExpression = ConvertToPostfix(expression);
		System.out.println(postfixExpression);
		double val = EvaluatePostfix(postfixExpression);
		System.out.println(val);
	}
	public static String ConvertToPostfix(String expression) {
		String result = "";
		Stack<Character> stk = new Stack<Character>();
		int i = 0;
		while(i < expression.length()) {
			if(expression.charAt(i) >= '0' && expression.charAt(i) <= '9') {
				result += expression.charAt(i); 
			}
			else if(expression.charAt(i) == '+' || expression.charAt(i) == '-' ||
					expression.charAt(i) == '*' || expression.charAt(i) == '/' ) {
				while(!stk.isEmpty() && (precedenceOf(expression.charAt(i)) <= precedenceOf(stk.peek()))) {
					result+=stk.pop();
				}
				stk.push(expression.charAt(i));
			}
			else if(expression.charAt(i) == '(') {
				stk.push(expression.charAt(i));
			}
			else if(expression.charAt(i) == ')') {
				while(!stk.isEmpty() && stk.peek() != '(') {
					result+=stk.pop();
				}
				if(stk.peek() != '(') {
					result = "InValid Expression";
					return result;
				}
				else {
					stk.pop();
				}
			}
			else {
				result = "Invalid Expression";
				return result;
				}
			i++;
		}
		while(!stk.isEmpty()) {
			result += stk.pop();
		}
		return result;
	}
	public static int precedenceOf(char c) {
		if(c == '+' || c == '-') {
			return 1;
		}
		else if(c == '/' || c == '*') {
			return 2;
		}
		else
			return -1;
	}
	public static double EvaluatePostfix(String postfixExp) {
			Stack<Double> stk = new Stack<Double>();
			double result;
			for(int i = 0; i < postfixExp.length(); i++) {
				if(postfixExp.charAt(i) == '+' || postfixExp.charAt(i) == '-'
						|| postfixExp.charAt(i) == '*' || postfixExp.charAt(i) == '/') {
					double op2 = stk.pop();
					double op1 = stk.pop();
					result = Eval(op1, op2, postfixExp.charAt(i));
					stk.push(result);
				}
				else {
					stk.push(Double.parseDouble(""+postfixExp.charAt(i)));
				}
			}
			return stk.pop();
	}
	public static double Eval(double op1, double op2, char operator) {
		if(operator == '+') {
			return op1 + op2;
		}
		else if(operator == '-') {
			return op1-op2;
		}
		else if (operator == '*') {
			return op1*op2;
		}
		else {
			return op1/op2;
		}
	}
}
