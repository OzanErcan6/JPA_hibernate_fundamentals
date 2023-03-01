package com.ozzyjpa.demojpa.entity;

import javax.persistence.*;


// @Entity
// 1. default @Inheritance(strategy = InheritanceType.JOINED), there will be null cells, high performance, all subclasses will be stored in one table
// 2. @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) for each subclass there is a new table, common columns repeated
// 3. @Inheritance(strategy = InheritanceType.JOINED) common columns do not repeat, not for best performance
// 4. MappedSuperclass it cannot be an @Entity
// @Inheritance(strategy = InheritanceType.JOINED)
@MappedSuperclass
public abstract class Employee {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    public Employee(String name) {
        this.name = name;
    }
    protected Employee() {}


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
