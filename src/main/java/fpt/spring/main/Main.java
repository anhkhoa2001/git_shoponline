package fpt.spring.main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.function.Consumer;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import fpt.spring.dao.DAO;
import fpt.spring.model.Category;
import fpt.spring.model.Laptop;
import fpt.spring.model.OrderProduct;
import fpt.spring.model.Orders;
import fpt.spring.model.PhoneTab;
import fpt.spring.model.Product;

public class Main {
	public static DAO dao = new DAO();
	public static final int dola = 22;
	public static final int CMID_PHONE = 1;
	public static final int CMID_TABLET = 2;
	public static final int CMID_LAPTOP = 3;
	
	
	public static final int ID_PHONE_IPHONE = 1;
	public static final int ID_PHONE_SAMSUNG = 2;
	public static final int ID_PHONE_XIAOMI = 3;
	public static final int ID_PHONE_OPPO = 4;
	public static final int ID_PHONE_NOKIA = 5;
	public static final int ID_PHONE_VIVO = 6;
	
	public static final String OPTION_SORT_PRICE_TOP = "top";
	public static final String OPTION_SORT_PRICE_BOT = "bot";
	public static final String OPTION_SORT_NAME_AZ = "az";
	public static final String OPTION_SORT_NAME_ZA = "za";
	
	public static final int COUNT_PRODUCT_LOAD = 9;
	
	public static DateTimeFormatter day = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	public static DateTimeFormatter hour = DateTimeFormatter.ofPattern("hh:mm:ss");
	public static LocalDate localDate = LocalDate.now();
	
	public static final int COUNT_TOP_CUSTOMER = 5;
	public static final int SIZE_TABLE_MANAGE = 10;
	
	public static void main(String[] args) {
		
		long startTime = System.nanoTime();
		//33490
		List<Laptop> list = dao.getAllLaptop();
		List<Laptop> list1 = Main.dao.sortLaptopByPrice(10, "desc");
		List<PhoneTab> list2 = dao.getAllPhoneTab();
		
		List<Category> list3 = dao.getAllCategory();
		PhoneTab product = dao.findPhoneTabByCode("IP_11PM256");
		List<PhoneTab> list6 = dao.getAllPhoneTabByID(3);
		
		List<PhoneTab> list7 = dao.sortPhoneTabByType("name", OPTION_SORT_NAME_AZ, list2);
		List<Laptop> list8 = dao.getAllLaptop();
		List<Laptop> list9 = dao.sortLaptopByType("name", OPTION_SORT_NAME_AZ, list8);
		List<Orders> list12 = dao.getAllOrders();
		List<OrderProduct> list13 = dao.getAllOrderProducts();
		
		
		Collections.sort(list, new Comparator<Laptop>() {
		    @Override
		    public int compare(Laptop p1, Laptop p2) {
		        return p1.getPrice() > p2.getPrice() ? -1 : (p1.getPrice() < p2.getPrice()) ? 1 : 0;
		    }
		});
		
		list.forEach(e -> {
			System.out.println(e.getPrice());
		});
		
		
		long endTime   = System.nanoTime();
		System.out.println(endTime - startTime);
		
	}
}
