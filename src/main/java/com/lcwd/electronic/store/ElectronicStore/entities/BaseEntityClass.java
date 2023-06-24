package com.lcwd.electronic.store.ElectronicStore.entities;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import java.time.LocalDate;

public class BaseEntityClass {

  @Column(name = "create_Date", updatable = false)
    @CreationTimestamp
    private LocalDate createDate;

  @Column(name = "update_Date", insertable = false)
    private LocalDate updateDate;

  @Column(name = "is_Active")
    private String isactive;


}
