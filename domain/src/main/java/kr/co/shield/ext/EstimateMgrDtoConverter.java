package kr.co.shield.ext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import kr.co.shield.dto.EstimateMgrDto;

import java.io.IOException;

public class EstimateMgrDtoConverter implements AttributeConverter<EstimateMgrDto, String> {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(EstimateMgrDto attribute) {
        try {
            return objectMapper.writeValueAsString(attribute);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("JSON writing error", e);
        }
    }

    @Override
    public EstimateMgrDto convertToEntityAttribute(String dbData) {
        try {
            return objectMapper.readValue(dbData, EstimateMgrDto.class);
        } catch (IOException e) {
            throw new RuntimeException("JSON reading error", e);
        }
    }
}