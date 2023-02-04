package com.example.mvc_project.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "client_t")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 200)
    private String nameClient;

    @JsonIgnore
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    @ToString.Exclude
    private Set<Order> orders = new HashSet<>();

    public Client(Integer id, String nameClient, Set<Order> orders) {
        this.id = id;
        this.nameClient = nameClient;
        this.orders = orders;
    }

    public Client(Integer id,String nameClient) {
        this.id = id;
        this.nameClient = nameClient;
    }

    public Client(String nameClient) {
        this.nameClient = nameClient;
    }

    @Override
    public String toString() {
//        if(orders == null)
            return "{id=c" + id + ", nameClient= " + nameClient + '}';
//        return "{id= " + id + ", nameClient= " + nameClient + ", orders= " + orders + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Client client = (Client) o;
        return id != null && Objects.equals(id, client.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
