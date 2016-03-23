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
     * POST  /labels : Create a new label.
     *
     * @param labelDTO the labelDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new labelDTO, or with status 400 (Bad Request) if the label has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @RequestMapping(value = "/labels",
        method = RequestMethod.POST,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<LabelDTO> createLabel(@Valid @RequestBody LabelDTO labelDTO) throws URISyntaxException {
        log.debug("REST request to save Label : {}", labelDTO);
        if (labelDTO.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert("label", "idexists", "A new label cannot already have an ID")).body(null);
        }
        Label label = labelMapper.labelDTOToLabel(labelDTO);
        label = labelRepository.save(label);
        LabelDTO result = labelMapper.labelToLabelDTO(label);
        return ResponseEntity.created(new URI("/api/labels/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert("label", result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /labels : Updates an existing label.
     *
     * @param labelDTO the labelDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated labelDTO,
     * or with status 400 (Bad Request) if the labelDTO is not valid,
     * or with status 500 (Internal Server Error) if the labelDTO couldnt be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @RequestMapping(value = "/labels",
        method = RequestMethod.PUT,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<LabelDTO> updateLabel(@Valid @RequestBody LabelDTO labelDTO) throws URISyntaxException {
        log.debug("REST request to update Label : {}", labelDTO);
        if (labelDTO.getId() == null) {
            return createLabel(labelDTO);
        }
        Label label = labelMapper.labelDTOToLabel(labelDTO);
        label = labelRepository.save(label);
        LabelDTO result = labelMapper.labelToLabelDTO(label);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert("label", labelDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /labels : get all the labels.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of labels in body
     */
    @RequestMapping(value = "/labels",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    @Transactional(readOnly = true)
    public List<LabelDTO> getAllLabels() {
        log.debug("REST request to get all Labels");
        List<Label> labels = labelRepository.findAll();
        return labelMapper.labelsToLabelDTOs(labels);
    }

    /**
     * GET  /labels/:id : get the "id" label.
     *
     * @param id the id of the labelDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the labelDTO, or with status 404 (Not Found)
     */
    @RequestMapping(value = "/labels/{id}",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<LabelDTO> getLabel(@PathVariable Long id) {
        log.debug("REST request to get Label : {}", id);
        Label label = labelRepository.findOne(id);
        LabelDTO labelDTO = labelMapper.labelToLabelDTO(label);
        return Optional.ofNullable(labelDTO)
            .map(result -> new ResponseEntity<>(
                result,
                HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * DELETE  /labels/:id : delete the "id" label.
     *
     * @param id the id of the labelDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @RequestMapping(value = "/labels/{id}",
        method = RequestMethod.DELETE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<Void> deleteLabel(@PathVariable Long id) {
        log.debug("REST request to delete Label : {}", id);
        labelRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert("label", id.toString())).build();
    }

}
