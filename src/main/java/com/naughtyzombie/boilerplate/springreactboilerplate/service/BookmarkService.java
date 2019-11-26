//package com.naughtyzombie.boilerplate.springreactboilerplate.service;
//
//import com.naughtyzombie.boilerplate.springreactboilerplate.model.Bookmark;
//import com.naughtyzombie.boilerplate.springreactboilerplate.model.News;
//import com.naughtyzombie.boilerplate.springreactboilerplate.model.security.User;
//import com.naughtyzombie.boilerplate.springreactboilerplate.repository.BookmarkRepository;
//import com.naughtyzombie.boilerplate.springreactboilerplate.repository.NewsRepository;
//import com.naughtyzombie.boilerplate.springreactboilerplate.security.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service("bookmarkService")
//public class BookmarkService {
//	@Autowired
//	BookmarkRepository bookmarkRepository;
//	@Autowired
//	UserRepository userRepository;
//	@Autowired
//	NewsRepository newsRepository;
//	public boolean addBookmark(Long userId, Long newsId) {
//		Bookmark bookmark = new Bookmark();
//		User user = userRepository.findById(userId).get();
//		News news = newsRepository.findById(newsId).get();
//		bookmark.setUserId(user);
//		bookmark.setNewsId(news);
//		bookmarkRepository.save(bookmark);
//		return bookmark != null;
//	}
//
//	public List<Object[]> getAllBookmarks(Long userId) {
//		return  bookmarkRepository.getAllBookmarks(userId);
//    }
//
////	public void deleteBookmark(Long userId, Long newsId) {
////		bookmarkRepository.deleteBookmark(userId, newsId);
////	}
//}
package com.naughtyzombie.boilerplate.springreactboilerplate.service;

import com.naughtyzombie.boilerplate.springreactboilerplate.model.Bookmark;
import com.naughtyzombie.boilerplate.springreactboilerplate.model.BookmarkId;
import com.naughtyzombie.boilerplate.springreactboilerplate.repository.BookmarkRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static com.naughtyzombie.boilerplate.springreactboilerplate.SpringReactBoilerplateApplication.logger;

import java.util.List;
import java.util.Optional;

@Service()
public class BookmarkService {

	@Autowired
	private BookmarkRepository bookmarkRepository;

//	public List<Bookmark> getAllBookMarks() {
//		return bookMarkRepository.findAll();
//	}

	public boolean addBookmark(Bookmark bookMark) {
		Bookmark save = bookmarkRepository.save(bookMark);
		return save != null;
	}

	public void deleteBookmark(BookmarkId bookMarkId) {
		bookmarkRepository.deleteById(bookMarkId);
	}

//	public Optional<Bookmark> oneBookMark(BookmarkId bookMarkId) {
//		return bookmarkRepository.findById(bookMarkId);
//	}
	public List<Object[]> getAllBookmarks(Long userId) {
		return bookmarkRepository.findByUserId(userId);
	}
}
