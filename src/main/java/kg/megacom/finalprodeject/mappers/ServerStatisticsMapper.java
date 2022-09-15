package kg.megacom.finalprodeject.mappers;

import kg.megacom.finalprodeject.mappers.base.CrudMapper;
import kg.megacom.finalprodeject.models.User;
import kg.megacom.finalprodeject.models.dto.ServerStatistics;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ServerStatisticsMapper extends CrudMapper <User, ServerStatistics> {
    ServerStatisticsMapper INSTANCE = Mappers.getMapper(ServerStatisticsMapper.class);
}
