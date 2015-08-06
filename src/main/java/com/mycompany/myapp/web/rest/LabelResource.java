package com.mycompany.myapp.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.mycompany.myapp.domain.Label;
import com.mycompany.myapp.repository.LabelRepository;
import com.mycompany.myapp.web.rest.util.HeaderUtil;
import com.mycompany.myapp.web.rest.dto.LabelDTO;
import com.mycompany.myapp.web.rest.mapper.LabelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
 * REST controller for managing Label.
 */
@RestController
@RequestMapping("/api")
public class LabelResource {

    private final Logger log = LoggerFactory.getLogger(LabelResource.class);

    @Inject
    private LabelRepository labelRepository;

    @Inject
    private LabelMapper labelMapper;

    /**
     * POST  /labels -> Create a new label.
     */
    @RequestMapping(value = "/labels",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<LabelDTO> create(@Valid @RequestBody LabelDTO labelDTO) throws URISyntaxException {
        log.debug("REST request to save Label : {}", labelDTO);
        if (labelDTO.getId() != null) {
            return ResponseEntity.badRequest().header("Failure", "A new label cannot already have an ID").body(null);
        }
        Label label = labelMapper.labelDTOToLabel(labelDTO);
        Label result = labelRepository.save(label);
        return ResponseEntity.created(new URI("/api/labels/" + result.getId()))
                .headers(HeaderUtil.createEntityCreationAlert("label", result.getId().toString()))
                .body(labelMapper.labelToLabelDTO(result));
    }

    /**
     * PUT  /labels -> Updates an existing label.
     */
    @RequestMapping(value = "/labels",
        method = RequestMethod.PUT,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<LabelDTO> update(@Valid @RequestBody LabelDTO labelDTO) throws URISyntaxException {
        log.debug("REST request to update Label : {}", labelDTO);
        if (labelDTO.getId() == null) {
            return create(labelDTO);
        }
        Label label = labelMapper.labelDTOToLabel(labelDTO);
        Label result = labelRepository.save(label);
        return ResponseEntity.ok()
                .headers(HeaderUtil.createEntityUpdateAlert("label", labelDTO.getId().toString()))
                .body(labelMapper.labelToLabelDTO(result));
    }

    /**
     * GET  /labels -> get all the labels.
     */
    @RequestMapping(value = "/labels",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    @Transactional(readOnly = true)
    public List<LabelDTO> getAll() {
        log.debug("REST request to get all Labels");
        return labelRepository.findAll().stream()
            .map(label -> labelMapper.labelToLabelDTO(label))
            .collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * GET  /labels/:id -> get the "id" label.
     */
    @RequestMapping(value = "/labels/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<LabelDTO> get(@PathVariable Long id) {
        log.debug("REST request to get Label : {}", id);
        return Optional.ofNullable(labelRepository.findOne(id))
            .map(labelMapper::labelToLabelDTO)
            .map(labelDTO -> new ResponseEntity<>(
                labelDTO,
                HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * DELETE  /labels/:id -> delete the "id" label.
     */
    @RequestMapping(value = "/labels/{id}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        log.debug("REST request to delete Label : {}", id);
        labelRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert("label", id.toString())).build();
    }
}
