package controllers;

import models.Post;
import play.cache.Cache;
import play.data.validation.Required;
import play.libs.Codec;
import play.libs.Images;
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
        String uuid = Codec.UUID();
        render(post, uuid);
    }

    public static void postComment(
            Long id,
            @Required(message="Author is required") String author,
            @Required(message="A message is required") String content,
            @Required(message="Please type the code") String code,
            String uuid) {
        Post post = Post.findById(id);
        validation.equals(code, Cache.get(uuid)).message("Invalid code. Please type it again");

    }

    public static void captcha(String id) {
        Images.Captcha captcha = Images.captcha();
        String code = captcha.getText("#EEEEEE");
        System.out.println(code);
        Cache.set(id, code, "10mn");
        renderBinary(captcha);
    }

}