package com.demater.core.port;

import com.demater.core.domain.auth.AuthCredentials;
import com.demater.core.domain.auth.UserCredentials;

public interface Authentication {
    UserCredentials  authenticate(AuthCredentials user);
}
