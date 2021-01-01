package com.young.tree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Zongxu.Yang
 * create at 2021/1/1
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Region {


    private transient Integer pId;

    private Integer id;
    private String name;
    private transient Integer level;

    private List<Region> regionList;
}
