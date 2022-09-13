package kg.megacom.finalprodeject.repo;

import kg.megacom.finalprodeject.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
    @Query(value = "update user set user_name=?2, number=?3, email=?4 where id=?1", nativeQuery = true)
    User update(@Param("id")Long id, @Param("nameUser") String nameUser, @Param("number")String number, @Param("email")String email );}
