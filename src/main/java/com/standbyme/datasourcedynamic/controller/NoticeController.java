package com.standbyme.datasourcedynamic.controller;

import com.standbyme.datasourcedynamic.domain.NoticeDetail;
import com.standbyme.datasourcedynamic.service.NoticeService;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    NoticeService noticeService;

    @GetMapping("/detail/{id}")
    public NoticeDetail getNoticeDetail(@PathVariable("id")Long noticeId) {
        return noticeService.selectNoticeDetailById(noticeId);
    }

    @GetMapping("/select/{queryName}")
    public List<NoticeDetail> selectByCondition(@PathVariable("queryName") String queryName) {
        return noticeService.selectByCondition(queryName);
    }

}
