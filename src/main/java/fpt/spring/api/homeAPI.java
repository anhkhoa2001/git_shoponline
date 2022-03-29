package fpt.spring.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fpt.spring.main.Main;
import fpt.spring.model.Account;
import fpt.spring.model.Category;
import fpt.spring.model.Laptop;
import fpt.spring.model.OrderProduct;
import fpt.spring.model.Orders;
import fpt.spring.model.PhoneTab;
import fpt.spring.model.Product;
import fpt.spring.service.AccountService;
import fpt.spring.service.CategoryService;
import fpt.spring.service.LaptopService;
import fpt.spring.service.OrderProductService;
import fpt.spring.service.OrdersService;
import fpt.spring.service.PhoneTabService;

@Controller
public class homeAPI {
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private LaptopService laptopService;
	
	@Autowired
	private PhoneTabService phoneTabService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private OrdersService ordersService;

	@Autowired
	private OrderProductService orderProductService;
	
	@RequestMapping(value = "/apiproduct", method = RequestMethod.GET)
	@ResponseBody
	public List<Product> homeProduct() {
//		List<Product> list = Main.dao.getAllProduct();
		List<Product> list = new ArrayList<>();
		List<PhoneTab> list2 = phoneTabService.findAll();
		List<Laptop> list3 = laptopService.findAll();
		for(PhoneTab p : list2) {
			Product product = (Product) p;
			list.add(product);
		}
		
		for(Laptop l : list3) {
			Product product = (Product) l;
			list.add(product);
		}
		
		return list;
	}
	
	@RequestMapping(value = "/apiaccount", method = RequestMethod.GET)
	@ResponseBody
	public List<Account> apiAccount(HttpServletRequest request, Model model) {
		List<Account> list = accountService.findAll();
		
		return list;
	}
	
	@RequestMapping(value = "/apilaptop", method = RequestMethod.GET)
	@ResponseBody
	public List<Laptop> homeLaptop(HttpServletRequest request, Model model) {
		List<Laptop> list = laptopService.findAll();
		if(request.getParameter("count") != null) {
			int count = Integer.valueOf(request.getParameter("count"));
			String type = request.getParameter("type");
			if(type.equals("desc")) {
				Collections.sort(list, new Comparator<Laptop>() {
				    @Override
				    public int compare(Laptop p1, Laptop p2) {
				        return p1.getPrice() > p2.getPrice() ? -1 : (p1.getPrice() < p2.getPrice()) ? 1 : 0;
				    }
				});
			} else {
				Collections.sort(list, new Comparator<Laptop>() {
				    @Override
				    public int compare(Laptop p1, Laptop p2) {
				        return p1.getPrice() > p2.getPrice() ? 1 : (p1.getPrice() < p2.getPrice()) ? -1 : 0;
				    }
				});
			}
			
			list = list.subList(0, count);
		} 
		
		if(list.size() > Main.COUNT_PRODUCT_LOAD) {
			model.addAttribute("loadmore", true);
			List<Laptop> list2 = new ArrayList<>();
			for(int i=0; i<Main.COUNT_PRODUCT_LOAD; i++) {
				list2.add(list.get(i));
			}
			return list2;
		} else {
			return list;
		}
	}
	
