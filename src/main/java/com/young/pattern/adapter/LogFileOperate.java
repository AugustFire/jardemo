package com.young.pattern.adapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yzx
 * create_time 2020/9/4
 */
public class LogFileOperate implements LogFileOperateApi{
    @Override
    public List<LogBean> readLogFile() {
        return new ArrayList<>();
    }

    @Override
    public void writeLogFile(List<LogBean> list) {
    }
}
