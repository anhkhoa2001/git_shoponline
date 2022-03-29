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

import fpt.spring.model.Category;
import fpt.spring.model.PhoneTab;
import fpt.spring.repository.PhoneTabRespository;

@Service
@Transactional
public class PhoneTabService {
	
	@Autowired
	private PhoneTabRespository phoneTabRespository;
	
	public List<PhoneTab> findAll() {
		return phoneTabRespository.findAll();
	}
	
	public void save(PhoneTab phoneTab) {
		phoneTabRespository.save(phoneTab);
    }
	
	public void update(PhoneTab phoneTab) {
		
		phoneTabRespository.save(phoneTab);
    }
	
	public void delete(String code) {
		int id = 0;
		List<PhoneTab> list = findAll();
		for(PhoneTab p:list) {
			if(p.getCode().equals(code)) {
				id = p.getPhonetab_id();
			}
		}
		phoneTabRespository.delete(id);
    }
	
	public List<PhoneTab> getAllPhoneTabBycmID(int cmID) {
		List<PhoneTab> list = findAll();
		List<PhoneTab> list2 = new ArrayList<>();
		for(PhoneTab p:list) {
			if(p.getCategory().getCatemenu().getId() == cmID) {
				list2.add(p);
			}
		}
		
		return list2;
	}
	
	public List<PhoneTab> findByCid(int cid) {
		List<PhoneTab> list = phoneTabRespository.findAll();
		List<PhoneTab> list2 = new ArrayList<>();
		for(PhoneTab p:list) {
			if(p.getCategory().getId() == cid) {
				list2.add(p);
			}
		}
		
		return list2;
	}
	
	public List<PhoneTab> sortPhoneTabByPrice(int count, String type) {
		List<PhoneTab> list = phoneTabRespository.findAll();
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
	                List<PhoneTab> list2 = findByCid(((Long)o).intValue());
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

}
