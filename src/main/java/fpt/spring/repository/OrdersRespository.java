package fpt.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fpt.spring.model.Orders;

public interface OrdersRespository extends JpaRepository<Orders, Integer> {

}
