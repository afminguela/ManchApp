package com.adulting101.ManchApp.repositories;

import com.adulting101.ManchApp.models.Sustancia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SustanciaRepository extends JpaRepository<Sustancia,Long> {
}
