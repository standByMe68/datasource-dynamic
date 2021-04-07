package com.standbyme.datasourcedynamic.repository;


import com.baomidou.dynamic.datasource.annotation.DS;
import com.standbyme.datasourcedynamic.domain.NoticeDetail;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface NoticeRepository extends JpaRepository<NoticeDetail,Long>, JpaSpecificationExecutor<NoticeDetail> {

    @DS("#dataSourceName")
    @Query(value = "Select * from notice_detail a where a.id = ?1",nativeQuery = true)
    NoticeDetail findOne(Long id,String dataSourceName);
}
