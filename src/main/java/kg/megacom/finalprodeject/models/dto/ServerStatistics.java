package kg.megacom.finalprodeject.models.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import kg.megacom.finalprodeject.models.enums.StatusUser;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Date;
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ServerStatistics {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    Long id;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    StatusUser status;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    Date date;

}
