package com.heima.article.controller.v1;

import com.heima.article.service.ApArticleService;
import com.heima.common.constants.ArticleConstants;
import com.heima.model.article.dtos.ArticleHomeDto;
import com.heima.model.common.dtos.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.xml.ws.Response;

@RestController
@RequestMapping("api/v1/article")
public class ArticleHomeController {

    @Autowired
    private ApArticleService apArticleService;


    /*
    * 加载首页
    * */
    @PostMapping("/load")
    public ResponseResult load(@RequestBody ArticleHomeDto dto){

        return apArticleService.load(dto, ArticleConstants.LOADTYPE_LOAD_MORE);
    }

    /*
     * 加载更多
     * */
    @PostMapping("/loadmore")
    public ResponseResult loadmore(@RequestBody ArticleHomeDto dto){
        return apArticleService.load(dto, ArticleConstants.LOADTYPE_LOAD_MORE);
    }

    /*
     * 加载最新
     * */
    @PostMapping("/loadnew")
    public ResponseResult loadnew(@RequestBody ArticleHomeDto dto){
        return apArticleService.load(dto, ArticleConstants.LOADTYPE_LOAD_NEW);
    }
}
