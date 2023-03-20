package org.example.collection;

public class Main {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable();
        hashTable.add("A"); hashTable.add("f");
        hashTable.add("B"); hashTable.add("H");
        hashTable.add("C"); hashTable.add("I");
        hashTable.add("x");
        hashTable.add("Y"); hashTable.add("J");
        hashTable.add("m"); hashTable.add("s");
        hashTable.add("z");
        hashTable.add(new String("N"));
        hashTable.add("Y");

        System.out.println(hashTable.contain("A"));

        for(Object items: hashTable.slot){
            System.out.println(items);
        }

        hashTable.remove("H");

        for (Object items : hashTable){
            System.out.println(items);
        }

    }
}
