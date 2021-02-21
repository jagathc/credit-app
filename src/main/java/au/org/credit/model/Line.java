/**
 * This represents a line in the input data file.
 */
package au.org.credit.model;

/**
 * @author jagath
 */
public class Line {
	private String name;
	private String parent;
	private int limit;
	private int utilisation;

	/**
	 * @param name
	 * @param parent
	 * @param limit
	 * @param utilisation
	 */
	public Line(String name, String parent, int limit, int utilisation) {
		this.name = name;
		this.parent = parent;
		this.limit = limit;
		this.utilisation = utilisation;
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
	 * @return the parent
	 */
	public String getParent() {
		return parent;
	}

	/**
	 * @param parent the parent to set
	 */
	public void setParent(String parent) {
		this.parent = parent;
	}

	/**
	 * @return the limit
	 */
	public int getLimit() {
		return limit;
	}

	/**
	 * @param limit the limit to set
	 */
	public void setLimit(int limit) {
		this.limit = limit;
	}

	/**
	 * @return the utilisation
	 */
	public int getUtilisation() {
		return utilisation;
	}

	/**
	 * @param utilisation the utilisation to set
	 */
	public void setUtilisation(int utilisation) {
		this.utilisation = utilisation;
	}
}
