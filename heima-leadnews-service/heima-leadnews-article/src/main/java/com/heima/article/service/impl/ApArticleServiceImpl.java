package com.heima.article.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heima.article.mapper.ApArticleMapper;
import com.heima.article.service.ApArticleService;
import com.heima.common.constants.ArticleConstants;
import com.heima.model.article.dtos.ArticleHomeDto;
import com.heima.model.article.pojos.ApArticle;
import com.heima.model.common.dtos.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.helper.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
@Slf4j
public class ApArticleServiceImpl extends ServiceImpl<ApArticleMapper, ApArticle> implements ApArticleService{
    //mybatis-plus对于多表查询并不是特别友好，所以使用mapper类再进行多表查询
    @Autowired
    private ApArticleMapper apArticleMapper;

    private final static short MAX_PAGE_SIZE = 50;
    /**
     * 加载文章列表
     * @param dto
     * @param type  1 加载更多  2 加载最新
     * @return
     */
    public ResponseResult load(ArticleHomeDto dto,Short type){
        //1.校验参数
        //分页条数校验
        Integer size  = dto.getSize();
        if(size==null||size==0)
            size = 10;
        //分页值不超过50
        dto.setSize(Math.min(size,MAX_PAGE_SIZE));
        //校验参数 -->type
        if (!type.equals(ArticleConstants.LOADTYPE_LOAD_MORE) && !type.equals(ArticleConstants.LOADTYPE_LOAD_NEW))
            type = 1;

        //频道参数校验
        if (StringUtil.isBlank(dto.getTag()))
            dto.setTag(ArticleConstants.DEFAULT_TAG);


        //时间校验
        if (dto.getMaxBehotTime()==null)dto.setMaxBehotTime(new Date());
        if (dto.getMinBehotTime()==null)dto.setMinBehotTime(new Date());


        //2.查询
        List<ApArticle> apArticleList = apArticleMapper.loadArticleList(dto, type);


        return ResponseResult.okResult(apArticleList);
    }

}
