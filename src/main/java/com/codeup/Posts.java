package com.codeup;

import java.util.List;

/**
 * Created by Patrick on 1/5/17.
 */
public interface Posts {

    List<Post> findAll();

    void save(Post post);
}
