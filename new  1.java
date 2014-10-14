 
 StringTokenizer tokenizer = new StringTokenizer(input);
 numAttributes = tokenizer.countTokens();
 if (numAttributes <= 1) {System.err.println( "Read line: " + input);
 System.err.println( "Could not obtain the names of attributes in theline");
 System.err.println( "Expecting at least one input attribute and oneoutput attribute");
 return 0;}domains = new Vector[numAttributes];
 for (int i=0; i < numAttributes; i++) domainsIdea [I] = new Vector();
 attributeNames = new String[numAttributes];
 for (int i=0; i < numAttributes; i++) 
	{
	attributeNamesIdea [I] = tokenizer.nextToken();
	}
	while(true) {input = bin.readLine();
	if (input == null) break;
	if (input.startsWith("//")) continue;
	if (input.equals("")) continue;
	tokenizer = new StringTokenizer(input);
	int numtokens = tokenizer.countTokens();
	if (numtokens != numAttributes) {System.err.println( "Read " + root.data.size() + " data");
	System.err.println( "Last line read: " + input);System.err.println( "Expecting " + numAttributes + " attributes");
 
return 0;
}
DataPoint point = new DataPoint(numAttributes);
for (int i=0; i < numAttributes; i++) 
	{
	point.attributesIdea [I] = getSymbolValue(i, tokenizer.nextToken());
	}
	root.data.addElement(point);
	}
	bin.close();
	return 1;
	} 
	
	public void printTree(TreeNode node, String tab) 
	{
	int outputattr = numAttributes-1;
	if (node.children == null) {int []values = getAllValues(node.data, outputattr );
	if (values.length == 1) 
	{
	System.out.println(tab + "\t" + attributeNames[outputattr] + " = \"" +domains[outputattr].elementAt(values[0]) + "\";");
	return;}System.out.print(tab + "\t" + attributeNames[outputattr] + " = {");
	for (int i=0; i < values.length; i++) 
	{
	System.out.print("\"" + domains[outputattr].elementAt(valuesIdea [I]) + "\"");
	if ( i != values.length-1 ) System.out.print( " , " );
	}
	System.out.println( " };");
 
return;
}
int numvalues = node.children.length;
for (int i=0; i < numvalues; i++) {System.out.println(tab + "if( " +attributeNames[node.decompositionAttribute] + " == \"" +domains[node.decompositionAttribute].elementAt(i)+ "\") {" );
printTree(node.childrenIdea [I], tab + "\t");
if (i != numvalues-1) System.out.print(tab + "} else ");
else System.out.println(tab + "}");
} 
} 
public void createDecisionTree() {decomposeNode(root);printTree(root, "");
} /* main function */public static void main(String[] args) throws Exception { ID3 me = new ID3();int status = me.readData("c:\\in.txt");
if (status <= 0) return;me.createDecisionTree();
 
} 
}
