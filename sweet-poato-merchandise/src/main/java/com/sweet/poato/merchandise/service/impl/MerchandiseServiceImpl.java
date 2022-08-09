package com.sweet.poato.merchandise.service.impl;

import com.sweet.poato.merchandise.service.MerchandiseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sweet.poato.result.Result;

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
        return Result.success(200,"看见他就说明成功了");
    }
}
