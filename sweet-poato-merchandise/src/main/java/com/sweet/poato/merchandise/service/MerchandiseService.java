package com.sweet.poato.merchandise.service;

import sweet.poato.res.Test;
import sweet.poato.result.Result;

/**
 * @Author: TheSunshine
 * @Date: 2022/8/8 16:40
 * @Version 1.0
 */
public interface MerchandiseService {

    public Result<String> getTestInfo();

    public Result<Test> getTestDTO();
}
