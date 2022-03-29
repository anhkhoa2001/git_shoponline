package fpt.spring.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import fpt.spring.config.JPAUtils;
import fpt.spring.main.Main;
import fpt.spring.model.Account;
import fpt.spring.model.Category;
import fpt.spring.model.Catemenu;
import fpt.spring.model.Laptop;
import fpt.spring.model.OrderProduct;
import fpt.spring.model.Orders;
import fpt.spring.model.PhoneTab;
import fpt.spring.model.Product;

public class DAO {
	
	//ACCOUNT
	///////////////////////////////////////////////////////////////////////////////////////////////
	public List<Account> getAllAccount() {
		EntityManager em = JPAUtils.getEntityManager();
		TypedQuery<Account> typedQuery = em.createNamedQuery("Account.findAll", Account.class);
		
		return typedQuery.getResultList();
	}
	
	public Account findAccountByUsername(String username) {
		EntityManager em = JPAUtils.getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		Account account = new Account();
		List<Account> list = getAllAccount();
		int id = 0;
		for(Account account2 : list) {
			if(account2.getUsername().equals(username)) {
				id = account2.getId();
			}
		}
		
		try {
			transaction.begin();
			
			account = em.find(Account.class, id);
			
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			em.close();
		}
		
		return account;
	}
	
//	//PRODUCT
//	/////////////////////////////////////////////////////////////////////////////////////////////////
	
	public PhoneTab findPhoneTabByCode(String code) {
		EntityManager em = JPAUtils.getEntityManager();
		
		String jql = "Select f from PhoneTab as f where f.id = 1 ";
		Query barQuery = em.createQuery(jql, PhoneTab.class);
		PhoneTab p = (PhoneTab) barQuery.getSingleResult();
		return p;
	}
	
//	public Product findProduct(int id) {
//		EntityManager em = JPAUtils.getEntityManager();
//		EntityTransaction transaction = em.getTransaction();
//		Product product = new Product();
//		
//		try {
//			transaction.begin();
//			
//			product = em.find(Product.class, id);
//			
//			transaction.commit();
//		} catch (Exception e) {
//			e.printStackTrace();
//			transaction.rollback();
//		} finally {
//			em.close();
//		}
//		
//		return product;
//	}
//	
	
	public List<Product> getAllProduct() {
		List<Product> list = new ArrayList<>();
		List<Laptop> listLaptops = Main.dao.getAllLaptop();
		for(Laptop laptop:listLaptops) {
			Product product = (Product) laptop;
			list.add(product);
		}
		
		List<PhoneTab> listPhoneTabs = Main.dao.getAllPhoneTab();
		for(PhoneTab p:listPhoneTabs) {
			Product product = (Product) p;
			list.add(product);
		}
		
		return list;
	}
	
	public List<Product> getAllProductByListCode(List<String> listCode) {
		List<Product> list = new ArrayList<>();
		
		for(String string : listCode) {
			Product product = findProductByCode(string);
			list.add(product);
		}
		
		return list;
	}
	
	public Product findProductByCode(String code) {
		List<Laptop> list1 = getAllLaptop();
		List<PhoneTab> list2 = getAllPhoneTab();
		Product product = null;
		for(Product p : list1) {
			if(code.equals(p.getCode())) {
				product = p;
			}
		}
		
		for(Product p : list2) {
			if(code.equals(p.getCode())) {
				product = p;
			}
		}
		
		return product;
	}

//	
//	public Product updateProduct(Product product) {
//		EntityManager em = JPAUtils.getEntityManager();
//		EntityTransaction transaction = em.getTransaction();
//		try {
//			transaction.begin();
//
//			em.merge(product);
//			
//			transaction.commit();
//		} catch (Exception e) {
//			e.printStackTrace();
//			transaction.rollback();
//		} finally {
//			em.close();
//		}
//		return product;
//	}
//	
//	public List<Product> getProductByID(int start, int count) {
//		EntityManager em = JPAUtils.getEntityManager();
//		TypedQuery<Product> typedQuery = em.createNamedQuery("Product.findAll", Product.class);
//		typedQuery.setFirstResult(start);
//		typedQuery.setMaxResults(count);
//		
//		
//		return typedQuery.getResultList();
//	}
//	
//	//desc tu cao toi thap
//	// asc nguoc lai
//	public List<Product> sortProductByPrice(int count, String type) {
//		EntityManager em = JPAUtils.getEntityManager();
//		String jql = type != null ? "Select f from Product as f order by f.price " + type : "Select f from Product as f";
//		Query barQuery = em.createQuery(jql);
//		List<Product> list =  barQuery.setMaxResults(count).getResultList();
//		
//		return list;
//	}
	
