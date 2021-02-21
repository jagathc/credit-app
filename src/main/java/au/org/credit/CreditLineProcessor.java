/**
 * This is a class processing the credit lines.
 */
package au.org.credit;

import java.io.IOException;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

import au.org.credit.model.LimitUtilisation;
import au.org.credit.model.Line;
import au.org.credit.model.Node;
import au.org.credit.util.FileReader;

public class CreditLineProcessor<T> {

	public void processCredits() throws IOException {
		List<String[]> lines = FileReader.readFile();
		List<Line> list = lines.parallelStream().map(
				line -> new Line(line[0].trim(), line[1].trim(), Integer.valueOf(line[2]), Integer.valueOf(line[3])))
				.collect(Collectors.toList());
		
		
	}
	
	private fun updateTree(trees: MutableSet<Node<LimitUtilisation>>, line: Line): MutableSet<Node<LimitUtilisation>> {
	    if (line.parent.isBlank()) {
	        trees.add(line.toNode())
	        return trees
	    }

	    for (root in trees) {
	        val parentNode = findNode(root, line.parent)
	        if (parentNode != null) {
	            val childNode = line.toNode()
	            parentNode.addChild(childNode)

	            break
	        }
	    }

	    return trees
	}

	private Node<T> findNode(Node<T> root, String name) {
		Stack<Node<T>> stack = new Stack<Node<T>>();
	    stack.push(root);

	    Node<T> node = null;

	    do {
	    	Node<T> currentNode = stack.pop();
	        if (currentNode.getName().equals(name)) {
	            return currentNode;
	        }

	        currentNode.getChildren().forEach() { child -> stack.push(child) }
	    } while(stack.isNotEmpty())

	    return node;
	}

	public static void main(String[] args) {
		try {
			new CreditLineProcessor().processCredits();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
