package com.lcwd.electronic.store.ElectronicStore.dtos;


import lombok.*;

import java.util.List;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PageableResponse<T> {



    private List<T> content;

    private int pageNumber;

    private int pageSize;

    private long totalElements;

    private int totalPage;

    private boolean lastPage;


}
