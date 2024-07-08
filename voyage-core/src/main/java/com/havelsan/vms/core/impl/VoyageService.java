package com.havelsan.vms.core.impl;

import com.havelsan.vms.core.api.VoyageServiceInterface;
import com.havelsan.vms.core.config.exception.ClassNotExistsException;
import com.havelsan.vms.data.dao.VoyageDao;
import com.havelsan.vms.data.dto.VoyageDto;
import org.springframework.stereotype.Service;
import com.havelsan.vms.repository.VoyageRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VoyageService implements VoyageServiceInterface {

    private final VoyageRepository voyageRepository;
    private final ObjectConverter objectConverter;

    public VoyageService(VoyageRepository voyageRepository, ObjectConverter objectConverter) {
        this.voyageRepository = voyageRepository;
        this.objectConverter = objectConverter;
    }

    @Override
    public VoyageDao getVoyageById(String id) {
        if(voyageRepository.findById(id).isPresent()){
            return voyageRepository.findById(id).get();
        }
        else{
            throw new ClassNotExistsException("Cannot find voyage by id: " + id);
        }
    }

    @Override
    public List<VoyageDao> getAllVoyages() {
        return voyageRepository.findAll();
    }

    @Override
    public VoyageDto addVoyage(VoyageDto voyageDto) {
        VoyageDao voyageDao = objectConverter.voyageDtoToVoyageDao(voyageDto);
        voyageRepository.save(voyageDao);
        return objectConverter.voyageDaoToVoyageDto(voyageDao);
    }

    @Override
    public VoyageDto updateVoyage(String voyageId, VoyageDto voyageDto){
        Optional<VoyageDao> voyageDaoOptional = voyageRepository.findById(voyageId);

        if(voyageDaoOptional.isPresent()){
            VoyageDao voyageDao = objectConverter.voyageDtoToVoyageDao(voyageDto, voyageId);
            voyageRepository.save(voyageDao);
            return objectConverter.voyageDaoToVoyageDto(voyageDao);
        }
        else {
            throw new ClassNotExistsException("Cannot find voyage by id: " + voyageId + ". Cannot update voyage.");
        }
    }

    @Override
    public VoyageDao updateVoyage(String voyageId, VoyageDao voyageDao){
        Optional<VoyageDao> voyageDaoOptional = voyageRepository.findById(voyageId);

        if(voyageDaoOptional.isPresent()){
            voyageDao.setId(voyageId);
            voyageRepository.save(voyageDao);
            return voyageDao;
        }
        else {
            throw new ClassNotExistsException("Cannot find voyage by id: " + voyageId + ". Cannot update voyage.");
        }
    }

    @Override
    public void deleteVoyage(String voyageId) {
        Optional<VoyageDao> voyageDaoOptional = voyageRepository.findById(voyageId);

        if(voyageDaoOptional.isPresent()){
            voyageRepository.deleteById(voyageId);
        }
        else{
            throw new ClassNotExistsException("Cannot find voyage by id: " + voyageId + ". Cannot delete voyage.");
        }
    }
}
