package com.cozy.command.infra.jpa;

import com.cozy.command.core.model.entity.Command;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaCommandRepository extends JpaRepository<Command, Long> {

}
