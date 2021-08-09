package com.example.eshop.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Set;


@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "category", schema = "shop")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    long id;

    @Column(name = "parent_id")
    long parentId;

    @Column(name = "title")
    String title;

    @Column(name = "meta_title")
    String metaTitle;

    @Column(name = "slug")
    String slug;

    @Column(name = "content")
    String content;

    @JsonIgnore
    @ManyToMany(mappedBy = "categories", fetch = FetchType.LAZY)
    Set<Product> products;
}
