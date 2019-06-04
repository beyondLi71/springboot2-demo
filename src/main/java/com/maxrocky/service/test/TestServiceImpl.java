package com.maxrocky.service.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.maxrocky.common.tools.exception.ExceptionManager;
import com.maxrocky.common.utils.mapper.MapperUtils;
import com.maxrocky.common.utils.page.PageParam;
import com.maxrocky.common.utils.page.PageResult;
import com.maxrocky.common.utils.page.PageResultFactory;
import com.maxrocky.entity.po.test.UserInfoPO;
import com.maxrocky.entity.vo.test.UserInfoVO;
import com.maxrocky.repository.test.TestQueryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by beyondLi
 * Date 2019/6/4 14:14
 * Desc .
 */
@Service
public class TestServiceImpl implements TestService {

    @Resource
    TestQueryMapper testQueryMapper;

    @Resource
    PageResultFactory pageResultFactory;

    @Resource
    ExceptionManager exceptionManager;
    @Override
    @Transactional(rollbackFor = Exception.class)
    public PageResult getinfo(PageParam pageParam) {
        //设置分页
        PageHelper.startPage(pageParam.getP(), pageParam.getC());
        List<UserInfoPO> userInfoPOList = testQueryMapper.getinfo();
        // 取分页信息
        int total = (int) new PageInfo(userInfoPOList).getTotal();
        List<UserInfoVO> userInfoVOS = MapperUtils.mapperList(userInfoPOList, UserInfoVO.class);
        PageResult pageResult = pageResultFactory.createPageResult(pageParam.getP(), total, userInfoVOS);
        return pageResult;
    }

    @Override
    @Transactional(readOnly = true)
    public void errInfo() {
        if (true) {
            throw exceptionManager.createByCode("TEST_0001");
        }
    }
}
