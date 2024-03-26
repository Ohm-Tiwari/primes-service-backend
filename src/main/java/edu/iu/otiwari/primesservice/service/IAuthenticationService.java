package edu.iu.otiwari.primesservice.service;

import edu.iu.otiwari.primesservice.model.Customer;

import java.io.IOException;

public interface IAuthenticationService {

    boolean register(Customer customer) throws IOException;

    boolean login(String username, String password) throws IOException;
}
