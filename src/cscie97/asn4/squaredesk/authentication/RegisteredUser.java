package cscie97.asn4.squaredesk.authentication;

import java.util.LinkedList;
import java.util.List;

public class RegisteredUser implements Visitable
{
	private String id;
	private String name;

	private List<Entitlement> entiList;
	private AccessToken accToken;
	private UserNamePassword creds;
	
	public RegisteredUser()
	{
		this.id = "";
		this.name = "";
		entiList = new LinkedList<Entitlement>();
		accToken  = null;
		creds = null;
	}
	
	

	public RegisteredUser( String id, String name, String description,
			               UserNamePassword creds )
	{
		this.id = id;
		this.name = name;
		this.entiList = new LinkedList<Entitlement>();
		this.accToken = null;
		this.creds = creds;
	}
	
	/**
	 * adds entitlement to the list of entitlement
	 * Admin restricted method
	 * @param ent Entitlement
	 */
	public void addEntitlement( Entitlement ent )
	{
		// authImpl.validateAccess( accToken, <entitlement string> ).
		if ( !entiList.contains( ent ) )
		{
			entiList.add( ent );
		}
	}
	
	/**
	 * removes entitlement from the list of entitlement
	 * Admin restricted method
	 * @param ent Entitlement
	 */
	public void removeEntitlement( Entitlement ent )
	{
		// authImpl.validateAccess( accToken, <entitlement string> ).
		if ( entiList.contains( ent ) )
		{
			entiList.remove( ent );
		}
	}
	
	
	/**
	 * accessor method
	 * @return AccessToken : accToken
	 */
	public AccessToken getAccToken() 
	{
		return accToken;
	}

	/**
	 * accessor method
	 * @return UserNamePassword : creds
	 */
	public UserNamePassword getCreds() 
	{
		return creds;
	}

	/**
	 * mutator method
	 * @param accToken to set
	 */
	public void setAccToken(AccessToken accToken)
	{
		this.accToken = accToken;
	}

	/**
	 * mutator method
	 * @param  creds to set
	 */
	public void setCreds(UserNamePassword creds)
	{
		this.creds = creds;
	}
	
	/**
	 * accessor method
	 * @return  entiList List of Entitlements
	 */
	public List<Entitlement> getListOfEntitlements ()
	{
		return entiList;
	}
	
	/**
	 * accessor method
	 * @return String : id
	 */
	public String getId()
	{
		return id;
	}

	/**
	 * accessor method
	 * @return String : name
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * mutator method
	 * @param id - service's id to be set
	 */
	public void setId(String id)
	{
		this.id = id;
	}

	/**
	 * mutator method
	 * @param name - service's name to be set
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * method used in Visitor pattern implementation,
	 * used by all Visitables to provide access to their instances by the Visitor
	 * @param v - Visitor
	 */
	public void acceptVisitor( Visitor v )
	{
		v.visit( this );
	}

}
