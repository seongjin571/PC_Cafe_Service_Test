package jdbc.ex;

import jdbc.dao.*;
import jdbc.dto.*;
import java.util.*;


public class jdbcEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String menu="아이스티";//메뉴가 주문되었다고 가정
		PCDao PCDao=new PCDao();
		Food food=PCDao.getFood(menu);
		System.out.println(food);
		String[] ingredient=food.getIngredients().split(",");//주문된 음식의 재료를 나눠서 String에 저장
		for(int i=0;i<ingredient.length;i++) {//재고 수가 1개 이거나 2개 이므로 배열에 길이에 맞춰 반복
			PCDao.useStock(ingredient[i]);//재고 수를 한 개씩 줄여줌
		}
		//실행 후 stock table 확인하면 해당 재고 수가 하나씩 감소함
		managerGUI stock=new managerGUI();
		stock.showStock();
	}

}
