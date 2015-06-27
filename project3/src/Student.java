/**
 * @author Lonnie Bissmeyer
 * @author Michael Williams
 * @version 5/20/13
 * 
 * The Student class for project 3.
 *
 */

public class Student {

	/**
	 * A value identifying this specific student
	 */
	private long id;
	
	/**
	 * This students last name
	 */
	private String lastName;
	
	public Student(long id, String lastName)
	{
		this.id = id;
		this.lastName = lastName;
	}
	
	/**
	 * Checks if the given object equals this student object by their id
	 * @param other the object to compare to
	 * @return true if the given object is of the Student class and has the same id as this object; false otherwise
	 */
	public boolean equals(Object other)
	{
		if(other==null)
		{
			return false;
		}
		else if(other.getClass()!=this.getClass())
		{
			return false;
		}
		else if(this.id!=((Student)other).id)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	/**
	 * Converts the student class to a string representation
	 * @return a string representation of the student object
	 */
	public String toString()
	{
		return id + ", " + lastName;
	}
	
	/**
	 * Gets the hash code of this object based off the student's id
	 * @return the hash code of this object
	 */
	public int hashCode()
	{
		return Long.valueOf(id).hashCode();
	}
	
}
