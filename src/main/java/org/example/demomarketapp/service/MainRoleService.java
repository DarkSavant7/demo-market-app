package org.example.demomarketapp.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.demomarketapp.model.Role;
import org.example.demomarketapp.repository.RoleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class MainRoleService implements RoleService {
    private static final Logger log = LoggerFactory.getLogger(
        MainRoleService.class);
    RoleRepository roleRepository;

    @Override
    public Role get(Long id) {
        log.info("Trying to get role with id: {}", id);
        return roleRepository.findById(id).orElseThrow();
    }

    @Override
    public Role getReference(Long id) {
        var anotherVariable = "ANOTHER";
        log.warn("Trying to get role with id: {} {}", id, anotherVariable);
        return roleRepository.getReferenceById(id);
    }
}
