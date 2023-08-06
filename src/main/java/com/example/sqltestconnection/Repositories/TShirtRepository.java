package com.example.sqltestconnection.Repositories;

import com.example.sqltestconnection.Entities.TShirt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TShirtRepository extends JpaRepository<TShirt, Long> {
    //    List<TShirt> findAllByOrderBySize();
    List<TShirt> findAllByOrderByPriceDesc();

    List<TShirt> findAllByOrderByPriceAsc();

    List<TShirt> findBySize(String size);

    List<TShirt> findAllByOrderByAvailable();
}
