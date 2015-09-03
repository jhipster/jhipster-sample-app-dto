package com.mycompany.myapp.web.rest.mapper;

import com.mycompany.myapp.domain.*;
import com.mycompany.myapp.web.rest.dto.BankAccountDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity BankAccount and its DTO BankAccountDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public abstract class BankAccountMapper {

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "user.login", target = "userLogin")
    abstract BankAccountDTO bankAccountToBankAccountDTO(BankAccount bankAccount);

    @Mapping(source = "userId", target = "user")
    @Mapping(target = "operations", ignore = true)
    abstract BankAccount bankAccountDTOToBankAccount(BankAccountDTO bankAccountDTO);

    public User userFromId(Long id) {
        if (id == null) {
            return null;
        }
        User user = new User();
        user.setId(id);
        return user;
    }
}
