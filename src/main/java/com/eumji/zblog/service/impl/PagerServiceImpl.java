package com.eumji.zblog.service.impl;

import com.eumji.zblog.mapper.ArticleMapper;
import com.eumji.zblog.mapper.PagerMapper;
import com.eumji.zblog.service.PagerService;
import com.eumji.zblog.vo.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PagerServiceImpl implements PagerService {

    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private PagerMapper pagerMapper;
    @Override
    public void initPage(Pager pager) {
        int count = articleMapper.getArticleCount();
        pager.setTotalCount(count);
    }

    @Override
    public void loadCategoryPager(Pager pager,Integer categoryId) {
        int count = pagerMapper.loadCategoryPager(categoryId);
        pager.setTotalCount(count);
    }

    @Override
    public void loadTagPager(Pager pager, Integer tagId) {
        int count = pagerMapper.loadTagPager(tagId);
        pager.setTotalCount(count);
    }

    @Override
    public void loadArchivePager(Pager pager, String createTime) {
        int count = pagerMapper.loadArchivePager(createTime);
        pager.setTotalCount(count);
    }
}
