package me.zipestudio.itemvanisher.utils;

import net.minecraft.entity.projectile.ArrowEntity;

public class ArrowUtils {
    public static boolean isArrowFreeze(ArrowEntity arrowEntity) {
        return arrowEntity.getVelocity().lengthSquared() < 0.05;
    }
}
