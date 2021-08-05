package com.ssnail.myspringboot.domain.model.enums;

import lombok.Getter;

/**
 * @author pengdengwang
 * @since 2021/8/4
 */
@Getter
public enum SexEnum {
    MALE(1, ""),
    FEMALE(2, "");
    private Integer sex;
    private String desc;

    SexEnum(Integer sex, String desc) {
        this.sex = sex;
        this.desc = desc;
    }

    public static SexEnum getSexEnum(Integer sex) {
        for (SexEnum value : SexEnum.values()) {
            if (value.getSex().equals(sex)) {
                return value;
            }
        }
        return null;
    }
}
