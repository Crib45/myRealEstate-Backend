package com.stefanmilojevic.myRealEstate.service;

import com.stefanmilojevic.myRealEstate.model.SavedFilter;
import com.stefanmilojevic.myRealEstate.model.User;
import com.stefanmilojevic.myRealEstate.repository.SavedFilterRepository;
import com.stefanmilojevic.myRealEstate.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.List;

@Service
public class SavedFilterServiceImpl implements SavedFilterService {

    private final SavedFilterRepository savedFilterRepository;
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public SavedFilterServiceImpl(SavedFilterRepository savedFilterRepository) {
        this.savedFilterRepository = savedFilterRepository;
    }

    @Override
    public List<SavedFilter> getAllForLogged(HttpServletRequest request) {
        String email = UserUtil.getEmailFromRequest(request);
        User user = userService.getByEmail(email);
        return savedFilterRepository.findAllByUser(user);
    }

    @Override
    public String delete(Long id) {
        savedFilterRepository.deleteById(id);
        return "Success";
    }

    @Override
    public String save(SavedFilter savedFilter, HttpServletRequest request) {
        String email = UserUtil.getEmailFromRequest(request);
        User user = userService.getByEmail(email);
        savedFilter.setLastChecked(new Timestamp(System.currentTimeMillis()));
        savedFilter.setUser(user);
        savedFilterRepository.save(savedFilter);
        return "Success";
    }
}
