package com.stefanmilojevic.myRealEstate.service;

import com.stefanmilojevic.myRealEstate.model.Message;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface MessageService {
    /**
     * Returns list of all <code>Message</code> for logged <code>User</code>
     * @param request <code>HttpServletRequest</code>
     * @return List of <code>Message</code>
     */
    List<Message> getAllByLogged(HttpServletRequest request);

    /**
     * Saves <code>Message</code> and returns updated list of <code>Message</code>
     * @param message <code>Message</code> for save
     * @param request <code>HttpServletRequest</code>
     * @return List of <code>Message</code>
     */
    List<Message> save(Message message, HttpServletRequest request);

    String markAsSeen(List<Message> messages);
}
