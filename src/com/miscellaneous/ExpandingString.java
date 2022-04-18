package com.miscellaneous;

import java.util.Stack;
/**
 * 
 * @author abks
 *	@implNote ServiceNow Round 1
 */
public class ExpandingString {
	public String getExpandedString(String s) {
		StringBuffer result=new StringBuffer();
		Stack<String> sStack = new Stack<>();
		Stack<String> rStack = new Stack<>();
		
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			
			if(c == ']') {
				while(!"[".equalsIgnoreCase(sStack.peek())) {
					rStack.push(sStack.pop());
				}
				sStack.pop();
				StringBuffer sb = new StringBuffer();
				
				while(!rStack.isEmpty()) {
					sb.append(rStack.pop());
				}
				
				String temp = sb.toString();
				int rep = Integer.parseInt(s.charAt(++i)+"");
				
				while(rep-- > 1)
					sb.append(temp);
				
				sStack.push(sb.toString());
			}else
				sStack.push(c+"");
		}
		
		while(!sStack.isEmpty()) {
			rStack.push(sStack.pop());
		}
		
		while(!rStack.isEmpty()) {
			result.append(rStack.pop());
		}
		
		return result.toString();
	}

}