	//PHONETAB
	////////////////////////////////////////////////////////////////////////////////////////////
	public List<PhoneTab> getAllPhoneTab() {
		EntityManager em = JPAUtils.getEntityManager();
		TypedQuery<PhoneTab> typedQuery = em.createNamedQuery("PhoneTab.findAll", PhoneTab.class);
		
		return typedQuery.getResultList();
	}
	
	public List<PhoneTab> sortPhoneTabByType(String type, String value, List<PhoneTab> oldList) {
		if(type.equals("default")) {
			
		} else if(type.equals("price")) {
			if(value.equals("top")) {
				Collections.sort(oldList, new Comparator<PhoneTab>() {
				    @Override
				    public int compare(PhoneTab p1, PhoneTab p2) {
				        return p1.getPrice() > p2.getPrice() ? -1 : (p1.getPrice() < p2.getPrice()) ? 1 : 0;
				    }
				});
			} else {
				Collections.sort(oldList, new Comparator<PhoneTab>() {
				    @Override
				    public int compare(PhoneTab p1, PhoneTab p2) {
				        return p1.getPrice() > p2.getPrice() ? 1 : (p1.getPrice() < p2.getPrice()) ? -1 : 0;
				    }
				});
			}
		} else {
			if(value.equals("az")) {
				Collections.sort(oldList, new Comparator<PhoneTab>() {
				    @Override
				    public int compare(PhoneTab p1, PhoneTab p2) {
				        return p1.getCode().compareTo(p2.getCode());
				    }
				});
			} else {
				Collections.sort(oldList, new Comparator<PhoneTab>() {
				    @Override
				    public int compare(PhoneTab p1, PhoneTab p2) {
				        return p2.getCode().compareTo(p1.getCode());
				    }
				});
			}
		}
		return oldList;
	}
	
	public boolean updatePhoneTab(PhoneTab phoneTab, int id) {
		EntityManager em = JPAUtils.getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		String before = null, last = null;
		try {
			transaction.begin();
			PhoneTab phoneTab2 = em.find(PhoneTab.class, id);
			before = phoneTab2.toString();
			phoneTab2 = phoneTab;
			phoneTab2.setPhonetab_id(id);
			em.merge(phoneTab2);
			last = em.find(PhoneTab.class, id).toString();
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			em.close();
		}
		return !before.equals(last);
	}
	
	public PhoneTab findPhoneTab(int id) {
		EntityManager em = JPAUtils.getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		PhoneTab phoneTab = new PhoneTab();
		
		try {
			transaction.begin();
			
			phoneTab = em.find(PhoneTab.class, id);
			
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			em.close();
		}
		
		return phoneTab;
	}
	
	public Product addPhoneTab(PhoneTab phoneTab) {
		EntityManager em = JPAUtils.getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		
		try {
			transaction.begin();
			
			 em.persist(phoneTab);
			
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			em.close();
		}
		
		return phoneTab;
	}
	
	public void deletePhoneTab(String code) {
		EntityManager em = JPAUtils.getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		int id = 0;
		for(PhoneTab p : getAllPhoneTab()) {
			if(p.getCode().equals(code)) {
				id = p.getPhonetab_id();
			}
		}
		try {
			transaction.begin();
			PhoneTab phoneTab = em.find(PhoneTab.class, id);
			em.remove(phoneTab);
			
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			em.close();
		}
	}
	
	
	
