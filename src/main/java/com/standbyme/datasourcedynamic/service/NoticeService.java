package com.standbyme.datasourcedynamic.service;

import com.standbyme.datasourcedynamic.domain.NoticeDetail;

import java.util.List;

public interface NoticeService {
    NoticeDetail selectNoticeDetailById(Long noticeId);

    List<NoticeDetail> selectByCondition(String queryName);
}
