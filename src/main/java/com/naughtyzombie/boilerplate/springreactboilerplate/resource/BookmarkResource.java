package com.naughtyzombie.boilerplate.springreactboilerplate.resource;
import static com.naughtyzombie.boilerplate.springreactboilerplate.SpringReactBoilerplateApplication.logger;
import com.naughtyzombie.boilerplate.springreactboilerplate.model.Bookmark;
import com.naughtyzombie.boilerplate.springreactboilerplate.model.BookmarkId;
import com.naughtyzombie.boilerplate.springreactboilerplate.service.BookmarkService;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "/api", produces = APPLICATION_JSON_VALUE)
@Slf4j
public class BookmarkResource {

	@Autowired
    BookmarkService bookmarkService;

//    @RequestMapping(path = "/getAllBookmarks", method = GET)
//    public List<Bookmark> getAllBookmarks(@RequestParam(value = "userId") Long userId) {
//        return bookmarkService.getAllBookmarks(userId);
//    }
    @RequestMapping(path = "/getallbookmarks/{id}", method = GET)
    public List<Object[]> findUserBookMark(@PathVariable Long id) {
        return bookmarkService.getAllBookmarks(id);
    }

    @RequestMapping(path = "/addbookmark", method = POST)
    public boolean addBookmark(@RequestBody String bookmark) {
        try {
            logger.info("Book ADD request {}", bookmark);
            JSONObject obj = new JSONObject(bookmark.toString());
            Long userId = obj.getLong("userId");
            String newsId = obj.getString("newsId");
            String markDate = obj.getString("markDate");
            BookmarkId id = new BookmarkId(userId,newsId);
            Bookmark bookmark_obj = new Bookmark(id,markDate);
            bookmarkService.addBookmark(bookmark_obj);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
//    @RequestMapping(path = "/addBookmark", method = POST)
//    public List<Bookmark> addBookmark(@RequestParam(value = "userId") Long userId, @RequestParam(value = "newsId") Long newsId) {
//        bookmarkService.addBookmark(userId, newsId);
//        return bookmarkService.getAllBookmarks(userId);
//    }

    @RequestMapping(path = "/deleteBookmark", method = POST)
    public List<Object[]> deleteBookmark(@RequestBody String bookmark) {
        try {
            logger.info("Book DELETE request {}", bookmark);
            JSONObject obj = new JSONObject(bookmark);
            Long userId = obj.getLong("userId");
            String newsId = obj.getString("newsId");
            BookmarkId id = new BookmarkId(userId, newsId);
            bookmarkService.deleteBookmark(id);
            return bookmarkService.getAllBookmarks(userId);
        }catch(Exception e){
            return null;
        }
    }
}
