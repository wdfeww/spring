package model;

public class Circle {

   private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String name(){
        return name;
    }

    public String setAndReturn(String name){
        this.name = name;
        return this.name;
    }
}
