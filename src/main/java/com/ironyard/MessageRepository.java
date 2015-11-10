package com.ironyard;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by MattBrown on 11/10/15.
 */
public interface MessageRepository extends CrudRepository<Message, Integer> {

}
