package io.github.jhipster.sample.service.dto;


import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A DTO for the Label entity.
 */
public class LabelDTO implements Serializable {

    private Long id;

    @NotNull
    @Size(min = 3)
    private String label;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        LabelDTO labelDTO = (LabelDTO) o;

        if ( ! Objects.equals(id, labelDTO.id)) { return false; }

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "LabelDTO{" +
            "id=" + id +
            ", label='" + label + "'" +
            '}';
    }
}
