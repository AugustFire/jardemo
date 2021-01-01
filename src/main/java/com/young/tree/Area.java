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
public class Area {
    private Integer pid;
    private Integer cid;
    private Integer dId;
    private String pName;
    private String cName;
    private String dName;
}
