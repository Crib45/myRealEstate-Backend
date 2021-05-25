package com.stefanmilojevic.myRealEstate.service;

import com.stefanmilojevic.myRealEstate.model.Advertisement;
import com.stefanmilojevic.myRealEstate.model.AdvertisementPicture;
import com.stefanmilojevic.myRealEstate.repository.AdvertisementPictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class AdvertisementPictureServiceImpl implements AdvertisementPictureService {

    private final AdvertisementPictureRepository advertisementPictureRepository;
    private final AdvertisementService advertisementService;

    @Autowired
    public AdvertisementPictureServiceImpl(AdvertisementPictureRepository advertisementPictureRepository,
                                           AdvertisementService advertisementService) {
        this.advertisementService = advertisementService;
        this.advertisementPictureRepository = advertisementPictureRepository;
    }

    @Override
    public List<AdvertisementPicture> getAllByAdvertisementId(Long advertisementId) {
        return advertisementPictureRepository.findAllByAdvertisement_Id(advertisementId);
    }

    @Override
    public String save(MultipartFile file, Long advertisementId) throws IOException {
        Advertisement advertisement = advertisementService.getById(advertisementId);
        AdvertisementPicture advertisementPicture = new AdvertisementPicture();
        advertisementPicture.setFileName(file.getOriginalFilename());
        advertisementPicture.setContentType(file.getContentType());
        advertisementPicture.setFileData(file.getBytes());
        advertisementPicture.setAdvertisement(advertisement);
        advertisementPicture.setPrimaryPic(false);
        advertisementPictureRepository.save(advertisementPicture);
        return "Success";
    }

    @Override
    public String delete(int id) {
        advertisementPictureRepository.deleteById(id);
        return "Success";
    }

    @Override
    public AdvertisementPicture setPrimaryById(Long advertisementId, int id) {
        List<AdvertisementPicture> advertisementPictureList;
        advertisementPictureList = advertisementPictureRepository.findAllByAdvertisement_Id(advertisementId);
        for(AdvertisementPicture advertisementPicture : advertisementPictureList){
            advertisementPicture.setPrimaryPic(advertisementPicture.getId() == id);
        }
        advertisementPictureRepository.saveAll(advertisementPictureList);
        return advertisementPictureRepository.findById(id);
    }

    @Override
    public AdvertisementPicture getPrimaryByAdvertisementId(Long advertisementId) {
        return advertisementPictureRepository.findByPrimaryPicIsTrueAndAdvertisement_Id(advertisementId);
    }
}
