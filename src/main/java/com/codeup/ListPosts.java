package com.codeup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Patrick on 1/5/17.
 */
public class ListPosts implements Posts {

    private List<Post> posts;

    public ListPosts() {
        posts = new ArrayList<>();
    }

    @Override
    public List<Post> findAll() {
        return posts;
    }

    @Override
    public void save(Post post) {
        post.setId(posts.size() + 1);
        posts.add(post);
    }
}
