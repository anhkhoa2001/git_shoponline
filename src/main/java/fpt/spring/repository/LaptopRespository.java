package fpt.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fpt.spring.model.Laptop;

public interface LaptopRespository extends JpaRepository<Laptop, Integer> {
	
}
