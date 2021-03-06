package cscie97.asn4.squaredesk.authentication;


public interface Visitor
{

	/**
	 * visit method ( intended to visit RegisteredUser instance )
	 * @param regUser - RegisteredUser
	 *
	 */
	public void visit( RegisteredUser regUser );
	
	/**
	 * visit method ( intended to visit Role instance )
	 * @param ent Entitlement
	 *
	 */
	public void visit( Entitlement ent );
	
	/**
	 * visit method ( intended to visit Role instance )
	 * @param service Service
	 *
	 */
	public void visit( Service service );


	public void visit( Permission permission );

	/**
	 * accessor method, returns formatted inventory string 
	 * @return String : inventory
	 */
	public String getInventoryFromVisitor();
}
