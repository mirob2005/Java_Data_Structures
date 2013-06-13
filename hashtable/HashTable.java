// Produce own hash codes as an exercise rather than using hashCode() method.

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
            return this.key==key;
        }
        @Override
        public String toString(){
            if(this.key instanceof String){
                return ("\""+this.key+"\": "+this.value);
            }
            else if(this.key instanceof Character){
                return ("'"+this.key+"': "+this.value);
            }
            else{
                return (""+this.key+": "+this.value);
            }
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
        String keyStr = key.toString();
        int hashCode = this.getHash(keyStr);
        boolean found = false;
        for(Entry e:this.buckets[hashCode%this.numBuckets]){
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
        if(!found)this.buckets[hashCode%this.numBuckets].add(new Entry(key,value));
    }
    public void delete(K key){
        throw new UnsupportedOperationException("Feature Not Yet Implemented!");
    }
    public void updateValue(K key, V value){
        throw new UnsupportedOperationException("Feature Not Yet Implemented!");
    }
    public V lookUp(K key){
        throw new UnsupportedOperationException("Feature Not Yet Implemented!");
    }
    private int getHash(String key){
        char[] carray = key.toCharArray();
        int hashCode = 0;
        int power = 0;
        for(char c:carray){
            hashCode += (int)(((int)c-32)*Math.pow(95, power));
            power++;
        }
        return hashCode;
    }
    public void printTable(){
        for(ArrayList list:this.buckets){
            System.out.println(list);
        }
    }
    public static void main(String[] args) {
        HashTable ht = new HashTable(10);
        ht.add("abc", 23);
        ht.add(1, "bob");
        ht.add('1', 22);
        ht.add("1", 23.1);
        ht.printTable();
    }
}
