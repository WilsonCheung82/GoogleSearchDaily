package com.naughtyzombie.boilerplate.springreactboilerplate.model;

import java.util.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Set;
import java.util.Date;

@Entity
@Table(name = "news")
@Data
@NoArgsConstructor
public class News{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String content;
	private String author;
	private String category;
	private String location;
	private Date timeStamp;
	private String linkUrl;
	private String imgUrl;
}
