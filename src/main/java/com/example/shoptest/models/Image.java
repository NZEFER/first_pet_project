package com.example.shoptest.models;

import jakarta.persistence.*;
import jakarta.security.auth.message.callback.PrivateKeyCallback;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "Images")
@AllArgsConstructor
@NoArgsConstructor
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "originalFileName")
    private String originalFileName;

    @Column(name = "size")
    private Long size;

    @Column(name = "contextType")
    private String contentType;

    @Column(name = "isPreviewImage")
    private boolean isPreviewImage;

    @Lob //@Column(columnDefinition = "LONGBLOB")
    private byte[] bytes;

    //у одного товара может иметься много фотографий будем делать отношение многие к одному
    //cascade - что будет со связанным объектом при удалении
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)  //fetch = FetchType.EAGER способ загрузки, в данном случае подгружается все, есть ленивый метод
    private Product product;   //преобразуется в fkey
}
