package com.havelsan.vms.repository;

import com.havelsan.vms.data.dao.ShipDao;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipRepository extends MongoRepository<ShipDao, String> {
}
