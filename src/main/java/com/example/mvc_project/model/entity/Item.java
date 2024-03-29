package com.example.mvc_project.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import java.util.Objects;
import java.util.Set;
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "item_t")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //    @Column(nullable = false, length = 200)
    @Column
    private String itemName;
    @Column(nullable = false)
    private Long itemArticle;

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    @JsonIgnore
    @ToString.Exclude
    private Set<OrdersItem> ordersItem;

    public Item(Integer id, String itemName, Long itemArticle, Set<OrdersItem> ordersItems) {
        this.id = id;
        this.itemName = itemName;
        this.itemArticle = itemArticle;
        this.ordersItem = ordersItems;
    }

    public Item(Integer id, String itemName, Long itemArticle) {
        this.id = id;
        this.itemName = itemName;
        this.itemArticle = itemArticle;
    }

    public Item(String itemName, Long itemArticle) {
        this.itemName = itemName;
        this.itemArticle = itemArticle;
    }

    @Override
    public String toString() {
//        if(ordersItem == null)
            return "{id= " + id + ", itemName= " + itemName + ", itemArticle= " + itemArticle + '}';
//        return "{id= " + id + ", itemName= " + itemName + ", itemArticle= " + itemArticle +
//                ", ordersItem= " + ordersItem + '}';
    }

    public String getItemName() {
        return itemName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Item item = (Item) o;
        return id != null && Objects.equals(id, item.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
