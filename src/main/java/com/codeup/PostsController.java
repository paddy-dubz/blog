package com.codeup;

import com.codeup.Posts;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Patrick on 1/5/17.
 */
@Controller
@RequestMapping("/posts")
public class PostsController {

    @GetMapping
    public String index(Model model) {
        List<Post> posts = DaoFactory.getPostsDao().findAll();
        model.addAttribute("posts", posts);
        return "posts/index";
    }

    @GetMapping("/create")
    public String showForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Post post) {
        DaoFactory.getPostsDao().save(post);
        return "redirect:/posts";
    }
}
