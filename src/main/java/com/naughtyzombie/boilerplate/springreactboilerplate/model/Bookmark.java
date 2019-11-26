//package com.naughtyzombie.boilerplate.springreactboilerplate.model;
//
//import java.util.*;
//
//import com.sun.javafx.beans.IDProperty;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import javax.persistence.*;
//import java.util.Set;
//import java.util.Date;
//import java.time.LocalDateTime;
//import com.naughtyzombie.boilerplate.springreactboilerplate.model.security.User;
//
//@Entity
//@NoArgsConstructor
//@Data
//@Table(name = "bookmark")
//public class Bookmark {
//
//    @Id
//    @Column(name = "ID")
//    @GeneratedValue(strategy=GenerationType.AUTO)
//    Long id;
//
//    @ManyToOne
//    @MapsId("userId")
//    @JoinColumn(name = "userId")
//    User userId;
//
//    @ManyToOne
//    @MapsId("newsId")
//    @JoinColumn(name = "newsId")
//    News newsId;
//
//    LocalDateTime markedAt;
//
//    public User getUserId(){
//        return userId;
//    }
//
//    public void setUserId(User user){
//        userId = user;
//    }
//
//    public void setNewsId(News news){
//        newsId = news;
//    }
//    // additional properties
//    // standard constructors, getters, and setters
//}
package com.naughtyzombie.boilerplate.springreactboilerplate.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.naughtyzombie.boilerplate.springreactboilerplate.model.security.User;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "bookmark")
@Data
@NoArgsConstructor
public class Bookmark {

    @EmbeddedId
    private BookmarkId id;

    @ManyToOne
    @JoinColumn(name = "user_id",insertable = false, updatable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "news_id",insertable = false, updatable = false)
    private News news;

    @Column(name = "MARKDATE",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date markDate;

    public Bookmark(BookmarkId id, String markDate)throws Exception{
        this.id = id;
        Date date= new SimpleDateFormat("yyyy-MM-dd").parse(markDate);
        this.markDate = date;
    }

    public void setId(BookmarkId id) {
        this.id = id;
    }
}