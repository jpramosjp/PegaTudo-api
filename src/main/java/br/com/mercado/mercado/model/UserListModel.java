package br.com.mercado.mercado.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import jakarta.persistence.*;

@Entity
@Table(name = "user_lists")
@Data
@Builder
@AllArgsConstructor
public class UserListModel {
    public UserListModel(){}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private UserModel user;

    @ManyToOne
    @JoinColumn(name = "id_list", nullable = false)
    private ListModel list;

}
