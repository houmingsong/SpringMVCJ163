package com.lovo.mvc.dao;

import org.springframework.stereotype.Repository;

import com.lovo.mvc.entity.NewsEntity;

@Repository(value="newsDao")
public class NewsDaoImpl extends BasicDao<NewsEntity>{

}
