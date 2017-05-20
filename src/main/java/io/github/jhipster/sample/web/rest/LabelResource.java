package io.github.jhipster.sample.web.rest;

import com.codahale.metrics.annotation.Timed;
import io.github.jhipster.sample.domain.Label;

import io.github.jhipster.sample.repository.LabelRepository;
import io.github.jhipster.sample.web.rest.util.HeaderUtil;
import io.github.jhipster.sample.service.dto.LabelDTO;
import io.github.jhipster.sample.service.mapper.LabelMapper;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing Label.
 */
@RestController
@RequestMapping("/api")
public class LabelResource {

    private final Logger log = LoggerFactory.getLogger(LabelResource.class);

    private static final String ENTITY_NAME = "label";
        
    private final LabelRepository labelRepository;

    private final LabelMapper labelMapper;

    public LabelResource(LabelRepository labelRepository, LabelMapper labelMapper) {
        this.labelRepository = labelRepository;
        this.labelMapper = labelMapper;
    }

    /**
     * POST  /labels : Create a new label.
     *
     * @param labelDTO the labelDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new labelDTO, or with status 400 (Bad Request) if the label has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/labels")
    @Timed
    public ResponseEntity<LabelDTO> createLabel(@Valid @RequestBody LabelDTO labelDTO) throws URISyntaxException {
        log.debug("REST request to save Label : {}", labelDTO);
        if (labelDTO.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new label cannot already have an ID")).body(null);
        }
        Label label = labelMapper.toEntity(labelDTO);
        label = labelRepository.save(label);
        LabelDTO result = labelMapper.toDto(label);
        return ResponseEntity.created(new URI("/api/labels/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
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
    @PutMapping("/labels")
    @Timed
    public ResponseEntity<LabelDTO> updateLabel(@Valid @RequestBody LabelDTO labelDTO) throws URISyntaxException {
        log.debug("REST request to update Label : {}", labelDTO);
        if (labelDTO.getId() == null) {
            return createLabel(labelDTO);
        }
        Label label = labelMapper.toEntity(labelDTO);
        label = labelRepository.save(label);
        LabelDTO result = labelMapper.toDto(label);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, labelDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /labels : get all the labels.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of labels in body
     */
    @GetMapping("/labels")
    @Timed
    public List<LabelDTO> getAllLabels() {
        log.debug("REST request to get all Labels");
        List<Label> labels = labelRepository.findAll();
        return labelMapper.toDto(labels);
    }

    /**
     * GET  /labels/:id : get the "id" label.
     *
     * @param id the id of the labelDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the labelDTO, or with status 404 (Not Found)
     */
    @GetMapping("/labels/{id}")
    @Timed
    public ResponseEntity<LabelDTO> getLabel(@PathVariable Long id) {
        log.debug("REST request to get Label : {}", id);
        Label label = labelRepository.findOne(id);
        LabelDTO labelDTO = labelMapper.toDto(label);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(labelDTO));
    }

    /**
     * DELETE  /labels/:id : delete the "id" label.
     *
     * @param id the id of the labelDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/labels/{id}")
    @Timed
    public ResponseEntity<Void> deleteLabel(@PathVariable Long id) {
        log.debug("REST request to delete Label : {}", id);
        labelRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

}
