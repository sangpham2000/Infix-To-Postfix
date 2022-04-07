import java.util.Stack;

public class CalculatePostfixSolve implements Requirement2_OutputGetter{
	private String inputString;
	private double resultOfExpression;
	
	public CalculatePostfixSolve(){ 
		this.inputString = "";
		this.resultOfExpression = 0;
	}
	
	public CalculatePostfixSolve(String inputString){
		this.inputString = inputString;
		this.resultOfExpression = 0;
	}
	
	public void setInputString(String inputString){ 
		this.inputString = inputString;
	}	
	
	public double getResultOfExpression(){ 
		this.resultOfExpression = calculatePostfix();
		return this.resultOfExpression;
	}	
	

	
	private double calculatePostfix(){
		String[] str = stringTokenizer(inputString);
		Stack<Double> stack = new Stack<Double>();
		double cal = 0;
		double temp=0;
		for (int i=0; i < str.length; i++)
		{
			if(isNum(str[i]))
			{	
				stack.push(Double.parseDouble(str[i]));
			}
			else if (str[i].equals("+"))
			{	
				temp = stack.pop();
				cal = stack.pop() + temp;
				stack.push(cal);
			}	
			else if (str[i].equals("-"))
			{	
				temp = stack.pop();
				cal = stack.pop() - temp;
				stack.push(cal);
			}	
			else if (str[i].equals("*"))
			{	
				temp = stack.pop();
				cal = stack.pop() * temp;
				stack.push(cal);
			}	
			else if (str[i].equals("/"))
			{	
				temp = stack.pop();
				cal = stack.pop() / temp;
				stack.push(cal);
			}	
			else if (str[i].equals("^"))
			{	
				temp = stack.pop();
				cal = Math.pow(stack.pop(),temp);
				stack.push(cal);
			}	
		}
		cal = stack.pop();
		return cal;
	}
	
	private String[] stringTokenizer(String str){
		String[] tokens = new String[str.length()];
		int n = 0;
		for(int i = 0; i < str.length();i++)
		{
			tokens[i] = "";
		}
		for(int i = 0; i < str.length();i++)
		{
			if(str.charAt(i)!=' ')
				tokens[n] = tokens[n] + Character.toString(str.charAt(i));
			else 
				n++;
		}
		return tokens;
	}
	
	private boolean isNum(String c) {
    	return c.matches("0|([1-9][0-9]*)");
    }
}
