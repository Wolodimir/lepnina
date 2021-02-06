package ru.lepnina.shop.client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepo extends JpaRepository<Client, Long> {

    Optional<Client> findByPhoneNumber(String PhoneNumber);

    List<Client> findByActiveEquals(Boolean active);
}
