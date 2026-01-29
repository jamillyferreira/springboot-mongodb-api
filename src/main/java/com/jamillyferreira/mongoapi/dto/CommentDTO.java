package com.jamillyferreira.mongoapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentDTO {
    private String text;
    private Date date;
    private AuthorDTO author;

}
