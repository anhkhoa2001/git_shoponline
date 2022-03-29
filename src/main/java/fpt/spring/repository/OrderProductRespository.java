package fpt.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fpt.spring.model.OrderProduct;

public interface OrderProductRespository extends JpaRepository<OrderProduct, Integer> {

}
