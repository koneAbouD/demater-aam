package com.demater.core.port;

import com.demater.core.domain.account.Account;
import com.demater.core.domain.folder.Folder;

import java.util.List;

public interface AccountRepository {
    List<Account> findAll();
    Account save(Account account);
}
