import java.util.Hashtable;

// a hash table is a collection of key-value pairs, 2 pieces of data: 1 key and 1 value
// ideal with large datasets, not so much with small datasets

// say our hash table has a capacity of 10 (indeces 0-9): key-value pairs will yield a hashcode that
// determines where the pair is stored. if a pair has a hashcode of 48265, simply solve ( hashCode % capacity ) and
// the value will determine its index storage (in this case, index would be 5). this formula is called "hashing."

// collisions are when later key-value pairs yield the same remainder for their hashcode. for example, one key-value pair
// has a (hashCode % 10) of 7 and another key-value pair also has a (hashCode % 10) of 7. we can't store both values inside
// one index, so the solution is to manage the bucket (the proper term for the storage index in hash tables) by treating the 
// data as a linked list. we append the address of the next value to the first value, ultimately treating each key-value pair
// as a linked list node, all being able to point to other nodes.

public class HashTableDemo {
    public static void main (String[] args) {
        
        Hashtable<Integer, String> intTable = new Hashtable<>(10); // default initial capacity of 11 elements, but we set it to 10. dynamically expands
        Hashtable<String, String> stringTable = new Hashtable<>(10);

        intTable.put(100, "Spongebob");
        intTable.put(123, "Patrick");
        intTable.put(321, "Sandy");
        intTable.put(555, "Squidward");
        intTable.put(777, "Gary");

        stringTable.put("100", "Spongebob");
        stringTable.put("123", "Patrick");
        stringTable.put("321", "Sandy");
        stringTable.put("555", "Squidward");
        stringTable.put("777", "Gary");

        // intTable.remove(777);

        for(Integer key : intTable.keySet()) {
            System.out.println(key.hashCode() % 10 + "\t" + key + "\t" + intTable.get(key));
        }

        // part of the output yields:
        // 5	777	Gary
        // 5	100	Spongebob
        // both stored in bucket 5, treated as a linked list
        // linked lists are iterated through linearly O(n)
        for(String key : stringTable.keySet()) {
            System.out.println(key.hashCode() % 10 + "\t" + key + "\t" + stringTable.get(key));
        }
        
        // if you want to avoid collisions altogether, increasing capacity changes the formula that determines where key-value pairs are stored.
        // in this example, increasing capacity to 21 makes it so no collisions occur with the given data.

    }
}