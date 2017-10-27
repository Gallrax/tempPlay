package controllers;

import models.Post;
import play.mvc.Before;
import play.mvc.Controller;

import java.util.List;

public class Application extends Controller {

    @Before
    static void addDefaults() {
        renderArgs.put("blogTitle", "Temp Title");
        renderArgs.put("blogBaseline", "Temp Baseline");
    }

    public static void index() {
        Post frontPost  = (Post) Post.findAll().get(0);
        List<Post> olderPosts  = Post.findAll();
        render(frontPost, olderPosts);
    }

    public static void show(Long id) {
        Post post = Post.findById(id);
        render(post);
    }

}