package com.cozy.infra;

import com.cozy.account.core.port.in.AccountManagement;
import com.cozy.command.core.port.in.CommandManagement;
import com.cozy.core.adapter.CommandService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public record ServicesFacade(AccountManagement accountService, CommandManagement commandService) {

}
