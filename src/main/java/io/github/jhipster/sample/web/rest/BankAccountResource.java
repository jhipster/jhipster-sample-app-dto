package io.github.jhipster.sample.web.rest;

import com.codahale.metrics.annotation.Timed;
import io.github.jhipster.sample.domain.BankAccount;

import io.github.jhipster.sample.repository.BankAccountRepository;
import io.github.jhipster.sample.web.rest.util.HeaderUtil;
import io.github.jhipster.sample.service.dto.BankAccountDTO;
import io.github.jhipster.sample.service.mapper.BankAccountMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * REST controller for managing BankAccount.
 */
@RestController
@RequestMapping("/api")
public class BankAccountResource {

    private final Logger log = LoggerFactory.getLogger(BankAccountResource.class);
        
    @Inject
    private BankAccountRepository bankAccountRepository;

    @Inject
    private BankAccountMapper bankAccountMapper;

    /**
     * POST  /bank-accounts : Create a new bankAccount.
     *
     * @param bankAccountDTO the bankAccountDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new bankAccountDTO, or with status 400 (Bad Request) if the bankAccount has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/bank-accounts")
    @Timed
    public ResponseEntity<BankAccountDTO> createBankAccount(@Valid @RequestBody BankAccountDTO bankAccountDTO) throws URISyntaxException {
        log.debug("REST request to save BankAccount : {}", bankAccountDTO);
        if (bankAccountDTO.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert("bankAccount", "idexists", "A new bankAccount cannot already have an ID")).body(null);
        }
        BankAccount bankAccount = bankAccountMapper.bankAccountDTOToBankAccount(bankAccountDTO);
        bankAccount = bankAccountRepository.save(bankAccount);
        BankAccountDTO result = bankAccountMapper.bankAccountToBankAccountDTO(bankAccount);
        return ResponseEntity.created(new URI("/api/bank-accounts/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert("bankAccount", result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /bank-accounts : Updates an existing bankAccount.
     *
     * @param bankAccountDTO the bankAccountDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated bankAccountDTO,
     * or with status 400 (Bad Request) if the bankAccountDTO is not valid,
     * or with status 500 (Internal Server Error) if the bankAccountDTO couldnt be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/bank-accounts")
    @Timed
    public ResponseEntity<BankAccountDTO> updateBankAccount(@Valid @RequestBody BankAccountDTO bankAccountDTO) throws URISyntaxException {
        log.debug("REST request to update BankAccount : {}", bankAccountDTO);
        if (bankAccountDTO.getId() == null) {
            return createBankAccount(bankAccountDTO);
        }
        BankAccount bankAccount = bankAccountMapper.bankAccountDTOToBankAccount(bankAccountDTO);
        bankAccount = bankAccountRepository.save(bankAccount);
        BankAccountDTO result = bankAccountMapper.bankAccountToBankAccountDTO(bankAccount);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert("bankAccount", bankAccountDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /bank-accounts : get all the bankAccounts.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of bankAccounts in body
     */
    @GetMapping("/bank-accounts")
    @Timed
    public List<BankAccountDTO> getAllBankAccounts() {
        log.debug("REST request to get all BankAccounts");
        List<BankAccount> bankAccounts = bankAccountRepository.findAll();
        return bankAccountMapper.bankAccountsToBankAccountDTOs(bankAccounts);
    }

    /**
     * GET  /bank-accounts/:id : get the "id" bankAccount.
     *
     * @param id the id of the bankAccountDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the bankAccountDTO, or with status 404 (Not Found)
     */
    @GetMapping("/bank-accounts/{id}")
    @Timed
    public ResponseEntity<BankAccountDTO> getBankAccount(@PathVariable Long id) {
        log.debug("REST request to get BankAccount : {}", id);
        BankAccount bankAccount = bankAccountRepository.findOne(id);
        BankAccountDTO bankAccountDTO = bankAccountMapper.bankAccountToBankAccountDTO(bankAccount);
        return Optional.ofNullable(bankAccountDTO)
            .map(result -> new ResponseEntity<>(
                result,
                HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * DELETE  /bank-accounts/:id : delete the "id" bankAccount.
     *
     * @param id the id of the bankAccountDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/bank-accounts/{id}")
    @Timed
    public ResponseEntity<Void> deleteBankAccount(@PathVariable Long id) {
        log.debug("REST request to delete BankAccount : {}", id);
        bankAccountRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert("bankAccount", id.toString())).build();
    }

}
