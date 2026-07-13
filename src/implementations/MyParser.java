package implementations;
//XML PARSER
/*
	 * Write an XML parser that will accomplish the following:
	a. Read supplied XML documents.
	b. Parse for errors in the XML construction.
	c. When parsing is complete, print all lines that are not properly constructed in the order
	in which the errors occur.
	
	
	Parsing Rules
	
	An XML document is syntactically correct if it meets the following requirements:
	
	• An opening tag has the format <tag> and a closing tag has the format </tag>.
	Note: Although, XML tags may contain attributes in the format of name=“value” pairs,
	ignore these attributes for this assignment.
	
	• For every closing tag, there is an earlier, matching opening tag.
	
	• An exception to the above is a self-closing tag, which has the format <tag/>. Self-closing
	tags require no closing tag.
	
	• The sub-phrase between a pair of matching tags is well-constructed.
	
	• All tags are case-sensitive.
	
	• Every XML document must have one and only one root tag.
	
	• Tags in the format: <?xml somedata=”data”?> are processing instructions and can be
	ignored for this assignment.
	
	• If nested, the tag pairs cannot intercross. For example, the following is not syntactically
	correct:
	<b>This is to be bold and <i>italic</b></i>
	
	

	 * Given Pseudo Code for the XML Parser:
	 * 
	 * 
	 * If Self_Closing_Tag
			Ignore
		If Start_Tag
			Push on stack
		If End_Tag
			If matches top of stack, pop stack and all is well
			Else if matches head of errorQ, dequeue and ignore
			Else if stack is empty, add to errorQ
			Else
				Search stack for matching Start_Tag
				If stack has match
					Pop each E from stack into errorQ until match, report as error
				Else
					Add E to extrasQ
					
			Repeat until EOF
			If stack is not empty, pop each E into errorQ
			If either queue is empty (but not both), report each E in both queues as error
			If both queues are not empty, peek both queues
				If they don’t match, dequeue from errorQ and report as error
				Else dequeue from both
			Repeat until both queues are empty
			
			
			ex cmd output: 
		
			Input: -jar myParser.jar sample1.xml
			Output: XML Document is constructed correctly.
			
			Input: -jar myParser.jar sample2.xml
			Output: Error at line: 8 <i> is not constructed correctly
 */
public class MyParser {

	public static void main(String[] args) {
		
	}

}
