package com.mycompany.myapp.web.rest.mapper;

import com.mycompany.myapp.domain.*;
import com.mycompany.myapp.web.rest.dto.OperationDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Operation and its DTO OperationDTO.
 */
@Mapper(componentModel = "spring", uses = {LabelMapper.class, })
public interface OperationMapper {

    @Mapping(source = "bankAccount.id", target = "bankAccountId")
    @Mapping(source = "bankAccount.name", target = "bankAccountName")
    OperationDTO operationToOperationDTO(Operation operation);

    @Mapping(source = "bankAccountId", target = "bankAccount")
    Operation operationDTOToOperation(OperationDTO operationDTO);

    default BankAccount bankAccountFromId(Long id) {
        if (id == null) {
            return null;
        }
        BankAccount bankAccount = new BankAccount();
        bankAccount.setId(id);
        return bankAccount;
    }

    default Label labelFromId(Long id) {
        if (id == null) {
            return null;
        }
        Label label = new Label();
        label.setId(id);
        return label;
    }
}
