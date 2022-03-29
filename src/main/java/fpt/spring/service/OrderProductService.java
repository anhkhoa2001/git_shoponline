package fpt.spring.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fpt.spring.model.OrderProduct;
import fpt.spring.repository.OrderProductRespository;

@Service
@Transactional
public class OrderProductService {
	
	@Autowired
	private OrderProductRespository orderProductRespository;
	
	public List<OrderProduct> findAll() {
		return orderProductRespository.findAll();
	}
	
	public Map<String, Integer> getOrderProductLimit(int count) {
		List<OrderProduct> list = findAll();
		
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
}
