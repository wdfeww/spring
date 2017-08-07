package model;

import aspects.Loggable;

public class Circle {

   private String name;

    @Loggable
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
