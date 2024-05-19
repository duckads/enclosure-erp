package kr.co.shield.ext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import kr.co.shield.dto.BusinessDealMgrDto;

import java.io.IOException;

public class BusinessDealMgrDtoConverter implements AttributeConverter<BusinessDealMgrDto, String> {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(BusinessDealMgrDto attribute) {
        try {
            return objectMapper.writeValueAsString(attribute);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("JSON writing error", e);
        }
    }

    @Override
    public BusinessDealMgrDto convertToEntityAttribute(String dbData) {
        try {
            return objectMapper.readValue(dbData, BusinessDealMgrDto.class);
        } catch (IOException e) {
            throw new RuntimeException("JSON reading error", e);
        }
    }
}