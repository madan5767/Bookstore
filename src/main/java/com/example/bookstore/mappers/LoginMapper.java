package com.example.bookstore.mappers;

import com.example.bookstore.dto.LoginDto;
import com.example.bookstore.models.Admin;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface LoginMapper {
    LoginMapper INSTANCE = Mappers.getMapper(LoginMapper.class);

    List<LoginDto> modelsToDto(List<Admin> admins);
}
