package jdbc.dto;

public class Food {
   private int id;
   private String name;
   private int price;
   private String ingredients;
   public Food(){
      
   }
   public Food(int id, String name, int price, String ingredients){
      this.id = id;
      this.name = name;
      this.price=price;
      this.ingredients=ingredients;
   }
   public int getId() {
      return id;
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
   
   public void setId(int id) {
      this.id = id;
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
      return "Id = " + id + ", name = " + name + ", price = "+price+", ingredient = "+ingredients;
   }

}