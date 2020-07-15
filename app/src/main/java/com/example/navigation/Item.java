package com.example.navigation;

public class Item {
    private int Image;
    private String Text1;
    private int Age;
    private String Text2;
    private String Text3;

    public Item(int image, String text1, int age, String text2, String text3){
        Image = image;
        Text1 = text1;
        Age = age;
        Text2 = text2;
        Text3 = text3;
    }

    public int getImage() {
        return Image;
    }

    public String getText1() {
        return Text1;
    }

    public int getAge() {
        return Age;
    }

    public String getText2() {
        return Text2;
    }

    public String getText3() {
        return Text3;
    }

}
