package io.github.jhipster.sample.service.mapper;

import io.github.jhipster.sample.domain.*;
import io.github.jhipster.sample.service.dto.OperationDTO;

import org.mapstruct.*;
import java.util.List;

/**
 * Mapper for the entity Operation and its DTO OperationDTO.
 */
@Mapper(componentModel = "spring", uses = {LabelMapper.class, })
public interface OperationMapper {

    @Mapping(source = "bankAccount.id", target = "bankAccountId")
    @Mapping(source = "bankAccount.name", target = "bankAccountName")
    OperationDTO operationToOperationDTO(Operation operation);

    List<OperationDTO> operationsToOperationDTOs(List<Operation> operations);

    @Mapping(source = "bankAccountId", target = "bankAccount")
    Operation operationDTOToOperation(OperationDTO operationDTO);

    List<Operation> operationDTOsToOperations(List<OperationDTO> operationDTOs);

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
