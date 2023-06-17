package my.edu.utem.ftmk.dad.restorderapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import my.edu.utem.ftmk.dad.restorderapp.model.OrderType;

public interface OrderTypeRepository extends JpaRepository<OrderType, Long> {
	
	public List<OrderType> findByNameContaining(String partName);
	
}
