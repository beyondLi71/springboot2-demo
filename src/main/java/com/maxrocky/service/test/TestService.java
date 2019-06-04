package com.maxrocky.service.test;

import com.maxrocky.common.utils.page.PageParam;
import com.maxrocky.common.utils.page.PageResult;

/**
 * Created by beyondLi
 * Date 2019/6/4 14:14
 * Desc .
 */
public interface TestService {
    /**
     * 查看用户信息
     * @param pageParam
     * @return
     */
    PageResult getinfo(PageParam pageParam);

    /**
     * 测试异常
     */
    void errInfo();
}
