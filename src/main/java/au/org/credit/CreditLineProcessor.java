/**
 * This is a class processing the credit lines.
 */
package au.org.credit;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import au.org.credit.model.Line;
import au.org.credit.model.Node;
import au.org.credit.util.FileReader;

public class CreditLineProcessor {

	private final Set<Node> trees = new HashSet<>();

	/**
	 * This method read the credit entries from the data file for processing.
	 * @throws IOException
	 */
	public void processCredits() throws IOException {
		try (Stream<Line> fileLines = FileReader.readFile()) {
			fileLines.forEach(this::updateTree);
		}
	}

	/**
	 * This method calculates the credit utilisation of each tree.
	 * @throws IOException
	 */
	public void calculateCombinedUtilisation() {
		for (Node tree: trees) {
			tree.calculateCombinedUtilisation();
		}
	}

	/**
	 * This method prints the report.
	 */
	public void printReport() {
		Set<Node> withInLimitNodes = new HashSet<>();
		Set<Node> limitBreachedNodes = new HashSet<>();

		for (Node root: trees) {
			Stack<Node> stack = new Stack<>();
			stack.push(root);

			do {
				Node currentNode = stack.pop();
				if (currentNode.isLimitBreached()) {
					limitBreachedNodes.add(currentNode);
				} else {
					withInLimitNodes.add(currentNode);
					for (Node child: currentNode.getChildren()) {
						stack.push(child);
					}
				}

			} while(!stack.isEmpty());
		}

		System.out.print("Entries: ");
		System.out.print(
				withInLimitNodes.stream()
					.map(Node::getName)
					.collect(Collectors.joining("/"))
		);
		System.out.println(" :");
		System.out.println("No limit breaches\n\n");

		limitBreachedNodes
				.forEach(node -> {
					System.out.print("Entries: ");
					System.out.print(node.getName() + "/");
					System.out.print(node.getAllDescendants().map(Node::getName).collect(Collectors.joining("/")));

					System.out.println(" :");
					System.out.printf(
							"Limit breach at %s (limit = %d, direct utilisation = %d, combined utilisation = %d).%n",
							node.getName(), node.getLimit(), node.getDirectUtilisation(), node.getCombinedUtilisation()

					);

				});
	}
	
	private void updateTree(Line line) {
	    if (line.getParent() == null) {
	        trees.add(
					new Node(line.getName(), line.getLimit(), line.getUtilisation())
			);

	        return;
	    }

		for (Node root: trees) {
			Node parentNode = findNode(root, line.getParent());
			if (parentNode != null) {
				Node childNode = new Node(
						line.getName(), line.getLimit(), line.getUtilisation()
				);

				parentNode.addChild(childNode);
				break;
			}
		}
	}

	private Node findNode(Node root, String name) {
		Stack<Node> stack = new Stack<>();
	    stack.push(root);

	    do {
	    	Node currentNode = stack.pop();
	        if (currentNode.getName().equals(name)) {
	            return currentNode;
	        }

	        currentNode.getChildren().forEach(stack::push);
	    } while(!stack.isEmpty());

	    return null;
	}

	public static void main(String[] args) {
		CreditLineProcessor processor = new CreditLineProcessor();
		try {
			processor.processCredits();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}

		processor.calculateCombinedUtilisation();
		processor.printReport();
	}

	/**
	 * @return the trees
	 */
	public Set<Node> getTrees() {
		return trees;
	}
}
