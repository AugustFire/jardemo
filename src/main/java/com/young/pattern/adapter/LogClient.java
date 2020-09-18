package com.young.pattern.adapter;

import java.util.ArrayList;

/**
 * @author yzx
 * create_time 2020/9/4
 */
public class LogClient {
    public static void main(String[] args) {
        LogBean logBean = new LogBean();
        logBean.setLogId("1");
        logBean.setOpeUserId("001");
        ArrayList<LogBean> logBeans = new ArrayList<>();
        LogFileOperateApi logFileOperateApi = new LogFileOperate();
        LogAdapter adapter = new LogAdapter(logFileOperateApi);
        adapter.createLog(logBean);
    }
}
