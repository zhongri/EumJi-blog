package com.eumji.zblog.controller;

import com.eumji.zblog.service.CategoryService;
import com.eumji.zblog.vo.ArticleCustom;
import com.eumji.zblog.vo.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class ArchiveController {

    @Autowired
    private CategoryService categoryService;

    /**
     * 文章归档列表
     *
     * 2017.5.29 fixed bug 归档的标题错误问题
     * 设置名称出错
     * @param createTime 创建时间
     * @param pager 分页对象
     * @param model 对象
     * @return
     */
    @RequestMapping("/archive/load/{createTime}")
    public String categoryList(@PathVariable String createTime, Pager pager, Model model){
        List<ArticleCustom> articleList = categoryService.loadArticleByArchive(createTime,pager);
        if (articleList != null && !articleList.isEmpty()) {
            model.addAttribute("articleList", articleList);
            model.addAttribute("pager", pager);
            model.addAttribute("createTime", createTime);
        }
        return "blog/part/archiveSummary";
    }
}