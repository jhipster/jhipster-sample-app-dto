package com.mycompany.myapp.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.mycompany.myapp.domain.Operation;
import com.mycompany.myapp.repository.OperationRepository;
import com.mycompany.myapp.web.rest.util.HeaderUtil;
import com.mycompany.myapp.web.rest.util.PaginationUtil;
import com.mycompany.myapp.web.rest.dto.OperationDTO;
import com.mycompany.myapp.web.rest.mapper.OperationMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
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
 * REST controller for managing Operation.
 */
@RestController
@RequestMapping("/api")
public class OperationResource {

    private final Logger log = LoggerFactory.getLogger(OperationResource.class);

    @Inject
    private OperationRepository operationRepository;

    @Inject
    private OperationMapper operationMapper;

    /**
     * POST  /operations -> Create a new operation.
     */
    @RequestMapping(value = "/operations",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<OperationDTO> createOperation(@Valid @RequestBody OperationDTO operationDTO) throws URISyntaxException {
        log.debug("REST request to save Operation : {}", operationDTO);
        if (operationDTO.getId() != null) {
            return ResponseEntity.badRequest().header("Failure", "A new operation cannot already have an ID").body(null);
        }
        Operation operation = operationMapper.operationDTOToOperation(operationDTO);
        Operation result = operationRepository.save(operation);
        return ResponseEntity.created(new URI("/api/operations/" + result.getId()))
                .headers(HeaderUtil.createEntityCreationAlert("operation", result.getId().toString()))
                .body(operationMapper.operationToOperationDTO(result));
    }

    /**
     * PUT  /operations -> Updates an existing operation.
     */
    @RequestMapping(value = "/operations",
        method = RequestMethod.PUT,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<OperationDTO> updateOperation(@Valid @RequestBody OperationDTO operationDTO) throws URISyntaxException {
        log.debug("REST request to update Operation : {}", operationDTO);
        if (operationDTO.getId() == null) {
            return createOperation(operationDTO);
        }
        Operation operation = operationMapper.operationDTOToOperation(operationDTO);
        Operation result = operationRepository.save(operation);
        return ResponseEntity.ok()
                .headers(HeaderUtil.createEntityUpdateAlert("operation", operationDTO.getId().toString()))
                .body(operationMapper.operationToOperationDTO(result));
    }

    /**
     * GET  /operations -> get all the operations.
     */
    @RequestMapping(value = "/operations",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    @Transactional(readOnly = true)
    public ResponseEntity<List<OperationDTO>> getAllOperations(@RequestParam(value = "page" , required = false) Integer offset,
                                  @RequestParam(value = "per_page", required = false) Integer limit)
        throws URISyntaxException {
        Page<Operation> page = operationRepository.findAll(PaginationUtil.generatePageRequest(offset, limit));
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/operations", offset, limit);
        return new ResponseEntity<>(page.getContent().stream()
            .map(operationMapper::operationToOperationDTO)
            .collect(Collectors.toCollection(LinkedList::new)), headers, HttpStatus.OK);
    }

    /**
     * GET  /operations/:id -> get the "id" operation.
     */
    @RequestMapping(value = "/operations/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<OperationDTO> getOperation(@PathVariable Long id) {
        log.debug("REST request to get Operation : {}", id);
        return Optional.ofNullable(operationRepository.findOneWithEagerRelationships(id))
            .map(operationMapper::operationToOperationDTO)
            .map(operationDTO -> new ResponseEntity<>(
                operationDTO,
                HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * DELETE  /operations/:id -> delete the "id" operation.
     */
    @RequestMapping(value = "/operations/{id}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<Void> deleteOperation(@PathVariable Long id) {
        log.debug("REST request to delete Operation : {}", id);
        operationRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert("operation", id.toString())).build();
    }
}
