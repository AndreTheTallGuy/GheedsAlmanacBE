package com.GheedsAlmanac.GheedsAlmanac.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "records")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Record {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private int id;

    @Column(name = "date")
    private Date date = new Date();

    @Column(name = "itemA")
    private String itemA;

    @Column(name = "itemB")
    private String itemB;

}
