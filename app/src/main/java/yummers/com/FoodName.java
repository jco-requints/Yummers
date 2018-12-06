package yummers.com;

public class FoodName {

    String id;
    String foodName;

    public FoodName(){

    }

    public FoodName(String id, String foodName){
        this.id = id;
        this.foodName = foodName;
    }

    public String getId(){
        return id;
    }
    public String getFoodName(){
        return foodName;
    }
}
