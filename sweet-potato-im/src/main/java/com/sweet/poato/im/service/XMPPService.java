package com.sweet.poato.im.service;

import com.sweet.poato.im.config.XMPPTCPConfig;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.chat2.Chat;
import org.jivesoftware.smack.chat2.ChatManager;
import org.jxmpp.jid.EntityBareJid;
import org.jxmpp.jid.impl.JidCreate;
import org.jxmpp.stringprep.XmppStringprepException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author The Sunshine
 * @version 1.0
 * @date 2023/6/27 15:52
 */
@Service
public class XMPPService {

    @Autowired
    private XMPPTCPConfig xmpptcpConfig;

    public void sendMessage(String recipient, String message) throws SmackException.NotConnectedException, InterruptedException, XmppStringprepException {
        EntityBareJid jid = JidCreate.entityBareFrom(recipient);
        Chat chat = ChatManager.getInstanceFor(xmpptcpConfig.xmppConnection()).chatWith(jid);
        chat.send(message);
    }
}
