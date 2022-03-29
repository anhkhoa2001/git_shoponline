package fpt.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fpt.spring.model.Category;

public interface CategoryRespository extends JpaRepository<Category, Integer> {

}
