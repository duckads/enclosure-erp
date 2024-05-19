package kr.co.shield.ext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import kr.co.shield.dto.BusinessDealDto;

import java.io.IOException;

public class BusinessDealDtoConverter implements AttributeConverter<BusinessDealDto, String> {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(BusinessDealDto attribute) {
        try {
            return objectMapper.writeValueAsString(attribute);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("JSON writing error", e);
        }
    }

    @Override
    public BusinessDealDto convertToEntityAttribute(String dbData) {
        try {
            return objectMapper.readValue(dbData, BusinessDealDto.class);
        } catch (IOException e) {
            throw new RuntimeException("JSON reading error", e);
        }
    }
}