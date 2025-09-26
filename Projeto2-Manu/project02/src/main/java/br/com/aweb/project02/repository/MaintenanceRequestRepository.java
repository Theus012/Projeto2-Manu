package br.com.aweb.project02.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.aweb.project02.model.MaintenanceRequest;

public interface MaintenanceRequestRepository extends JpaRepository<MaintenanceRequest, Long> {
    
}