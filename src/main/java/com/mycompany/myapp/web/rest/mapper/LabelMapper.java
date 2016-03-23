package com.mycompany.myapp.web.rest.mapper;

import com.mycompany.myapp.domain.*;
import com.mycompany.myapp.web.rest.dto.LabelDTO;

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
}
