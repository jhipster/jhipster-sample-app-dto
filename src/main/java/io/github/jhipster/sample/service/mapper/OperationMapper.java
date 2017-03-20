package io.github.jhipster.sample.service.mapper;

import io.github.jhipster.sample.domain.*;
import io.github.jhipster.sample.service.dto.OperationDTO;

import org.mapstruct.*;
import java.util.List;

/**
 * Mapper for the entity Operation and its DTO OperationDTO.
 */
@Mapper(componentModel = "spring", uses = {BankAccountMapper.class, LabelMapper.class, })
public interface OperationMapper {

    @Mapping(source = "bankAccount.id", target = "bankAccountId")
    @Mapping(source = "bankAccount.name", target = "bankAccountName")
    OperationDTO operationToOperationDTO(Operation operation);

    List<OperationDTO> operationsToOperationDTOs(List<Operation> operations);

    @Mapping(source = "bankAccountId", target = "bankAccount")
    Operation operationDTOToOperation(OperationDTO operationDTO);

    List<Operation> operationDTOsToOperations(List<OperationDTO> operationDTOs);
    /**
     * generating the fromId for all mappers if the databaseType is sql, as the class has relationship to it might need it, instead of
     * creating a new attribute to know if the entity has any relationship from some other entity
     *
     * @param id id of the entity
     * @return the entity instance
     */
     
    default Operation operationFromId(Long id) {
        if (id == null) {
            return null;
        }
        Operation operation = new Operation();
        operation.setId(id);
        return operation;
    }
    

}
