package dev.rodrigoguedes.core.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

public abstract class CoreEntity<K extends Serializable> {

    public abstract K getId();

    @JsonIgnore
    public boolean isNew() {
        return getId() == null;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (this.getId() == null || obj == null || !(this.getClass().equals(obj.getClass()))) {
            return false;
        }

        CoreEntity that = (CoreEntity) obj;

        return this.getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return getId() == null ? 0 : getId().hashCode();
    }

}
