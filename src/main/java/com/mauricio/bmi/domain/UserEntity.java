package com.mauricio.bmi.domain;

import com.mauricio.bmi.constant.Sex;
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
@Table(name = "users")
public class UserEntity implements Persistable<UUID> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID userUuid;
    private String username;
    private String password;
    private String name;
    private int age;
    private Sex sex;
    private float height;

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
        return this.getUserUuid();
    }

    @Override
    public boolean isNew() {
        return this.isNew;
    }
}
