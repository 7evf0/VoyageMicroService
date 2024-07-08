package com.havelsan.vms.repository;

import com.havelsan.vms.data.dao.VoyageDao;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoyageRepository extends MongoRepository<VoyageDao, String> {

}
