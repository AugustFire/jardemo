package com.young.tree;

import com.alibaba.fastjson.JSON;

import java.awt.image.ImageProducer;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author Zongxu.Yang
 * create at 2021/1/1
 */
//@SuppressWarnings("all")
public class Main {


    public static void main(String[] args) {
        Area area1 = new Area(1, 10, 101, "湖北省", "十堰市", "张湾区");
        Area area2 = new Area(1, 10, 102, "湖北省", "十堰市", "茅箭区");
        Area area4 = new Area(1, 11, 112, "湖北省", "武汉市", "洪山区");

        Area area3 = new Area(1, 11, 111, "湖北省", "武汉市", "蔡甸区");
        Area area5 = new Area(2, 20, 201, "湖南省", "长沙市", "长沙1区");
        Area area6 = new Area(2, 20, 201, "湖南省", "长沙市", "长沙2区");
        Area area7 = new Area(2, 21, 211, "湖南省", "株洲市", "株洲1区");
        Area area8 = new Area(2, 21, 212, "湖南省", "株洲市", "株洲2区");


        Area area9  = new Area(3, 3, 301, "北京市", "北京市", "东城区");
        Area area10 = new Area(3, 3, 302, "北京市", "北京市", "西城区");
        ArrayList<Area> areas = new ArrayList<>();
        areas.add(area1);
        areas.add(area2);
        areas.add(area3);
        areas.add(area4);
        areas.add(area5);
        areas.add(area6);
        areas.add(area7);
        areas.add(area8);
        areas.add(area9);
        areas.add(area10);

        List<Dto> dtos = new ArrayList<>();
        for (Area area : areas) {
            Dto dto1 = new Dto(area.getPid(), area.getPName(), -1,1);
            Dto dto2 = new Dto(area.getCid(), area.getCName(), area.getPid(),2);
            Dto dto3 = new Dto(area.getDId(), area.getDName(), area.getCid(),3);
            dtos.add(dto1);
            dtos.add(dto2);
            dtos.add(dto3);
        }
        dtos = dtos.stream().distinct().collect(Collectors.toList());

        List<Region> regionList = dtos.stream().map(i -> {
            Region region = new Region();
            region.setPId(i.getPid());
            region.setId(i.getId());
            region.setName(i.getName());
            region.setLevel(i.getLevel());
            return region;
        }).collect(Collectors.toList());

        List<Region> rootList = regionList.stream().filter(i -> i.getPId().equals(-1)&&i.getLevel().equals(1)).collect(Collectors.toList());
        //regionList.removeIf(region -> region.getPId().equals(-1));
        System.out.println(12);
        //regionList.removeIf(i -> i.getPId().equals(-1));
        for (Region region : rootList) {
            Integer id = region.getId();
            List<Region> regionList1 = regionList.stream().filter(i -> i.getPId().equals(id)&&i.getLevel().equals(2)).collect(Collectors.toList());
            //regionList.removeIf(i -> i.getPId().equals(id));
            region.setRegionList(regionList1);

            for (Region region1 : regionList1) {
                Integer id1 = region1.getId();
                List<Region> regionList2 = regionList.stream().filter(i -> i.getPId().equals(id1)&&i.getLevel().equals(3)).collect(Collectors.toList());
                region1.setRegionList(regionList2);

            }

        }

        System.out.println(JSON.toJSONString(rootList));

    }
}
