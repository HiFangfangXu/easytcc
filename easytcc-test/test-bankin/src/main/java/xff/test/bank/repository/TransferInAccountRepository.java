package xff.test.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import xff.test.bank.entity.TransferInAccount;
/**
 * 
 * @author Fangfang.Xu
 */
public interface TransferInAccountRepository extends JpaRepository<TransferInAccount, Long>{

	@Query(value="update bankin_acct set amt = amt + (?2) where id = ?1",nativeQuery=true)
	@Modifying
	int sumAmt(long id,long amt);
}
