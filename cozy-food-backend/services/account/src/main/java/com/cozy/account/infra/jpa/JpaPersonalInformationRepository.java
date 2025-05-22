package com.cozy.command.infra.jpa;

import com.cozy.command.core.model.entity.PersonalInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface JpaPersonalInformationRepository extends JpaRepository<PersonalInformation, Long> {

    @Query("""
                SELECT COUNT(p) FROM PersonalInformation  p WHERE p.email = :email
            """)
    int countByEmail(@Param("email") String email);

}
