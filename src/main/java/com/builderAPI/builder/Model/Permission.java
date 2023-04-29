package com.builderAPI.builder.model;

/**
 * a Permission class that represents a permission in your application
 *
 */
public class Permission {

    private Long id;
    private Permission name;

    public Permission() {
    }

    public Permission(Long id, Permission name) {
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

    public Permission getName() {
        return name;
    }

    public void setName(Permission name) {
        this.name = name;
    }


}
