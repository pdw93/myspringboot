package com.ssnail.myspringboot.domain.model.convert;

import com.ssnail.myspringboot.domain.model.enums.SexEnum;
import javax.persistence.AttributeConverter;

/**
 * @author pengdengwang
 * @since 2021/8/4
 */
public class SexConverter implements AttributeConverter<SexEnum, Integer> {
    @Override
    public Integer convertToDatabaseColumn(SexEnum sexEnum) {
        return sexEnum.getSex();
    }

    @Override
    public SexEnum convertToEntityAttribute(Integer sex) {
        return SexEnum.getSexEnum(sex);
    }
}
