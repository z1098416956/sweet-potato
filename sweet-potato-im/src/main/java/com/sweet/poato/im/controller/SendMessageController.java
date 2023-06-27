package com.sweet.poato.im.controller;

import com.sweet.poato.im.service.XMPPService;
import lombok.extern.slf4j.Slf4j;
import org.jivesoftware.smack.SmackException;
import org.jxmpp.stringprep.XmppStringprepException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sweet.poato.result.Result;

/**
 * @author The Sunshine
 * @version 1.0
 * @date 2023/6/27 15:05
 */
@Slf4j
@RestController
@RequestMapping("/v1/message")
public class SendMessageController {


    @Autowired
    private XMPPService xmppService;

    @GetMapping(value = "/sendMessage")
    public Result sendMessage(@RequestParam String to ,@RequestParam String message){
         try {
             xmppService.sendMessage(to,message);
             return Result.success(200,"成功");
         }catch (Exception e){
             log.error("e =============> :{}",e);
             return Result.error(500,e.getMessage());
         }
    }




    @GetMapping("/sendXMPPMessage")
    public String sendXMPPMessage(@RequestParam String recipient, @RequestParam String message) throws InterruptedException, SmackException.NotConnectedException, XmppStringprepException {
        xmppService.sendMessage(recipient, message);
        return "Message sent!";
    }

}
