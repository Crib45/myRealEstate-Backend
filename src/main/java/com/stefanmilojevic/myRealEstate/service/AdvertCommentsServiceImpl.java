package com.stefanmilojevic.myRealEstate.service;

import com.stefanmilojevic.myRealEstate.model.AdvertComments;
import com.stefanmilojevic.myRealEstate.model.User;
import com.stefanmilojevic.myRealEstate.repository.AdvertCommentsRepository;
import com.stefanmilojevic.myRealEstate.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.Comparator;
import java.util.List;

@Service
public class AdvertCommentsServiceImpl implements AdvertCommentsService {

    private final AdvertCommentsRepository advertCommentsRepository;
    private UserService userService;

    @Autowired
    public void setAdvertisementService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public AdvertCommentsServiceImpl(AdvertCommentsRepository advertCommentsRepository) {
        this.advertCommentsRepository = advertCommentsRepository;
    }

    @Override
    public String save(AdvertComments advertComments, HttpServletRequest request) {
        String email = UserUtil.getEmailFromRequest(request);
        User user = userService.getByEmail(email);
        advertComments.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        advertComments.setMadeBy(user);
        advertCommentsRepository.save(advertComments);
        return "Success";
    }

    @Override
    public List<AdvertComments> getAllByAdvertId(Long advertId) {
        List<AdvertComments> advertCommentsList = advertCommentsRepository.findAllByAdvertisement_Id(advertId);
        advertCommentsList.sort(Comparator.comparing(AdvertComments::getCreatedAt).reversed());
        return advertCommentsList;
    }
}
