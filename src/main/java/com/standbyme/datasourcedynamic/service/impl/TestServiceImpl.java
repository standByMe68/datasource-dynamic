package com.standbyme.datasourcedynamic.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.standbyme.datasourcedynamic.domain.CalcTask;
import com.standbyme.datasourcedynamic.mapper.TestMapper;
import com.standbyme.datasourcedynamic.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class TestServiceImpl implements TestService {
    @Autowired
    private TestMapper testMapper;

    @Override
    public String getCalcTaskById(Integer taskId) {
        CalcTask taskById = testMapper.getTaskById(taskId);
        return taskById.getTaskname();
    }

    @Override
    @DS("slave")
    public String getCalcTaskByIdJcf(Integer taskId) {
        CalcTask calcTask = new CalcTask();
        calcTask.setCreateTime(new Date());
        calcTask.setTaskname("测试1");
        calcTask.setCycleEnd(new Date());
        calcTask.setCode(3L);
        calcTask.setCycle(3L);
        calcTask.setExpression("测试");
        calcTask.setCycleStart("231");
        calcTask.setSiteid(123L);
        calcTask.setMpointid(123L);
        calcTask.setStartdt(new Date());
        calcTask.setFormulaid(123L);
        calcTask.setStatus("123");
        calcTask.setCreateUserid(123L);
        calcTask.setUpdateTime(new Date());
        calcTask.setCreateUserid(12L);
        calcTask.setExcuteInfo("2123");
        calcTask.setUpdateUserid(123L);
        Integer integer = testMapper.insertCalcTask(calcTask);
        System.out.println(1/0);
        CalcTask taskById = testMapper.getTaskById(taskId);
        return taskById.getTaskname();
    }

    @Override
    public Integer insertCalcTask() {
        return null ;
    }
}
