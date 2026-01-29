package com.jamillyferreira.mongoapi.model;

import com.jamillyferreira.mongoapi.dto.AuthorDTO;
import com.jamillyferreira.mongoapi.dto.CommentDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "posts")
public class Post {
    @Id
    private String id;

    private Date date;
    private String title;
    private String body;
    private AuthorDTO author;

    private List<CommentDTO> comments = new ArrayList<>();

    public Post(Date date, String title, String body, AuthorDTO author) {
        this.date = date;
        this.title = title;
        this.body = body;
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(id, post.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
