package com.spring.iasfex2.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Date;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "products")
@SQLDelete(sql = "UPDATE products SET status = 0 WHERE id = ?")
@Where(clause = "status = 0")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String slug;

    private String description;

    private String detail;

    private Double price;

    private String thumbnail;

    private String manufacturer;

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;

    @UpdateTimestamp
    private Date deletedAt;

    private String createdBy;

    private String updatedBy;

    private int status;
}
