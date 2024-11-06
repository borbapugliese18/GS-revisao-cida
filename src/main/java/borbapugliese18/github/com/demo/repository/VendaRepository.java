package borbapugliese18.github.com.demo.repository;

import borbapugliese18.github.com.demo.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {
}
