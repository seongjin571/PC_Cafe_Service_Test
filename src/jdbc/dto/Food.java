package jdbc.dto;

public class Food {
   private String name;
   private int price;
   private String ingredients;
   public Food(){
      
   }
   public Food(String name, int price, String ingredients){
      this.name = name;
      this.price=price;
      this.ingredients=ingredients;
   }
   public String getName() {
      return name;
   }
   public int getPrice() {
      return price;
   }
   public String getIngredients() {
	      return ingredients;
   }
   
   public void setName(String name) {
      this.name = name;
   }
   public void setPrice(int price) {
	      this.price = price;
	   }
   public void setIngredients(String ingredients) {
	      this.ingredients = ingredients;
	   }
   public String toString() {
      return "name = " + name + ", price = "+price+", ingredient = "+ingredients;
   }

}