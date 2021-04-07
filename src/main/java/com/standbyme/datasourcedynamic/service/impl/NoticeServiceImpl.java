package com.standbyme.datasourcedynamic.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.standbyme.datasourcedynamic.domain.NoticeDetail;
import com.standbyme.datasourcedynamic.repository.NoticeRepository;
import com.standbyme.datasourcedynamic.service.NoticeService;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Arrays;
import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    NoticeRepository noticeRepository;

    @Override
    public NoticeDetail selectNoticeDetailById(Long noticeId) {

        return noticeRepository.findOne(noticeId,"slave");
    }

    @DS("slave")
    @Override
    public List<NoticeDetail> selectByCondition(String queryName ){

        System.out.println("queryName="+queryName);
        NoticeDetail noticeDetail = new NoticeDetail();
        noticeDetail.setName(queryName);

        /**
         * 进行分页
         */
        Integer pageCurr = 0;
        Integer pageSize = 10;

        Sort.Order id = Sort.Order.asc("id");
        Sort by = Sort.by(id);
        PageRequest pageRequest = PageRequest.of(pageCurr, pageSize, by);

        Page<NoticeDetail> all = noticeRepository.findAll(new Specification<NoticeDetail>() {
            @Override
            public Predicate toPredicate(Root<NoticeDetail> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                query.where(cb.le(root.get("33").as(Integer.class),33));
                query.groupBy(root.get("id").as(Long.class));
                query.having(cb.ge(root.get("id").as(Long.class), 123));
                return query.getRestriction();
            }
        }, pageRequest);



        return all.getContent();
    }


}
