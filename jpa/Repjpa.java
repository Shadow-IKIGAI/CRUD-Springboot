package server.tryout.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import server.tryout.model.Product;

public interface Repjpa extends JpaRepository<Product,Integer>{

}
