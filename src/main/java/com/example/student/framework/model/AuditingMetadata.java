package com.example.student.framework.model;

import jakarta.persistence.MappedSuperclass;

import java.io.Serializable;

@MappedSuperclass
public abstract class AuditingMetadata implements Serializable {

    private String createdByUsername;
    private String lastModifiedByUsername;
    private boolean enabled;

    public String getCreatedByUsername() {
        return createdByUsername;
    }

    public void setCreatedByUsername(final String createdByUsername) {
        this.createdByUsername = createdByUsername;
    }

    public String getLastModifiedByUsername() {
        return lastModifiedByUsername;
    }

    public void setLastModifiedByUsername(final String lastModifiedByUsername) {
        this.lastModifiedByUsername = lastModifiedByUsername;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(final boolean enabled) {
        this.enabled = enabled;
    }
}
