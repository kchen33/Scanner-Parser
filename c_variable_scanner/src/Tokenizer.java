import java.lang.*;

public class Tokenizer {
	
    
    public boolean check_letter(char a){
    	boolean result = false;
    	int temp = a;
    	if((temp>=65 && temp<= 90) || (temp >= 97 && temp <= 122)||(temp == 95)){
    		result = true;
    	}
		return result;
    }
    
    public boolean check_digit(char a){
    	boolean result = false;
    	int temp = a;
    	if(temp>=48 && temp<=57){
    		result = true;
    	}
    	return result;
    }
    
    public boolean check_reservedword(String a){
    	boolean result = false;
    	if(a.equals("int")){
    		result = true;
    	}else if(a.equals("void")){
    		result = true;
    	}else if(a.equals("if")){
    		result = true;
    	}else if(a.equals("while")){
    		result = true;
    	}else if(a.equals("return")){
    		result = true;
    	}else if(a.equals("continue")){
    		result = true;
    	}else if(a.equals("break")){
    		result = true;
    	}else if(a.equals("scanf")){
    		result = true;
    	}else if(a.equals("printf")){
    		result = true;
    	}else if(a.equals("main")){
    		result = true;
    	}else
    		result = false;
		return result;
    }
    
    public boolean check_symbol(char a){
    	boolean result = false;
    	switch(a){
    	case '(':
    		result = true; break;	
    	case ')':
    		result = true; break;
    	case '{':
    		result = true; break;
    	case '}':
    		result = true; break;
    	case '[':
    		result = true; break;
    	case ']':
    		result = true; break;
    	case ',':
    		result = true; break;
    	case ';':
    		result =true; break;
    	case '+':
    		result =true; break;
    	case '-':
    		result = true; break;
    	case '*':
    		result = true; break;
    	case '/':
    		result = true; break;
    	case '=':
    		result = true; break;
    	case '!':
    		result = true; break;
    	case '>':
    		result = true; break;
    	case '<':
    		result = true; break;
    	case '&':
    		result = true; break;	
    	case '|':
    		result = true; break;	
    	}
    	return result;
    }
    
    public boolean check_string(String s){
    	int size = s.length();
    	boolean result = false;
    	if((size >=2) && (s.charAt(0) == '"') && (s.charAt(size-1) == '"') ){
    		result = true;
    	}
    	return result;
    }
    
    public boolean check_char(String s){
    	int size = s.length();
    	int temp = s.charAt(0);
    	int temp2 = s.charAt(size-1);
    	boolean result = false;
    	if((size >=2) && (temp == 39) && (temp2 == 39) ){
    		result = true;
    	}
    	return result;
    }
    
    public boolean check_meta(String s){
    	int size = s.length();
    	if(s.charAt(0) == '#' ){
    		return true;
    	}
    	if(s.charAt(0) == '/' && s.charAt(1) == '/'){
    		return true;
    	}
    	return false;
    }
    
    public boolean check_number(String s){
    	int size = s.length();
    	for(int i = 0; i < size; i++){
    		if((!check_digit(s.charAt(i)))){
    			return false;
    		}
    	}
    	return true;
    }
    
    public boolean check_identifier(String s){
    	if(!check_letter(s.charAt(0))){
    		return false;
    	}
    	int size = s.length();
    	for(int i = 1; i < size; i++){
    		if((!check_letter(s.charAt(i))) && (!check_digit(s.charAt(i)))){
    			return false;
    		}
    	}
    	if(check_reservedword(s)){
    		return false;
    	}
    	return true;
    }
}
