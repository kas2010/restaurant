package com.task.restaurant.converter;

import java.util.stream.Stream;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.task.restaurant.model.DishCategory;

@Converter(autoApply = true)
public class DishCategoryConverter implements AttributeConverter<DishCategory, Long>{

	@Override
	public Long convertToDatabaseColumn(DishCategory dishCategory) {
		if (dishCategory == null) {
			return null;
		}
		return dishCategory.getId();
	}

	@Override
	public DishCategory convertToEntityAttribute(Long dbData) {
		if (dbData == null) {
			return null;
		}

		return Stream.of(DishCategory.values())
		          .filter(c -> c.getId() == dbData)
		          .findFirst()
		          .orElseThrow(IllegalArgumentException::new);
	}

}
