package my.edu.utem.ftmk.dad.restorderapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import my.edu.utem.ftmk.dad.restorderapp.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
