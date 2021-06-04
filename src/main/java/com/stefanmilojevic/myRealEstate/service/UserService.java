package com.stefanmilojevic.myRealEstate.service;

import com.stefanmilojevic.myRealEstate.model.User;

public interface UserService {
    /**
     * Creates new <code>User</code>
     * @param user <code>User</code>
     * @return Succes string
     */
    String createUser(User user);

    /**
     * Returns <code>User</code> by email param
     * @param email <code>String</code>
     * @return <code>User</code> found
     */
    User getByEmail(String email);

    /**
     * Compares 2 password strings
     * @param password <code>String</code>
     * @param passwordTwo <code>String</code>
     * @return <code>boolean</code> True if passwords match
     */
    boolean comparePasswords(String password, String passwordTwo);

    /**
     * Return <code>User</code>
     * @param id id of <code>User</code>
     * @return Found <code>User</code>
     */
    User getById(Long id);

    /**
     * Save <code>User</code> by given <code>User</code> object
     * @param user <code>User</code>
     * @return Success string
     */
    String save(User user);
}
