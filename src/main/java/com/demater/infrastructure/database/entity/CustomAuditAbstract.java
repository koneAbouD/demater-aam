package com.demater.infrastructure.database.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.util.Date;

import static jakarta.persistence.TemporalType.TIMESTAMP;


@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "updateTimestamp" }, allowGetters = true)
public abstract class CustomAuditAbstract implements Serializable {
    @Temporal(TIMESTAMP)
    @Column(name = "created_timestamp", nullable = false, updatable = false)
    @CreatedDate
    private Date createdTimestamp;

    @Temporal(TIMESTAMP)
    @Column(name = "updated_timestamp", nullable = false)
    private Date updatedTimestamp;

    @PrePersist
    protected void onCreate() {
        updatedTimestamp = createdTimestamp = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedTimestamp = new Date();
    }

    public Date getCreatedTimestamp() {
        return createdTimestamp;
    }

    public Date getUpdatedTimestamp() {
        return updatedTimestamp;
    }
}
