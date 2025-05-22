/*
 *  Copyright (c) Dntech 2023 - All rights reserved.
 */

package com.cozy.command.infra.jpa;

import com.cozy.command.core.model.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaAccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByUserId(String userId);
}
