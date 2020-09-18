package com.young.pattern.adapter;

import java.util.List;

/**
 * @author yzx
 * create_time 2020/9/4
 */
public class LogAdapter implements LogDbOpeApi{

    private LogFileOperateApi adaptee;

    public LogAdapter(LogFileOperateApi adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void createLog(LogBean logBean) {
        List<LogBean> list = adaptee.readLogFile();
        list.addAll(list);
    }
}
