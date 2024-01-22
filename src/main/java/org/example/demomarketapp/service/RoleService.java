package org.example.demomarketapp.service;

import org.example.demomarketapp.model.Role;

public interface RoleService {
   Long USER_ROLE_ID = 1L;
   Role get(Long id);
   Role getReference(Long id);
}
