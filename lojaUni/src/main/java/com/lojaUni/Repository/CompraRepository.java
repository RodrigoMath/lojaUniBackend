package com.lojaUni.Repository;

import com.lojaUni.Model.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {

    Compra findById(long id);

    Compra save(Compra compra);
}
