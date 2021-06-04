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

    /**
     * Sets seen to true for all <code>Message</code> in list
     * @param messages List of <code>Message</code>
     * @return Success String
     */
    String markAsSeen(List<Message> messages);

    /**
     * Returns number of messages not seen by logged <code>User</code>
     * @param request <code>HttpServletRequest</code>
     * @return <code>int</code> Number of messages not seen
     */
    Integer getNumOfNotSeen(HttpServletRequest request);
}
