package com.project.ey.bluepy.transfer.repositories;

import com.project.ey.bluepy.transfer.entities.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferRepository extends JpaRepository<Transfer,Long> {
}
