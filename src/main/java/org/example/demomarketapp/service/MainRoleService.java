package org.example.demomarketapp.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.example.demomarketapp.model.Role;
import org.example.demomarketapp.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class MainRoleService implements RoleService {
    RoleRepository roleRepository;

    @Override
    public Role get(Long id) {
        return roleRepository.findById(id).orElseThrow();
    }

    @Override
    public Role getReference(Long id) {
        return roleRepository.getReferenceById(id);
    }
}
