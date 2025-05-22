package com.cozy.command.core.port.in;

import com.cozy.command.core.model.entity.Profile;
import com.cozy.command.core.model.payload.internal.field.UpdateProfileRequest;
import io.vavr.control.Try;

import java.util.List;

public interface ProfileManagement {
    Try<Profile> findProfileById(Long profileId);

    Try<Profile> updateProfileById(Long profileId, UpdateProfileRequest request);

    Try<List<Profile>> getAllProfiles();
}
