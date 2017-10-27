package models;

import play.db.jpa.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: 冯冠凯
 * @Description:
 * @Date: Created on 2017/10/27
 * @Version: 1.0
 */
@Entity
@Table(name = "cx_post")
public class Post extends Model {

    public String title;
    public Date insertTime;

    @Lob
    public String content;

    @ManyToOne
    public User author;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    public List<Comment> comments;

    public Post addComment(String author, String content) {
        Comment comment = new Comment(author, content, new Date(), this).save();
        this.comments.add(comment);
        this.save();
        return this;
    }

    public Post(String title, Date insertTime, String content, User author) {
        if(comments == null) comments = new ArrayList<>();
        this.title = title;
        this.insertTime = insertTime;
        this.content = content;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Post{" +
                "title='" + title + '\'' +
                ", insertTime=" + insertTime +
                ", content='" + content + '\'' +
                ", author=" + author +
                '}';
    }
}
