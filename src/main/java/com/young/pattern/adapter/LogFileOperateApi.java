package com.young.pattern.adapter;

import java.util.List;

/**
 * @author yzx
 * create_time 2020/9/4
 */
public interface LogFileOperateApi {

    List<LogBean> readLogFile();

    void writeLogFile(List<LogBean> list);


}
