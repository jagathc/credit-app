/**
 * This is a node of the tree.
 */
package au.org.credit.model;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author jagath
 *
 */
public class Node {
	private String name;
	private int limit;
	private int directUtilisation;
	private int combinedUtilisation = -1;

	
	private Node parent;
	private Set<Node> children = new HashSet<>();
	
	public Node(String name, int limit, int directUtilisation) {
		this.name = name;
		this.limit = limit;
		this.directUtilisation = directUtilisation;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the limit
	 */
	public int getLimit() {
		return limit;
	}

	/**
	 * @return the direct utilisation.
	 */
	public int getDirectUtilisation() {
		return directUtilisation;
	}

	/**
	 * @return the combined utilisation.
	 */
	public int getCombinedUtilisation() {
		return combinedUtilisation;
	}
	
	/**
	 * @return the parent
	 */
	public Node getParent() {
		return parent;
	}

	/**
	 * @return the children
	 */
	public Set<Node> getChildren() {
		return children;
	}

	/**
	 * @return add the child
	 */
	public void addChild(Node child) {
		child.parent = this;
		this.children.add(child);
	}

	/**
	 * This method calculates the combined utilisation.
	 * 
	 * @return the combined utilisation
	 */
	public int calculateCombinedUtilisation() {

		int combinedUtilisationForChildren = 0;

		for (Node child: children) {
			combinedUtilisationForChildren += child.calculateCombinedUtilisation();
		}

		this.combinedUtilisation = combinedUtilisationForChildren + directUtilisation;

		return combinedUtilisation;
	}

	/**
	 * Checks the limit is breached.
	 * @return
	 */
	public boolean isLimitBreached() {
		return this.combinedUtilisation > limit;
	}

	/**
	 * All the descendants.
	 * @return
	 */
	public Stream<Node> getAllDescendants() {
		return children.parallelStream().map(Node::getAllDescendants)
				.reduce(
						children.stream(),
						Stream::concat
				);
	}
}
