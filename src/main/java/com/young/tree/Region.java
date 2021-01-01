package com.young.tree;

import lombok.Data;

import java.util.List;

/**
 * @author Zongxu.Yang
 * create at 2021/1/1
 */
@Data
public class Region {
    private Integer id;
    private String name;

    private List<Region> regionList;
}
