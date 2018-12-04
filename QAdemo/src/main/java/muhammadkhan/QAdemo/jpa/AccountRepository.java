package muhammadkhan.QAdemo.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import muhammadkhan.QAdemo.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

}
