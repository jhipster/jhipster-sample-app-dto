package io.github.jhipster.sample.service.mapper;

import io.github.jhipster.sample.domain.*;
import io.github.jhipster.sample.service.dto.BankAccountDTO;

import org.mapstruct.*;
import java.util.List;

/**
 * Mapper for the entity BankAccount and its DTO BankAccountDTO.
 */
@Mapper(componentModel = "spring", uses = {UserMapper.class, })
public interface BankAccountMapper {

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "user.login", target = "userLogin")
    BankAccountDTO bankAccountToBankAccountDTO(BankAccount bankAccount);

    List<BankAccountDTO> bankAccountsToBankAccountDTOs(List<BankAccount> bankAccounts);

    @Mapping(source = "userId", target = "user")
    @Mapping(target = "operations", ignore = true)
    BankAccount bankAccountDTOToBankAccount(BankAccountDTO bankAccountDTO);

    List<BankAccount> bankAccountDTOsToBankAccounts(List<BankAccountDTO> bankAccountDTOs);
    /**
     * generating the fromId for all mappers if the databaseType is sql, as the class has relationship to it might need it, instead of
     * creating a new attribute to know if the entity has any relationship from some other entity
     *
     * @param id id of the entity
     * @return the entity instance
     */
     
    default BankAccount bankAccountFromId(Long id) {
        if (id == null) {
            return null;
        }
        BankAccount bankAccount = new BankAccount();
        bankAccount.setId(id);
        return bankAccount;
    }
    

}
