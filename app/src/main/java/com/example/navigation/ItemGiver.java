package com.example.navigation;

import java.util.ArrayList;

public class ItemGiver {
    public static ArrayList<Item> items = new ArrayList<>();
    private static ItemGiver itemGiver = null;

    public static ItemGiver getInstance() {
        if (itemGiver == null) {
            itemGiver = new ItemGiver();
        }
        return itemGiver;
    }


    private ItemGiver() {
        items.add(new Item(1, "Kapil Pandey", 23, "Bhaktapur", "male"));
        items.add(new Item(1, "Kp Oli", 70, "Jhapa", "male"));
        items.add(new Item(1, "Bibek Tamang", 69, "Kathmandu ", "male"));
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        if (item.getId() <= 0) {
           item.setId(items.size() + 1);
        }
        items.add(0, item);
        int i = 0;
    }

    public void deleteItem(Item item){
        // error
        for(Item i : items){
            if (i.getId() == item.getId()){
                items.remove(i);
            }
        }
    }
}