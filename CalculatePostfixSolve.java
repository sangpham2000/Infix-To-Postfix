import java.util.Stack;

//Sinh vien khong chinh sua bat ky dong lenh nao ben tren dong comment "Phan bai lam cua sinh vien", duoc phep them thu vien khi can thiet

public class CalculatePostfixSolve implements Requirement2_OutputGetter{
	private String inputString;
	private double resultOfExpression;
	
	public CalculatePostfixSolve(){ //Phuong thuc khong duoc chinh sua
		this.inputString = "";
		this.resultOfExpression = 0;
	}
	
	public CalculatePostfixSolve(String inputString){ //Phuong thuc khong duoc chinh sua
		this.inputString = inputString;
		this.resultOfExpression = 0;
	}
	
	public void setInputString(String inputString){ //Phuong thuc khong duoc chinh sua
		this.inputString = inputString;
	}	
	
	public double getResultOfExpression(){ //Phuong thuc khong duoc chinh sua
		this.resultOfExpression = calculatePostfix();
		return this.resultOfExpression;
	}	
	
	// Phan bai lam cua sinh vien
	
	private double calculatePostfix(){
        // code here
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
        // code here
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