	@RequestMapping(value = "/apilaptop", method = RequestMethod.PUT)
	@ResponseBody
	public List<Laptop> homePutLaptop(HttpServletRequest request, @RequestBody String data, Model model) {
		JSONParser parser = new JSONParser();  
		try {
			JSONObject json = (JSONObject) parser.parse(data);
			List<Laptop> list3 = laptopService.filterLaptop(json);
			int count = ((Long) json.get("count")).intValue();
			if(list3.size() > count) {
				List<Laptop> list4 = new ArrayList<>();
				for(int i=0; i<count; i++) {
					list4.add(list3.get(i));
				}
				return list4;
			} else {
				return list3;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	@RequestMapping(value = "/apiphone", method = RequestMethod.GET)
	@ResponseBody
	public List<PhoneTab> homeGetPhoneTab(HttpServletRequest request, Model model) {
		List<PhoneTab> list = phoneTabService.findAll();
		if(request.getParameter("count") != null) {
			int count = Integer.valueOf(request.getParameter("count"));
			String type = request.getParameter("type");
			if(type.equals("desc")) {
				Collections.sort(list, new Comparator<PhoneTab>() {
				    @Override
				    public int compare(PhoneTab p1, PhoneTab p2) {
				        return p1.getPrice() > p2.getPrice() ? -1 : (p1.getPrice() < p2.getPrice()) ? 1 : 0;
				    }
				});
			} else {
				Collections.sort(list, new Comparator<PhoneTab>() {
				    @Override
				    public int compare(PhoneTab p1, PhoneTab p2) {
				        return p1.getPrice() > p2.getPrice() ? 1 : (p1.getPrice() < p2.getPrice()) ? -1 : 0;
				    }
				});
			}
			
			list = list.subList(0, count);
			
			return list;
		} else {
			List<PhoneTab> list2 = new ArrayList<>();
			for(PhoneTab p:list) {
				if(p.getCategory().getCatemenu().getId() == 1) {
					list2.add(p);
				}
			}
		}
		
		if(list.size() > Main.COUNT_PRODUCT_LOAD) {
			model.addAttribute("loadmore", true);
			List<PhoneTab> list2 = new ArrayList<>();
			for(int i=0; i<Main.COUNT_PRODUCT_LOAD; i++) {
				list2.add(list.get(i));
			}
			return list2;
		} else {
			return list;
		}
	}
	
	@RequestMapping(value = "/apiphone/size", method = RequestMethod.PUT)
	@ResponseBody
	public int sizePhone(HttpServletRequest request, @RequestBody String data) {
		JSONParser parser = new JSONParser();  
		try {
			JSONObject json = (JSONObject) parser.parse(data);
			List<PhoneTab> list3 = phoneTabService.filterPhoneTab(json, 1);
			return list3.size();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	@RequestMapping(value = "/apitablet/size", method = RequestMethod.PUT)
	@ResponseBody
	public int sizeTablet(HttpServletRequest request, @RequestBody String data) {
		JSONParser parser = new JSONParser();  
		try {
			JSONObject json = (JSONObject) parser.parse(data);
			List<PhoneTab> list3 = phoneTabService.filterPhoneTab(json, 2);
			return list3.size();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	@RequestMapping(value = "/apilaptop/size", method = RequestMethod.PUT)
	@ResponseBody
	public int sizeLaptop(HttpServletRequest request, @RequestBody String data) {
		JSONParser parser = new JSONParser();  
		try {
			JSONObject json = (JSONObject) parser.parse(data);
			List<Laptop> list3 = laptopService.filterLaptop(json);
			return list3.size();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	@RequestMapping(value = "/apiphone", method = RequestMethod.PUT)
	@ResponseBody
	public List<PhoneTab> homePutPhoneTab(HttpServletRequest request, @RequestBody String data) {
		JSONParser parser = new JSONParser();  
		try {
			JSONObject json = (JSONObject) parser.parse(data);
			List<PhoneTab> list3 = phoneTabService.filterPhoneTab(json, 1);
			int count = ((Long) json.get("count")).intValue();
			if(list3.size() > count) {
				List<PhoneTab> list4 = new ArrayList<>();
				for(int i=0; i<count; i++) {
					list4.add(list3.get(i));
				}
				return list4;
			} else {
				return list3;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	@RequestMapping(value = "/apitablet", method = RequestMethod.PUT)
	@ResponseBody
	public List<PhoneTab> homePutTablet(HttpServletRequest request, @RequestBody String data, Model model) {
		JSONParser parser = new JSONParser();  
		try {
			JSONObject json = (JSONObject) parser.parse(data);
			List<PhoneTab> list3 = phoneTabService.filterPhoneTab(json, 2);
			int count = ((Long) json.get("count")).intValue();
			if(list3.size() > count) {
				model.addAttribute("loadmore", true);
				List<PhoneTab> list4 = new ArrayList<>();
				for(int i=0; i<count; i++) {
					list4.add(list3.get(i));
				}
				return list4;
			} else {
				return list3;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	@RequestMapping(value = "/apitablet", method = RequestMethod.GET)
	@ResponseBody
	public List<PhoneTab> homeTablet(HttpServletRequest request, Model model) {
		List<PhoneTab> list = phoneTabService.getAllPhoneTabBycmID(2);
		
		if(list.size() > Main.COUNT_PRODUCT_LOAD) {
			model.addAttribute("loadmore", true);
			List<PhoneTab> list2 = new ArrayList<>();
			for(int i=0; i<Main.COUNT_PRODUCT_LOAD; i++) {
				list2.add(list.get(i));
			}
			return list2;
		} else {
			return list;
		}
	}
	
	
	
	
	@RequestMapping(value = "/apicategory", method = RequestMethod.GET)
	@ResponseBody
	public List<Category> homeCategory(HttpServletRequest request, Model model) {
		int cmID = request.getParameter("cmID") == null ? 0 : Integer.valueOf(request.getParameter("cmID"));
		List<Category> list = new ArrayList<>();
		if(cmID == 0) {
			list = categoryService.findAll();
		} else {
			list = categoryService.getAllCategoryBycmID(cmID);
		}
		return list;
	}
	
	@RequestMapping(value = "/apicart", method = RequestMethod.PUT)
	@ResponseBody
	public List<Product> homeCart(HttpServletRequest request, Model model, @RequestBody String data) {
		List<Product> list = new ArrayList<>();
		List<String> listCode = new ArrayList<>();
		JSONParser parser = new JSONParser();  
		try {
			JSONArray json = (JSONArray) parser.parse(data);
			for(int i=0; i<json.size(); i++) {
				JSONObject jsonObject = (JSONObject) json.get(i);
				listCode.add(jsonObject.get("key").toString());
			}
			List<Laptop> listLaptops = laptopService.findAll();
			for(int j=0; j<listCode.size(); j++) {
				for(int i=0; i<listLaptops.size(); i++) {
					if(listCode.get(j).equals(listLaptops.get(i).getCode())) {
						Product product = (Product) listLaptops.get(i);
						list.add(product);
					}
				}
			}
			
			List<PhoneTab> listPhoneTabs = phoneTabService.findAll();
			for(int j=0; j<listCode.size(); j++) {
				for(int i=0; i<listPhoneTabs.size(); i++) {
					if(listCode.get(j).equals(listPhoneTabs.get(i).getCode())) {
						Product product = (Product) listPhoneTabs.get(i);
						list.add(product);
					}
				}
			}

			return list;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	@RequestMapping(value = "/apimanage/chart", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public List<Integer> apiManageChartOne(HttpServletRequest request, Model model) {
		String number = request.getParameter("number");
		List<Integer> list = new ArrayList<>();
		if(number.equals("one")) {
			List<Orders> list2 = ordersService.findAll();
			
			for(int i=1; i<=12; i++) {
				String month = String.format("%02d", i) + "-2022";
				int count = 0;
				for(Orders o : list2) {
					if(o.getCreated().contains(month)) {
						count++;
					}
				}
				list.add(count);
			}
			
			return list;
		} else {
			List<OrderProduct> list2 = orderProductService.findAll();
			for(int i=1; i<=3; i++) {
				int count = 0;
				for(OrderProduct op : list2) {
					if(op.getCategory().getCatemenu().getId() == i) {
						count += op.getQuantity();
					}
				}
				list.add(count);
			}
			return list;
		}
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/apimanage/table/one", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String apiManageTabletOne(HttpServletRequest request, Model model) {
		JSONArray jsonArray = new JSONArray();
		List<OrderProduct> list2 = orderProductService.findAll();
		for(int i=1; i<=3; i++) {
			JSONObject jsonObject = new JSONObject();
			String device = "";
			int count = 0, total = 0;
			for(OrderProduct op : list2) {
				if(op.getCategory().getCatemenu().getId() == i) {
					count += op.getQuantity();
					device = op.getCategory().getCatemenu().getLine();
					total += op.getTotal();
				}
			}
			jsonObject.put("device", device);
			jsonObject.put("quantity", count);
			jsonObject.put("total", total);
			jsonObject.put("avg", total/count);
			jsonArray.add(jsonObject);
		}
		return jsonArray.toJSONString();
	}
	
	@RequestMapping(value = "/apimanage/table/two", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public List<Orders> apiManageTabletTwo(HttpServletRequest request, Model model) {
		List<Orders> list = ordersService.getOrderLimit(Main.COUNT_TOP_CUSTOMER);
		
		return list;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/apimanage/table/three", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String apiManageTabletThree(HttpServletRequest request, Model model) {
		Map<String, Integer> map = orderProductService.getOrderProductLimit(Main.COUNT_TOP_CUSTOMER);
		JSONArray jsonArray = new JSONArray();
		
		Set<Entry<String, Integer>> set = map.entrySet();
	    List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(set);
	    Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {

	        @Override
	        public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {

	            return o2.getValue().compareTo(o1.getValue());
	        }
	    });
		
	    list = list.subList(0, Main.COUNT_TOP_CUSTOMER);
	    
	    for(Entry<String, Integer> entry : list) {
	    	String code = entry.getKey();
	    	Product product = null;
	    	List<Laptop> listLaptops = laptopService.findAll();
			for(int i=0; i<listLaptops.size(); i++) {
				if(code.equals(listLaptops.get(i).getCode())) {
					product = (Product) listLaptops.get(i);
				}
			}
			
			List<PhoneTab> listPhoneTabs = phoneTabService.findAll();
			for(int i=0; i<listPhoneTabs.size(); i++) {
				if(code.equals(listPhoneTabs.get(i).getCode())) {
					product = (Product) listPhoneTabs.get(i);
				}
			}
	    	int quantity = entry.getValue();
	    	JSONObject jsonObject = new JSONObject();
	    	jsonObject.put("code", code);
	    	jsonObject.put("quantity", quantity);
	    	jsonObject.put("name", product.getName());
	    	jsonObject.put("image", product.getImage());
	    	jsonObject.put("price", product.getPriceDola());
	    	jsonArray.add(jsonObject);
	    }
	    
		return jsonArray.toJSONString();
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/apimanage/product", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String apiManageProduct(HttpServletRequest request, Model model) {
		List<Product> list = new ArrayList<>();
		List<Laptop> listLaptops = laptopService.findAll();
		for(int i=0; i<listLaptops.size(); i++) {
			Product product = (Product) listLaptops.get(i);
			list.add(product);
		}
		
		List<PhoneTab> listPhoneTabs = phoneTabService.findAll();
		for(int i=0; i<listPhoneTabs.size(); i++) {
			Product product = (Product) listPhoneTabs.get(i);
			list.add(product);
		}
		
		String search = request.getParameter("search");
		if(!search.equals("")) {
			List<Product> list2 = new ArrayList<>();
			for(Product product : list) {
				if(product.getName().toLowerCase().contains(search.toLowerCase())) {
					list2.add(product);
				}
			}
			list = list2;
		} 
		
		int countPage = list.size()%Main.SIZE_TABLE_MANAGE == 0 ? 
				list.size()/Main.SIZE_TABLE_MANAGE : list.size()/Main.SIZE_TABLE_MANAGE + 1;
		int start = (request.getParameter("start") != null) ? Integer.parseInt(request.getParameter("start")) : 0;
		int end = (request.getParameter("end") != null) ? Integer.parseInt(request.getParameter("end")) : 0;
		
		List<Product> list2 = new ArrayList<>();
		end = (end >= list.size()) ? list.size() - 1 : end;
		for(int i=start; i<=end; i++) {
			list2.add(list.get(i));
		}
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("countPage", countPage);
		JSONArray jsonArray = new JSONArray();
		for(int i=0; i<list2.size(); i++) {
			JSONObject jsonObject2 = new JSONObject();
			jsonObject2.put("code", list2.get(i).getCode());
			jsonObject2.put("image", list2.get(i).getImage());
			jsonObject2.put("name", list2.get(i).getName());
			jsonObject2.put("line", list2.get(i).getCategory().getLine());
			jsonObject2.put("lineCatemenu", list2.get(i).getCategory().getCatemenu().getLine().toLowerCase());
			jsonObject2.put("quantity", list2.get(i).getQuantityStock());
			jsonObject2.put("price", list2.get(i).getPriceDola());
			jsonArray.add(jsonObject2);
		}
		jsonObject.put("data", jsonArray);
		
		return jsonObject.toJSONString();
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/apimanage/orders", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String apiManageOrder(HttpServletRequest request, Model model) {
		List<Orders> list = ordersService.findAll();
		String search = request.getParameter("search");
//		if(!search.equals("")) {
//			List<Orders> list2 = new ArrayList<>();
//			for(Orders o : list) {
//				if(o.getName().toLowerCase().contains(search.toLowerCase())) {
//					list2.add(o);
//				}
//			}
//			list = list2;
//		} 
		int countPage = list.size()%Main.SIZE_TABLE_MANAGE == 0 ? 
				list.size()/Main.SIZE_TABLE_MANAGE : list.size()/Main.SIZE_TABLE_MANAGE + 1;
		int start = (request.getParameter("start") != null) ? Integer.parseInt(request.getParameter("start")) : 0;
		int end = (request.getParameter("end") != null) ? Integer.parseInt(request.getParameter("end")) : 0;
		
		List<Orders> list2 = new ArrayList<>();
		end = (end >= list.size()) ? list.size() - 1 : end;
		for(int i=start; i<=end; i++) {
			list2.add(list.get(i));
		}
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("countPage", countPage);
		JSONArray jsonArray = new JSONArray();
		for(int i=0; i<list2.size(); i++) {
			JSONObject jsonObject2 = new JSONObject();
			jsonObject2.put("ordinal", list2.get(i).getId());
			jsonObject2.put("name", list2.get(i).getName());
			jsonObject2.put("email", list2.get(i).getEmail());
			jsonObject2.put("quantity", list2.get(i).getQuantity());
			jsonObject2.put("created", list2.get(i).getCreated());
			jsonObject2.put("price", list2.get(i).getTotal());
			jsonArray.add(jsonObject2);
		}

		jsonObject.put("data", jsonArray);
		return jsonObject.toJSONString();
	}
		
	
	@RequestMapping(value = "/apimanage/orders/view", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
	@ResponseBody
	public List<OrderProduct> apiManageOrderPut(HttpServletRequest request, Model model) {
		List<OrderProduct> list2 = orderProductService.findAll();
		int id = request.getParameter("id") != null ? Integer.parseInt(request.getParameter("id")) : 0;
		List<OrderProduct> list = new ArrayList<>();
		for(OrderProduct orderProduct : list2) {
			if(orderProduct.getOrders().getId() == id) {
				String name = orderProductService.convertCodeToString(orderProduct.getCode());
				orderProduct.setCode(name);
				list.add(orderProduct);
			}
		}
		
		return list;
	}
		
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/apimanage/account", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String apiManageAccount(HttpServletRequest request, Model model) {
		List<Account> list = accountService.findAll();
		List<Account> list2 = new ArrayList<>();
		for(Account account : list) {
			if(!account.getRole().equals("ADMIN")) {
				list2.add(account);
			}
		}
		
		int countPage = list2.size()%Main.SIZE_TABLE_MANAGE == 0 ? 
				list2.size()/Main.SIZE_TABLE_MANAGE : list2.size()/Main.SIZE_TABLE_MANAGE + 1;
		int start = (request.getParameter("start") != null) ? Integer.parseInt(request.getParameter("start")) : 0;
		int end = (request.getParameter("end") != null) ? Integer.parseInt(request.getParameter("end")) : 0;
		
		List<Account> list3 = new ArrayList<>();
		end = (end >= list.size()) ? list.size() - 1 : end;
		for(int i=start; i<=end; i++) {
			list3.add(list.get(i));
		}
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("countPage", countPage);
		JSONArray jsonArray = new JSONArray();
		for(int i=0; i<list3.size(); i++) {
			JSONObject jsonObject2 = new JSONObject();
			jsonObject2.put("ordinal", list3.get(i).getId());
			jsonObject2.put("username", list3.get(i).getUsername());
			jsonObject2.put("name", list3.get(i).getName());
			jsonObject2.put("email", list3.get(i).getEmail());
			jsonObject2.put("password", list3.get(i).getPassword());
			jsonObject2.put("created", list3.get(i).getDate());
			jsonObject2.put("address", list3.get(i).getAddress());
			jsonObject2.put("phone", list3.get(i).getPhone());
			jsonObject2.put("role", list3.get(i).getRole());
			jsonArray.add(jsonObject2);
		}
	
		jsonObject.put("data", jsonArray);
		return jsonObject.toJSONString();
	}
	
	@RequestMapping(value = "/apimanage/product/add", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String apiManageProductAdd(HttpServletRequest request, Model model, @RequestBody String data) {
		String line = request.getParameter("line");
		JSONParser parser = new JSONParser();
		if(line.equals("phone") || line.equals("tablet")) {
			try {
				JSONObject jsonObject = (JSONObject) parser.parse(data);
				String name = jsonObject.get("name").toString();
				String code = jsonObject.get("code").toString();
				int quantity = ((Long) jsonObject.get("quantity")).intValue();
				int price = ((Long) jsonObject.get("price")).intValue();
				String screen = jsonObject.get("screen").toString();
				String chip = jsonObject.get("chip").toString();
				String ram = jsonObject.get("ram").toString();
				String front = jsonObject.get("front").toString();
				String back = jsonObject.get("back").toString();
				String memory = jsonObject.get("memory").toString();
				String file = jsonObject.get("file").toString();
				PhoneTab phoneTab = new PhoneTab(name, code, price*Main.dola, quantity, screen, front, back, chip, memory, ram, file);
				System.out.println(phoneTab.getCode());
				Category category = categoryService.findCategory(code);
				phoneTab.setCategory(category);
				System.out.println(phoneTab.getCode());
				phoneTabService.save(phoneTab);
				return "1";
			} catch (ParseException e) {
				e.printStackTrace();
			}
		} else {
			try {
				JSONObject jsonObject = (JSONObject) parser.parse(data);
				String name = jsonObject.get("name").toString();
				String code = jsonObject.get("code").toString();
				int quantity = ((Long) jsonObject.get("quantity")).intValue();
				int price = ((Long) jsonObject.get("price")).intValue();
				String display = jsonObject.get("display").toString();
				String card = jsonObject.get("card").toString();
				String ram = jsonObject.get("ram").toString();
				String cpu = jsonObject.get("cpu").toString();
				String w = jsonObject.get("weight").toString();
				float weight = Float.valueOf(w);
				String size = jsonObject.get("size").toString();
				String memory = jsonObject.get("memory").toString();
				String file = jsonObject.get("file").toString();
				Laptop laptop = new Laptop(name, code, price, quantity, display, memory, cpu, ram, card, weight, size, file);
				
				Category category = categoryService.findCategory(code);
				laptop.setCategory(category);
				
				laptopService.save(laptop);
				return "1";
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	
	@RequestMapping(value = "/apimanage/product/edit", method = RequestMethod.GET)
	@ResponseBody
	public Product apiManageProductEdit(HttpServletRequest request) {
		String code = request.getParameter("code") == null ? "error" : request.getParameter("code");
		System.out.println(code);
		Product product = null;
    	List<Laptop> listLaptops = laptopService.findAll();
		for(int i=0; i<listLaptops.size(); i++) {
			if(code.equals(listLaptops.get(i).getCode())) {
				product = (Product) listLaptops.get(i);
			}
		}
		
		List<PhoneTab> listPhoneTabs = phoneTabService.findAll();
		for(int i=0; i<listPhoneTabs.size(); i++) {
			if(code.equals(listPhoneTabs.get(i).getCode())) {
				product = (Product) listPhoneTabs.get(i);
			}
		}
		if(product.getCategory().getCatemenu().getId() == Main.CMID_PHONE || 
			product.getCategory().getCatemenu().getId() == Main.CMID_TABLET) {
			PhoneTab phoneTab = (PhoneTab) product;
			return phoneTab;
		} else {
			Laptop laptop = (Laptop) product;
			return laptop;
		}
	}
	
	@RequestMapping(value = "/apimanage/product/edit", method = RequestMethod.PUT)
	@ResponseBody
	public String apiManageProductEdit(HttpServletRequest request, Model model, @RequestBody String data) {
		String line = request.getParameter("line");
		JSONParser parser = new JSONParser();
		if(line.equals("phone") || line.equals("tablet")) {
			try {
				JSONObject jsonObject = (JSONObject) parser.parse(data);
				int id = ((Long) jsonObject.get("id")).intValue();
				String name = jsonObject.get("name").toString();
				String code = jsonObject.get("code").toString();
				int quantity = ((Long) jsonObject.get("quantity")).intValue();
				int price = ((Long) jsonObject.get("price")).intValue();
				String screen = jsonObject.get("screen").toString();
				String chip = jsonObject.get("chip").toString();
				String ram = jsonObject.get("ram").toString();
				String front = jsonObject.get("front").toString();
				String back = jsonObject.get("back").toString();
				String memory = jsonObject.get("memory").toString();
				String file = jsonObject.get("file").toString();
				PhoneTab phoneTab2 = Main.dao.findPhoneTab(id);
				phoneTab2.setCode(code);
				phoneTab2.setName(name);
				phoneTab2.setQuantityStock(quantity);
				phoneTab2.setPrice(price*Main.dola);
				phoneTab2.setScreen(screen);
				phoneTab2.setChip(chip);
				phoneTab2.setRam(ram);
				phoneTab2.setFrontCamera(front);
				phoneTab2.setBackCamera(back);
				phoneTab2.setMemory(memory);
				if(!file.contains("undefined")) {
					phoneTab2.setImage(file);
				}
				
				Category category = categoryService.findCategory(code);
				phoneTab2.setCategory(category);
				phoneTabService.update(phoneTab2);
				return "1";
			} catch (ParseException e) {
				e.printStackTrace();
			}
		} else {
			try {
				JSONObject jsonObject = (JSONObject) parser.parse(data);
				int id = ((Long) jsonObject.get("id")).intValue();
				String name = jsonObject.get("name").toString();
				String code = jsonObject.get("code").toString();
				int quantity = ((Long) jsonObject.get("quantity")).intValue();
				int price = ((Long) jsonObject.get("price")).intValue();
				String display = jsonObject.get("display").toString();
				String card = jsonObject.get("card").toString();
				String ram = jsonObject.get("ram").toString();
				String cpu = jsonObject.get("cpu").toString();
				String w = jsonObject.get("weight").toString();
				float weight = Float.valueOf(w);
				String size = jsonObject.get("size").toString();
				String memory = jsonObject.get("memory").toString();
				String file = jsonObject.get("file").toString();
				
				Laptop laptop = Main.dao.findLaptop(id);
				laptop.setCode(code);
				laptop.setName(name);
				laptop.setQuantityStock(quantity);
				laptop.setPrice(price*Main.dola);
				laptop.setDisplay(display);
				laptop.setWeight(weight);
				laptop.setSize(size);
				laptop.setRam(ram);
				laptop.setCpu(cpu);
				laptop.setCard(card);
				laptop.setMemory(memory);
				if(!file.contains("undefined")) {
					laptop.setImage(file);
				}
				
				Category category = categoryService.findCategory(code);
				laptop.setCategory(category);
				laptopService.update(laptop);
				return "1";
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	@RequestMapping(value = "/apimanage/product/delete", method = RequestMethod.GET)
	@ResponseBody
	public String apiManageProductDelete(HttpServletRequest request) {
		String code = request.getParameter("code");
		String line = request.getParameter("line");
		if(line.equals("laptop")) {
			laptopService.delete(code);
		} else {
			phoneTabService.delete(code);
		}
		
		return "1";
	}
	
	@RequestMapping(value = "/apimanage/orders/delete", method = RequestMethod.GET)
	@ResponseBody
	public String apiManageOrdersDelete(HttpServletRequest request) {
		int id = request.getParameter("id") == null ? 0 : Integer.valueOf(request.getParameter("id"));
		ordersService.delete(id);
		return "1";
	}
	
	@RequestMapping(value = "/apimanage/notification", method = RequestMethod.GET)
	@ResponseBody
	public List<Orders> apiManageNotification(HttpServletRequest request) {
		List<Orders> list = new ArrayList<>();
		List<Orders> list2 = ordersService.findAll();
		for(Orders o:list2) {
			if(!o.isStatus()) {
				list.add(o);
			}
		}
		
		for(Orders o:list) {
			ordersService.update(o.getId());
		}
		
		return list;
	}
	
	@RequestMapping(value = "/apimanage/contact/delete", method = RequestMethod.GET)
	@ResponseBody
	public String apiManageContactDelete(HttpServletRequest request) {
		String username = request.getParameter("username");
		accountService.delete(username);
		
		return "1";
	}
	
	@RequestMapping(value = "/registor", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String registor(HttpServletRequest request, @RequestBody String data, Model model) {
		JSONParser parser = new JSONParser();  
		try {
			JSONObject jsonObject = (JSONObject) parser.parse(data);
			String name = jsonObject.get("name").toString();
			String phone = jsonObject.get("phone").toString();
			String email = jsonObject.get("email").toString();
			String username = jsonObject.get("username").toString();
			String pass = jsonObject.get("pass").toString();
			String address = jsonObject.get("address").toString();
			String role = "CUSTOMER";
			String date = Main.day.format(Main.localDate);
			
			Account account = new Account(username, address, role, date, email, name, pass, phone);
			accountService.save(account);
			return "1";
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
