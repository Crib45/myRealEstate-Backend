package com.stefanmilojevic.myRealEstate.service;

import com.stefanmilojevic.myRealEstate.model.ProfileComments;
import com.stefanmilojevic.myRealEstate.model.User;
import com.stefanmilojevic.myRealEstate.repository.ProfileCommentsRepository;
import com.stefanmilojevic.myRealEstate.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.List;

@Service
public class ProfileCommentsServiceImpl implements ProfileCommentsService {

    private final ProfileCommentsRepository profileCommentsRepository;

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public ProfileCommentsServiceImpl(ProfileCommentsRepository profileCommentsRepository) {
        this.profileCommentsRepository = profileCommentsRepository;
    }

    @Override
    public List<ProfileComments> getAllByUserId(Long userId) {
        return profileCommentsRepository.findAllByMadeFor_Id(userId);
    }

    @Override
    public List<ProfileComments> save(ProfileComments profileComments, HttpServletRequest request) {
        User user = userService.getByEmail(UserUtil.getEmailFromRequest(request));
        profileComments.setMadeBy(user);
        profileComments.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        profileCommentsRepository.save(profileComments);
        return profileCommentsRepository.findAllByMadeFor_Id(profileComments.getMadeFor().getId());
    }
}
