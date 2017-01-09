package com.codeup;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @GetMapping("/{id}")
    public String show(@PathVariable long id, Model model) {
        Post post = DaoFactory.getPostsDao().findMessage(id);
        model.addAttribute("post", post);
        return "posts/view";
    }

    @GetMapping("/create")
    public String showForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/create")
    public String create(@Valid Post post, Errors validation, Model model) {
        if (validation.hasErrors()) {
            model.addAttribute("errors", validation);
            model.addAttribute("post", post);
            return "posts/create";
        }
        DaoFactory.getPostsDao().save(post);
        return "redirect:/posts";
    }

    @GetMapping("/{id}/edit")
    public String showEdit(@PathVariable long id, Model model) {
        Post post = DaoFactory.getPostsDao().findMessage(id);
        model.addAttribute("post", post);
        return "posts/edit";
    }

    @PostMapping("/{id}/edit")
    public String update(@Valid Post editedPost, Errors validation, Model model) {
        if (validation.hasErrors()) {
            model.addAttribute("errors", validation);
            model.addAttribute("post", editedPost);
            return "posts/edit";
        }
        Post exisitingPost = DaoFactory.getPostsDao().findMessage(editedPost.getId());
        String newTitle = editedPost.getTitle();
        String newBody = editedPost.getBody();
        exisitingPost.setTitle(newTitle);
        exisitingPost.setBody(newBody);
        DaoFactory.getPostsDao().update(exisitingPost);
        return "redirect:/posts/" + exisitingPost.getId();
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable long id) {
        DaoFactory.getPostsDao().deleteMessage(id);
        return "redirect:/posts";
    }
}
