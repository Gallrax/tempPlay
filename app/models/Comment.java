package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Author: 冯冠凯
 * @Description:
 * @Date: Created on 2017/10/27
 * @Version: 1.0
 */
@Entity
@Table(name = "cx_comment")
public class Comment extends Model {

    public String author;

    @Lob
    public String content;
    public Date insertTime;

    @ManyToOne
    public Post post;

    public Comment(String author, String content, Date insertTime, Post post) {
        this.author = author;
        this.content = content;
        this.insertTime = insertTime;
        this.post = post;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "author='" + author + '\'' +
                ", insertTime=" + insertTime +
                ", content='" + content + '\'' +
                ", post=" + post +
                '}';
    }
}
