/**
 * This is the class to keep the credit limit and utilisation of user.
 */
package au.org.credit.model;

/**
 * @author jagath
 *
 */
public class LimitUtilisation {
    private int limit;
    private int utilisation;
	/**
	 * @param limit
	 * @param utilisation
	 */
	public LimitUtilisation(int limit, int utilisation) {
		this.limit = limit;
		this.utilisation = utilisation;
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
