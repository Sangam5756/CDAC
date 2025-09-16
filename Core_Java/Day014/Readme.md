<!-- in the -->

in the hashset the tc is O(1) for insertion and also for the retrival
the reason is that internally hashset uses the hashing techinque which allows us to insert the element at constant time
.
steps what the internally happens in java

HashSet<Type> hset = new HashSet<>();
 - init capacity = 16
 - size = 0

in memory  0 .......15  intially store the ref as null

 


1. when we try to add the element in hashset 
that time first thing jvm call the hashcode method wihich returns the hashcode;
so using that hashcode.
2. using that hashcode it checks there is any bucket which has same hashcode.
    - if Not 
        - then it will insert the elemenet there by calling add method
        - this add method will return true
    - if Yes
        - if yes then it will call the equals method which will be called by jvm 
        - depends on the numbers of elements in it.
        - as if that equals method return true then its duplicate

        EQUALS METHOD
        - TRUE -> if method return true then the duplicate so no add, add() method return false
        - FALSE -> if false then eleement get added and then sets add method return true



internally the hashtable is get creted for each hash 
and for storing the eleemtn it uses the Singly linklist 
            - each node consist of
              - hash(hash value) , element , Next(Pointer)
            



BETTER UNDERSTANDING 
 - copy the code from MemoryDemo.java and paste in the visualizer
 - (visualize internal working)[https://pythontutor.com/visualize.html#mode=edit]
    