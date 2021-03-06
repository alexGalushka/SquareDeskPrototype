package cscie97.asn4.squaredesk.authentication;

public interface Visitable
{
	/**
	 * method used in Visitor pattern implementation,
	 * used by all Visitables to provide access to their instances by the Visitor
	 * @param v - Visitor
	 */
	void acceptVisitor ( Visitor v );
}
