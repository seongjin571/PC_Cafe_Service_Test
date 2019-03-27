package jdbc.dto;

public class Stock {
   private String name;
   private int count;
   public Stock(){
      
   }
   public Stock(String name, int count){
      this.name = name;
      this.count=count;
   }
   
   public String getName() {
      return name;
   }
   public int getCount() {
      return count;
   }
   
   public void setName(String name) {
      this.name = name;
   }
   public void setCount(int count) {
	      this.count = count;
	   }
   
   public String toString() {
      return "name = " + name + ", count = "+count;
   }

}