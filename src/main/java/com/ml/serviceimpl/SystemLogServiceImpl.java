package com.ml.serviceimpl;

import com.ml.mapper.SystemLogMapper;
import com.ml.model.SystemLog;
import com.ml.service.SystemLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author dml
 * @date 2021/12/6 15:07
 */
@Service
public class SystemLogServiceImpl implements SystemLogService {

    @Resource
    private SystemLogMapper systemLogMapper;

    @Override
    public void addLog(SystemLog systemLog) {
        systemLogMapper.insert(systemLog);
    }
}
