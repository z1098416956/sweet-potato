package com.sweet.poato.im.config;

import lombok.extern.slf4j.Slf4j;
import org.jivesoftware.smack.*;
import org.jivesoftware.smack.chat.ChatManager;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import org.jivesoftware.smack.tcp.XMPPTCPConnectionConfiguration;
import org.jxmpp.jid.impl.JidCreate;
import org.jxmpp.stringprep.XmppStringprepException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * @author The Sunshine
 * @version 1.0
 * @date 2023/6/27 11:57
 */
@Configuration
@Slf4j
public class XMPPTCPConfig {


    @Value("${xmpp.host}")
    private String host;

    @Value("${xmpp.port}")
    private int port;

    @Value("${xmpp.username}")
    private String username;

    @Value("${xmpp.password}")
    private String password;


    @Bean
    public XMPPConnection xmppConnection() {
        try {
            XMPPTCPConnectionConfiguration configuration = XMPPTCPConnectionConfiguration.builder()
                    .setHost(host)
                    .setPort(port)
                    .setXmppDomain(JidCreate.domainBareFrom(host))
                    .setSecurityMode(ConnectionConfiguration.SecurityMode.disabled)
                    .setCompressionEnabled(false)
                    .setUsernameAndPassword(username, password)
                    .build();
            AbstractXMPPConnection connection = new XMPPTCPConnection(configuration);
            connection.connect().login();
            return connection;
        } catch (Exception e) {
            log.error("Failed to establish XMPP connection", e);
            return null;
        }
    }



}
