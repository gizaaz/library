package com.japs.lab5db.repository;

import com.japs.lab5db.model.DeliveryNDeleting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryNDeletingRepository extends JpaRepository<DeliveryNDeleting,Integer> {
}
