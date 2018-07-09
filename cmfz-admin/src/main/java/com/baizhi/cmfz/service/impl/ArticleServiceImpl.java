package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.ArticleDao;
import com.baizhi.cmfz.entity.Article;
import com.baizhi.cmfz.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * 描述:
 *
 * @author future_zwp
 * @create 2018-07-08 21:46
 */
@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {


    @Autowired
    private ArticleDao ad;

    @Override
    public Boolean addArticle(Article article) {
        Integer i = ad.insertArticle(article);
        if(i>0){
            return true;
        }
        return false;
    }
}
