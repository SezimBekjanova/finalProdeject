package kg.megacom.finalprodeject.services;

import kg.megacom.finalprodeject.models.dto.ServerStatistics;
import kg.megacom.finalprodeject.models.enums.StatusUser;

import java.util.Date;
import java.util.List;

public interface ServiceStatisticsService {
    List<ServerStatistics> serverStatistics(StatusUser statusUser, Date date);
}
