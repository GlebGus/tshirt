package com.example.sqltestconnection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TShirtRepository extends JpaRepository<TShirt, Long> {
//    List<TShirt> findAllByOrderBySize();
    List<TShirt> findAllByOrderByPriceDesc();
   List<TShirt> findAllByOrderByPriceAsc();
//    List<TShirt> findAllByOrderByAvailable();
}
