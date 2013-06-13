/*
 * Michael Robertson
 * mirob2005@gmail.com
 * Completed: 6/13/13
 *
 * HashTable.java
 * 
 * Hash Table is built using an array of buckets.
 * When an entry is added to a given bucket, the bucket stores the entries in an ArrayList
 * The bucket used is decided using the defined getHash() method which returns an index
 *   based off a hashing value modulo number of buckets in the hash table defined at
 *   object initialization.
 * The hashing value is calculated as follows:
 *   (int)character-32*95^placement
 *   where (int)character returns the decimal value of the ASCII character
 * The printable ASCII chars are decimal 32 to 126, by subtracting 32 we get: 0 to 94
 * Example: key  = 'test'
 * (int)'t'-32 = 84 *95 ^0 = 84
 * (int)'e'-32 = 69 *95 ^1 = 6555
 * (int)'s'-32 = 83 *95 ^2 = 749075
 * (int)'t'-32 = 84 *95 ^3 = 72019500
 * Hashing Value = 72019500 + 749075 + 6555 + 84 = 72775214
 * Index = Hashing Value % numBuckets
 *
 * Results in a unique hashing value for any key
 *
 * Collisions are dealt using separate chaining.  Each bucket contains an 
 * ArrayList of entries with that index.
 * 
 * NOTE: Produce own hash codes as an exercise rather than using hashCode() method.
 * 
 */

package hashtable;

import java.util.ArrayList;

