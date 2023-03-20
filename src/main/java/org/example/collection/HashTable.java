package org.example.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HashTable implements Iterable{
    Object[] slot = new Object[10];

    public HashTable() {
        for(int i = 0; i< slot.length; i++){
            slot[i] = new ArrayList<>();
        }
    }

    public void add(Object items) {
        int hashCode = items.hashCode();
        int index = hashCode % 10;
        List lists = (List) slot[index];
        if(lists.isEmpty()){
            lists.add(items);
        } else {
            boolean found = false;
            for(int i = 0; i<lists.size(); i++){
                if (lists.get(i).equals(items)){
                    found = true;
                    break;
                }
            }
            if(!found){
                lists.add(items);
            }
        }
    }
    public void remove(Object items){
        int hashCode = items.hashCode();
        int index = hashCode % 10;
        List lists = (List) slot[index];
        System.out.println("remove "+items.toString());

        if (contain(items)){
            for (int i = 0; i<lists.size(); i++){
                if(lists.get(i) != null && lists.get(i).equals(items)){
                    lists.remove(items);
                    System.out.println("remove successfully");
                }
            }
        } else {
            System.out.println("Don't have a element");
        }
    }

    public boolean contain(Object items) {
        int hashCode = items.hashCode();
        int index = hashCode % 10;
        List lists = (List) slot[index];
        for(int i = 0; i< lists.size();i++){
            if(lists.get(i) != null && lists.get(i).equals(items)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            int currentIndex;
            int currentSubIndex =0;

            @Override
            public boolean hasNext() {
                return currentIndex < slot.length;
            }

            @Override
            public Object next() {
                List currentSlot = (List) slot[currentIndex];
                while (currentSlot.isEmpty()) {
                    currentIndex++;
                    currentSubIndex = 0;
                    currentSlot = (List) slot[currentIndex];
                    return null;
                }
                if (currentIndex < slot.length) {
                    if (currentSubIndex < currentSlot.size()) {
                        if (currentSubIndex == currentSlot.size() - 1) {
                            currentIndex++;
                        }
                        Object  items = currentSlot.get(currentSubIndex++);
                        if(currentSubIndex == currentSlot.size()){
                            currentSubIndex = 0;
                        }
                        return items;
                    }
                }
                return null;
            }
        };
    }
}
