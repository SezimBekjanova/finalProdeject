package kg.megacom.finalprodeject.models.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import kg.megacom.finalprodeject.models.enums.StatusUser;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDto {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    Long id;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    String userName;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    String email;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    String number;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    String photo;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    StatusUser status;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    Date date;
}
