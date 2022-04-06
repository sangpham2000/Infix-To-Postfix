import java.util.Stack;

//Sinh vien khong chinh sua bat ky dong lenh nao ben tren dong comment "Phan bai lam cua sinh vien", duoc phep them thu vien khi can thiet

public class InfixToPostfixSolve implements Requirement1_OutputGetter {
	private String inputString;
	private String outputString;
	
	public InfixToPostfixSolve(){ //Phuong thuc khong duoc chinh sua
		this.inputString = "";
		this.outputString = "";
	}
	
	public InfixToPostfixSolve(String inputString){ //Phuong thuc khong duoc chinh sua
		this.inputString = inputString;
		this.outputString = "";
	}
		
	public void setInputString(String inputString){ //Phuong thuc khong duoc chinh sua
		this.inputString = inputString;
	}
	
	 public String getOutputString() { //Phuong thuc khong duoc chinh sua
    	this.outputString = infixToPostfix();
		return outputString;
	}	
	
	// Phan bai lam cua sinh vien
	
	private String infixToPostfix(){
		String postfix = "";
        // code here
		String[] str = stringTokenizer(inputString);
		Stack<String> stack = new Stack<String>();
		for (int i = 0; i < str.length; i++)
		{
			if (isNum(str[i]))
			{	
				postfix = postfix + str[i] + " ";
			}	
			else if (str[i].equals("("))
			{	
				stack.push(str[i]);
			}	
			else if (str[i].equals(")"))
			{	
				while(!"(".equals(stack.peek()))
					postfix = postfix + stack.pop() + " ";
				stack.pop();
			}	
			else if (priorityOfOperator(str[i])>0)
			{	
				while(!stack.empty() && stack.peek() != "(" && priorityOfOperator(str[i]) <= priorityOfOperator(stack.peek()))
					postfix = postfix + stack.pop() + " ";
					stack.push(str[i]);
			}	
		}
		while(!stack.empty())
			postfix = postfix + stack.pop() + " ";						
		return postfix;
	}
	
	private String[] stringTokenizer(String str){
        // code here
		String[] tokens = new String[str.length()];
		int n = 0;
		for(int i = 0; i < str.length(); i++)
		{
			tokens[i] = "";
		}
		for(int i = 0; i < str.length(); i++)
		{
			if(str.charAt(i) != ' ')
				tokens[n] = tokens[n] + Character.toString(str.charAt(i));
			else 
				n++;
		}
		return tokens;
	}
	        
	private boolean isNum(String c) {
    	return c.matches("0|([1-9][0-9]*)");
    }
	
	private int priorityOfOperator(String op){
        // code here
		if (op.equals("+") || op.equals("-"))
			return 1;
		if (op.equals("*") || op.equals("/"))
			return 2;
		if (op.equals("^") )
			return 3;
    	return 0;
    }   
}
