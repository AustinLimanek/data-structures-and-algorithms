# Hash Map

[Implementation Code](../hashmap/HashMap.java)

[Testing Code](../../../../test/java/datastructures/hashmap/HashMapTest.java)

## Challenge

Construct a hash map that is follows the architecture of an ArrayList that contains a linkedlist that holds HashMapPairs of a Key and a Value. Setting repeat keys should override the value of that key.

## Features

- [x] void set <K,V>: A key value pair is added to the hashmap. If the key already exists, then the value for the pre-existing key is replaced by the new value. [Space O(1); Time O(1)]
- [x] V get K: Takes in a key and outputs the corresponding value for that pair. If the key does not exist in the hashmap, then the return is null. [Space O(1); Time O(1)]
- [x] boolean peek K: Takes in a key and determines whether that key can be located in the hashmap. The return is a boolean. [Space O(1); Time O(1)]
- [x] List<K> keys void: The method returns all the keys in the hashmap. There are only unique keys in the hashmap.  [Space O(N); Time O(N), where N is the size of the hashmap]
- [x] String toString void: Returns a string for the hashmap. [Space O(1); Time O(N), where N is the size of the hashmap]
-
## Specifications & Tests

- [x] Setting a key/value to your hashtable results in the value being in the data structure
- [x] Retrieving based on a key returns the value stored
- [x] Successfully returns null for a key that does not exist in the hashtable
- [x] Successfully returns a list of all unique keys that exist in the hashtable
- [x] Successfully handle a collision within the hashtable
- [x] Successfully retrieve a value from a bucket within the hashtable that has a collision
- [x] Successfully hash a key to an in-range value
