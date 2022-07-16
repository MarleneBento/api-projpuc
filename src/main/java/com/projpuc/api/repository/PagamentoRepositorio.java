package com.projpuc.api.repository;

import com.projpuc.api.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepositorio extends JpaRepository<Pagamento,Long> {
}
