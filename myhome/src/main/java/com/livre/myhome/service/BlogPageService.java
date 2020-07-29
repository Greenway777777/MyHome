package com.livre.myhome.service;

import com.livre.myhome.dao.BlogPageDao;
import com.livre.myhome.pojo.BlogPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class BlogPageService {
    @Autowired
    BlogPageDao blogPageDao;

    public Page list(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        return blogPageDao.findAll(PageRequest.of(page, size, sort));
    }

    public BlogPage findById(int id) {
        return blogPageDao.findById(id);
    }

    public void addOrUpdate(BlogPage blogPage) {
        blogPageDao.save(blogPage);
    }

    public void delete(int id) {
        blogPageDao.deleteById(id);
    }
}
