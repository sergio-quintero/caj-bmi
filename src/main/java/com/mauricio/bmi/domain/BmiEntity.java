package com.mauricio.bmi.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "bmi")
public class BmiEntity implements Persistable<UUID> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID bmiUuid;
    private UUID userUuid;
    private double value;

    @CreationTimestamp
    @Column(updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdatedDate;

    @Transient
    private boolean isNew = true;

    @Override
    public UUID getId() {
        return this.bmiUuid;
    }

    @Override
    public boolean isNew() {
        return this.isNew;
    }
}
