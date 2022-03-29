package fpt.spring.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fpt.spring.model.Laptop;
import fpt.spring.model.Orders;
import fpt.spring.repository.OrdersRespository;

@Service
@Transactional
public class OrdersService {

	@Autowired
	private OrdersRespository ordersRespository;
	
	public List<Orders> findAll() {
		return ordersRespository.findAll();
	}
	
	public List<Orders> getOrderLimit(int count) {
		List<Orders> list = findAll();
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
	
	public Orders findById(int id) {
		return ordersRespository.findOne(id);
	}
	
	public void update(int id) {
		Orders orders = findById(id);
		orders.setStatus(true);
		ordersRespository.save(orders);
	}
	
	public void delete(int id) {
		ordersRespository.delete(id);
    }
}
