package com.programming.service;

import com.programming.model.User;
import com.programming.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    // by-default propagation level is REQUIRED i.e @Transactional(propagation = Propagation.REQUIRED)
    public String addUsers(List<User> users){

        System.out.println("Method started : addUsers() ");

        for(int i = 0; i< users.size();i++){
            User singleUser = users.get(i);
            addSingleUser(singleUser);
        }

        System.out.println("Method completed : addUsers() ");
        return "Users added Successfully";

    }


    /*
    @Transactional(propagation = Propagation.REQUIRED)
    - This is a default propagation level.
    - REQUIRED means supports a current transaction, create one if none exists.
     */

    /*
     @Transactional(propagation = Propagation.REQUIRES_NEW)
    - If we want to required a new transaction then we can use this propagation level.
    - It will suspend the previous transaction if any transaction exists
      and execute all this code as a part of a new transaction.
     */

    /*
     @Transactional(propagation = Propagation.NEVER)
    - It executes non-transactionally. It throws an exception if a transaction exists. i.e. IllegalTransactionException
     */

    /*
     @Transactional(propagation = Propagation.NOT_SUPPORTED)
    - It Execute non-transactionally , It suspends the current transaction if exists.
     */

    /*
     @Transactional(propagation = Propagation.MANDATORY)
    - It supports a current transaction, It throws an exception if none exists.
     */

    /*
     @Transactional(propagation = Propagation.SUPPORTS)
    - If there is transaction exists then it use this transaction. and if transaction is not exists
      then it will execute non-transactionally. It doesn't throws any exception.
     */
    public void addSingleUser(User user){
        userRepository.save(user);
        System.out.println("User Saved....");
    }

}
