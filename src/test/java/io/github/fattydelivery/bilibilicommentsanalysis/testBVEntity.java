package io.github.fattydelivery.bilibilicommentsanalysis;

import io.github.fattydelivery.bilibilicommentsanalysis.entity.BVEntity;
import org.junit.jupiter.api.Test;

/**
 * @program:bilibili-comments-analysis
 * @description
 * @author: Jayce(Bingjie Yan)
 * @create: 2020-12-23-21:50
 **/
public class testBVEntity {
    @Test
    public static void main(String args[]) {
        BVEntity bvEntity = new BVEntity("BV1zs411S7sz");
        System.out.println(bvEntity.getCid());
        System.out.println(bvEntity.getBvid());
    }
}
