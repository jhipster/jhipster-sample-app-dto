package io.github.jhipster.sample.service.mapper;

import io.github.jhipster.sample.domain.*;
import io.github.jhipster.sample.service.dto.LabelDTO;

import org.mapstruct.*;
import java.util.List;

/**
 * Mapper for the entity Label and its DTO LabelDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface LabelMapper {

    LabelDTO labelToLabelDTO(Label label);

    List<LabelDTO> labelsToLabelDTOs(List<Label> labels);

    @Mapping(target = "operations", ignore = true)
    Label labelDTOToLabel(LabelDTO labelDTO);

    List<Label> labelDTOsToLabels(List<LabelDTO> labelDTOs);
    /**
     * generating the fromId for all mappers if the databaseType is sql, as the class has relationship to it might need it, instead of
     * creating a new attribute to know if the entity has any relationship from some other entity
     *
     * @param id id of the entity
     * @return the entity instance
     */
     
    default Label labelFromId(Long id) {
        if (id == null) {
            return null;
        }
        Label label = new Label();
        label.setId(id);
        return label;
    }
    

}
