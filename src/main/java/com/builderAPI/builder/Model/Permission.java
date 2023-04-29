package com.builderAPI.builder.model;

import jakarta.persistence.*;

/**
 * a Permission class that represents a permission in your application
 *
 */
@Entity
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private PermissionName name;

    public Permission() {
    }

    public Permission(Long id, PermissionName name) {
        this.id = id;
        this.name = name;
    }

    //constructors, getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PermissionName getName() {
        return name;
    }

    public void setName(PermissionName name) {
        this.name = name;
    }


}

