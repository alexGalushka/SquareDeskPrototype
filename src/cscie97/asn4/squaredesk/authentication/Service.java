package cscie97.asn4.squaredesk.authentication;

import java.util.LinkedList;
import java.util.List;


public class Service implements Visitable
{
	private String id;
	private String name;
	private String description;

	private List<Entitlement> permiList;
	
	public Service()
	{
		this.id = "";
		this.name = "";
		this.description = "";
		permiList = new LinkedList<Entitlement>();
	}
	
	public Service( String id, String name, String description, List<Entitlement> permiList2 )
	{
		this.id = id;
		this.name = name;
		this.description = description;
		this.permiList = permiList2;
	}
	
	/**
	 * adds permission to the list of permissions
	 * @param accToken - access token
	 * @param perm Permission
	 */
	public void addPermission( AccessToken accToken, Permission perm )
	{
		// authImpl.validateAccess( accToken, <permission string> ).
		if ( !permiList.contains( perm ) )
		{
			permiList.add( perm );
		}
	}
	
	/**
	 * removes permission from the list of permissions
	 * @param accToken - AccessToken
	 * @param perm - Permission
	 */
	public void removePermission( AccessToken accToken, Permission perm )
	{
		// authImpl.validateAccess( accToken, <permission string> ).
		if ( permiList.contains( perm ) )
		{
			permiList.remove( perm );
		}
	}
	
	/**
	 * accessor method
	 * @return permiList
	 */
	public List<Entitlement> getListOfPermissions ()
	{
		return permiList;
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
	 * accessor method
	 * @return String : description
	 */
	public String getDescription()
	{
		return description;
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
	 * mutator method
	 * @param description - service's description to be set
	 */
	public void setDescription(String description) 
	{
		this.description = description;
	}

	/**
	 * support method for Visitor design pattern: accepts Visitor - performs "visit" operation
	 */
	public void acceptVisitor(Visitor v) 
	{
		v.visit(this);	
	}

}
