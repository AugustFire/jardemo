package com.young.libdemo.guava.tool;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import org.junit.Test;

/**
 * 布隆过滤器
 * create_time 2019/12/25
 *
 * @author yzx
 */
public class BloomFilterTest {

    @Test
    public void bloomFilterTest() {
        int size = 1000000;
        double fpp = 0.0001;
        BloomFilter<Integer> bloomFilter = BloomFilter.create(Funnels.integerFunnel(), size, fpp);
        for (int i = 0; i < 1000000; i++) {
            bloomFilter.put(i);
        }
        int count = 0;
        for (int i = 1000000; i < 2000000; i++) {
            if (bloomFilter.mightContain(i)) {
                count++;
                System.out.println("误判:" + i);
            }
        }
        System.out.println("总误判"+count);

    }


}
