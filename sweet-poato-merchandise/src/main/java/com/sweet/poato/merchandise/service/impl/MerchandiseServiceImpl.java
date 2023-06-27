package com.sweet.poato.merchandise.service.impl;

import com.sweet.poato.merchandise.service.MerchandiseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sweet.poato.res.Test;
import sweet.poato.result.Result;
import sweet.poato.utils.SnowFlakeUtils;

/**
 * @Author: TheSunshine
 * @Date: 2022/8/8 16:41
 * @Version 1.0
 */
@Slf4j
@Service
public class MerchandiseServiceImpl implements MerchandiseService {

    @Override
    public Result<String> getTestInfo() {
        return Result.success("200","看见他就说明成功了");
    }

    @Override
    public Result<Test> getTestDTO() {
        Test test = new Test();
        test.setAge("18");
        test.setId(SnowFlakeUtils.nextId());
        test.setName("小明");
        return Result.success("成功",test);
    }
}
