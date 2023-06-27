package com.sweet.poato.network.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author The Sunshine
 * @version 1.0
 * @date 2023/2/27 16:03
 */
@Slf4j
@Service
public class DiscardServiceImpl implements DiscardService{
    /**
     * 丢弃消息
     *
     * @param message
     */
    @Override
    public void discard(String message) {
        log.info("丢弃消息 :{}",message);
    }
}
