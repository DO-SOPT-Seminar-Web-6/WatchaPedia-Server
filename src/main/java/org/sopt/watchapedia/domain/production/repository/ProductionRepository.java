package org.sopt.watchapedia.domain.production.repository;

import org.sopt.watchapedia.domain.production.domain.Production;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductionRepository extends JpaRepository<Production, Long> {
}
