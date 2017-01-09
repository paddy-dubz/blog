package com.codeup;

import org.hibernate.Session;

import java.util.List;

/**
 * Created by Patrick on 1/5/17.
 */
public interface Posts {

    List<Post> findAll();

    void save(Post post);

    Post findMessage(long id);

    void update(Post existingPost);

    void deleteMessage(long id);

}
