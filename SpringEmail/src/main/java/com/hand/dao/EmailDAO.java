package com.hand.dao;

import com.hand.event.MailSendEvent;

public interface EmailDAO {
    public void addEmail(MailSendEvent mailSendEvent);
}
