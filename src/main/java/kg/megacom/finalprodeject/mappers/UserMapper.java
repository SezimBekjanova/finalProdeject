package kg.megacom.finalprodeject.mappers;

import kg.megacom.finalprodeject.mappers.base.CrudMapper;
import kg.megacom.finalprodeject.models.User;
import kg.megacom.finalprodeject.models.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface  UserMapper extends CrudMapper<User,UserDto> {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

}
