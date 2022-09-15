package kg.megacom.finalprodeject.services.impl;

import kg.megacom.finalprodeject.mappers.ServerStatisticsMapper;
import kg.megacom.finalprodeject.models.User;
import kg.megacom.finalprodeject.models.dto.ServerStatistics;
import kg.megacom.finalprodeject.models.enums.StatusUser;
import kg.megacom.finalprodeject.services.ServiceStatisticsService;
import kg.megacom.finalprodeject.services.UserService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class ServiceStatisticsServiceImpl implements ServiceStatisticsService {
    private final UserService userService;
    private final ServerStatisticsMapper serverStatisticsMapper;

    public ServiceStatisticsServiceImpl(UserService userService) {
        this.userService = userService;
        this.serverStatisticsMapper = ServerStatisticsMapper.INSTANCE;
    }

    @Override
    public List <ServerStatistics> serverStatistics(StatusUser statusUser, Date date) {
        System.out.println(new Date());
        List<User> userList = userService.findAll();
        List<ServerStatistics> serverStatisticsList = serverStatisticsMapper.toDtoList(userList);
        List<ServerStatistics> serverStatisticsList1 =  serverStatisticsList
                .stream()
                .filter(x-> x.getStatus()!=null && x.getDate()!=null)
                .collect(Collectors.toList());

        if(statusUser == null && date ==null ){
            return serverStatisticsList1;
        }

        if(statusUser != null && date==null){
            return serverStatisticsList1
                    .stream()
                    .filter(x-> x.getStatus()==statusUser )
                    .collect(Collectors.toList());
        }

        if(statusUser ==null && date != null){
            return serverStatisticsList1
                    .stream()
                    .filter(x-> x.getDate().getTime() >= date.getTime())
                    .collect(Collectors.toList());
        }

        if(statusUser !=null && date != null){
            return serverStatisticsList1
                    .stream()
                    .filter(x-> x.getStatus() == statusUser && x.getDate().getTime() >= date.getTime())
                    .collect(Collectors.toList());
        }

        return null;
    }
}
