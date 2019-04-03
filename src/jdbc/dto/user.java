package jdbc.dto;


public class user {
   private int id;
   private String u_id;
   private String u_pw;
   private String u_email;
   private int u_price;
   public user(){
      
   }
   public user(String u_id, String u_pw, String u_email, int u_price){
      //this.id = id;
      this.u_id = u_id;
      this.u_pw = u_pw;
      this.u_email = u_email;
      this.u_price = u_price;
   }
   public user(String u_id, String u_pw, int u_price){
	  //this.id = id;
	  this.u_id = u_id;
	  this.u_pw = u_pw;
	  this.u_price = u_price;
	   }
   public int getId() {
      return id;
   }
   public String getU_id() {
      return u_id;
   }
   public String getU_pw() {
      return u_pw;
   }
   public String getU_email() {
	  return u_email;
   }
   public int getU_price() {
	  return u_price;
   }
   public void setId(int id) {
      this.id = id;
   }
   public void setU_id(String u_id) {
      this.u_id = u_id;
   }
   public void setU_pw(String u_pw) {
      this.u_pw = u_pw;
   }
   public void setU_email(String u_email) {
	  this.u_email = u_email;
   }
   public void setU_price(int u_price) {
	  this.u_price =  u_price;
	   }
   public String toString() {
      return "Id = " + id + ", u_id = " + u_id + ", u_pw = "+u_pw + ", u_email = "+u_email + ", u_price = "+u_price;
   }

}