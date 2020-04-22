package com.ljl.management.query;

import lombok.Data;

@Data
public class PageQuery {

    private Integer pageSize = 10;
    private Integer page = 1;
}
