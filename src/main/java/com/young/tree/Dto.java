package com.young.tree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Zongxu.Yang
 * create at 2021/1/1
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dto {

    private Integer id;
    private String name;
    private Integer pid;
    private Integer level;
}
