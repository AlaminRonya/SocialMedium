package com.alamin.model;


import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Data
@Entity
@Table(name = "statuses")
@ToString
public class Status implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "privacy")
    private String privacy;

    @Column(name = "is_deleted")
    private boolean isDeleted;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    @ManyToOne(fetch = FetchType.LAZY) //, targetEntity = User.class)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    private Location location;


    @OneToMany(fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinTable(name = "status_attachments",
            joinColumns = {@JoinColumn(name = "status_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "attachment_id", referencedColumnName = "id")})
    private List<Attachment> statusAttachmentList;


}
