public class RandomizedCollection {
    List<Integer> nums;
	Map<Integer, List<Integer>> locs;
	Random rand = new Random();
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        nums = new ArrayList<Integer>();
	    locs = new HashMap<Integer, List<Integer>>();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean contain = locs.containsKey(val);
	    if ( ! contain ) locs.put( val, new ArrayList<Integer>() ); 
	    locs.get(val).add(nums.size());        
	    nums.add(val);
	    return ! contain ;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        boolean contain = locs.containsKey(val);
	    if ( ! contain ) return false;
	    int loc = locs.get(val).remove( locs.get(val).size() - 1 );
	    if (loc < nums.size() - 1 ) {
	       int lastone = nums.get(nums.size() - 1);
	       nums.set( loc , lastone );
	       locs.get(lastone).remove( locs.get(lastone).size() - 1);
	       locs.get(lastone).add(loc);
	    }
	    nums.remove( nums.size() - 1 );
	    if (locs.get(val).isEmpty()) locs.remove(val);
	    return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return nums.get( rand.nextInt(nums.size()) );
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */