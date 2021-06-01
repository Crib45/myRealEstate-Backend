package com.stefanmilojevic.myRealEstate.service;

import com.stefanmilojevic.myRealEstate.model.Message;
import com.stefanmilojevic.myRealEstate.model.User;
import com.stefanmilojevic.myRealEstate.repository.MessageRepository;
import com.stefanmilojevic.myRealEstate.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public List<Message> getAllByLogged(HttpServletRequest request) {
        String email = UserUtil.getEmailFromRequest(request);
        User user = userService.getByEmail(email);
        return messageRepository.findAllBySenderOrReceiver(user,user);
    }

    @Override
    public List<Message> save(Message message, HttpServletRequest request) {
        String email = UserUtil.getEmailFromRequest(request);
        User user = userService.getByEmail(email);
        message.setSender(user);
        message.setSeen(false);
        message.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        messageRepository.saveAndFlush(message);
        return messageRepository.findAllBySenderOrReceiver(user, user);
    }

    @Override
    public String markAsSeen(List<Message> messages) {
        for (Message message: messages) {
            message.setSeen(true);
        }
        messageRepository.saveAll(messages);
        return "Success";
    }
}