public class HashTable<K,V> {
    public class Entry<K,V>{
        private K key;
        private V value;
        public Entry(K key,V value){
            this.key = key;
            this.value = value;
        }
        public K getKey(){
            return this.key;
        }
        public V getValue(){
            return this.value;
        }
        public void updateValue(V value){
            this.value = value;
        }
        public boolean matchBoth(K key, V value){
            return(this.key==key && this.value == value);
        }
        public boolean matchKey(K key){
            if(key.getClass()==this.key.getClass()){
                if(key instanceof Double || key instanceof Float){
                    return key.toString().equals(this.key.toString());
                }
                else{
                    return key==this.key;
                }
            }
            return false;
        }
        @Override
        public String toString(){
            String returnStr = "";
            if(this.key instanceof String){
                returnStr += ("\""+this.key+"\": ");
            }
            else if(this.key instanceof Character){
                returnStr += ("'"+this.key+"': ");
            }
            else{
                returnStr += (this.key+": ");
            }
            if(this.value instanceof String){
                returnStr += ("\""+this.value+"\"");
            }
            else if(this.value instanceof Character){
                returnStr += ("'"+this.value+"'");
            }
            else{
                returnStr += this.value;
            }            
            return returnStr;
        }
    }
    private int numBuckets;
    private ArrayList<Entry>[] buckets;
    public HashTable(int numBuckets){
        this.numBuckets = numBuckets;
        this.buckets = new ArrayList[this.numBuckets];
        for(int index = 0; index<this.numBuckets;index++){
            this.buckets[index] = new ArrayList<>();
        }
    }
    public void add(K key,V value){
        int hashCode = this.getHash(key);
        boolean found = false;
        for(Entry e:this.buckets[hashCode]){
            if(e.matchBoth(key, value)){
                found = true;
                break;
            }
            else if(e.matchKey(key)){
                this.updateValue(key, value);
                found = true;
                break;
            }
        }
        if(!found)this.buckets[hashCode].add(new Entry(key,value));
    }
    public void delete(K key){
        int hashCode = this.getHash(key);
        boolean found = false;
        for(Entry e:this.buckets[hashCode]){
            if(e.matchKey(key)){
                this.buckets[hashCode].remove(e);
                found = true;
                break;
            }
        }
        if(!found){
            this.printErrorMsg(key);
        }
    }
    public void deleteAll(){
        for(ArrayList list:this.buckets){
            list.clear();
        }
    }
    public void updateValue(K key, V value){
        Entry found = this.find(key);
        if(found!=null){
            found.updateValue(value);
        }
    }
    public V lookUp(K key){
        Entry found = this.find(key);
        if(found!=null){
            return (V)found.getValue();
        }
        else{
            return null;
        }
    }
    private Entry find(K key){
        int hashCode = this.getHash(key);
        for(Entry e:this.buckets[hashCode]){
            if(e.matchKey(key)){
                return e;
            }
        }
        this.printErrorMsg(key);
        return null;
    }
    private void printErrorMsg(K key){
        if(key instanceof String){
            System.out.println("Key \""+key+"\" does NOT exist!");
        }
        else if(key instanceof Character){
            System.out.println("Key '"+key+"' does NOT exist!");
        }
        else{
            System.out.println("Key "+key+" does NOT exist!");
        }
    }
    private int getHash(K key){
        String keyStr = key.toString();
        char[] carray = keyStr.toCharArray();
        long hashCode = 0;
        int power = 0;
        for(char c:carray){
            hashCode += (int)(((int)c-32)*Math.pow(95, power));
            power++;
        }
        return (int)(hashCode%this.numBuckets);
    }
    public void printTable(){
        for(ArrayList list:this.buckets){
            System.out.println(list);
        }
    }
    public static void main(String[] args) {
        HashTable ht = new HashTable(11);
        ht.add("abc", 23);
        ht.add(23,"abc");
        ht.add(1.1, 'b');
        ht.add('1', 3);
        int[] i = {1,2,3};
        ht.add("1", i);
        ht.add(1,'c');
        ht.printTable();
        System.out.println();
        System.out.println("Add already entered \"abc\" with new value (23->\"22\")");
        ht.add("abc","22");
        System.out.println("Add already entered 23 with new value (\"abc\"->'z')");
        ht.add(23,'z');
        System.out.println("Add already entered 1.1 with new value ('b'->13)");
        ht.add(1.1,13);
        System.out.println("Add already entered '1' with new value (3->12.1)");
        ht.add('1',12.1);
        System.out.println("Add already entered \"1\" with new value (int[]->1111)");
        ht.add("1",1111);
        System.out.println("Add already entered 1 with new value ('c'->\"Bob\")");
        ht.add(1,"Bob");
        ht.printTable();
        System.out.println();
        System.out.println("Updating values back to originals");
        ht.updateValue("abc", 23);
        ht.updateValue(23, "abc");
        ht.updateValue(1.1, 'b');
        ht.updateValue('1', 3);
        ht.updateValue("1",i);
        ht.updateValue(1, 'c');
        ht.printTable();
        System.out.println();
        System.out.println("Looking up each key");
        System.out.print(ht.lookUp("abc")+" ");
        System.out.print(ht.lookUp(23)+" ");
        System.out.print(ht.lookUp(1.1)+" ");
        System.out.print(ht.lookUp('1')+" ");
        System.out.print(ht.lookUp("1")+" ");
        System.out.print(ht.lookUp(1)+" ");
        System.out.println();
        System.out.println("Deleting keys: 1, '1', and \"abc\"");
        ht.delete("abc");
        ht.delete(1);
        ht.delete('1');
        ht.printTable();
        System.out.println();
        System.out.println("Deleting ALL");
        ht.deleteAll();
        ht.printTable();
        System.out.println();
        System.out.println("Checking lookup, update, and delete on non-existent keys, respectively");
        ht.lookUp(1);
        ht.updateValue("1", 'x');
        ht.delete('1');
        
        System.out.println("\nAdding random elements");
        ht.add("this is a string", 42);
        ht.add("second string",231.232);
        ht.add("third string",'f');
        ht.add("fourth string", "some value");
        ht.add('a',54);
        ht.add('b',653.12321);
        ht.add('c','w');
        ht.add('d',"has key 'd'");
        ht.add(1,99);
        ht.add(2,99.99);
        ht.add(3,'y');
        ht.add(4,"filler");
        ht.add(1.11,5);
        ht.add(22.22,101.23);
        ht.add(.33,'r');
        ht.add(4444.44,"random");
        ht.printTable();
        System.out.println();
    }
}
