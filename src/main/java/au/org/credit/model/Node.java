/**
 * This is a node of the tree.
 */
package au.org.credit.model;

import java.util.Set;

/**
 * @author jagath
 *
 */
public class Node<T> {
	private String name;
	private T data;
	
	private Node<T> parent;
	private Set<T> children;
	
	/**
	 * This constructs a node instance.
	 * @param name
	 * @param data
	 */
	public Node(String name, T data) {
		this.name = name;
		this.data = data;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the data
	 */
	public T getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(T data) {
		this.data = data;
	}

	/**
	 * @return the parent
	 */
	public Node<T> getParent() {
		return parent;
	}

	/**
	 * @param parent the parent to set
	 */
	public void setParent(Node<T> parent) {
		this.parent = parent;
	}

	/**
	 * @return the children
	 */
	public Set<T> getChildren() {
		return children;
	}

	/**
	 * @param children the children to set
	 */
	public void setChildren(Set<T> children) {
		this.children = children;
	}
}
