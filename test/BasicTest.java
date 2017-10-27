import models.Comment;
import models.Post;
import models.User;
import org.junit.Before;
import org.junit.Test;
import play.test.Fixtures;
import play.test.UnitTest;

import java.util.Date;
import java.util.List;

public class BasicTest extends UnitTest {

    @Before
    public void before() {
        Fixtures.deleteDatabase();
    }

    @Test
    public void aVeryImportantThingToTest() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void test01() {
        User user = new User("tom", "tom");
        user.save();

//        User result = User.find("byUsername", "tom").first();
        User result = User.login("tom", "tom");
        System.out.println(result);
    }

    @Test
    public void test02() {
        User user = new User("tom", "tom").save();
        new Post("title01", new Date(), "content01", user).save();
        assertEquals(1, Post.count());

        List<Post> posts = Post.find("byAuthor", user).fetch();

        System.out.println(posts.size());
        for (Post post : posts) {
            System.out.println(" post : " + post);
        }
    }

    @Test
    public void test03() {
        User user = new User("tom", "tom").save();
        Post post = new Post("title", new Date(), "content", user).save();
        post.addComment("Jack", "This is so cool!");

        System.out.println(" user.count : " + User.count());
        System.out.println(" post.count : " + Post.count());
        System.out.println(" comment.count : " + Comment.count());


    }

}
