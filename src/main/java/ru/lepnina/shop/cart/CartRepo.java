package ru.lepnina.shop.cart;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepo extends JpaRepository<Cart, Long> {

    List<Cart> findByActiveEquals(Boolean active);

    List<Cart> findCartByClientIdAndActiveEquals(Long id, Boolean active);

}