	@SuppressWarnings("unchecked")
	public List<PhoneTab> sortPhoneTabByPrice(int count, String type) {
		EntityManager em = JPAUtils.getEntityManager();
		String jql = type != null ? "Select f from PhoneTab as f order by f.price " + type : 
										"Select f from PhoneTab as f";
		Query barQuery = em.createQuery(jql);
		List<PhoneTab> list =  barQuery.setMaxResults(count).getResultList();
		
		return list;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<PhoneTab> getAllPhoneTabByID(int id) {
		EntityManager em = JPAUtils.getEntityManager();
		String jql = "Select f from PhoneTab as f where f.category.id = " + id;
		Query barQuery = em.createQuery(jql);
		List<PhoneTab> list =  barQuery.getResultList();
		
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public List<PhoneTab> getAllPhoneTabBycmID(int cmID) {
		EntityManager em = JPAUtils.getEntityManager();
		String jql = "Select f from PhoneTab as f where f.category.catemenu.id = " + cmID;
		Query barQuery = em.createQuery(jql);
		List<PhoneTab> list =  barQuery.getResultList();
		
		return list;
	}
	
	public List<PhoneTab> filterPhoneTab(JSONObject json, int cmID) {
		List<PhoneTab> list = new ArrayList<>();
		JSONArray ids = (JSONArray) json.get("id");
		int top = ((Long) json.get("top")).intValue();
		int bot = ((Long) json.get("bot")).intValue();
		JSONObject sort = (JSONObject) json.get("sort");
		String type = sort.get("type").toString();
		String value = sort.get("value").toString();
		if (ids != null) {
			if(ids.size() == 0) {
				List<PhoneTab> list2 = getAllPhoneTabBycmID(cmID);
				list.addAll(list2);
			} else {
				for (Object o : ids) {
	                List<PhoneTab> list2 = getAllPhoneTabByID(((Long) o).intValue());
	                list.addAll(list2);
	            }
			}
        } else {
            System.out.println("error");
        }
		
		List<PhoneTab> list2 = new ArrayList<>();
		if(top == 0 || (top == 0 && bot == 0)) {
			list2 = list;
		} else {
			for(PhoneTab p : list) {
				if(p.getPriceDola() >= bot && p.getPriceDola() <= top) {
					list2.add(p);
				}
			}
		}
		List<PhoneTab> list3 = sortPhoneTabByType(type, value, list2);
		return list3;
	}
	
	//LAPTOP
	/////////////////////////////////////////////////////////////////////////////////////////

	public void deleteLaptop(String code) {
		EntityManager em = JPAUtils.getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		int id = 0;
		for(Laptop laptop : getAllLaptop()) {
			if(laptop.getCode().equals(code)) {
				id = laptop.getLaptop_id();
			}
		}
		try {
			transaction.begin();
			Laptop laptop = em.find(Laptop.class, id);
			 em.remove(laptop);
			
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			em.close();
		}
	}
	
	public Laptop findLaptop(int id) {
		EntityManager em = JPAUtils.getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		Laptop laptop = new Laptop();
		
		try {
			transaction.begin();
			
			laptop = em.find(Laptop.class, id);
			
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			em.close();
		}
		
		return laptop;
	}
	
	public Product addLaptop(Laptop laptop) {
		EntityManager em = JPAUtils.getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		
		try {
			transaction.begin();
			
			em.persist(laptop);
			
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			em.close();
		}
		
		return laptop;
	}
	
	public boolean updateLaptop(Laptop laptop, int id) {
		EntityManager em = JPAUtils.getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		String before = null, last = null;
		try {
			transaction.begin();

			Laptop laptop2 = em.find(Laptop.class, id);
			before = laptop2.toString();
			laptop2 = laptop;
			laptop2.setLaptop_id(id);
			em.merge(laptop2);
			last = em.find(Laptop.class, id).toString();
			
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			em.close();
		}
		return !before.equals(last);
	}
	
	
	public List<Laptop> filterLaptop(JSONObject json) {
		List<Laptop> list = new ArrayList<>();
		JSONArray ids = (JSONArray) json.get("id");
		int top = ((Long) json.get("top")).intValue();
		int bot = ((Long) json.get("bot")).intValue();
		JSONObject sort = (JSONObject) json.get("sort");
		String type = sort.get("type").toString();
		String value = sort.get("value").toString();
		if (ids != null) {
			if(ids.size() == 0) {
				List<Laptop> list2 = getAllLaptop();
				list.addAll(list2);
			} else {
				for (Object o : ids) {
	                List<Laptop> list2 = getAllLaptopByID(((Long) o).intValue());
	                list.addAll(list2);
	            }
			}
        } else {
            System.out.println("error");
        }
		
		List<Laptop> list2 = new ArrayList<>();
		if(top == 0 || (top == 0 && bot == 0)) {
			list2 = list;
		} else {
			for(Laptop p : list) {
				if(p.getPriceDola() >= bot && p.getPriceDola() <= top) {
					list2.add(p);
				}
			}
		}
		List<Laptop> list3 = sortLaptopByType(type, value, list2);
		return list3;
	}
	
	public List<Laptop> getAllLaptop() {
		EntityManager em = JPAUtils.getEntityManager();
		TypedQuery<Laptop> typedQuery = em.createNamedQuery("Laptop.findAll", Laptop.class);
		
		return typedQuery.getResultList();
	}
	
	public List<Laptop> sortLaptopByType(String type, String value, List<Laptop> oldList) {
		if(type.equals("default")) {
			
		} else if(type.equals("price")) {
			if(value.equals("top")) {
				Collections.sort(oldList, new Comparator<Laptop>() {
				    @Override
				    public int compare(Laptop p1, Laptop p2) {
				        return p1.getPrice() > p2.getPrice() ? -1 : (p1.getPrice() < p2.getPrice()) ? 1 : 0;
				    }
				});
			} else {
				Collections.sort(oldList, new Comparator<Laptop>() {
				    @Override
				    public int compare(Laptop p1, Laptop p2) {
				        return p1.getPrice() > p2.getPrice() ? 1 : (p1.getPrice() < p2.getPrice()) ? -1 : 0;
				    }
				});
			}
		} else {
			if(value.equals("az")) {
				Collections.sort(oldList, new Comparator<Laptop>() {
				    @Override
				    public int compare(Laptop p1, Laptop p2) {
				        return p1.getCode().compareTo(p2.getCode());
				    }
				});
			} else {
				Collections.sort(oldList, new Comparator<Laptop>() {
				    @Override
				    public int compare(Laptop p1, Laptop p2) {
				        return p2.getCode().compareTo(p1.getCode());
				    }
				});
			}
		}
		return oldList;
	}
	
	@SuppressWarnings("unchecked")
	public List<Laptop> getAllLaptopByID(int id) {
		EntityManager em = JPAUtils.getEntityManager();
		String jql = "Select f from Laptop as f where f.category.id = " + id;
		Query barQuery = em.createQuery(jql);
		List<Laptop> list =  barQuery.getResultList();
		
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public List<Laptop> sortLaptopByPrice(int count, String type) {
		EntityManager em = JPAUtils.getEntityManager();
		String jql = type != null ? "Select l from Laptop as l order by l.price " + type : 
										"Select f from Laptop as f";
		Query barQuery = em.createQuery(jql);
		List<Laptop> list =  barQuery.setMaxResults(count).getResultList();
		
		return list;
	}
	
	
	
	//CATEGORY
	/////////////////////////////////////////////////////////////////////////////////////////
	public int convertCodeToID(String code) {
		List<Category> list = getAllCategory();
		int id = 0;
		for(Category c:list) {
			if(c.getCode() != null && code.contains(c.getCode())) {
				id = c.getId();
			}
		}
		
		return id;
	}
	
	public List<Category> getAllCategory() {
		EntityManager em = JPAUtils.getEntityManager();
		TypedQuery<Category> typedQuery = em.createNamedQuery("Category.findAll", Category.class);
		
		return typedQuery.getResultList();
	}
	
	public Category findCategory(int id) {
		EntityManager em = JPAUtils.getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		Category category = new Category();
		
		try {
			transaction.begin();
			
			category = em.find(Category.class, id);
			
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			em.close();
		}
		
		return category;
	}
	
	@SuppressWarnings("unchecked")
	public List<Category> getAllCategoryBycmID(int cmID) {
		EntityManager em = JPAUtils.getEntityManager();
		String jql = "Select l from Category as l where l.catemenu.id = " + cmID;
		Query barQuery = em.createQuery(jql);
		List<Category> list =  barQuery.getResultList();
		
		return list;
	}
	
	public void addAccount(Account account) {
		EntityManager em = JPAUtils.getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		
		try {
			transaction.begin();
			
			em.persist(account);
			
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			em.close();
		}
		
	}
	

	//ORDER
	/////////////////////////////////////////////////////////////////////////////////////////
	public void addOrder(Orders order) {
		EntityManager em = JPAUtils.getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		
		try {
			transaction.begin();
			
			em.persist(order);
			
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			em.close();
		}
		
	}
	
	public void addOrderProduct(OrderProduct order) {
		EntityManager em = JPAUtils.getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		
		try {
			transaction.begin();
			
			em.persist(order);
			
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			em.close();
		}
		
	}
	
	public List<Catemenu> getAllCatemenus() {
		EntityManager em = JPAUtils.getEntityManager();
		TypedQuery<Catemenu> typedQuery = em.createNamedQuery("Catemenu.findAll", Catemenu.class);
		
		return typedQuery.getResultList();
	}
	
	public List<Orders> getAllOrders() {
		EntityManager em = JPAUtils.getEntityManager();
		TypedQuery<Orders> typedQuery = em.createNamedQuery("Orders.findAll", Orders.class);
		
		return typedQuery.getResultList();
	}
	
	public List<OrderProduct> getAllOrderProducts() {
		EntityManager em = JPAUtils.getEntityManager();
		TypedQuery<OrderProduct> typedQuery = em.createNamedQuery("OrderProduct.findAll", OrderProduct.class);
		
		return typedQuery.getResultList();
	}
	
	public List<Orders> getAllOrdersByCreated(String timer) {
		List<Orders> list = new ArrayList<>();
		for(Orders o : getAllOrders()) {
			if(o.getCreated().equals(timer)) {
				list.add(o);
			}
		}
		
		return list;
	}
	
	
	public List<Orders> getOrderLimit(int count) {
		List<Orders> list = getAllOrders();
		Collections.sort(list, new Comparator<Orders>() {
		    @Override
		    public int compare(Orders p1, Orders p2) {
		        return p1.getTotal() > p2.getTotal() ? -1 : (p1.getTotal() < p2.getTotal()) ? 1 : 0;
		    }
		});
		
		if(list.size() <= count) {
			return list;
		} else {
			List<Orders> second = new ArrayList<Orders>(list.subList(0, count));
			return second;
		}
	}
	
	public Map<String, Integer> getOrderProductLimit(int count) {
		List<OrderProduct> list = getAllOrderProducts();
		
		Map<String, Integer> map = new HashMap<>();
		for(int i=0; i<list.size(); i++) {
			
			if(map.size() > 0) {
				String code = list.get(i).getCode();
				int val = 0;
				for (String entry : map.keySet()) {
				    if(entry.equals(code)) {
				    	int value = map.get(entry) + list.get(i).getQuantity();
				    	map.put(entry, value);
				    	val++;
				    }
				}
				if(val == 0) {
					map.put(list.get(i).getCode(), list.get(i).getQuantity());
				}
			} else {
				map.put(list.get(i).getCode(), list.get(i).getQuantity());
			}
		}
		return map;
	}
	
	@SuppressWarnings("unchecked")
	public String filterTableProduct(HttpServletRequest request, List<Product> list) {
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
	public String filterTableOrders(HttpServletRequest request, List<Orders> list) {
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
	
	
	@SuppressWarnings("unchecked")
	public String filterTableContact(HttpServletRequest request, List<Account> list) {
		int countPage = list.size()%Main.SIZE_TABLE_MANAGE == 0 ? 
					list.size()/Main.SIZE_TABLE_MANAGE : list.size()/Main.SIZE_TABLE_MANAGE + 1;
		int start = (request.getParameter("start") != null) ? Integer.parseInt(request.getParameter("start")) : 0;
		int end = (request.getParameter("end") != null) ? Integer.parseInt(request.getParameter("end")) : 0;
		
		List<Account> list2 = new ArrayList<>();
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
			jsonObject2.put("username", list2.get(i).getUsername());
			jsonObject2.put("name", list2.get(i).getName());
			jsonObject2.put("email", list2.get(i).getEmail());
			jsonObject2.put("password", list2.get(i).getPassword());
			jsonObject2.put("created", list2.get(i).getDate());
			jsonObject2.put("address", list2.get(i).getAddress());
			jsonObject2.put("phone", list2.get(i).getPhone());
			jsonObject2.put("role", list2.get(i).getRole());
			jsonArray.add(jsonObject2);
		}

		jsonObject.put("data", jsonArray);
		return jsonObject.toJSONString();
	}
	
	public void deleteAccount(String username) {
		EntityManager em = JPAUtils.getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		List<Account> list = getAllAccount();
		int id = 0;
		for(Account account2 : list) {
			if(account2.getUsername().equals(username)) {
				id = account2.getId();
			}
		}
		try {
			transaction.begin();
			Account account = em.find(Account.class, id);
			 em.remove(account);
			
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			em.close();
		}
	}
	
	public boolean deleteOrders(int id) {
		EntityManager em = JPAUtils.getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		int before = getAllOrders().size();
		try {
			transaction.begin();
			Orders order = em.find(Orders.class, id);
			em.remove(order);
			
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			em.close();
		}
		int last = getAllOrders().size();
		return before > last;
	}
	
	public boolean createAccount(Account account) {
		EntityManager em = JPAUtils.getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		int before = getAllAccount().size();
		try {
			transaction.begin();
			
			em.persist(account);
			
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			em.close();
		}
		System.out.println(before);
		int last = getAllAccount().size();
		System.out.println(last);
		return before < last;
	}
	
	
	public void updateOrders(int id) {
		EntityManager em = JPAUtils.getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			Orders orders = em.find(Orders.class, id);
			orders.setStatus(true);
			em.merge(orders);
			
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			em.close();
		}
	}
	
}
