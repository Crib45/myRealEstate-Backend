package com.stefanmilojevic.myRealEstate.service;

import com.stefanmilojevic.myRealEstate.dto.NotificationDTO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface NotificationService {
    /**
     * Get all notifications for logged <code>User</code>
     * @param request <code>HttpServletRequest</code>
     * @return List of <code>NotificationDTO</code>
     */
    List<NotificationDTO> getAll(HttpServletRequest request);

    /**
     * Returns number of notifications not seen by logged <code>User</code>
     * @param request <code>HttpServletRequest</code>
     * @return <code>int</code> Number of messages not seen
     */
    Integer getNum(HttpServletRequest request);
}
