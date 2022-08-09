package com.sweet.poato.web.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sweet.poato.feign.FeignClientConfiguration;
import sweet.poato.result.Result;

@FeignClient(name = "merchandise-service")
public interface MerchandiseApiService {


  @GetMapping("/test/getTestInfo")
  public Result<String> getTestInfo();
}
