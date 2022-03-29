package fpt.spring.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fpt.spring.model.Laptop;
import fpt.spring.model.PhoneTab;
import fpt.spring.repository.LaptopRespository;

@Service
@Transactional
public class LaptopService {
	
	@Autowired
	private LaptopRespository laptopRespository;
	
	public List<Laptop> findAll() {
		return laptopRespository.findAll();
	}
	
	public void save(Laptop laptop) {
		laptopRespository.save(laptop);
	}
	
	public void delete(String code) {
		int id = 0;
		List<Laptop> list = findAll();
		for(Laptop p:list) {
			if(p.getCode().equals(code)) {
				id = p.getLaptop_id();
			}
		}
		laptopRespository.delete(id);
    }
	
	public void update(Laptop laptop) {
		laptopRespository.save(laptop);
	}
	
	public Laptop findById(int id) {
		return laptopRespository.findOne(id);
	}
	
	public List<Laptop> findByCid(int cid) {
		List<Laptop> list = findAll();
		List<Laptop> list2 = new ArrayList<>();
		for(Laptop laptop:list) {
			if(laptop.getCategory().getId() == cid) {
				list2.add(laptop);
			}
		}
		
		return list2;
	}
	
	public List<Laptop> sortLaptopByPrice(int count, String type) {
		List<Laptop> list = laptopRespository.findAll();
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
		
		return list;
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
				List<Laptop> list2 = findAll();
				list.addAll(list2);
			} else {
				for (Object o : ids) {
	                List<Laptop> list2 = findByCid(((Long) o).intValue());
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
}
