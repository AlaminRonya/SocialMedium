package com.alamin.model;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



@Entity
@Table(name = "locations")
@Data
public class Location implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "location_name")
    private String locationName;

    @OneToMany(orphanRemoval = true, mappedBy = "location")
    private List<User> users = new ArrayList<>();

//    @OneToMany(mappedBy = "location", fetch = FetchType.LAZY)
//    private List<User> users = new ArrayList<>();

    @OneToMany(orphanRemoval = true, mappedBy = "location")
    private List<Status> statuses = new ArrayList<>();

}
