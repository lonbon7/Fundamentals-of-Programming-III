
public class MyHashTest
{
	public static void main(String[] args)
	{
		MyHashTable<Integer> hash = new MyHashTable<Integer>(10);
		
		hash.insert(21);
		hash.insert(91);
		hash.insert(71);
		hash.insert(32);
		hash.insert(14);
		hash.insert(4);
		hash.insert(24);
		hash.insert(84);	
		
		hash.output();
		
		System.out.println("\nSize: " + hash.size());
		hash.makeEmpty();
		System.out.println("\nSize: " + hash.size());
		hash.output();
	}
}
