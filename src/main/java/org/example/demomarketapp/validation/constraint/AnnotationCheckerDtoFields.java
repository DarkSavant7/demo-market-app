package org.example.demomarketapp.validation.constraint;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.example.demomarketapp.dto.ProductDto;
import org.example.demomarketapp.service.ProductService;
import org.example.demomarketapp.validation.interf.CheckDtoFields;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AnnotationCheckerDtoFields implements ConstraintValidator<CheckDtoFields, ProductDto> {

    private final ProductService productService;

    @Override
    public boolean isValid(ProductDto productDto, ConstraintValidatorContext constraintValidatorContext) {
        return !(productService.existsByDescriptionAndTitleAndPrice(
                productDto.getDescription(),
                productDto.getTitle(),
                productDto.getPrice()));
    }
}
